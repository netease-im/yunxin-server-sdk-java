package com.netease.nim.server.sdk.im.v1.super_team.response;

public class SuperTeamMemberInfo {
    /**
     * 超大群 ID
     */
    private Long tid;

    /**
     * 云信分配的用户 ID
     */
    private Long uid;

    /**
     * 用户账号
     */
    private String accid;

    /**
     * 群成员类型：0，普通成员；1，群主；2，管理员
     */
    private Integer type;

    /**
     * 群昵称
     */
    private String nick;

    /**
     * 加入群的时间
     */
    private String jointime;

    /**
     * 是否被禁言：1，禁言；0，解禁
     */
    private Integer mute;

    /**
     * 云信分配的邀请者的 ID
     */
    private Long invitoruid;

    /**
     * 邀请者的账号
     */
    private String invitor;

    /**
     * 有效标志：0，无效；1，有效
     */
    private Integer validflag;

    /**
     * 自定义扩展属性
     */
    private String custom;

    /**
     * 激活状态：0，未激活；1，已激活
     */
    private Integer state;

    /**
     * 群成员配置
     */
    private Long bits;

    /**
     * 创建时间
     */
    private Long createtime;

    /**
     * 更新时间
     */
    private Long updatetime;

    // Getters and Setters
    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getJointime() {
        return jointime;
    }

    public void setJointime(String jointime) {
        this.jointime = jointime;
    }

    public Integer getMute() {
        return mute;
    }

    public void setMute(Integer mute) {
        this.mute = mute;
    }

    public Long getInvitoruid() {
        return invitoruid;
    }

    public void setInvitoruid(Long invitoruid) {
        this.invitoruid = invitoruid;
    }

    public String getInvitor() {
        return invitor;
    }

    public void setInvitor(String invitor) {
        this.invitor = invitor;
    }

    public Integer getValidflag() {
        return validflag;
    }

    public void setValidflag(Integer validflag) {
        this.validflag = validflag;
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getBits() {
        return bits;
    }

    public void setBits(Long bits) {
        this.bits = bits;
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }

    public Long getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Long updatetime) {
        this.updatetime = updatetime;
    }
}
