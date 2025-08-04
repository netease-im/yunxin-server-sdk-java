package com.netease.nim.server.sdk.im.v1.message.response;

import java.util.List;

public class MarkReadTeamMessageResponseV1 {

    /**
     * 标记已读失败的群消息 ID 列表
     */
    private List<Long> errMsgIds;

    public List<Long> getErrMsgIds() {
        return errMsgIds;
    }

    public void setErrMsgIds(List<Long> errMsgIds) {
        this.errMsgIds = errMsgIds;
    }
}
