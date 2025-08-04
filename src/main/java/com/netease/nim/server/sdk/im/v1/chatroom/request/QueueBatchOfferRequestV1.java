package com.netease.nim.server.sdk.im.v1.chatroom.request;

import com.alibaba.fastjson2.annotation.JSONField;
import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;
import java.util.List;

/**
 * Request for batch adding elements to chatroom queue
 */
public class QueueBatchOfferRequestV1 {

    @YunxinParam("roomid")
    private Long roomid;

    @YunxinParam("operator")
    private String operator;

    @YunxinParam("transient")
    private Boolean transient_;

    @YunxinParam("elements")
    private List<QueueElement> elements;

    @YunxinParam("needNotify")
    private Boolean needNotify;
    
    @YunxinParam("notifyExt")
    private String notifyExt;

    @YunxinParam("highPriority")
    private Integer highPriority;
    
    @YunxinParam("highPriorityPolicy")
    private Integer highPriorityPolicy;

    public static class QueueElement {

        private String key;

        private String value;

        private String accid;

        @JSONField(name = "transient")
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

        public Boolean getTransient() {
            return transient_;
        }

        public void setTransient(Boolean value) {
            this.transient_ = value;
        }
    }

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