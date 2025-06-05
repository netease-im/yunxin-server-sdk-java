package com.netease.nim.server.sdk.im.v1.message.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

public class RecallMessageRequestV1 {

    /**
     * 要撤回消息的消息 ID
     */
    @YunxinParam("deleteMsgid")
    private Long deleteMsgid;

    /**
     * 要撤回消息的创建时间
     */
    @YunxinParam("timetag")
    private Long timetag;

    /**
     * 只能传入 7 或 8: 7 表示单聊消息撤回，8 表示群消息撤回
     */
    @YunxinParam("type")
    private Integer type;

    /**
     * 消息发送方的云信 IM 账号（accid）
     */
    @YunxinParam("from")
    private String from;

    /**
     * 如果是单聊消息，为消息接收方的云信 IM 账号（accid）。如果是群消息，则为对应群的ID （tid）
     */
    @YunxinParam("to")
    private String to;

    /**
     * 消息撤回的相应描述，默认值为“撤回了一条信息”。最大长度 128 个字符
     */
    @YunxinParam("msg")
    private String msg;

    /**
     * 只能传入 1，1 表示忽略撤回时间检测，传其他值均判定为非法参数
     */
    @YunxinParam("ignoreTime")
    private String ignoreTime;

    /**
     * 推送文案，超过 500 字符后，会对文本进行截断
     */
    @YunxinParam("pushcontent")
    private String pushcontent;

    /**
     * 推送对应的 payload，必须是 JSON 格式，不能超过 2048 字符
     */
    @YunxinParam("payload")
    private String payload;

    /**
     * 消息撤回事件需要抄送到的环境的名称
     */
    @YunxinParam("env")
    private String env;

    /**
     * 扩展字段，最大 5000 字符
     */
    @YunxinParam("attach")
    private String attach;

    public Long getDeleteMsgid() {
        return deleteMsgid;
    }

    public void setDeleteMsgid(Long deleteMsgid) {
        this.deleteMsgid = deleteMsgid;
    }

    public Long getTimetag() {
        return timetag;
    }

    public void setTimetag(Long timetag) {
        this.timetag = timetag;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getIgnoreTime() {
        return ignoreTime;
    }

    public void setIgnoreTime(String ignoreTime) {
        this.ignoreTime = ignoreTime;
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

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

}
