package com.netease.nim.im.server.sdk.v1.chatroom.request;

import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;
import java.util.Map;

/**
 * Request for batch updating elements in chatroom queue
 */
public class QueueBatchUpdateRequestV1 {

    /**
     * Chatroom ID
     */
    @YunxinParam("roomid")
    private Long roomId;
    
    /**
     * Operator account for batch updating elements.
     * The operator must be the creator or admin of the chatroom.
     */
    @YunxinParam("operator")
    private String operator;
    
    /**
     * Updated elements key-value pairs, maximum 200.
     * Example: {"k1":"v1","k2":"v2"}
     */
    @YunxinParam("elements")
    private Map<String, String> elements;
    
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

    public Map<String, String> getElements() {
        return elements;
    }

    public void setElements(Map<String, String> elements) {
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