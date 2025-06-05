package com.netease.nim.server.sdk.im.v1.chatroom.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

/**
 * Request for cleaning up (dropping) a chatroom queue
 */
public class QueueDropRequestV1 {

    /**
     * Chatroom ID
     */
    @YunxinParam("roomid")
    private Long roomId;
    
    /**
     * Whether to set as high priority message
     * 0: No (default); 1: Yes, high priority message
     */
    @YunxinParam("highPriority")
    private Integer highPriority;
    
    /**
     * High priority message policy: for high priority messages,
     * whether to downgrade to normal message when exceeding flow control or return 416 error code
     * 0: Downgrade to normal message (default); 1: Return 416 error code
     */
    @YunxinParam("highPriorityPolicy")
    private Integer highPriorityPolicy;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
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