package com.netease.nim.im.server.sdk.v2.account.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Created by caojiajun on 2024/12/11
 */
public class UpdateAccountRequestV2 {

    @JSONField(name = "account_id")
    private String accountId;

    @JSONField(name = "token")
    private String token;

    @JSONField(name = "configuration")
    private Configuration configuration;

    @JSONField(name = "need_kick")
    private Boolean needKick;

    @JSONField(name = "kick_notify_extension")
    private String kickNotifyExtension;

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
    }

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

    public Boolean getNeedKick() {
        return needKick;
    }

    public void setNeedKick(Boolean needKick) {
        this.needKick = needKick;
    }

    public String getKickNotifyExtension() {
        return kickNotifyExtension;
    }

    public void setKickNotifyExtension(String kickNotifyExtension) {
        this.kickNotifyExtension = kickNotifyExtension;
    }
}
