package com.netease.nim.im.server.sdk.v1.chatroom.response;


import java.util.List;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class RemoveRobotResponseV1 {
    private List<String> failAccids;
    private List<String> successAccids;

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

}
