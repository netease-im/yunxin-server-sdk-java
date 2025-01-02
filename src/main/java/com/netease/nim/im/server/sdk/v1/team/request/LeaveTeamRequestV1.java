package com.netease.nim.im.server.sdk.v1.team.request;


import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class LeaveTeamRequestV1 {
    @YunxinParam("tid")
    private Long tid;

    @YunxinParam("attach")
    private String attach;

    @YunxinParam("accid")
    private String accid;

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }
}
