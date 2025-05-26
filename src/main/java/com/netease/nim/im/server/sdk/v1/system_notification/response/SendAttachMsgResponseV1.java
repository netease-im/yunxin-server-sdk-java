package com.netease.nim.im.server.sdk.v1.system_notification.response;

import java.util.List;

/**
 * 发送自定义系统通知的响应参数
 */
public class SendAttachMsgResponseV1 {
    
    /**
     * 未注册的账号列表，如果开启 checkAccidAsyncEnable，则该字段不会返回
     */
    private List<String> unregister;

    public List<String> getUnregister() {
        return unregister;
    }

    public void setUnregister(List<String> unregister) {
        this.unregister = unregister;
    }
} 