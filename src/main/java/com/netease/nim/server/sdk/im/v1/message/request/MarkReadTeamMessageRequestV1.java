package com.netease.nim.server.sdk.im.v1.message.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

import java.util.List;

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
    private List<Long> msgids;

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

    public List<Long> getMsgids() {
        return msgids;
    }

    public void setMsgids(List<Long>  msgids) {
        this.msgids = msgids;
    }

}
