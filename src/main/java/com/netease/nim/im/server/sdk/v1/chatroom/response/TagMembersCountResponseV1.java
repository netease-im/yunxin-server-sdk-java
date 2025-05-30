package com.netease.nim.im.server.sdk.v1.chatroom.response;


/**
 * Created by hekaijie on 2024/12/24
 */
public class TagMembersCountResponseV1 {

    private String tag;
    private Integer onlineUserCount;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getOnlineUserCount() {
        return onlineUserCount;
    }

    public void setOnlineUserCount(Integer onlineUserCount) {
        this.onlineUserCount = onlineUserCount;
    }
}
