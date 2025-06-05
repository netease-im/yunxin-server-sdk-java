package com.netease.nim.server.sdk.im.v1.team.request;


import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class DismissTeamRequestV1 {
    @YunxinParam("tid")
    private Long tid;
    @YunxinParam("attach")
    private String attach;
    @YunxinParam("owner")
    private String owner;

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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
