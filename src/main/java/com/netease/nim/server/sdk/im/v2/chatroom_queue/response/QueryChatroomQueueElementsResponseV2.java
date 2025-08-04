package com.netease.nim.server.sdk.im.v2.chatroom_queue.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for querying chatroom queue elements
 * 
 * API: POST https://open.yunxinapi.com/im/v2/room_queues/{room_id}/actions/query
 */
public class QueryChatroomQueueElementsResponseV2 {
    
    /**
     * Chatroom ID
     */
    @JSONField(name = "room_id")
    private Long roomId;
    
    /**
     * Maximum queue size
     */
    @JSONField(name = "queue_size_limit")
    private Long queueSizeLimit;
    
    /**
     * Current queue size
     */
    @JSONField(name = "queue_size")
    private Long queueSize;
    
    /**
     * List of queue elements
     */
    @JSONField(name = "element_list")
    private List<QueueElement> elementList;
    
    /**
     * Default constructor
     */
    public QueryChatroomQueueElementsResponseV2() {
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
     * Get maximum queue size
     * 
     * @return maximum queue size
     */
    public Long getQueueSizeLimit() {
        return queueSizeLimit;
    }
    
    /**
     * Set maximum queue size
     * 
     * @param queueSizeLimit maximum queue size
     */
    public void setQueueSizeLimit(Long queueSizeLimit) {
        this.queueSizeLimit = queueSizeLimit;
    }
    
    /**
     * Get current queue size
     * 
     * @return current queue size
     */
    public Long getQueueSize() {
        return queueSize;
    }
    
    /**
     * Set current queue size
     * 
     * @param queueSize current queue size
     */
    public void setQueueSize(Long queueSize) {
        this.queueSize = queueSize;
    }
    
    /**
     * Get queue elements
     * 
     * @return queue elements
     */
    public List<QueueElement> getElementList() {
        return elementList;
    }
    
    /**
     * Set queue elements
     * 
     * @param elementList queue elements
     */
    public void setElementList(List<QueueElement> elementList) {
        this.elementList = elementList;
    }
    
    /**
     * Represents a queue element
     */
    public static class QueueElement {
        
        /**
         * Element key
         */
        @JSONField(name = "element_key")
        private String elementKey;
        
        /**
         * Element value
         */
        @JSONField(name = "element_value")
        private String elementValue;
        
        /**
         * Element owner account ID
         */
        @JSONField(name = "element_account_id")
        private String elementAccountId;
        
        /**
         * Whether the element is removed when the owner leaves the chatroom
         */
        @JSONField(name = "element_transient")
        private Boolean elementTransient;
        
        /**
         * Default constructor
         */
        public QueueElement() {
        }
        
        /**
         * Get element key
         * 
         * @return element key
         */
        public String getElementKey() {
            return elementKey;
        }
        
        /**
         * Set element key
         * 
         * @param elementKey element key
         */
        public void setElementKey(String elementKey) {
            this.elementKey = elementKey;
        }
        
        /**
         * Get element value
         * 
         * @return element value
         */
        public String getElementValue() {
            return elementValue;
        }
        
        /**
         * Set element value
         * 
         * @param elementValue element value
         */
        public void setElementValue(String elementValue) {
            this.elementValue = elementValue;
        }
        
        /**
         * Get element owner account ID
         * 
         * @return element owner account ID
         */
        public String getElementAccountId() {
            return elementAccountId;
        }
        
        /**
         * Set element owner account ID
         * 
         * @param elementAccountId element owner account ID
         */
        public void setElementAccountId(String elementAccountId) {
            this.elementAccountId = elementAccountId;
        }
        
        /**
         * Get whether the element is removed when the owner leaves the chatroom
         * 
         * @return whether the element is removed when the owner leaves the chatroom
         */
        public Boolean getElementTransient() {
            return elementTransient;
        }
        
        /**
         * Set whether the element is removed when the owner leaves the chatroom
         * 
         * @param elementTransient whether the element is removed when the owner leaves the chatroom
         */
        public void setElementTransient(Boolean elementTransient) {
            this.elementTransient = elementTransient;
        }
    }
} 