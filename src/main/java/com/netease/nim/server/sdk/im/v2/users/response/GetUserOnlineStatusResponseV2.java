package com.netease.nim.server.sdk.im.v2.users.response;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Response class for getting users' online status
 */
public class GetUserOnlineStatusResponseV2 {

    @JSONField(name = "success_list")
    private List<UserOnlineStatus> successList;

    @JSONField(name = "failed_list")
    private List<FailedInfo> failedList;

    /**
     * User online status information for successfully queried accounts
     */
    public static class UserOnlineStatus {
        @JSONField(name = "account_id")
        private String accountId;
        
        @JSONField(name = "online_status")
        private List<ClientStatus> onlineStatus;
        
        public String getAccountId() {
            return accountId;
        }

        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }

        public List<ClientStatus> getOnlineStatus() {
            return onlineStatus;
        }

        public void setOnlineStatus(List<ClientStatus> onlineStatus) {
            this.onlineStatus = onlineStatus;
        }
    }
    
    /**
     * Client status information
     */
    public static class ClientStatus {
        /**
         * Client type: Android
         */
        public static final int CLIENT_TYPE_ANDROID = 1;
        
        /**
         * Client type: iOS
         */
        public static final int CLIENT_TYPE_IOS = 2;
        
        /**
         * Client type: PC
         */
        public static final int CLIENT_TYPE_PC = 4;
        
        /**
         * Client type: Web
         */
        public static final int CLIENT_TYPE_WEB = 16;
        
        /**
         * Client type: Mac
         */
        public static final int CLIENT_TYPE_MAC = 64;
        
        /**
         * Client type: Harmony
         */
        public static final int CLIENT_TYPE_HARMONY = 65;
        
        @JSONField(name = "client_type")
        private Integer clientType;
        
        @JSONField(name = "login_time")
        private Long loginTime;

        public Integer getClientType() {
            return clientType;
        }

        public void setClientType(Integer clientType) {
            this.clientType = clientType;
        }

        public Long getLoginTime() {
            return loginTime;
        }

        public void setLoginTime(Long loginTime) {
            this.loginTime = loginTime;
        }
    }

    /**
     * Information about failed queries
     */
    public static class FailedInfo {
        @JSONField(name = "account_id")
        private String accountId;
        
        @JSONField(name = "error_code")
        private Integer errorCode;
        
        @JSONField(name = "error_msg")
        private String errorMsg;

        public String getAccountId() {
            return accountId;
        }

        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }

        public Integer getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(Integer errorCode) {
            this.errorCode = errorCode;
        }

        public String getErrorMsg() {
            return errorMsg;
        }

        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }
    }

    public List<UserOnlineStatus> getSuccessList() {
        return successList;
    }

    public void setSuccessList(List<UserOnlineStatus> successList) {
        this.successList = successList;
    }

    public List<FailedInfo> getFailedList() {
        return failedList;
    }

    public void setFailedList(List<FailedInfo> failedList) {
        this.failedList = failedList;
    }
} 