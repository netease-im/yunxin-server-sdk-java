package com.netease.nim.server.sdk.im.v2.chatroom_queue.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for updating chatroom queue
 * 
 * API: PATCH https://open.yunxinapi.com/im/v2/room_queues/{room_id}
 */
public class UpdateChatroomQueueResponseV2 {
    
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
     * List of successfully inserted element keys
     */
    @JSONField(name = "insert_element_list")
    private List<String> insertElementList;
    
    /**
     * List of successfully updated element keys
     */
    @JSONField(name = "update_element_list")
    private List<String> updateElementList;
    
    /**
     * List of elements that failed to be added or updated
     */
    @JSONField(name = "failed_element_list")
    private List<FailedElement> failedElementList;
    
    /**
     * Default constructor
     */
    public UpdateChatroomQueueResponseV2() {
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
     * Get list of successfully inserted element keys
     * 
     * @return list of successfully inserted element keys
     */
    public List<String> getInsertElementList() {
        return insertElementList;
    }
    
    /**
     * Set list of successfully inserted element keys
     * 
     * @param insertElementList list of successfully inserted element keys
     */
    public void setInsertElementList(List<String> insertElementList) {
        this.insertElementList = insertElementList;
    }
    
    /**
     * Get list of successfully updated element keys
     * 
     * @return list of successfully updated element keys
     */
    public List<String> getUpdateElementList() {
        return updateElementList;
    }
    
    /**
     * Set list of successfully updated element keys
     * 
     * @param updateElementList list of successfully updated element keys
     */
    public void setUpdateElementList(List<String> updateElementList) {
        this.updateElementList = updateElementList;
    }
    
    /**
     * Get list of elements that failed to be added or updated
     * 
     * @return list of elements that failed to be added or updated
     */
    public List<FailedElement> getFailedElementList() {
        return failedElementList;
    }
    
    /**
     * Set list of elements that failed to be added or updated
     * 
     * @param failedElementList list of elements that failed to be added or updated
     */
    public void setFailedElementList(List<FailedElement> failedElementList) {
        this.failedElementList = failedElementList;
    }
    
    /**
     * Failed element information
     */
    public static class FailedElement {
        
        /**
         * Element key that failed
         */
        @JSONField(name = "element_key")
        private String elementKey;
        
        /**
         * Error message
         */
        @JSONField(name = "error_msg")
        private String errorMsg;
        
        /**
         * Error code
         */
        @JSONField(name = "error_code")
        private Integer errorCode;
        
        /**
         * Default constructor
         */
        public FailedElement() {
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
         * Get error message
         * 
         * @return error message
         */
        public String getErrorMsg() {
            return errorMsg;
        }
        
        /**
         * Set error message
         * 
         * @param errorMsg error message
         */
        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }
        
        /**
         * Get error code
         * 
         * @return error code
         */
        public Integer getErrorCode() {
            return errorCode;
        }
        
        /**
         * Set error code
         * 
         * @param errorCode error code
         */
        public void setErrorCode(Integer errorCode) {
            this.errorCode = errorCode;
        }
    }
} 