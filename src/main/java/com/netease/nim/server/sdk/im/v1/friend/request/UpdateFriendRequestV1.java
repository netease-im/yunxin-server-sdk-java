package com.netease.nim.server.sdk.im.v1.friend.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

public class UpdateFriendRequestV1 {
    /**
     * 修改好友信息的用户accid
     **/
    @YunxinParam("accid")
    private String accid;

    /**
     * 被更新信息的用户accid
     **/
    @YunxinParam("faccid")
    private String faccid;

    /**
     * 给好友增加备注名，可设置为空字符串
     **/
    @YunxinParam("alias")
    private String alias;

    /**
     * 修改ex字段，可设置为空字符串
     **/
    @YunxinParam("ex")
    private String ex;

    /**
     * 修改serverex字段，可设置为空字符串
     **/
    @YunxinParam("serverex")
    private String serverex;

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

    public String getFaccid() {
        return faccid;
    }

    public void setFaccid(String faccid) {
        this.faccid = faccid;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public String getServerex() {
        return serverex;
    }

    public void setServerex(String serverex) {
        this.serverex = serverex;
    }
}
