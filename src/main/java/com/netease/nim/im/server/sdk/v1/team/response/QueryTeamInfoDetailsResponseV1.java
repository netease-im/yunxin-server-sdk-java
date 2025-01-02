package com.netease.nim.im.server.sdk.v1.team.response;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class QueryTeamInfoDetailsResponseV1 {

    public TeamInfo tinfo;

    public TeamInfo getTinfo() {
        return tinfo;
    }

    public void setTinfo(TeamInfo tinfo) {
        this.tinfo = tinfo;
    }

    public static class TeamMemberInfo {
        private Long createtime;

        private Long updatetime;

        private String nick;

        private String accid;

        private Boolean mute;

        private String custom;

        public Long getCreatetime() {
            return createtime;
        }

        public void setCreatetime(Long createtime) {
            this.createtime = createtime;
        }

        public Long getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(Long updatetime) {
            this.updatetime = updatetime;
        }

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public String getAccid() {
            return accid;
        }

        public void setAccid(String accid) {
            this.accid = accid;
        }

        public Boolean getMute() {
            return mute;
        }

        public void setMute(Boolean mute) {
            this.mute = mute;
        }

        public String getCustom() {
            return custom;
        }

        public void setCustom(String custom) {
            this.custom = custom;
        }
    }

    public static class TeamInfo {
        private String tname;

        private String icon;

        private TeamMemberInfo owner;

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

        @JSONField(name = "invitemode")
        private Integer inviteMode;

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

        private List<TeamMemberInfo> admins;

        private List<TeamMemberInfo> members;

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

        public Integer getInviteMode() {
            return inviteMode;
        }

        public void setInviteMode(Integer inviteMode) {
            this.inviteMode = inviteMode;
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

        public TeamMemberInfo getOwner() {
            return owner;
        }

        public void setOwner(TeamMemberInfo owner) {
            this.owner = owner;
        }

        public List<TeamMemberInfo> getAdmins() {
            return admins;
        }

        public void setAdmins(List<TeamMemberInfo> admins) {
            this.admins = admins;
        }

        public List<TeamMemberInfo> getMembers() {
            return members;
        }

        public void setMembers(List<TeamMemberInfo> members) {
            this.members = members;
        }
    }
}
