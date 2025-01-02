package com.netease.nim.im.server.sdk.v1.team.request;


import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class MuteTeamTargetMemberRequestV1 {
    @YunxinParam("tid")
    private Long tid;

    @YunxinParam("accid")
    private String accid;

    @YunxinParam("owner")
    private String owner;

    @YunxinParam("mute")
    private Integer mute;

    @YunxinParam("attach")
    private String attach;

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getMute() {
        return mute;
    }

    public void setMute(Integer mute) {
        this.mute = mute;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }
}
