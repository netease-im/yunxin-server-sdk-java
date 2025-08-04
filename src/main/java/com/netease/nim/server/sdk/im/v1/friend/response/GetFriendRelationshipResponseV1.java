package com.netease.nim.server.sdk.im.v1.friend.response;


public class GetFriendRelationshipResponseV1 {

    private Long createtime;

    private String ex;

    private Boolean bidirection;

    private String faccid;

    private String serverex;

    private Long updatetime;

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public Boolean getBidirection() {
        return bidirection;
    }

    public void setBidirection(Boolean bidirection) {
        this.bidirection = bidirection;
    }

    public String getFaccid() {
        return faccid;
    }

    public void setFaccid(String faccid) {
        this.faccid = faccid;
    }

    public String getServerex() {
        return serverex;
    }

    public void setServerex(String serverex) {
        this.serverex = serverex;
    }

    public Long getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Long updatetime) {
        this.updatetime = updatetime;
    }
}