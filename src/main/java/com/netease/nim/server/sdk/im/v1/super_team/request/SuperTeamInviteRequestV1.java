package com.netease.nim.server.sdk.im.v1.super_team.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

/**
 * 请求参数类
 */
public class SuperTeamInviteRequestV1 {

    /**
     * 云信服务器产生，超大群唯一标识，创建时会返回，最大长度 64 位长整型
     */
    @YunxinParam("tid")
    private Long tid;

    /**
     * 邀请人的用户账号，accid，最大长度 32 位字符
     */
    @YunxinParam("owner")
    private String owner;

    /**
     * 被邀请入群的用户列表
     */
    @YunxinParam("inviteAccids")
    private String inviteAccids;

    /**
     * 邀请发送的文字，最大长度 150 位字符
     */
    @YunxinParam("msg")
    private String msg;

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

    public String getInviteAccids() {
        return inviteAccids;
    }

    public void setInviteAccids(String inviteAccids) {
        this.inviteAccids = inviteAccids;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}