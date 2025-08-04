package com.netease.nim.server.sdk.im.v2.account.response;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Created by caojiajun on 2024/12/11
 */
public class BatchQueryAccountsResponseV2 {

    @JSONField(name = "success_list")
    private List<Account> successList;

    @JSONField(name = "failed_list")
    private List<FailedAccount> failedList;

    public List<Account> getSuccessList() {
        return successList;
    }

    public void setSuccessList(List<Account> successList) {
        this.successList = successList;
    }

    public List<FailedAccount> getFailedList() {
        return failedList;
    }

    public void setFailedList(List<FailedAccount> failedList) {
        this.failedList = failedList;
    }

    public static class Account {
        @JSONField(name = "account_id")
        private String accountId;

        @JSONField(name = "configuration")
        private Configuration configuration;

        public String getAccountId() {
            return accountId;
        }

        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }

        public Configuration getConfiguration() {
            return configuration;
        }

        public void setConfiguration(Configuration configuration) {
            this.configuration = configuration;
        }

        public static class Configuration {

            @JSONField(name = "enabled")
            private Boolean enabled;

            @JSONField(name = "p2p_chat_banned")
            private Boolean p2pChatBanned;

            @JSONField(name = "team_chat_banned")
            private Boolean teamChatBanned;

            @JSONField(name = "chatroom_chat_banned")
            private Boolean chatroomChatBanned;

            @JSONField(name = "qchat_chat_banned")
            private Boolean qchatChatBanned;

            @JSONField(name = "push_enabled_when_desktop_online")
            private Boolean pushEnabledWhenDesktopOnline;

            public Boolean getEnabled() {
                return enabled;
            }

            public void setEnabled(Boolean enabled) {
                this.enabled = enabled;
            }

            public Boolean getP2pChatBanned() {
                return p2pChatBanned;
            }

            public void setP2pChatBanned(Boolean p2pChatBanned) {
                this.p2pChatBanned = p2pChatBanned;
            }

            public Boolean getTeamChatBanned() {
                return teamChatBanned;
            }

            public void setTeamChatBanned(Boolean teamChatBanned) {
                this.teamChatBanned = teamChatBanned;
            }

            public Boolean getChatroomChatBanned() {
                return chatroomChatBanned;
            }

            public void setChatroomChatBanned(Boolean chatroomChatBanned) {
                this.chatroomChatBanned = chatroomChatBanned;
            }

            public Boolean getQchatChatBanned() {
                return qchatChatBanned;
            }

            public void setQchatChatBanned(Boolean qchatChatBanned) {
                this.qchatChatBanned = qchatChatBanned;
            }

            public Boolean getPushEnabledWhenDesktopOnline() {
                return pushEnabledWhenDesktopOnline;
            }

            public void setPushEnabledWhenDesktopOnline(Boolean pushEnabledWhenDesktopOnline) {
                this.pushEnabledWhenDesktopOnline = pushEnabledWhenDesktopOnline;
            }
        }
    }

    public static class FailedAccount {

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
}
