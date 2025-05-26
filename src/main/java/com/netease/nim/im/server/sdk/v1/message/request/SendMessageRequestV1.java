package com.netease.nim.im.server.sdk.v1.message.request;

import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

public class SendMessageRequestV1 {

    /**
     * 发送者的网易云信 IM 账号（accid），最大 32 字符
     */
    @YunxinParam("from")
    private String from;

    /**
     * 仅可传入 0 或 1，0：单聊消息，1：群消息（高级群）
     */
    @YunxinParam("ope")
    private Integer ope;

    /**
     * 消息的接收方，ope 为 0 时需填入接收消息用户的的网易云信 IM 账号（accid），ope 为 1 时需填入接收消息的群的 ID（即 tid），最大 32 字符
     */
    @YunxinParam("to")
    private String to;

    /**
     * 消息类型：0，文本消息；1，图片消息；2，语音消息；3，视频消息；4，地理位置信息；6，文件消息；10，提示消息；100，自定义消息
     */
    @YunxinParam("type")
    private Integer type;

    /**
     * 消息内容，JSON 格式
     */
    @YunxinParam("body")
    private String body;

    /**
     * 消息描述文本，对文本消息和提示消息以外的消息类型有效，最大长度 500 字符
     */
    @YunxinParam("msgDesc")
    private String msgDesc;

    /**
     * 已开通 安全通 的前提下，是否对自定义消息的指定内容（antispamCustom）进行反垃圾检测，默认 false
     */
    @YunxinParam("antispam")
    private Boolean antispam;

    /**
     * 在 antispam 参数为 true 时生效，自定义的需要过反垃圾检测的内容, JSON 格式，长度限制同 body 字段，不能超过 5000 字符
     */
    @YunxinParam("antispamCustom")
    private String antispamCustom;

    /**
     * 发消息时特殊指定的行为选项,JSON 格式，可用于指定消息的漫游、存云端历史、发送方多端同步、推送、消息抄送等特殊行为
     */
    @YunxinParam("option")
    private String option;

    /**
     * 推送文案，最长 500 字符
     */
    @YunxinParam("pushcontent")
    private String pushcontent;

    /**
     * 推送对应的 payload，必须是 JSON 格式，不能超过 2048 字符
     */
    @YunxinParam("payload")
    private String payload;

    /**
     * 开发者扩展字段，必须是 JSON 格式
     */
    @YunxinParam("ext")
    private String ext;

    /**
     * 发送群消息时，强推（@操作）列表是否为群里除发送者外的所有有效成员，默认为 false
     */
    @YunxinParam("forcepushall")
    private Boolean forcepushall;

    /**
     * 发送群消息时的强推（@操作）用户列表，格式为 JSONArray
     */
    @YunxinParam("forcepushlist")
    private String forcepushlist;

    /**
     * 发送群消息时，针对强推列表 forcepushlist 中的用户，强制推送的内容，最大 500 字符
     */
    @YunxinParam("forcepushcontent")
    private String forcepushcontent;

    /**
     * 单条消息（包括自定义消息）是否使用 安全通（即易盾反垃圾）
     */
    @YunxinParam("useYidun")
    private Integer useYidun;

    /**
     * 安全通业务 ID，可以指定当前消息过安全通某个检测策略
     */
    @YunxinParam("bid")
    private String bid;

    /**
     * 透传给易盾的反作弊检测参数，格式为 JSON，长度限制 1024 字符
     */
    @YunxinParam("yidunAntiCheating")
    private String yidunAntiCheating;

    /**
     * 透传给易盾的反垃含圈组版的检测参数，格式为 JSON，长度限制 1024 字符
     */
    @YunxinParam("yidunAntiSpamExt")
    private String yidunAntiSpamExt;

    /**
     * 群消息是否需要已读业务（仅对群消息有效），0:不需要，1:需要
     */
    @YunxinParam("markRead")
    private Integer markRead;

    /**
     * 是否异步，默认 false
     */
    @YunxinParam("async")
    private Boolean async;

    /**
     * 是否为好友关系才能发送消息，默认为 false
     */
    @YunxinParam("checkFriend")
    private String checkFriend;

    /**
     * 自定义消息子类型，大于 0
     */
    @YunxinParam("subType")
    private Integer subType;

    /**
     * 发送方是否无感知。0-有感知，1-无感知
     */
    @YunxinParam("msgSenderNoSense")
    private Integer msgSenderNoSense;

    /**
     * 接受方是否无感知。0-有感知，1-无感知
     */
    @YunxinParam("msgReceiverNoSense")
    private Integer msgReceiverNoSense;

    /**
     * 当前消息需要抄送到的环境的名称
     */
    @YunxinParam("env")
    private String env;

    /**
     * 机器人账号，对应控制台提前设置好的机器人，仅在群聊中有效，点对点聊天室中该字段会被忽略
     */
    @YunxinParam("robotAccount")
    private String robotAccount;

    /**
     * 机器人消息话题
     */
    @YunxinParam("robotTopic")
    private String robotTopic;

    /**
     * 机器人具体功能
     */
    @YunxinParam("robotFunction")
    private String robotFunction;

    /**
     * 机器人自定义内容
     */
    @YunxinParam("robotCustomContent")
    private String robotCustomContent;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Integer getOpe() {
        return ope;
    }

    public void setOpe(Integer ope) {
        this.ope = ope;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
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

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getPushcontent() {
        return pushcontent;
    }

    public void setPushcontent(String pushcontent) {
        this.pushcontent = pushcontent;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public Boolean getForcepushall() {
        return forcepushall;
    }

    public void setForcepushall(Boolean forcepushall) {
        this.forcepushall = forcepushall;
    }

    public String getForcepushlist() {
        return forcepushlist;
    }

    public void setForcepushlist(String forcepushlist) {
        this.forcepushlist = forcepushlist;
    }

    public String getForcepushcontent() {
        return forcepushcontent;
    }

    public void setForcepushcontent(String forcepushcontent) {
        this.forcepushcontent = forcepushcontent;
    }

    public Integer getUseYidun() {
        return useYidun;
    }

    public void setUseYidun(Integer useYidun) {
        this.useYidun = useYidun;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
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

    public Integer getMarkRead() {
        return markRead;
    }

    public void setMarkRead(Integer markRead) {
        this.markRead = markRead;
    }

    public Boolean getAsync() {
        return async;
    }

    public void setAsync(Boolean async) {
        this.async = async;
    }

    public String getCheckFriend() {
        return checkFriend;
    }

    public void setCheckFriend(String checkFriend) {
        this.checkFriend = checkFriend;
    }

    public Integer getSubType() {
        return subType;
    }

    public void setSubType(Integer subType) {
        this.subType = subType;
    }

    public Integer getMsgSenderNoSense() {
        return msgSenderNoSense;
    }

    public void setMsgSenderNoSense(Integer msgSenderNoSense) {
        this.msgSenderNoSense = msgSenderNoSense;
    }

    public Integer getMsgReceiverNoSense() {
        return msgReceiverNoSense;
    }

    public void setMsgReceiverNoSense(Integer msgReceiverNoSense) {
        this.msgReceiverNoSense = msgReceiverNoSense;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getRobotAccount() {
        return robotAccount;
    }

    public void setRobotAccount(String robotAccount) {
        this.robotAccount = robotAccount;
    }

    public String getRobotTopic() {
        return robotTopic;
    }

    public void setRobotTopic(String robotTopic) {
        this.robotTopic = robotTopic;
    }

    public String getRobotFunction() {
        return robotFunction;
    }

    public void setRobotFunction(String robotFunction) {
        this.robotFunction = robotFunction;
    }

    public String getRobotCustomContent() {
        return robotCustomContent;
    }

    public void setRobotCustomContent(String robotCustomContent) {
        this.robotCustomContent = robotCustomContent;
    }

}
