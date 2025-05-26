package com.netease.nim.im.server.sdk.v2.chatroom_queue.response;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Response for deleting chatroom queue
 * 
 * API: DELETE https://open.yunxinapi.com/im/v2/room_queues/{room_id}
 */
public class DeleteChatroomQueueResponseV2 {
    
    /**
     * Chatroom ID
     */
    @JSONField(name = "room_id")
    private Long roomId;
    
    /**
     * Queue size before deletion
     */
    @JSONField(name = "queue_size")
    private Integer queueSize;
    
    /**
     * Whether the queue change notification is a high priority message
     * Only returned if notification_enabled=true in the request
     */
    @JSONField(name = "high_priority")
    private Integer highPriority;
    
    /**
     * Default constructor
     */
    public DeleteChatroomQueueResponseV2() {
    }
    
    /**
     * Get chatroom ID
     * 
     * @return chatroom ID
     */
    public Long getRoomId() {
        return roomId;
    }
    
    /**
     * Set chatroom ID
     * 
     * @param roomId chatroom ID
     */
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    
    /**
     * Get queue size before deletion
     * 
     * @return queue size before deletion
     */
    public Integer getQueueSize() {
        return queueSize;
    }
    
    /**
     * Set queue size before deletion
     * 
     * @param queueSize queue size before deletion
     */
    public void setQueueSize(Integer queueSize) {
        this.queueSize = queueSize;
    }
    
    /**
     * Get whether the queue change notification is a high priority message
     * 
     * @return whether the queue change notification is a high priority message
     */
    public Integer getHighPriority() {
        return highPriority;
    }
    
    /**
     * Set whether the queue change notification is a high priority message
     * 
     * @param highPriority whether the queue change notification is a high priority message
     */
    public void setHighPriority(Integer highPriority) {
        this.highPriority = highPriority;
    }
} 