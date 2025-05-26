package com.netease.nim.im.server.sdk.v1.chatroom_message.request;


import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

import java.util.List;

public class ChatroomTargetMsgRequestV1 {

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
     * 消息内容，格式同消息格式示例中的 body 字段，最大长度 4096 位字符
     */
    @YunxinParam("attach")
    private String attach;

    /**
     * 发送消息的用户账号，accid
     */
    @YunxinParam("fromAccid")
    private String fromAccid;

    /**
     * 消息接收者 accid 列表，JSONArray，最多 100 个账号
     */
    @YunxinParam("toAccids")
    private String toAccids;

    /**
     * 消息类型,0: 文本消息，1:图片，2:语音，3:视频，4:地理位置信息，6:文件，10:提示消息（Tips），100: 自定义消息
     */
    @YunxinParam("msgType")
    private Integer msgType;

    /**
     * 自定义消息子类型，大于0
     */
    @YunxinParam("subType")
    private Integer subType;

    /**
     * 重发消息标记，0：非重发消息，1：重发消息，如重发消息会按照 msgId 检查去重逻辑
     */
    @YunxinParam("resendFlag")
    private Integer resendFlag;

    /**
     * 消息是否需要抄送,0：不需要；1：需要（默认）
     */
    @YunxinParam("route")
    private Integer route;

    /**
     * 消息扩展字段，内容可自定义，JSON 格式，最大长度 4096 位字符
     */
    @YunxinParam("ext")
    private String ext;

    /**
     * 单条消息是否使用安全通（即易盾反垃圾）
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
     * 安全通的自定义反垃圾（即内容审核）业务的 ID
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
     * 消息需要抄送到的环境的名称
     */
    @YunxinParam("env")
    private String env;

    // Getters and Setters

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

    public String getToAccids() {
        return toAccids;
    }

    public void setToAccids(String toAccids) {
        this.toAccids = toAccids;
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
}