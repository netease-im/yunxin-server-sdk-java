package com.netease.nim.server.sdk.im.v1.account.response;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Created by caojiajun on 2025/3/26
 */
public class QueryUserInfosResponseV1 {

    private List<UserInfo> userInfoList;

    public List<UserInfo> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<UserInfo> userInfoList) {
        this.userInfoList = userInfoList;
    }

    public static class UserInfo {

        @JSONField(name = "accid")
        private String accid;

        @JSONField(name = "name")
        private String name;

        @JSONField(name = "icon")
        private String icon;

        @JSONField(name = "sign")
        private String sign;

        @JSONField(name = "email")
        private String email;

        @JSONField(name = "birth")
        private String birth;

        @JSONField(name = "mobile")
        private String mobile;

        @JSONField(name = "ex")
        private String ex;

        @JSONField(name = "gender")
        private Integer gender;

        @JSONField(name = "valid")
        private Boolean valid;

        @JSONField(name = "mute")
        private Boolean mute;

        @JSONField(name = "muteP2P")
        private Boolean muteP2P;

        @JSONField(name = "muteQChat")
        private Boolean muteQChat;

        @JSONField(name = "muteTeam")
        private Boolean muteTeam;

        @JSONField(name = "muteRoom")
        private Boolean muteRoom;

        public String getAccid() {
            return accid;
        }

        public void setAccid(String accid) {
            this.accid = accid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
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

        public String getBirth() {
            return birth;
        }

        public void setBirth(String birth) {
            this.birth = birth;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getEx() {
            return ex;
        }

        public void setEx(String ex) {
            this.ex = ex;
        }

        public Integer getGender() {
            return gender;
        }

        public void setGender(Integer gender) {
            this.gender = gender;
        }

        public Boolean getValid() {
            return valid;
        }

        public void setValid(Boolean valid) {
            this.valid = valid;
        }

        public Boolean getMute() {
            return mute;
        }

        public void setMute(Boolean mute) {
            this.mute = mute;
        }

        public Boolean getMuteP2P() {
            return muteP2P;
        }

        public void setMuteP2P(Boolean muteP2P) {
            this.muteP2P = muteP2P;
        }

        public Boolean getMuteQChat() {
            return muteQChat;
        }

        public void setMuteQChat(Boolean muteQChat) {
            this.muteQChat = muteQChat;
        }

        public Boolean getMuteTeam() {
            return muteTeam;
        }

        public void setMuteTeam(Boolean muteTeam) {
            this.muteTeam = muteTeam;
        }

        public Boolean getMuteRoom() {
            return muteRoom;
        }

        public void setMuteRoom(Boolean muteRoom) {
            this.muteRoom = muteRoom;
        }
    }
}
