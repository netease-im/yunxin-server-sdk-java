package com.netease.nim.server.sdk.im.v1.chatroom_message.response;

import java.util.List;

/**
 * 批量发送聊天室定向消息的响应
 */
public class BatchChatroomTargetMsgResponseV1 {
    
    /**
     * 发送失败的消息列表
     */
    private List<FailedMessage> failList;
    
    /**
     * 发送成功的消息列表
     */
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
    
    /**
     * 发送失败的消息
     */
    public static class FailedMessage {
        /**
         * 客户端消息ID
         */
        private String clientMsgId;
        
        /**
         * 失败原因
         */
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
