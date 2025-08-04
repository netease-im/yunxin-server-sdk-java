package com.netease.nim.server.sdk.im.v1.system_notification.response;

import java.util.List;

/**
 * 发送自定义系统通知的响应参数
 */
public class SendAttachMsgResponseV1 {
    String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}