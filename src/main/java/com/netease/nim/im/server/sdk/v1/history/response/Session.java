package com.netease.nim.im.server.sdk.v1.history.response;

public class Session {

    /**
     * 会话类型，1 表示点对点，2 表示群，3 表示超大群
     */
    private Integer sessionType;

    /**
     * 如果是点对点会话，则包括账号 ID（`accid`） 字段
     */
    private String accid;

    /**
     * 如果是群和超大群，则包括 tid 字段
     */
    private Long tid;

    /**
     * 更新时间
     */
    private Long updateTime;

    /**
     * 扩展字段
     */
    private String ext;

    /**
     * 最后一条消息类型
     */
    private String lastMsgType;

    /**
     * 最后一条消息
     */
    private String lastMsg;

    public Integer getSessionType() {
        return sessionType;
    }

    public void setSessionType(Integer sessionType) {
        this.sessionType = sessionType;
    }

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

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getLastMsgType() {
        return lastMsgType;
    }

    public void setLastMsgType(String lastMsgType) {
        this.lastMsgType = lastMsgType;
    }

    public String getLastMsg() {
        return lastMsg;
    }

    public void setLastMsg(String lastMsg) {
        this.lastMsg = lastMsg;
    }

}
