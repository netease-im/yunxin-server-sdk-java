package com.netease.nim.im.server.sdk.core.endpoint;

import com.netease.nim.im.server.sdk.core.Constants;
import com.netease.nim.im.server.sdk.core.exception.EndpointFetchException;
import com.netease.nim.im.server.sdk.core.utils.NamedThreadFactory;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by caojiajun on 2024/12/9
 */
public class DynamicEndpointSelector implements EndpointSelector {

    private static final Logger logger = LoggerFactory.getLogger(DynamicEndpointSelector.class);

    private static final ScheduledExecutorService scheduler1 = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("yunxin-im-sdk-detect"));
    private static final ScheduledExecutorService scheduler2 = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("yunxin-im-sdk-schedule"));

    private final EndpointFetcher fetcher;
    private final int scheduleDetectIntervalSeconds;
    private final int scheduleResultIntervalSeconds;
    private final int slideWindowBuckets;
    private final long slideWindowTime;

    private String defaultEndpoint;
    private List<String> backupEndpoints;

    private final String detectPath;

    private final Map<String, RatioSlideWindows> ratioMap = new ConcurrentHashMap<>();
    private final Map<String, LatencySlideWindows> latencyMap = new ConcurrentHashMap<>();

    private OkHttpClient okHttpClient;

    private List<String> orderedEndpoints = new ArrayList<>();

    public DynamicEndpointSelector(EndpointFetcher fetcher) {
        this(fetcher, Constants.Endpoint.detectPath,
                Constants.Endpoint.scheduleDetectIntervalSeconds, Constants.Endpoint.scheduleResultIntervalSeconds,
                Constants.Endpoint.slideWindowBuckets, Constants.Endpoint.slideWindowTime);
    }

    public DynamicEndpointSelector(EndpointFetcher fetcher, String detectPath,
                                   int scheduleDetectIntervalSeconds,
                                   int scheduleResultIntervalSeconds, int slideWindowBuckets, long slideWindowTime) {
        this.fetcher = fetcher;
        this.detectPath = detectPath;
        this.scheduleDetectIntervalSeconds = scheduleDetectIntervalSeconds;
        this.scheduleResultIntervalSeconds = scheduleResultIntervalSeconds;
        this.slideWindowBuckets = slideWindowBuckets;
        this.slideWindowTime = slideWindowTime;
    }

    @Override
    public void init(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
        fetcher.init(okHttpClient);
        Endpoints endpoints = fetcher.get();
        if (endpoints == null) {
            throw new EndpointFetchException("endpoints fetch null");
        }
        this.defaultEndpoint = endpoints.getDefaultEndpoint();
        this.backupEndpoints = endpoints.getBackupEndpoints();
        if (defaultEndpoint == null) {
            throw new EndpointFetchException("default endpoint is null");
        }

        orderedEndpoints.add(defaultEndpoint);
        if (backupEndpoints != null) {
            orderedEndpoints.addAll(backupEndpoints);
        }
        if (detectPath != null) {
            scheduler1.scheduleAtFixedRate(this::scheduleDetect, scheduleDetectIntervalSeconds, scheduleDetectIntervalSeconds, TimeUnit.SECONDS);
        }
        scheduler2.scheduleAtFixedRate(this::scheduleResult, scheduleResultIntervalSeconds, scheduleResultIntervalSeconds, TimeUnit.SECONDS);
    }

    @Override
    public void update(String endpoint, RequestResult result) {
        RatioSlideWindows windows = getRatioSlideWindows(endpoint);
        if (result == RequestResult.SUCCESS) {
            windows.incrementSuccess();
        } else {
            windows.incrementFail();
        }
    }

    @Override
    public String selectEndpoint(String excludeEndpoint) {
        if (backupEndpoints == null || backupEndpoints.isEmpty()) {
            return defaultEndpoint;
        }
        try {
            for (String endpoint : orderedEndpoints) {
                if (!Objects.equals(endpoint, excludeEndpoint)) {
                    return endpoint;
                }
            }
            return defaultEndpoint;
        } catch (Exception e) {
            return defaultEndpoint;
        }
    }

    private void scheduleResult() {
        try {
            fetchEndpoints();
            RatioSlideWindows ratioSlideWindows = getRatioSlideWindows(defaultEndpoint);
            LatencySlideWindows latencySlideWindows = getLatencySlideWindows(defaultEndpoint);
            List<Entry> list = new ArrayList<>();
            list.add(new Entry(defaultEndpoint, ratioSlideWindows.getSuccessRatio(), latencySlideWindows.getLatency(), true));
            for (String backupEndpoint : backupEndpoints) {
                RatioSlideWindows backUpRatioSlideWindows = getRatioSlideWindows(backupEndpoint);
                LatencySlideWindows backUpLatencySlideWindows = getLatencySlideWindows(backupEndpoint);
                list.add(new Entry(backupEndpoint, backUpRatioSlideWindows.getSuccessRatio(), backUpLatencySlideWindows.getLatency(), false));
            }
            Collections.sort(list);
            List<String> result = new ArrayList<>();
            for (Entry entry : list) {
                result.add(entry.endpoint);
            }
            if (logger.isDebugEnabled()) {
                for (Entry entry : list) {
                    logger.debug("endpoint = {}, default-endpoint = {}, ratio = {}, latency = {}",
                            entry.endpoint, entry.defaultEndpoint, entry.ratio, entry.latency);
                }
            }
            this.orderedEndpoints = result;
        } catch (Exception e) {
            logger.error("schedule result error", e);
        }
    }

    private void scheduleDetect() {
        try {
            fetchEndpoints();
            check(defaultEndpoint);
            for (String backupEndpoint : backupEndpoints) {
                check(backupEndpoint);
            }
        } catch (Exception e) {
            logger.error("schedule detect error", e);
        }
    }

    private void fetchEndpoints() {
        try {
            Endpoints endpoints = fetcher.get();
            if (endpoints == null) {
                logger.error("fetch endpoints error, endpoints is null");
                return;
            }
            String defaultEndpoint = endpoints.getDefaultEndpoint();
            if (defaultEndpoint == null) {
                logger.error("fetch endpoints error, default endpoint is null");
                return;
            }
            List<String> backupEndpoints = endpoints.getBackupEndpoints();
            this.defaultEndpoint = defaultEndpoint;
            this.backupEndpoints = backupEndpoints;
        } catch (Exception e) {
            logger.error("fetch error", e);
        }
    }

    public static final class Entry implements Comparable<Entry> {
        public String endpoint;
        public double ratio;
        public double latency;
        public boolean defaultEndpoint;

        public Entry(String endpoint, double ratio, double latency, boolean defaultEndpoint) {
            this.endpoint = endpoint;
            this.ratio = ratio;
            this.latency = latency;
            this.defaultEndpoint = defaultEndpoint;
        }

        @Override
        public int compareTo(@NotNull Entry o) {
            if (this.ratio >= 1.0 && o.ratio >= 1.0) {
                int compare = Double.compare(this.latency, o.latency);
                if (compare == 0) {
                    if (defaultEndpoint) {
                        return -1;
                    }
                }
                return compare;
            } else if (this.ratio < 1.0 && this.ratio >= 0.999 && o.ratio < 1.0 && o.ratio >= 0.999) {
                return Double.compare(this.latency, o.latency);
            } else {
                int compare = Double.compare(o.ratio, this.ratio);
                if (compare != 0) {
                    return compare;
                }
                return Double.compare(this.latency, o.latency);
            }
        }
    }

    private void check(String endpoint) {
        if (okHttpClient == null) {
            return;
        }
        String url = endpoint + detectPath;
        Request request = new Request.Builder().get()
                .url(url)
                .build();
        long startTime = System.currentTimeMillis();
        boolean success;
        try (Response response = okHttpClient.newCall(request).execute()) {
            String string = response.body().string();
            success = response.code() == 200;
            if (logger.isDebugEnabled()) {
                logger.debug("detect, endpoint = {}, path = {}, code = {}, response = {}", endpoint, detectPath, response.code(), string);
            }
        } catch (Exception e) {
            if (logger.isDebugEnabled()) {
                logger.debug("detect error, endpoint = {}, path = {}", endpoint, detectPath, e);
            }
            success = false;
        }
        LatencySlideWindows latencySlideWindows = getLatencySlideWindows(endpoint);
        latencySlideWindows.increment(System.currentTimeMillis() - startTime);
        RatioSlideWindows ratioSlideWindows = getRatioSlideWindows(endpoint);
        if (success) {
            ratioSlideWindows.incrementSuccess();
        } else {
            ratioSlideWindows.incrementFail();
        }
    }

    private RatioSlideWindows getRatioSlideWindows(String endpoint) {
        RatioSlideWindows windows = ratioMap.get(endpoint);
        if (windows == null) {
            windows = ratioMap.computeIfAbsent(endpoint, s -> new RatioSlideWindows(slideWindowBuckets, slideWindowTime));
        }
        return windows;
    }

    private LatencySlideWindows getLatencySlideWindows(String endpoint) {
        LatencySlideWindows windows = latencyMap.get(endpoint);
        if (windows == null) {
            windows = latencyMap.computeIfAbsent(endpoint, s -> new LatencySlideWindows(slideWindowBuckets, slideWindowTime));
        }
        return windows;
    }

}
