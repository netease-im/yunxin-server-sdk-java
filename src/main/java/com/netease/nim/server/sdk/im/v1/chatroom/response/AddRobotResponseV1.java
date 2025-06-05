package com.netease.nim.server.sdk.im.v1.chatroom.response;


import java.util.List;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class AddRobotResponseV1 {
    private List<String> failAccids;
    private List<String> successAccids;
    private List<String> oldAccids;

    public List<String> getFailAccids() {
        return failAccids;
    }

    public void setFailAccids(List<String> failAccids) {
        this.failAccids = failAccids;
    }

    public List<String> getSuccessAccids() {
        return successAccids;
    }

    public void setSuccessAccids(List<String> successAccids) {
        this.successAccids = successAccids;
    }

    public List<String> getOldAccids() {
        return oldAccids;
    }

    public void setOldAccids(List<String> oldAccids) {
        this.oldAccids = oldAccids;
    }
}
