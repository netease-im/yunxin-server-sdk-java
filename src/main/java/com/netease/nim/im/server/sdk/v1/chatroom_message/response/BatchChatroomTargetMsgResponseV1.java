package com.netease.nim.im.server.sdk.v1.chatroom_message.response;


import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

import java.util.List;

public class BatchChatroomTargetMsgResponseV1 {
    /**
     * 发送失败的消息说明
     */
    @YunxinParam("fail")
    private List<FailedMessage> failList;

    /**
     * 发送成功的消息的详细信息
     */
    @YunxinParam("success")
    private List<ChatroomTargetMsgResponseV1> successList;

    public List<FailedMessage> getFailList() {
        return failList;
    }

    public void setFailList(List<FailedMessage> failList) {
        this.failList = failList;
    }

    public List<ChatroomTargetMsgResponseV1> getSuccessList() {
        return successList;
    }

    public void setSuccessList(List<ChatroomTargetMsgResponseV1> successList) {
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


}
