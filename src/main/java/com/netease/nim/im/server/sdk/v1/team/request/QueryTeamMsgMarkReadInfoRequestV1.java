package com.netease.nim.im.server.sdk.v1.team.request;


import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class QueryTeamMsgMarkReadInfoRequestV1 {
    @YunxinParam("tid")
    private Long tid;

    @YunxinParam("msgid")
    private Long msgId;

    @YunxinParam("fromAccid")
    private String fromAccid;

    @YunxinParam("snapshot")
    private Boolean snapshot;

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public String getFromAccid() {
        return fromAccid;
    }

    public void setFromAccid(String fromAccid) {
        this.fromAccid = fromAccid;
    }

    public Boolean getSnapshot() {
        return snapshot;
    }

    public void setSnapshot(Boolean snapshot) {
        this.snapshot = snapshot;
    }
}
