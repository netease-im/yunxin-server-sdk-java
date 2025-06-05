package com.netease.nim.server.sdk.im.v1.chatroom.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;
import java.util.List;

/**
 * Request for batch adding elements to chatroom queue
 */
public class QueueBatchOfferRequestV1 {

    /**
     * Chatroom ID
     */
    @YunxinParam("roomid")
    private Long roomId;
    
    /**
     * Operator account for batch adding elements.
     * Default is the creator of the chatroom if not specified.
     */
    @YunxinParam("operator")
    private String operator;
    
    /**
     * Whether the added element needs to be deleted when the owner goes offline or leaves the chatroom.
     * true: needs to be deleted; false: does not need to be deleted (default).
     * If set to true and the owner is not currently in the chatroom, then adding the element fails.
     * If transient parameter is not configured for individual elements, then this field's configuration is used.
     */
    @YunxinParam("transient")
    private Boolean transient_;
    
    /**
     * Key-value pairs of elements to add, maximum 20.
     */
    @YunxinParam("elements")
    private List<QueueElement> elements;
    
    /**
     * Whether to send update notification, default is true, notification is needed.
     * If set to false, frequency control is not triggered.
     */
    @YunxinParam("needNotify")
    private Boolean needNotify;
    
    /**
     * Notification event extension field, maximum length 2048 characters.
     */
    @YunxinParam("notifyExt")
    private String notifyExt;
    
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
    
    /**
     * Queue element class for batch offer
     */
    public static class QueueElement {
        /**
         * Element key
         */
        private String key;
        
        /**
         * Element value
         */
        private String value;
        
        /**
         * Account of the element owner, default is operator if not specified
         */
        private String accid;
        
        /**
         * Whether to delete the element when leaving the chatroom
         */
        private Boolean transient_;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getAccid() {
            return accid;
        }

        public void setAccid(String accid) {
            this.accid = accid;
        }

        public Boolean getTransient_() {
            return transient_;
        }

        public void setTransient_(Boolean transient_) {
            this.transient_ = transient_;
        }
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Boolean getTransient_() {
        return transient_;
    }

    public void setTransient_(Boolean transient_) {
        this.transient_ = transient_;
    }

    public List<QueueElement> getElements() {
        return elements;
    }

    public void setElements(List<QueueElement> elements) {
        this.elements = elements;
    }

    public Boolean getNeedNotify() {
        return needNotify;
    }

    public void setNeedNotify(Boolean needNotify) {
        this.needNotify = needNotify;
    }

    public String getNotifyExt() {
        return notifyExt;
    }

    public void setNotifyExt(String notifyExt) {
        this.notifyExt = notifyExt;
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