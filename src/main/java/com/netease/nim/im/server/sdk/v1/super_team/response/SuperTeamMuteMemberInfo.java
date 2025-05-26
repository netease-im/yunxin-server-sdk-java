package com.netease.nim.im.server.sdk.v1.super_team.response;

public class SuperTeamMuteMemberInfo {
    /**
     * 群成员昵称
     */
    private String nick;

    /**
     * 创建时间
     */
    private Long createtime;

    /**
     * 加入群的时间
     */
    private Long jointime;

    /**
     * 更新时间
     */
    private Long updatetime;

    /**
     * 第三方扩展字段
     */
    private String custom;

    /**
     * 群成员账号
     */
    private String accid;

    /**
     * 超大群 ID
     */
    private Long tid;

    /**
     * 群成员类型：0，普通成员；1，群主；2，管理员
     */
    private Integer type;

    /**
     * 是否被禁言：1，禁言；0，解禁
     */
    private Integer mute;

    /**
     * 邀请人账号
     */
    private String invitor;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }

    public Long getJointime() {
        return jointime;
    }

    public void setJointime(Long jointime) {
        this.jointime = jointime;
    }

    public Long getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Long updatetime) {
        this.updatetime = updatetime;
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMute() {
        return mute;
    }

    public void setMute(Integer mute) {
        this.mute = mute;
    }

    public String getInvitor() {
        return invitor;
    }

    public void setInvitor(String invitor) {
        this.invitor = invitor;
    }
}
