package com.netease.nim.server.sdk.im.v1.message.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;
import java.util.List;

public class SendBatchMessageRequestV1 {

    /**
     * 发送者的网易云信 IM 账号（accid），最大 32 字符
     */
    @YunxinParam("fromAccid")
    private String fromAccid;

    /**
     * 消息接收者的网易云信 IM 账号（accid）列表，限 500 人
     */
    private List<String> toAccids;

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
     * 消息描述文本，只对文本消息和提示消息以外的消息类型有效，最大长度 500 字符
     */
    @YunxinParam("msgDesc")
    private String msgDesc;

    /**
     * 发消息时特殊指定的行为选项,JSON 格式，可用于指定消息的漫游，存云端历史，发送方多端同步，推送，消息抄送等特殊行为
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
     * 单条消息（包括自定义消息）是否使用安全通（即易盾反垃圾）
     */
    @YunxinParam("useYidun")
    private Integer useYidun;

    /**
     * 安全通业务 ID，可以指定当前消息过安全通某个检测配置
     */
    @YunxinParam("bid")
    private String bid;

    /**
     * 透传给易盾的反作弊检测参数，格式为 JSON，长度限制 1024 字符
     */
    @YunxinParam("yidunAntiCheating")
    private String yidunAntiCheating;

    /**
     * 透传给易盾的反垃圾含圈组版的检测参数，格式为 JSON，长度限制 1024 字符
     */
    @YunxinParam("yidunAntiSpamExt")
    private String yidunAntiSpamExt;

    /**
     * 是否需要返回消息ID
     */
    @YunxinParam("returnMsgid")
    private Boolean returnMsgid;

    /**
     * 当前消息需要抄送到的环境的名称
     */
    @YunxinParam("env")
    private String env;

    /**
     * 发送方是否无感知
     */
    @YunxinParam("msgSenderNoSense")
    private Integer msgSenderNoSense;

    public String getFromAccid() {
        return fromAccid;
    }

    public void setFromAccid(String fromAccid) {
        this.fromAccid = fromAccid;
    }

    public List<String> getToAccids() {
        return toAccids;
    }

    public void setToAccids(List<String> toAccids) {
        this.toAccids = toAccids;
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

    public Boolean getReturnMsgid() {
        return returnMsgid;
    }

    public void setReturnMsgid(Boolean returnMsgid) {
        this.returnMsgid = returnMsgid;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public Integer getMsgSenderNoSense() {
        return msgSenderNoSense;
    }

    public void setMsgSenderNoSense(Integer msgSenderNoSense) {
        this.msgSenderNoSense = msgSenderNoSense;
    }

}
