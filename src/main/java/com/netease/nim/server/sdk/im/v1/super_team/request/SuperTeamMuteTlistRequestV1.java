package com.netease.nim.server.sdk.im.v1.super_team.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

import java.util.List;

public class SuperTeamMuteTlistRequestV1 {

    @YunxinParam("tid")
    private Long tid;

    @YunxinParam("owner")
    private String owner;

    private List<String> muteAccids;

    @YunxinParam("mute")
    private Integer mute;

    // Getters and Setters
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

    public List<String> getMuteAccids() {
        return muteAccids;
    }

    public void setMuteAccids(List<String> muteAccids) {
        this.muteAccids = muteAccids;
    }

    public Integer getMute() {
        return mute;
    }

    public void setMute(Integer mute) {
        this.mute = mute;
    }
}
