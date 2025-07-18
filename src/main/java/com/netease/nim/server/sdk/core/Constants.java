package com.netease.nim.server.sdk.core;

import com.netease.nim.server.sdk.core.endpoint.DefaultRetryPolicy;
import com.netease.nim.server.sdk.core.endpoint.RetryPolicy;

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
        public static final RetryPolicy retryPolicy = new DefaultRetryPolicy(maxRetry, true);

        public static final RetryPolicy retryOn502 = new DefaultRetryPolicy(maxRetry, true);
        public static final RetryPolicy notRetryOn502 = new DefaultRetryPolicy(maxRetry, false);
    }

    public static class Metric {
        public static final boolean enable = true;
        public static final int collectIntervalSeconds = 60;
    }

    public static class Endpoint {

        public static final int scheduleDetectIntervalSeconds = 5;
        public static final int scheduleResultIntervalSeconds = 10;
        public static final int scheduleFetchIntervalSeconds = 60;
        public static final int slideWindowBuckets = 12;
        public static final long slideWindowTime = 5000L;

        public static class LBS {
            public static final String default_lbs = "https://srv-sdk-lbs.yunxinapi.com/srv-sdk/allocate";
            public static final String cn_lbs = "https://srv-sdk-lbs-cn.yunxinapi.com/srv-sdk/allocate";
            public static final String sg_lbs = "https://srv-sdk-lbs-sg.yunxinapi.com/srv-sdk/allocate";
        }

        public static class IM {
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

        public static class RTC {
            public static class CN {
                public static final String DEFAULT = "https://rtc.yunxinapi.com";
                public static final String BACKUP_1 = "https://rtc-pri.yunxinapi.com";
                public static final String BACKUP_2 = "https://rtc-bak.yunxinapi.com";
            }

            public static class SG {
                public static final String DEFAULT = "https://rtc-ap.yunxinapi.com";
                public static final String BACKUP_1 = "https://rtc-ap-bak.yunxinapi.com";
            }
        }

        public static class SMS {
            public static class CN {
                public static final String DEFAULT = "https://sms.yunxinapi.com/sms";
                public static final String BACKUP_1 = "https://sms-backup.yunxinapi.com/sms";
            }
        }

        public static class LIVE {
            public static class CN {
                public static final String DEFAULT = "https://vcloud.yunxinapi.com";
                public static final String BACKUP_1 = "https://vcloud.163.com";
            }

            public static class SG {
                public static final String DEFAULT = "https://vcloud-sea.yunxinapi.com";
                public static final String BACKUP_1 = "https://api-sea.yunxinvcloud.com";
            }
        }

        public static class VOD {
            public static class CN {
                public static final String DEFAULT = "https://vcloud.yunxinapi.com";
                public static final String BACKUP_1 = "https://vcloud.163.com";
            }

            public static class SG {
                public static final String DEFAULT = "https://vcloud-sea.yunxinapi.com";
                public static final String BACKUP_1 = "https://api-sea.yunxinvcloud.com";
            }
        }

        public static class MEETING {
            public static class CN {
                public static final String DEFAULT = "https://roomkit-alt1.yunxinapi.com";
                public static final String BACKUP_1 = "https://roomkit-alt2.yunxinapi.com";
            }
        }

        public static class NEROOM {
            public static class CN {
                public static final String DEFAULT = "https://roomkit-alt1.yunxinapi.com";
                public static final String BACKUP_1 = "https://roomkit-alt2.yunxinapi.com";
            }
            public static class SG {
                public static final String DEFAULT = "https://roomkit-sg.yunxinapi.com";
                public static final String BACKUP_1 = "https://roomkit-sg-alt1.yunxinapi.com";
            }
        }

    }
}
