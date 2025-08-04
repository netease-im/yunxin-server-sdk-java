package com.netease.nim.server.sdk.im.v1.chatroom.response;



import java.util.List;

/**
 * Created by hekaijie on 2024/12/24
 */
public class QueryTagHistoryMsgResponseV1 {

    private List<TagMsgBean> msgs;

    public List<TagMsgBean> getMsgs() {
        return msgs;
    }

    public void setMsgs(List<TagMsgBean> msgs) {
        this.msgs = msgs;
    }

    public static class TagMsgBean {
        private String msgid;

        private String from;

        private Integer type;

        private Long sendtime;

        private String body;

        private Integer fromclienttype;

        public String getMsgid() {
            return msgid;
        }

        public void setMsgid(String msgid) {
            this.msgid = msgid;
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

        public Long getSendtime() {
            return sendtime;
        }

        public void setSendtime(Long sendtime) {
            this.sendtime = sendtime;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public Integer getFromclienttype() {
            return fromclienttype;
        }

        public void setFromclienttype(Integer fromclienttype) {
            this.fromclienttype = fromclienttype;
        }
    }
}
