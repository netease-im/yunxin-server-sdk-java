package com.netease.nim.server.sdk.im.v1.team.response;



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

        private Integer maxusers;

        private Long tid;

        private Integer size;

        private String announcement;

        private String intro;

        private Integer joinmode;

        private Integer beinvitemode;

        private Integer uptinfomode;

        private Integer upcustommode;

        private Integer invitemode;

        private Integer muteType;

        private Boolean isNotifyCloseOnline;

        private Boolean isNotifyClosePersistent;

        private String custom;

        private String clientCustom;

        private Boolean mute;

        private List<String> admins;

        private List<String> members;

        private Long createtime;

        private Long updatetime;

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

        public Integer getMaxusers() {
            return maxusers;
        }

        public void setMaxusers(Integer maxusers) {
            this.maxusers = maxusers;
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

        public Integer getJoinmode() {
            return joinmode;
        }

        public void setJoinmode(Integer joinmode) {
            this.joinmode = joinmode;
        }

        public Integer getBeinvitemode() {
            return beinvitemode;
        }

        public void setBeinvitemode(Integer beinvitemode) {
            this.beinvitemode = beinvitemode;
        }

        public Integer getUptinfomode() {
            return uptinfomode;
        }

        public void setUptinfomode(Integer uptinfomode) {
            this.uptinfomode = uptinfomode;
        }

        public Integer getUpcustommode() {
            return upcustommode;
        }

        public void setUpcustommode(Integer upcustommode) {
            this.upcustommode = upcustommode;
        }

        public Integer getInvitemode() {
            return invitemode;
        }

        public void setInvitemode(Integer invitemode) {
            this.invitemode = invitemode;
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
    }

}
