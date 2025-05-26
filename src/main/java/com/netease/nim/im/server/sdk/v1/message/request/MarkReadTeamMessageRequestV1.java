package com.netease.nim.im.server.sdk.v1.message.request;

import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

public class MarkReadTeamMessageRequestV1 {

    /**
     * 需要标记已读的用户账号（accid）
     */
    @YunxinParam("accid")
    private String accid;

    /**
     * 群组的 ID
     */
    @YunxinParam("tid")
    private Long tid;

    /**
     * 需要标记为已读的群消息数组。数组的每一项存放一个由云信服务端为群消息生成的消息 ID（serverId）
     */
    @YunxinParam("msgids")
    private String msgids;

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getMsgids() {
        return msgids;
    }

    public void setMsgids(String msgids) {
        this.msgids = msgids;
    }

}
