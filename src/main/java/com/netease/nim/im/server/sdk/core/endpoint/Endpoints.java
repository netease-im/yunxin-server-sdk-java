package com.netease.nim.im.server.sdk.core.endpoint;

import java.util.List;

/**
 * Created by caojiajun on 2024/12/9
 */
public class Endpoints {

    private String defaultEndpoint;
    private List<String> backupEndpoints;

    public String getDefaultEndpoint() {
        return defaultEndpoint;
    }

    public void setDefaultEndpoint(String defaultEndpoint) {
        this.defaultEndpoint = defaultEndpoint;
    }

    public List<String> getBackupEndpoints() {
        return backupEndpoints;
    }

    public void setBackupEndpoints(List<String> backupEndpoints) {
        this.backupEndpoints = backupEndpoints;
    }
}
