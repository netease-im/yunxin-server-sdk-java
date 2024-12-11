package com.netease.nim.im.server.sdk.core.endpoint;


import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.im.server.sdk.core.Constants;
import com.netease.nim.im.server.sdk.core.exception.EndpointFetchException;
import com.netease.nim.im.server.sdk.core.http.ParamBuilder;
import com.netease.nim.im.server.sdk.core.trace.ApiVersion;
import com.netease.nim.im.server.sdk.core.utils.NamedThreadFactory;
import com.netease.nim.im.server.sdk.core.version.YunxinApiSdkVersion;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * Created by caojiajun on 2024/12/9
 */
public class DynamicEndpointFetcher implements EndpointFetcher {

    private static final Logger logger = LoggerFactory.getLogger(DynamicEndpointFetcher.class);

    private final String appkey;
    private final String lbs;
    private final ApiVersion apiVersion;
    private final int reloadIntervalSeconds;

    private OkHttpClient okHttpClient;

    private String md5;
    private Endpoints endpoints;
    private long nextFetchTime;

    public DynamicEndpointFetcher(String appkey, ApiVersion apiVersion) {
        this(appkey, Constants.Endpoint.lbs, apiVersion, Constants.Endpoint.scheduleFetchIntervalSeconds);
    }

    public DynamicEndpointFetcher(String appkey, String lbs, ApiVersion apiVersion, int reloadIntervalSeconds) {
        this.appkey = appkey;
        this.lbs = lbs;
        this.apiVersion = apiVersion;
        this.reloadIntervalSeconds = reloadIntervalSeconds;
    }

    @Override
    public void init(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
        reload();
        if (endpoints == null) {
            throw new EndpointFetchException("init endpoints error");
        }
        Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("yunxin-im-sdk-endpoint-fetch"))
                .scheduleAtFixedRate(() -> {
                    try {
                        reload();
                    } catch (Exception e) {
                        logger.error("reload error", e);
                    }
                }, reloadIntervalSeconds, reloadIntervalSeconds, TimeUnit.SECONDS);
    }

    private void reload() {
        if (System.currentTimeMillis() < nextFetchTime) {
            return;
        }
        ParamBuilder builder = new ParamBuilder();
        builder.addParam("k", appkey);
        builder.addParam("sv", YunxinApiSdkVersion.version);
        builder.addParam("api", apiVersion.getValue());
        if (md5 != null) {
            builder.addParam("md5", md5);
        }
        Request request = new Request.Builder().get()
                .url(lbs + "?" + builder.build())
                .build();
        String string = null;
        try (Response response = okHttpClient.newCall(request).execute()) {
            if (response.code() != 200) {
                logger.error("fetch endpoints error, http.code = {}", response.code());
                throw new EndpointFetchException("http.code=" + response.code());
            }
            string = response.body().string();
            JSONObject json = JSONObject.parseObject(string);
            Integer code = json.getInteger("code");
            if (code == null) {
                logger.error("illegal endpoints, response = {}", string);
                return;
            }
            if (code == 304) {//没有发生变更
                return;
            }
            if (code == 200) {
                String defaultEndpoint = json.getString("default.endpoint");
                JSONArray backupEndpointsJson = json.getJSONArray("backup.endpoints");
                Endpoints endpoints = new Endpoints();
                List<String> backupEndpoints = new ArrayList<>();
                if (backupEndpointsJson != null) {
                    for (Object backupEndpoint : backupEndpointsJson) {
                        backupEndpoints.add(String.valueOf(backupEndpoint));
                    }
                }
                endpoints.setDefaultEndpoint(defaultEndpoint);
                endpoints.setBackupEndpoints(backupEndpoints);
                if (defaultEndpoint == null) {
                    logger.error("illegal endpoints, response = {}", string);
                    return;
                }
                logger.info("endpoints update, old = {}, new = {}", JSONObject.toJSONString(this.endpoints), JSONObject.toJSONString(endpoints));
                int ttl = json.getIntValue("ttl", 30);
                if (ttl <= 0 || ttl > 86400) {
                    ttl = 30;
                }
                this.nextFetchTime = System.currentTimeMillis() + ttl * 1000L;
                this.md5 = json.getString("md5");
                this.endpoints = endpoints;
            }
        } catch (EndpointFetchException e) {
            throw e;
        } catch (Exception e) {
            logger.error("fetch endpoints error, response = {}", string, e);
            throw new EndpointFetchException(e);
        }
    }

    @Override
    public Endpoints get() {
        return endpoints;
    }
}
