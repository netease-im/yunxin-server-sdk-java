package com.netease.nim.server.sdk.im.v1.chatroom_message.request;


import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

public class ChatroomBroadcastRequestV1 {

    /**
     * 客户端消息 ID，使用 uuid 等随机串
     */
    @YunxinParam("msgId")
    private String msgId;

    /**
     * 消息发出者的账号 accid
     */
    @YunxinParam("fromAccid")
    private String fromAccid;

    /**
     * 消息类型
     */
    @YunxinParam("msgType")
    private Integer msgType;

    /**
     * 文本消息内容
     */
    @YunxinParam("attach")
    private String attach;

    /**
     * 自定义消息子类型，大于0
     */
    @YunxinParam("subType")
    private Integer subType;

    /**
     * 重发消息标记：0：非重发消息，1：重发消息
     */
    @YunxinParam("resendFlag")
    private Integer resendFlag;

    /**
     * 消息是否需要抄送
     */
    @YunxinParam("route")
    private Integer route;

    /**
     * 消息扩展字段，内容可自定义，JSON 格式
     */
    @YunxinParam("ext")
    private String ext;

    /**
     * 是否使用易盾反垃圾
     */
    @YunxinParam("useYidun")
    private Integer useYidun;

    /**
     * 易盾反垃圾反作弊检测参数
     */
    @YunxinParam("yidunAntiCheating")
    private String yidunAntiCheating;

    /**
     * 安全通的自定义反垃圾业务 ID
     */
    @YunxinParam("bid")
    private String bid;

    /**
     * 本消息是否需要指定经由易盾检测的内容
     */
    @YunxinParam("antispam")
    private Boolean antispam;

    /**
     * 自定义的反垃圾检测内容
     */
    @YunxinParam("antispamCustom")
    private String antispamCustom;

    /**
     * 标签表达式，用于设定聊天室消息的投递对象
     */
    @YunxinParam("notifyTargetTags")
    private String notifyTargetTags;

    /**
     * 所属环境的名称
     */
    @YunxinParam("env")
    private String env;

    @YunxinParam("highPriority")
    private Boolean highPriority;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getFromAccid() {
        return fromAccid;
    }

    public void setFromAccid(String fromAccid) {
        this.fromAccid = fromAccid;
    }

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
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

    public Integer getRoute() {
        return route;
    }

    public void setRoute(Integer route) {
        this.route = route;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
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

    public String getAntispamCustom() {
        return antispamCustom;
    }

    public void setAntispamCustom(String antispamCustom) {
        this.antispamCustom = antispamCustom;
    }

    public String getNotifyTargetTags() {
        return notifyTargetTags;
    }

    public void setNotifyTargetTags(String notifyTargetTags) {
        this.notifyTargetTags = notifyTargetTags;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public Boolean getHighPriority() {
        return highPriority;
    }

    public void setHighPriority(Boolean highPriority) {
        this.highPriority = highPriority;
    }
}
