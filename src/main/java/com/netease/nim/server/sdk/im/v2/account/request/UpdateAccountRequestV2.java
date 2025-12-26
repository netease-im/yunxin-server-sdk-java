package com.netease.nim.server.sdk.im.v2.account.request;

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

    @JSONField(name = "user_information")
    private UserInformation userInformation;

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

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    public static class UserInformation {

        @JSONField(name = "name")
        private String name;

        @JSONField(name = "avatar")
        private String avatar;

        @JSONField(name = "sign")
        private String sign;

        @JSONField(name = "email")
        private String email;

        @JSONField(name = "birthday")
        private String birthday;

        @JSONField(name = "mobile")
        private String mobile;

        @JSONField(name = "gender")
        private Integer gender;

        @JSONField(name = "extension")
        private String extension;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Integer getGender() {
            return gender;
        }

        public void setGender(Integer gender) {
            this.gender = gender;
        }

        public String getExtension() {
            return extension;
        }

        public void setExtension(String extension) {
            this.extension = extension;
        }

    }
}
