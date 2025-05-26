package com.netease.nim.im.server.sdk.v1.system_notification.request;

import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;
import java.util.List;

/**
 * 批量发送自定义系统通知的请求参数
 */
public class SendBatchAttachMsgRequestV1 {

    /**
     * 发送者的网易云信 IM 账号（accid），最长 32 个字符，必须保证该账号为应用内唯一
     */
    @YunxinParam("fromAccid")
    private String fromAccid;

    /**
     * 接收者列表，["aaa","bbb"]（JSONArray 对应的 accid），最多 5000 人
     */
    @YunxinParam("toAccids")
    private List<String> toAccids;

    /**
     * 自定义通知内容，开发者自行组装的字符串，建议 JSON 格式，最大长度 4096 字符
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
     * 1 表示只发在线，2 表示会存离线
     */
    @YunxinParam("save")
    private Integer save;

    /**
     * 发消息时特殊指定的行为选项，JSON 格式，可用于指定系统通知计入未读等特殊行为
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
     * 系统通知需要抄送到的环境的名称
     */
    @YunxinParam("env")
    private String env;

    /**
     * 是否异步检查用户账号 ID。默认为 false
     */
    @YunxinParam("checkAccidAsyncEnable")
    private Boolean checkAccidAsyncEnable;

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