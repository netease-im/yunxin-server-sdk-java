package com.netease.nim.im.server.sdk.v1.message.response;

public class MarkReadTeamMessageResponseV1 {

    /**
     * 标记已读失败的群消息 ID 列表
     */
    private String errMsgIds;

    public String getErrMsgIds() {
        return errMsgIds;
    }

    public void setErrMsgIds(String errMsgIds) {
        this.errMsgIds = errMsgIds;
    }

}
