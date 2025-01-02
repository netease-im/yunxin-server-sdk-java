package com.netease.nim.im.server.sdk.v1.team.request;


import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class MuteTeamAllMemberRequestV1 {
    @YunxinParam("tid")
    private Long tid;

    @YunxinParam("owner")
    private String owner;

    @YunxinParam("mute")
    private Boolean mute;

    @YunxinParam("muteType")
    private Integer muteType;

    @YunxinParam("attach")
    private String attach;

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Integer getMuteType() {
        return muteType;
    }

    public void setMuteType(Integer muteType) {
        this.muteType = muteType;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Boolean getMute() {
        return mute;
    }

    public void setMute(Boolean mute) {
        this.mute = mute;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }
}
