package com.netease.nim.im.server.sdk.v1.super_team.request;

import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

public class SuperTeamChangeOwnerRequestV1 {
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
     * 新群主的用户账号，最大长度 32 位字符
     */
    @YunxinParam("accid")
    private String accid;

    /**
     * 是否离开该群，1表示离开，2表示成为普通成员
     */
    @YunxinParam("leave")
    private Integer leave;

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

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

    public Integer getLeave() {
        return leave;
    }

    public void setLeave(Integer leave) {
        this.leave = leave;
    }
}
