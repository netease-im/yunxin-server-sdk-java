package com.netease.nim.server.sdk.im.v1.message.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;
import java.util.List;

public class BroadcastMessageRequestV1 {

    /**
     * 广播消息内容，最大 4096 字符
     */
    @YunxinParam("body")
    private String body;

    /**
     * 发送者的云信 IM 账号（accid），最大长度 32 字符
     */
    @YunxinParam("from")
    private String from;

    /**
     * 广播消息是否存离线，true 或 false，默认 false
     */
    @YunxinParam("isOffline")
    private Boolean isOffline;

    /**
     * 目标客户端，默认所有客户端
     */
    private List<String> targetOs;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Boolean getOffline() {
        return isOffline;
    }

    public void setOffline(Boolean offline) {
        isOffline = offline;
    }

    public List<String> getTargetOs() {
        return targetOs;
    }

    public void setTargetOs(List<String> targetOs) {
        this.targetOs = targetOs;
    }

}
