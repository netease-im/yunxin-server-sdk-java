package com.netease.nim.server.sdk.im.v1.super_team.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

import java.util.List;

public class SuperTeamKickMemberRequestV1 {

    /**
     * 云信服务器产生，超大群唯一标识，最大长度 64 位长整型
     */
    @YunxinParam("tid")
    private Long tid;

    /**
     * 群主用户帐号，最大长度 32 位字符
     */
    @YunxinParam("owner")
    private String owner;

    /**
     * 被踢出的成员账号列表，一次最多可踢出 10 人
     */
    private List<String> kickAccids;


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

    public List<String> getKickAccids() {
        return kickAccids;
    }

    public void setKickAccids(List<String> kickAccids) {
        this.kickAccids = kickAccids;
    }
}
