package com.netease.nim.server.sdk.im.v1.friend.response;


public class GetFriendRelationshipResponseV1 {
    /**
     * 好友关系创建时间
     **/
    private long createtime;

    /**
     * 扩展字段
     **/
    private String ex;

    /**
     * 双向好友标志
     **/
    private boolean bidirection;

    /**
     * 好友的云信IM账号
     **/
    private String faccid;

    /**
     * 服务端扩展字段
     **/
    private String serverex;

    /**
     * 好友关系更新时间
     **/
    private long updatetime;

    public long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(long createtime) {
        this.createtime = createtime;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public boolean isBidirection() {
        return bidirection;
    }

    public void setBidirection(boolean bidirection) {
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

    public long getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(long updatetime) {
        this.updatetime = updatetime;
    }
}