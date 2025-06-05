package com.netease.nim.server.sdk.core.metrics;


import com.netease.nim.server.sdk.core.BizName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caojiajun on 2024/12/10
 */
public class Stats {

    private BizName bizName;
    private List<EndpointStats> endpointStatsList = new ArrayList<>();
    private List<UriStats> uriStatsList = new ArrayList<>();

    public BizName getBizName() {
        return bizName;
    }

    public void setBizName(BizName bizName) {
        this.bizName = bizName;
    }

    public List<EndpointStats> getEndpointStatsList() {
        return endpointStatsList;
    }

    public void setEndpointStatsList(List<EndpointStats> endpointStatsList) {
        this.endpointStatsList = endpointStatsList;
    }

    public List<UriStats> getUriStatsList() {
        return uriStatsList;
    }

    public void setUriStatsList(List<UriStats> uriStatsList) {
        this.uriStatsList = uriStatsList;
    }
}
