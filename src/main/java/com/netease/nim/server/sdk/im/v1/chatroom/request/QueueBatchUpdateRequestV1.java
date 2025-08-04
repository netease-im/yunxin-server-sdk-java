package com.netease.nim.server.sdk.im.v1.chatroom.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;
import java.util.Map;

/**
 * Request for batch updating elements in chatroom queue
 */
public class QueueBatchUpdateRequestV1 {

    @YunxinParam("roomid")
    private Long roomid;
    
    @YunxinParam("operator")
    private String operator;

    @YunxinParam("elements")
    private Map<String, String> elements;

    @YunxinParam("needNotify")
    private Boolean needNotify;

    @YunxinParam("notifyExt")
    private String notifyExt;

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