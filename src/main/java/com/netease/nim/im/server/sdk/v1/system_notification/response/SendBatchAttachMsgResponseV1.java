package com.netease.nim.im.server.sdk.v1.system_notification.response;

import java.util.List;

/**
 * 批量发送自定义系统通知的响应参数
 */
public class SendBatchAttachMsgResponseV1 {
    
    /**
     * toAccids 列表中存在的未注册用户，示例：["123123","111422"]
     * 如果列表中不存在未注册用户则不返回本参数
     * 如果设置了 checkAccidAsyncEnable=true，则无效账号不会返回，且响应结果中不会包含 unregister 字段
     */
    private List<String> unregister;

    public List<String> getUnregister() {
        return unregister;
    }

    public void setUnregister(List<String> unregister) {
        this.unregister = unregister;
    }
} 