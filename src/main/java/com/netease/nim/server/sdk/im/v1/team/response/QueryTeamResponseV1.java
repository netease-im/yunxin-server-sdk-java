package com.netease.nim.server.sdk.im.v1.team.response;


import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Created by hekaijie on 2024/12/24
 */
public class QueryTeamResponseV1 {
    private List<TeamInfoV1> tinfos;

    public List<TeamInfoV1> getTinfos() {
        return tinfos;
    }

    public void setTinfos(List<TeamInfoV1> tinfos) {
        this.tinfos = tinfos;
    }

    public static class TeamInfoV1 {
        private String tname;

        private String icon;

        private String owner;

        @JSONField(name = "maxusers")
        private Integer maxUsers;

        private Long tid;

        private Integer size;

        private String announcement;

        private String intro;

        @JSONField(name = "joinmode")
        private Integer joinMode;

        @JSONField(name = "beinvitemode")
        private Integer beInviteMode;

        @JSONField(name = "uptinfomode")
        private Integer upTinfoMode;

        @JSONField(name = "upcustommode")
        private Integer upCustomMode;

        private Integer muteType;

        private Boolean isNotifyCloseOnline;

        private Boolean isNotifyClosePersistent;

        private String custom;

        private String clientCustom;

        private Boolean mute;

        private List<String> admins;

        private List<String> members;

        @JSONField(name = "createtime")
        private Long createTime;

        @JSONField(name = "updatetime")
        private Long updateTime;

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public Integer getMaxUsers() {
            return maxUsers;
        }

        public void setMaxUsers(Integer maxUsers) {
            this.maxUsers = maxUsers;
        }

        public Long getTid() {
            return tid;
        }

        public void setTid(Long tid) {
            this.tid = tid;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public String getAnnouncement() {
            return announcement;
        }

        public void setAnnouncement(String announcement) {
            this.announcement = announcement;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public Integer getJoinMode() {
            return joinMode;
        }

        public void setJoinMode(Integer joinMode) {
            this.joinMode = joinMode;
        }

        public Integer getBeInviteMode() {
            return beInviteMode;
        }

        public void setBeInviteMode(Integer beInviteMode) {
            this.beInviteMode = beInviteMode;
        }

        public Integer getUpTinfoMode() {
            return upTinfoMode;
        }

        public void setUpTinfoMode(Integer upTinfoMode) {
            this.upTinfoMode = upTinfoMode;
        }

        public Integer getUpCustomMode() {
            return upCustomMode;
        }

        public void setUpCustomMode(Integer upCustomMode) {
            this.upCustomMode = upCustomMode;
        }

        public Integer getMuteType() {
            return muteType;
        }

        public void setMuteType(Integer muteType) {
            this.muteType = muteType;
        }

        public Boolean getNotifyCloseOnline() {
            return isNotifyCloseOnline;
        }

        public void setNotifyCloseOnline(Boolean notifyCloseOnline) {
            isNotifyCloseOnline = notifyCloseOnline;
        }

        public Boolean getNotifyClosePersistent() {
            return isNotifyClosePersistent;
        }

        public void setNotifyClosePersistent(Boolean notifyClosePersistent) {
            isNotifyClosePersistent = notifyClosePersistent;
        }

        public String getCustom() {
            return custom;
        }

        public void setCustom(String custom) {
            this.custom = custom;
        }

        public String getClientCustom() {
            return clientCustom;
        }

        public void setClientCustom(String clientCustom) {
            this.clientCustom = clientCustom;
        }

        public Boolean getMute() {
            return mute;
        }

        public void setMute(Boolean mute) {
            this.mute = mute;
        }

        public List<String> getAdmins() {
            return admins;
        }

        public void setAdmins(List<String> admins) {
            this.admins = admins;
        }

        public List<String> getMembers() {
            return members;
        }

        public void setMembers(List<String> members) {
            this.members = members;
        }

        public Long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
        }

        public Long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Long updateTime) {
            this.updateTime = updateTime;
        }
    }

}
