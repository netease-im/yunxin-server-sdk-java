package com.netease.nim.server.sdk.im.v2.broadcast.request;

import com.alibaba.fastjson2.annotation.JSONField;


public class QueryBroadcastNotificationListRequestV2 {

    @JSONField(name = "page_token")
    private String pageToken;
    @JSONField(name = "limit")
    private Integer limit;
    @JSONField(name = "type")
    private Integer type;

    public QueryBroadcastNotificationListRequestV2() {
        // Default values
        this.type = 1;
        this.limit = 100;
    }
    public String getPageToken() {
        return pageToken;
    }

    public void setPageToken(String pageToken) {
        this.pageToken = pageToken;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        if (type != null && (type == 1 || type == 2 || type == 3)) {
            this.type = type;
        } else {
            this.type = 1;
        }
    }
} 