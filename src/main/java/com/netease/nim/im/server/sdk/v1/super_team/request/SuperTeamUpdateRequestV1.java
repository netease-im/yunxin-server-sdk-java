package com.netease.nim.im.server.sdk.v1.super_team.request;

import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

public class SuperTeamUpdateRequestV1 {

    /**
     * 云信服务器产生，超大群唯一标识，最大长度 64 位长整型
     */
    @YunxinParam("tid")
    private Long tid;

    /**
     * 群主或管理员用户帐号，最大长度 32 位字符
     */
    @YunxinParam("owner")
    private String owner;

    /**
     * 群名称，最大长度 64 位字符
     */
    @YunxinParam("tname")
    private String tname;

    /**
     * 群描述，最大长度 512 位字符
     */
    @YunxinParam("intro")
    private String intro;

    /**
     * 群公告，最大长度 1024 位字符
     */
    @YunxinParam("announcement")
    private String announcement;

    /**
     * 自定义群扩展属性，最大长度 1024 位字符
     */
    @YunxinParam("serverCustom")
    private String serverCustom;

    /**
     * 群头像，最大长度 1024 位字符
     */
    @YunxinParam("icon")
    private String icon;

    /**
     * 申请入群的验证模式
     */
    @YunxinParam("joinmode")
    private Integer joinmode;

    /**
     * 邀请入群时是否需要被邀请人的同意
     */
    @YunxinParam("beinvitemode")
    private Integer beinvitemode;

    /**
     * 谁可以邀请他人入群
     */
    @YunxinParam("invitemode")
    private Integer invitemode;

    /**
     * 谁可以修改群信息
     */
    @YunxinParam("uptinfomode")
    private Integer uptinfomode;

    /**
     * 谁可以修改群自定义属性
     */
    @YunxinParam("upcustommode")
    private Integer upcustommode;

    /**
     * 反垃圾业务 ID，JSON 字符串
     */
    @YunxinParam("bid")
    private String bid;

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
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

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }
}
