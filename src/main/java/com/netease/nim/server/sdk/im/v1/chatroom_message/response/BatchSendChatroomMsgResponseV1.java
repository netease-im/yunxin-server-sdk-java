package com.netease.nim.server.sdk.im.v1.chatroom_message.response;


import java.util.List;

public class BatchSendChatroomMsgResponseV1 {

    private List<FailedMessage> failList;

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

        private String clientMsgId;

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

        private String clientMsgId;

        private String fromNick;

        private String fromAccount;

        private String attach;

        private String time;

        private Integer type;

        private String highPriorityFlag;

        private Long roomId;

        private String ext;

        private String fromClientType;

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

        public Long getRoomId() {
            return roomId;
        }

        public void setRoomId(Long roomId) {
            this.roomId = roomId;
        }

        public String getClientMsgId() {
            return clientMsgId;
        }

        public void setClientMsgId(String clientMsgId) {
            this.clientMsgId = clientMsgId;
        }

        public String getExt() {
            return ext;
        }

        public void setExt(String ext) {
            this.ext = ext;
        }

        public String getFromClientType() {
            return fromClientType;
        }

        public void setFromClientType(String fromClientType) {
            this.fromClientType = fromClientType;
        }
    }
}