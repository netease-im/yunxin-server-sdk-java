package com.netease.nim.server.sdk.im.v1.team.request;


import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class MuteTeamRequestV1 {
    @YunxinParam("tid")
    private Long tid;

    @YunxinParam("ope")
    private Integer ope;

    @YunxinParam("accid")
    private String accid;

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Integer getOpe() {
        return ope;
    }

    public void setOpe(Integer ope) {
        this.ope = ope;
    }

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }
}
