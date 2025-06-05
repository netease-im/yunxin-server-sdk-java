package com.netease.nim.server.sdk.im.v1.chatroom_message.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

public class SendChatroomMsgRequestV1 {

    /**
     * 聊天室 ID
     */
    @YunxinParam("roomid")
    private Long roomId;

    /**
     * 消息 ID，使用 uuid 等随机串
     */
    @YunxinParam("msgId")
    private String msgId;

    /**
     * 消息内容，最大长度 4096 字符
     */
    @YunxinParam("attach")
    private String attach;

    /**
     * 发送消息的用户账号，accid
     */
    @YunxinParam("fromAccid")
    private String fromAccid;

    /**
     * 是否忽略成员临时禁言，true：忽略；false：不忽略，默认为 false
     */
    @YunxinParam("ignoreMute")
    private Boolean ignoreMute;

    /**
     * 消息类型
     */
    @YunxinParam("msgType")
    private Integer msgType;

    /**
     * 自定义消息子类型，大于 0
     */
    @YunxinParam("subType")
    private Integer subType;

    /**
     * 重发消息标记
     */
    @YunxinParam("resendFlag")
    private Integer resendFlag;

    /**
     * 消息扩展字段，内容可自定义，JSON 格式
     */
    @YunxinParam("ext")
    private String ext;

    /**
     * 消息是否需要抄送,0：不需要；1：需要（默认）
     */
    @YunxinParam("route")
    private Integer route;

    /**
     * 是否存储云端历史消息,0：存储云端历史消息（默认）；1：不存储
     */
    @YunxinParam("skipHistory")
    private Integer skipHistory;

    /**
     * 消息丢弃的概率，取值范围 [0-9999]
     */
    @YunxinParam("abandonRatio")
    private Integer abandonRatio;

    /**
     * 高优先级消息标记
     */
    @YunxinParam("highPriority")
    private Boolean highPriority;

    /**
     * 会重发消息
     */
    @YunxinParam("needHighPriorityMsgResend")
    private Boolean needHighPriorityMsgResend;

    /**
     * 单条消息是否使用安全通
     */
    @YunxinParam("useYidun")
    private Integer useYidun;

    /**
     * 透传给易盾的反作弊检测参数
     */
    @YunxinParam("yidunAntiCheating")
    private String yidunAntiCheating;

    /**
     * 透传给易盾的反垃圾检测参数
     */
    @YunxinParam("yidunAntiSpamExt")
    private String yidunAntiSpamExt;

    /**
     * 自定义反垃圾业务的 ID
     */
    @YunxinParam("bid")
    private String bid;

    /**
     * 本消息是否需要指定经由易盾检测的内容
     */
    @YunxinParam("antispam")
    private Boolean antispam;

    /**
     * 目标标签表达式，用于设定聊天室消息的投递对象
     */
    @YunxinParam("notifyTargetTags")
    private String notifyTargetTags;

    /**
     * 自定义的反垃圾检测内容
     */
    @YunxinParam("antispamCustom")
    private String antispamCustom;

    /**
     * 消息需要抄送到的环境的名称
     */
    @YunxinParam("env")
    private String env;

    /**
     * 走 CDN通道的消息的优先级
     */
    @YunxinParam("chatMsgPriority")
    private Integer chatMsgPriority;

    /**
     * 高优先级消息被频控后是降级为普通消息还是返回 403 错误码,0：降级为普通消息（默认），1：返回 403 错误码
     */
    @YunxinParam("forbiddenIfHighPriorityMsgFreq")
    private Integer forbiddenIfHighPriorityMsgFreq;

    /**
     * 空间坐标x
     */
    @YunxinParam("locX")
    private Double locX;

    /**
     * 空间坐标y
     */
    @YunxinParam("locY")
    private Double locY;

    /**
     * 空间坐标z
     */
    @YunxinParam("locZ")
    private Double locZ;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getFromAccid() {
        return fromAccid;
    }

    public void setFromAccid(String fromAccid) {
        this.fromAccid = fromAccid;
    }

    public Boolean getIgnoreMute() {
        return ignoreMute;
    }

    public void setIgnoreMute(Boolean ignoreMute) {
        this.ignoreMute = ignoreMute;
    }

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    public Integer getSubType() {
        return subType;
    }

    public void setSubType(Integer subType) {
        this.subType = subType;
    }

    public Integer getResendFlag() {
        return resendFlag;
    }

    public void setResendFlag(Integer resendFlag) {
        this.resendFlag = resendFlag;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public Integer getRoute() {
        return route;
    }

    public void setRoute(Integer route) {
        this.route = route;
    }

    public Integer getSkipHistory() {
        return skipHistory;
    }

    public void setSkipHistory(Integer skipHistory) {
        this.skipHistory = skipHistory;
    }

    public Integer getAbandonRatio() {
        return abandonRatio;
    }

    public void setAbandonRatio(Integer abandonRatio) {
        this.abandonRatio = abandonRatio;
    }

    public Boolean getHighPriority() {
        return highPriority;
    }

    public void setHighPriority(Boolean highPriority) {
        this.highPriority = highPriority;
    }

    public Boolean getNeedHighPriorityMsgResend() {
        return needHighPriorityMsgResend;
    }

    public void setNeedHighPriorityMsgResend(Boolean needHighPriorityMsgResend) {
        this.needHighPriorityMsgResend = needHighPriorityMsgResend;
    }

    public Integer getUseYidun() {
        return useYidun;
    }

    public void setUseYidun(Integer useYidun) {
        this.useYidun = useYidun;
    }

    public String getYidunAntiCheating() {
        return yidunAntiCheating;
    }

    public void setYidunAntiCheating(String yidunAntiCheating) {
        this.yidunAntiCheating = yidunAntiCheating;
    }

    public String getYidunAntiSpamExt() {
        return yidunAntiSpamExt;
    }

    public void setYidunAntiSpamExt(String yidunAntiSpamExt) {
        this.yidunAntiSpamExt = yidunAntiSpamExt;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public Boolean getAntispam() {
        return antispam;
    }

    public void setAntispam(Boolean antispam) {
        this.antispam = antispam;
    }

    public String getNotifyTargetTags() {
        return notifyTargetTags;
    }

    public void setNotifyTargetTags(String notifyTargetTags) {
        this.notifyTargetTags = notifyTargetTags;
    }

    public String getAntispamCustom() {
        return antispamCustom;
    }

    public void setAntispamCustom(String antispamCustom) {
        this.antispamCustom = antispamCustom;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public Integer getChatMsgPriority() {
        return chatMsgPriority;
    }

    public void setChatMsgPriority(Integer chatMsgPriority) {
        this.chatMsgPriority = chatMsgPriority;
    }

    public Integer getForbiddenIfHighPriorityMsgFreq() {
        return forbiddenIfHighPriorityMsgFreq;
    }

    public void setForbiddenIfHighPriorityMsgFreq(Integer forbiddenIfHighPriorityMsgFreq) {
        this.forbiddenIfHighPriorityMsgFreq = forbiddenIfHighPriorityMsgFreq;
    }

    public Double getLocX() {
        return locX;
    }

    public void setLocX(Double locX) {
        this.locX = locX;
    }

    public Double getLocY() {
        return locY;
    }

    public void setLocY(Double locY) {
        this.locY = locY;
    }

    public Double getLocZ() {
        return locZ;
    }

    public void setLocZ(Double locZ) {
        this.locZ = locZ;
    }
}