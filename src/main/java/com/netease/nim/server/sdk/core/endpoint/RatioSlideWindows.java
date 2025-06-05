package com.netease.nim.server.sdk.core.endpoint;

import com.netease.nim.server.sdk.core.utils.NamedThreadFactory;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by caojiajun on 2024/12/9
 */
public class RatioSlideWindows {

    private static final ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
            new NamedThreadFactory("yunxin-sdk-ratio-slide-windows"));

    private final Counter[] counter;
    private int index;

    public RatioSlideWindows(int bucketSize, long windowTimePerBucket) {
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

    public void incrementSuccess() {
        counter[index].incrementSuccess();
    }

    public void incrementFail() {
        counter[index].incrementFail();
    }

    public double getSuccessRatio() {
        long success = 0;
        long fail = 0;
        for (Counter c : counter) {
            success += c.success.sum();
            fail += c.fail.sum();
        }
        if (success + fail == 0) {
            return 1.0;
        }
        return success * 1.0 / (success + fail);
    }

    private static class Counter {
        LongAdder success = new LongAdder();
        LongAdder fail = new LongAdder();

        void incrementSuccess() {
            success.increment();
        }

        void incrementFail() {
            fail.increment();
        }

        void reset() {
            success.reset();
            fail.reset();
        }
    }
}
