package com.netease.nim.im.server.sdk.v1.system_notification.request;

import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;
import java.util.List;

/**
 * 发送自定义系统通知的请求参数
 */
public class SendAttachMsgRequestV1 {

    /**
     * 发送者accid，用户帐号，最大32字符，APP内唯一
     */
    @YunxinParam("from")
    private String from;

    /**
     * 0：点对点自定义通知，1：群消息自定义通知
     */
    @YunxinParam("msgtype")
    private Integer msgType;

    /**
     * msgtype=0 时需填入接收系统通知的用户的的云信 IM 账号（accid），
     * msgtype=1 时需填入接收系统通知的群的 ID（即 tid），最大 32 字符
     */
    @YunxinParam("to")
    private String to;

    /**
     * 自定义系统通知的具体内容，开发者组装的字符串，建议 JSON 格式，最大长度 4096 字符
     */
    @YunxinParam("attach")
    private String attach;

    /**
     * 推送文案，最长 500 个字符
     */
    @YunxinParam("pushcontent")
    private String pushContent;

    /**
     * 推送对应的 payload，必须是 JSON 格式，不能超过 2048 字符
     */
    @YunxinParam("payload")
    private String payload;

    /**
     * 如果有指定推送，此属性指定为客户端本地的声音文件名，长度不要超过 30 个字符
     */
    @YunxinParam("sound")
    private String sound;

    /**
     * 只能传入 1 或 2，1 表示只发在线，2 表示会存离线
     */
    @YunxinParam("save")
    private Integer save;

    /**
     * 发消息时特殊指定的行为选项，JSON 格式，可用于指定该自定义系统通知是否计入未读数等特殊行为
     */
    @YunxinParam("option")
    private String option;

    /**
     * 发自定义系统通知时，是否强制推送
     */
    @YunxinParam("isForcePush")
    private Boolean isForcePush;

    /**
     * 发自定义系统通知时，强制推送的文案，最长 500 个字符
     */
    @YunxinParam("forcePushContent")
    private String forcePushContent;

    /**
     * 发群自定义系统通知时，强推列表是否为群里除发送者外的所有有效成员
     */
    @YunxinParam("forcePushAll")
    private Boolean forcePushAll;

    /**
     * 发群自定义系统通知时的强推列表，格式为 JSONArray，示例：["accid1","accid2"]，列表内最多 100 个用户
     */
    @YunxinParam("forcePushList")
    private String forcePushList;

    /**
     * 系统通知需要抄送到的环境的名称，对应在云信控制台中配置的自定义抄送的环境名称
     */
    @YunxinParam("env")
    private String env;

    /**
     * 是否异步检查用户账号 ID。默认为 false
     */
    @YunxinParam("checkAccidAsyncEnable")
    private Boolean checkAccidAsyncEnable;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getPushContent() {
        return pushContent;
    }

    public void setPushContent(String pushContent) {
        this.pushContent = pushContent;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public Integer getSave() {
        return save;
    }

    public void setSave(Integer save) {
        this.save = save;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public Boolean getIsForcePush() {
        return isForcePush;
    }

    public void setIsForcePush(Boolean isForcePush) {
        this.isForcePush = isForcePush;
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

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public Boolean getCheckAccidAsyncEnable() {
        return checkAccidAsyncEnable;
    }

    public void setCheckAccidAsyncEnable(Boolean checkAccidAsyncEnable) {
        this.checkAccidAsyncEnable = checkAccidAsyncEnable;
    }
} 