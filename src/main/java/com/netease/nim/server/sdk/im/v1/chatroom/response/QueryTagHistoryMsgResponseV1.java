package com.netease.nim.server.sdk.im.v1.chatroom.response;


import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Created by hekaijie on 2024/12/24
 */
public class QueryTagHistoryMsgResponseV1 {

    List<TagMsgBean> msgs;

    public List<TagMsgBean> getMsgs() {
        return msgs;
    }

    public void setMsgs(List<TagMsgBean> msgs) {
        this.msgs = msgs;
    }

    public class TagMsgBean {
        @JSONField(name = "msgid")
        private Long msgId;

        private String from;

        private Integer type;

        @JSONField(name = "sendtime")
        private Long sendTime;

        private String body;

        @JSONField(name = "fromclienttype")
        private Integer fromClientType;

        public Long getMsgId() {
            return msgId;
        }

        public void setMsgId(Long msgId) {
            this.msgId = msgId;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public Long getSendTime() {
            return sendTime;
        }

        public void setSendTime(Long sendTime) {
            this.sendTime = sendTime;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public Integer getFromClientType() {
            return fromClientType;
        }

        public void setFromClientType(Integer fromClientType) {
            this.fromClientType = fromClientType;
        }
    }
}
