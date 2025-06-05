package com.netease.nim.server.sdk.im.v1.super_team.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;
import java.util.List;

public class SuperTeamCreateRequestV1 {

    /**
     * 超大群群主用户帐号
     **/
    @YunxinParam("owner")
    private String owner;

    /**
     * 创建群时邀请的群成员列表
     **/
    private List<String> inviteAccids;

    /**
     * 超大群名称
     **/
    @YunxinParam("tname")
    private String tname;

    /**
     * 群描述
     **/
    @YunxinParam("intro")
    private String intro;

    /**
     * 群公告
     **/
    @YunxinParam("announcement")
    private String announcement;

    /**
     * 自定义群扩展属性
     **/
    @YunxinParam("serverCustom")
    private String serverCustom;

    /**
     * 群头像
     **/
    @YunxinParam("icon")
    private String icon;

    /**
     * 邀请发送的文字
     **/
    @YunxinParam("msg")
    private String msg;

    /**
     * 申请入群的验证模式,0，入群不需要验证（默认）；1，入群需要验证；2，不允许申请入群
     **/
    @YunxinParam("joinmode")
    private Integer joinmode;

    /**
     * 邀请入群时是否需要被邀请人的同意,0，需要同意(默认)；1，不需要同意
     **/
    @YunxinParam("beinvitemode")
    private Integer beinvitemode;

    /**
     * 谁可以邀请他人入群,0，群主和管理员（默认）；1，所有人
     **/
    @YunxinParam("invitemode")
    private Integer invitemode;

    /**
     * 谁可以修改群信息
     **/
    @YunxinParam("uptinfomode")
    private Integer uptinfomode;

    /**
     * 谁可以修改群自定义属性
     **/
    @YunxinParam("upcustommode")
    private Integer upcustommode;

    /**
     * 群人数级别
     **/
    @YunxinParam("tlevel")
    private Integer tlevel;

    /**
     * 反垃圾业务 ID
     **/
    @YunxinParam("bid")
    private String bid;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<String> getInviteAccids() {
        return inviteAccids;
    }

    public void setInviteAccids(List<String> inviteAccids) {
        this.inviteAccids = inviteAccids;
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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

    public Integer getTlevel() {
        return tlevel;
    }

    public void setTlevel(Integer tlevel) {
        this.tlevel = tlevel;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }
}