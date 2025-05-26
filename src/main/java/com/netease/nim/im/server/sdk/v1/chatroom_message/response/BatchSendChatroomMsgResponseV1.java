package com.netease.nim.im.server.sdk.v1.chatroom_message.response;

import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

import java.util.List;

public class BatchSendChatroomMsgResponseV1 {

    /**
     * 发送失败的消息说明
     */
    @YunxinParam("fail")
    private List<FailedMessage> failList;

    /**
     * 发送成功的消息的详细信息
     */
    @YunxinParam("success")
    private List<SuccessfulMessage> successList;

    public List<FailedMessage> getFailList() {
        return failList;
    }

    public void setFailList(List<FailedMessage> failList) {
        this.failList = failList;
    }

    public List<SuccessfulMessage> getSuccessList() {
        return successList;
    }

    public void setSuccessList(List<SuccessfulMessage> successList) {
        this.successList = successList;
    }

    public static class FailedMessage {
        /**
         * 客户端消息 ID
         */
        @YunxinParam("clientMsgId")
        private String clientMsgId;

        /**
         * 发送失败原因描述
         */
        @YunxinParam("reason")
        private String reason;

        public String getClientMsgId() {
            return clientMsgId;
        }

        public void setClientMsgId(String clientMsgId) {
            this.clientMsgId = clientMsgId;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }
    }

    public static class SuccessfulMessage {
        /**
         * 客户端消息 ID
         */
        @YunxinParam("clientMsgId")
        private String clientMsgId;

        /**
         * 发送消息的用户昵称
         */
        @YunxinParam("fromNick")
        private String fromNick;

        /**
         * 发送消息的用户账号，accid
         */
        @YunxinParam("fromAccount")
        private String fromAccount;

        /**
         * 消息内容
         */
        @YunxinParam("attach")
        private String attach;

        /**
         * 发送消息的时间戳，毫秒级
         */
        @YunxinParam("time")
        private String time;

        /**
         * 消息类型
         */
        @YunxinParam("type")
        private Integer type;

        /**
         * 高优先级消息标记
         */
        @YunxinParam("highPriorityFlag")
        private String highPriorityFlag;

        /**
         * 聊天室 ID
         */
        @YunxinParam("roomId")
        private String roomId;

        public String getFromNick() {
            return fromNick;
        }

        public void setFromNick(String fromNick) {
            this.fromNick = fromNick;
        }

        public String getFromAccount() {
            return fromAccount;
        }

        public void setFromAccount(String fromAccount) {
            this.fromAccount = fromAccount;
        }

        public String getAttach() {
            return attach;
        }

        public void setAttach(String attach) {
            this.attach = attach;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public String getHighPriorityFlag() {
            return highPriorityFlag;
        }

        public void setHighPriorityFlag(String highPriorityFlag) {
            this.highPriorityFlag = highPriorityFlag;
        }

        public String getRoomId() {
            return roomId;
        }

        public void setRoomId(String roomId) {
            this.roomId = roomId;
        }

        public String getClientMsgId() {
            return clientMsgId;
        }

        public void setClientMsgId(String clientMsgId) {
            this.clientMsgId = clientMsgId;
        }
    }
}