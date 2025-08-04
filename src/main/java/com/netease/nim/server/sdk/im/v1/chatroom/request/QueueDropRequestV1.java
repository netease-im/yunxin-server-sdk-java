package com.netease.nim.server.sdk.im.v1.chatroom.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

/**
 * Request for cleaning up (dropping) a chatroom queue
 */
public class QueueDropRequestV1 {

    @YunxinParam("roomid")
    private Long roomid;
    
    @YunxinParam("highPriority")
    private Integer highPriority;

    @YunxinParam("highPriorityPolicy")
    private Integer highPriorityPolicy;

    public Long getRoomid() {
        return roomid;
    }

    public void setRoomid(Long roomid) {
        this.roomid = roomid;
    }

    public Integer getHighPriority() {
        return highPriority;
    }

    public void setHighPriority(Integer highPriority) {
        this.highPriority = highPriority;
    }

    public Integer getHighPriorityPolicy() {
        return highPriorityPolicy;
    }

    public void setHighPriorityPolicy(Integer highPriorityPolicy) {
        this.highPriorityPolicy = highPriorityPolicy;
    }
} 