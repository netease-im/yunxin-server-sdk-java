package com.netease.nim.im.server.sdk.v1.team.request;


import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

import java.util.List;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class KickTeamRequestV1 {
    @YunxinParam("tid")
    private Long tid;

    @YunxinParam("owner")
    private String owner;

    @YunxinParam("attach")
    private String attach;

    private List<String> members;

    @YunxinParam("member")
    private String member;

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

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }
}
