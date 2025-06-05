package com.netease.nim.server.sdk.im.v1.super_team.response;

public class SuperTeamInfo {
    /**
     * 超大群 ID
     */
    private Long tid;

    /**
     * 超大群名称
     */
    private String tname;

    /**
     * 群主，创建者
     */
    private String creator;

    /**
     * 超大群级别，群最大人数
     */
    private Integer tlevel;

    /**
     * 超大群大小，即当前群人数
     */
    private Integer size;

    /**
     * 超大群介绍
     */
    private String intro;

    /**
     * 超大群公告
     */
    private String announcement;

    /**
     * 第三方客户端自定义字段
     */
    private String clientCustom;

    /**
     * 第三方服务器扩展字段
     */
    private String serverCustom;

    /**
     * 超大群头像
     */
    private String icon;

    /**
     * 群禁言类型
     */
    private Integer muteType;

    /**
     * 申请入群的验证方式
     */
    private Integer joinmode;

    /**
     * 邀请入群的验证方式
     */
    private Integer beinvitemode;

    /**
     * 邀请入群的权限，即谁可以邀请他人入群
     */
    private Integer invitemode;

    /**
     * 修改群信息权限
     */
    private Integer uptinfomode;

    /**
     * 修改群自定义属性的权限
     */
    private Integer upcustommode;

    /**
     * 创建时间
     */
    private Long createtime;

    /**
     * 更新时间
     */
    private Long updatetime;

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Integer getTlevel() {
        return tlevel;
    }

    public void setTlevel(Integer tlevel) {
        this.tlevel = tlevel;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public String getClientCustom() {
        return clientCustom;
    }

    public void setClientCustom(String clientCustom) {
        this.clientCustom = clientCustom;
    }

    public String getServerCustom() {
        return serverCustom;
    }

    public void setServerCustom(String serverCustom) {
        this.serverCustom = serverCustom;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getMuteType() {
        return muteType;
    }

    public void setMuteType(Integer muteType) {
        this.muteType = muteType;
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

    public Integer getInvitemode() {
        return invitemode;
    }

    public void setInvitemode(Integer invitemode) {
        this.invitemode = invitemode;
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
