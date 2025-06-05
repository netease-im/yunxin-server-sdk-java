package com.netease.nim.server.sdk.im.v1.friend.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

public class AddFriendRequestV1 {
    /**
     * 添加好友的发起者accid
     **/
    @YunxinParam("accid")
    private String accid;

    /**
     * 添加好友的接收者accid
     **/
    @YunxinParam("faccid")
    private String faccid;

    /**
     * 1 直接加好友；2 请求加好友；3 同意加好友；4 拒绝加好友
     **/
    @YunxinParam("type")
    private int type;

    /**
     * 加好友对应的请求消息
     **/
    @YunxinParam("msg")
    private String msg;

    /**
     * 服务器端扩展字段
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getServerex() {
        return serverex;
    }

    public void setServerex(String serverex) {
        this.serverex = serverex;
    }
}
