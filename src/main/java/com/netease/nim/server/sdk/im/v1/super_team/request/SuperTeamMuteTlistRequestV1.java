package com.netease.nim.server.sdk.im.v1.super_team.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

import java.util.List;

public class SuperTeamMuteTlistRequestV1 {
    /**
     * 云信服务器产生，超大群唯一标识，最大长度 64 位长整型
     */
    @YunxinParam("tid")
    private Long tid;

    /**
     * 群主或管理员帐号，最大长度 32 位字符
     */
    @YunxinParam("owner")
    private String owner;

    /**
     * 需要禁言的群成员账号列表，一次最多禁言 10 人
     */
    private List<String> muteAccids;

    /**
     * 是否禁言，1表示禁言，0表示解禁
     */
    @YunxinParam("mute")
    private Integer mute;

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

    public List<String> getMuteAccids() {
        return muteAccids;
    }

    public void setMuteAccids(List<String> muteAccids) {
        this.muteAccids = muteAccids;
    }

    public Integer getMute() {
        return mute;
    }

    public void setMute(Integer mute) {
        this.mute = mute;
    }
}
