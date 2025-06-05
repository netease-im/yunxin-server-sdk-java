package com.netease.nim.server.sdk.core.endpoint;

import com.netease.nim.server.sdk.core.utils.NamedThreadFactory;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by caojiajun on 2024/12/9
 */
public class LatencySlideWindows {

    private static final ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
            new NamedThreadFactory("yunxin-sdk-latency-slide-windows"));

    private final Counter[] counter;
    private int index;

    public LatencySlideWindows(int bucketSize, long windowTimePerBucket) {
        counter = new Counter[bucketSize];
        for (int i=0; i<bucketSize; i++) {
            counter[i] = new Counter();
        }
        index = 0;
        scheduledExecutorService.scheduleAtFixedRate(this::slideToNextBucket, windowTimePerBucket, windowTimePerBucket, TimeUnit.MILLISECONDS);
    }

    private void slideToNextBucket() {
        int nextIndex;
        if (index == counter.length - 1) {
            nextIndex = 0;
        } else {
            nextIndex = index + 1;
        }
        counter[nextIndex].reset();
        index = nextIndex;
    }

    public void increment(long spendMs) {
        counter[index].increment(spendMs);
    }

    public double getLatency() {
        long sum = 0;
        long count = 0;
        for (Counter c : counter) {
            count += c.count.sum();
            sum += c.spend.sum();
        }
        return sum * 1.0 / count;
    }

    private static class Counter {
        LongAdder count = new LongAdder();
        LongAdder spend = new LongAdder();

        void increment(long spendMs) {
            count.increment();
            spend.add(spendMs);
        }

        void reset() {
            count.reset();
            spend.reset();
        }
    }
}
