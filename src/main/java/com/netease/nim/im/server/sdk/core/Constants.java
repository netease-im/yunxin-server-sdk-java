package com.netease.nim.im.server.sdk.core;

import com.netease.nim.im.server.sdk.core.endpoint.DefaultRetryPolicy;
import com.netease.nim.im.server.sdk.core.endpoint.DynamicEndpointSelector;
import com.netease.nim.im.server.sdk.core.endpoint.RetryPolicy;

/**
 * Created by caojiajun on 2024/11/27
 */
public class Constants {

    public static class Http {
        public static final long connectTimeoutMillis = 5000L;
        public static final long readTimeoutMillis = 5000L;
        public static final long writeTimeoutMillis = 5000L;
        public static final int maxRequests = 4096;
        public static final int maxRequestsPerHost = 2048;
        public static final int keepAliveSeconds = 3;
        public static final int maxIdleConnections = 512;
    }

    public static class Retry {
        public static final int maxRetry = 1;
        public static final RetryPolicy retryPolicy = new DefaultRetryPolicy(true);
    }

    public static class Metric {
        public static final boolean enable = true;
        public static final int collectIntervalSeconds = 60;
    }

    public static class Endpoint {

        public static final String lbs = "https://lbs.netease.im/lbs/getApiEndpoints";

        public static final String detectPath = "/health/liveness.action";
        public static final int scheduleDetectIntervalSeconds = 5;
        public static final int scheduleResultIntervalSeconds = 10;
        public static final int scheduleFetchIntervalSeconds = 60;
        public static final int slideWindowBuckets = 12;
        public static final long slideWindowTime = 5000L;
        public static class CN {
            public static final String DEFAULT = "https://api-cn.yunxinapi.com/nimserver";
            public static final String BACKUP = "https://api-cn-bak.yunxinapi.com/nimserver";

            public static final String BACKUP_1 = "https://api-cn-01.yunxinapi.com/nimserver";
            public static final String BACKUP_2 = "https://api-cn-02.yunxinapi.com/nimserver";
            public static final String BACKUP_3 = "https://api-cn-03.yunxinapi.com/nimserver";
        }
        public static class SG {
            public static final String DEFAULT = "https://api-sg.yunxinapi.com/nimserver";
            public static final String BACKUP = "https://api-sg-bak.yunxinapi.com/nimserver";

            public static final String BACKUP_1 = "https://api-sg-01.yunxinapi.com/nimserver";
            public static final String BACKUP_2 = "https://api-sg-02.yunxinapi.com/nimserver";
            public static final String BACKUP_3 = "https://api-sg-03.yunxinapi.com/nimserver";
        }
    }
}
