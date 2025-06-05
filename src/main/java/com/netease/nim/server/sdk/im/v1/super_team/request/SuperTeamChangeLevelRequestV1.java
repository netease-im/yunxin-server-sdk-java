package com.netease.nim.server.sdk.im.v1.super_team.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

public class SuperTeamChangeLevelRequestV1 {

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
     * 群人数级别，该参数可设置的区间为 [2 ~ 控制台设置的群人数上限]
     */
    @YunxinParam("tlevel")
    private Integer tlevel;


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

    public Integer getTlevel() {
        return tlevel;
    }

    public void setTlevel(Integer tlevel) {
        this.tlevel = tlevel;
    }
}
