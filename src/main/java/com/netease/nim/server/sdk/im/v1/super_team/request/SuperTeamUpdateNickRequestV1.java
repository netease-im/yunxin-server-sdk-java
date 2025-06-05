package com.netease.nim.server.sdk.im.v1.super_team.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

public class SuperTeamUpdateNickRequestV1 {
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
     * 对应的群昵称，最大长度 32 位字符
     */
    @YunxinParam("nick")
    private String nick;

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

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
