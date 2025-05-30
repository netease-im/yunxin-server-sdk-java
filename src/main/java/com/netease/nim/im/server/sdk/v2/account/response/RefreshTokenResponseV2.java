package com.netease.nim.im.server.sdk.v2.account.response;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Response for refreshing account token
 */
public class RefreshTokenResponseV2 {
    /**
     * Account ID
     */
    @JSONField(name = "account_id")
    private String accountId;

    /**
     * New refreshed token
     */
    private String token;

    /**
     * Account configuration
     */
    private Configuration configuration;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * Account configuration settings
     */
    public static class Configuration {
        /**
         * Whether the account is enabled
         */
        private Boolean enabled;

        /**
         * Whether the account is banned from P2P chat
         */
        @JSONField(name = "p2p_chat_banned")
        private Boolean p2pChatBanned;

        /**
         * Whether the account is banned from team chat
         */
        @JSONField(name = "team_chat_banned")
        private Boolean teamChatBanned;

        /**
         * Whether the account is banned from chatroom chat
         */
        @JSONField(name = "chatroom_chat_banned")
        private Boolean chatroomChatBanned;

        /**
         * Whether the account is banned from qchat chat
         */
        @JSONField(name = "qchat_chat_banned")
        private Boolean qchatChatBanned;

        /**
         * Whether push is enabled when desktop is online
         */
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