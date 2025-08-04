package com.netease.nim.server.sdk.im.v1.super_team.request;

import java.util.List;

public class GetSuperTeamMessageByIdsRequestV1 {

    private List<Msg> msgs;

    public List<Msg> getMsgs() {
        return msgs;
    }

    public void setMsgs(List<Msg> msgs) {
        this.msgs = msgs;
    }

    public static class Msg {
        /**
         * 服务端消息 ID
         */
        private Long msgid;

        /**
         * 消息发送方账号，accid
         */
        private String from;

        /**
         * 超大群 ID
         */
        private Long to;

        /**
         * 消息发送时间
         */
        private Long time;

        public Long getMsgid() {
            return msgid;
        }

        public void setMsgid(Long msgid) {
            this.msgid = msgid;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public Long getTo() {
            return to;
        }

        public void setTo(Long to) {
            this.to = to;
        }

        public Long getTime() {
            return time;
        }

        public void setTime(Long time) {
            this.time = time;
        }
    }
}