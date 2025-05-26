package com.netease.nim.im.server.sdk.v1.super_team.request;

import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

public class SendSuperTeamMessageRequestV1 {

    /**
     * 云信服务器产生，创建超大群时会返回，最大长度 64 位长整型
     */
    @YunxinParam("tid")
    private Long tid;

    /**
     * 消息发送者账号，accid，必须是超大群成员，最大长度 32 位字符
     */
    @YunxinParam("fromAccid")
    private String fromAccid;

    /**
     * 消息类型：0，文本消息；1，图片；2，语音；3，视频；4，地理位置信息；6，文件；10，提示；100，自定义消息类型
     */
    @YunxinParam("type")
    private Integer type;

    /**
     * 消息内容，JSON，最大长度 5000 位字符
     */
    @YunxinParam("body")
    private String body;

    /**
     * 消息描述文本，针对非 Text、Tip 类型的消息有效，最大长度 500 位字符
     */
    @YunxinParam("msgDesc")
    private String msgDesc;

    /**
     * 对于已对接易盾反垃圾功能的应用，本消息是否需要指定经由易盾检测的内容
     */
    @YunxinParam("antispam")
    private Boolean antispam;

    /**
     * 自定义的反垃圾检测内容, JSON，长度限制同 body 字段
     */
    @YunxinParam("antispamCustom")
    private String antispamCustom;

    /**
     * 单条消息是否使用易盾反垃圾
     */
    @YunxinParam("useYidun")
    private Integer useYidun;

    /**
     * 易盾反垃圾含圈组反作弊专属字段，JSON，最大长度 1024 位字符
     */
    @YunxinParam("yidunAntiCheating")
    private String yidunAntiCheating;

    /**
     * 易盾反垃圾扩展字段，JSON，最大长度 1024 位字符
     */
    @YunxinParam("yidunAntiSpamExt")
    private String yidunAntiSpamExt;

    /**
     * 易盾反垃圾业务 ID，实现“单条消息配置对应的反垃圾业务规则”
     */
    @YunxinParam("bid")
    private String bid;

    /**
     * 发消息时特殊指定的行为选项，JSON
     */
    @YunxinParam("option")
    private String option;

    /**
     * 开发者扩展字段，最大长度 1024 位字符
     */
    @YunxinParam("ext")
    private String ext;

    /**
     * 推送内容，最大长度 500 位字符
     */
    @YunxinParam("pushContent")
    private String pushContent;

    /**
     * 推送对应的 payload，必须是 JSON 格式，不能超过 2048 字符
     */
    @YunxinParam("pushPayload")
    private String pushPayload;

    /**
     * 发送消息时，是否强制推送，默认 true
     */
    @YunxinParam("isForcePush")
    private Boolean isForcePush;

    /**
     * 发送消息时，强制推送的内容，最大长度 500 位字符
     */
    @YunxinParam("forcePushContent")
    private String forcePushContent;

    /**
     * 发送消息时，强推（@操作）列表是否为群里除发送者外的所有有效成员，默认 false
     */
    @YunxinParam("forcePushAll")
    private Boolean forcePushAll;

    /**
     * 发送消息时，强推（@操作）列表，JSONArray
     */
    @YunxinParam("forcePushList")
    private String forcePushList;

    /**
     * 消息子类型，大于 0
     */
    @YunxinParam("subType")
    private Integer subType;

    /**
     * 所属环境，可以配置不同的抄送地址，最大长度 32 位字符
     */
    @YunxinParam("env")
    private String env;

    /**
     * 发送群消息时，是否检查与群相关禁言
     */
    @YunxinParam("isCheckMute")
    private Boolean isCheckMute;

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getFromAccid() {
        return fromAccid;
    }

    public void setFromAccid(String fromAccid) {
        this.fromAccid = fromAccid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getMsgDesc() {
        return msgDesc;
    }

    public void setMsgDesc(String msgDesc) {
        this.msgDesc = msgDesc;
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

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getPushContent() {
        return pushContent;
    }

    public void setPushContent(String pushContent) {
        this.pushContent = pushContent;
    }

    public String getPushPayload() {
        return pushPayload;
    }

    public void setPushPayload(String pushPayload) {
        this.pushPayload = pushPayload;
    }

    public Boolean getForcePush() {
        return isForcePush;
    }

    public void setForcePush(Boolean forcePush) {
        isForcePush = forcePush;
    }

    public String getForcePushContent() {
        return forcePushContent;
    }

    public void setForcePushContent(String forcePushContent) {
        this.forcePushContent = forcePushContent;
    }

    public Boolean getForcePushAll() {
        return forcePushAll;
    }

    public void setForcePushAll(Boolean forcePushAll) {
        this.forcePushAll = forcePushAll;
    }

    public String getForcePushList() {
        return forcePushList;
    }

    public void setForcePushList(String forcePushList) {
        this.forcePushList = forcePushList;
    }

    public Integer getSubType() {
        return subType;
    }

    public void setSubType(Integer subType) {
        this.subType = subType;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public Boolean getCheckMute() {
        return isCheckMute;
    }

    public void setCheckMute(Boolean checkMute) {
        isCheckMute = checkMute;
    }
}