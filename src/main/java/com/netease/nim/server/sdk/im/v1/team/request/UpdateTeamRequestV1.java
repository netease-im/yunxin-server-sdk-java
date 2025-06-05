package com.netease.nim.server.sdk.im.v1.team.request;


import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class UpdateTeamRequestV1 {

    @YunxinParam("tid")
    private Long tid;

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
    private Integer joinMode;

    @YunxinParam("beinvitemode")
    private Integer beInviteMode;

    @YunxinParam("invitemode")
    private Integer inviteMode;

    @YunxinParam("uptinfomode")
    private Integer upTinfoMode;

    @YunxinParam("upcustommode")
    private Integer upCustomMode;

    @YunxinParam("attach")
    private String attach;

    @YunxinParam("teamMemberLimit")
    private Integer teamMemberLimit;

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

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public Integer getTeamMemberLimit() {
        return teamMemberLimit;
    }

    public void setTeamMemberLimit(Integer teamMemberLimit) {
        this.teamMemberLimit = teamMemberLimit;
    }
}
