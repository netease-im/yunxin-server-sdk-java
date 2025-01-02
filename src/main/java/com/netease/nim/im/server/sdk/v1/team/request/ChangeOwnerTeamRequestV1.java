package com.netease.nim.im.server.sdk.v1.team.request;


import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class ChangeOwnerTeamRequestV1 {
    @YunxinParam("tid")
    private Long tid;

    @YunxinParam("owner")
    private String owner;

    @YunxinParam("newowner")
    private String newOwner;

    @YunxinParam("leave")
    private Integer leave;

    @YunxinParam("attach")
    private String attach;

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

    public String getNewOwner() {
        return newOwner;
    }

    public void setNewOwner(String newOwner) {
        this.newOwner = newOwner;
    }

    public Integer getLeave() {
        return leave;
    }

    public void setLeave(Integer leave) {
        this.leave = leave;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }
}
