package com.netease.nim.server.sdk.im.v1.super_team.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

public class SuperTeamUpdateMemberInfoRequestV1 {
    /**
     * 云信服务器产生，超大群唯一标识，最大长度 64 位长整型
     */
    @YunxinParam("tid")
    private Long tid;

    /**
     * 需要设置的用户账号，accid，最大长度 32 位字符
     */
    @YunxinParam("accid")
    private String accid;

    /**
     * 用户对应的群成员昵称，最大长度 32 位字符
     */
    @YunxinParam("nick")
    private String nick;

    /**
     * 1，关闭消息提醒；0，打开消息提醒
     */
    @YunxinParam("silentType")
    private Integer silentType;

    /**
     * 自定义扩展字段，最大长度 32 位字符
     */
    @YunxinParam("custom")
    private String custom;

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

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getSilentType() {
        return silentType;
    }

    public void setSilentType(Integer silentType) {
        this.silentType = silentType;
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }
}
