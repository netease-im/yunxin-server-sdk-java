package com.netease.nim.im.server.sdk.v1.chatroom.request;


import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

import java.util.List;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class UpdateChatRoomRoleTagRequestV1 {
    @YunxinParam("roomId")
    private Long roomId;

    @YunxinParam("tags")
    private List<String> tags;

    @YunxinParam("accid")
    private String accid;

    @YunxinParam("notifyTargetTags")
    private String notifyTargetTags;


    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

    public String getNotifyTargetTags() {
        return notifyTargetTags;
    }

    public void setNotifyTargetTags(String notifyTargetTags) {
        this.notifyTargetTags = notifyTargetTags;
    }
}
