package com.netease.nim.server.sdk.im.v1.team.request;


import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

import java.util.List;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class CreateTeamRequestV1 {
    @YunxinParam("attach")
    private String attach;

    @YunxinParam("tname")
    private String tname;

    @YunxinParam("owner")
    private String owner;

    @YunxinParam("announcement")
    private String announcement;

    @YunxinParam("intro")
    private String intro;

    @YunxinParam("custom")
    private String custom;

    @YunxinParam("icon")
    private String icon;

    @YunxinParam("bid")
    private String bid;

    @YunxinParam("joinmode")
    private Integer joinmode;

    @YunxinParam("beinvitemode")
    private Integer beinvitemode;

    @YunxinParam("invitemode")
    private Integer invitemode;

    @YunxinParam("uptinfomode")
    private Integer uptinfomode;

    @YunxinParam("upcustommode")
    private Integer upcustommode;

    @YunxinParam("isNotifyCloseOnline")
    private Integer isNotifyCloseOnline;

    @YunxinParam("isNotifyClosePersistent")
    private Integer isNotifyClosePersistent;

    @YunxinParam("msg")
    private String msg;

    private List<String> members;

    @YunxinParam("teamMemberLimit")
    private Integer teamMemberLimit;

    @YunxinParam("magree")
    private Integer magree;

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
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

    public Integer getIsNotifyCloseOnline() {
        return isNotifyCloseOnline;
    }

    public void setIsNotifyCloseOnline(Integer isNotifyCloseOnline) {
        this.isNotifyCloseOnline = isNotifyCloseOnline;
    }

    public Integer getIsNotifyClosePersistent() {
        return isNotifyClosePersistent;
    }

    public void setIsNotifyClosePersistent(Integer isNotifyClosePersistent) {
        this.isNotifyClosePersistent = isNotifyClosePersistent;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public Integer getTeamMemberLimit() {
        return teamMemberLimit;
    }

    public void setTeamMemberLimit(Integer teamMemberLimit) {
        this.teamMemberLimit = teamMemberLimit;
    }

    public Integer getMagree() {
        return magree;
    }

    public void setMagree(Integer magree) {
        this.magree = magree;
    }
}
