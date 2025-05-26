package com.netease.nim.im.server.sdk.v2.account.request;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Request class for kicking account devices offline
 */
public class KickAccountRequestV2 {

    @JSONField(name = "account_id")
    private String accountId;
    
    @JSONField(name = "type")
    private Integer type;
    
    @JSONField(name = "device_id_list")
    private List<String> deviceIdList;
    
    @JSONField(name = "kick_notify_extension")
    private String kickNotifyExtension;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Integer getType() {
        return type;
    }

    /**
     * Set the kick operation type
     * @param type 1: kick all devices, 2: kick devices in device_id_list, 3: preserve devices in device_id_list, kick other devices
     */
    public void setType(Integer type) {
        this.type = type;
    }

    public List<String> getDeviceIdList() {
        return deviceIdList;
    }

    /**
     * Set the device IDs list (max 20 devices)
     * @param deviceIdList list of device IDs
     */
    public void setDeviceIdList(List<String> deviceIdList) {
        this.deviceIdList = deviceIdList;
    }

    public String getKickNotifyExtension() {
        return kickNotifyExtension;
    }

    /**
     * Set the notification extension for kicked devices
     * @param kickNotifyExtension extension string, max 256 characters
     */
    public void setKickNotifyExtension(String kickNotifyExtension) {
        this.kickNotifyExtension = kickNotifyExtension;
    }
} 