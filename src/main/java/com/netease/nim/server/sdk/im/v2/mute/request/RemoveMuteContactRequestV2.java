package com.netease.nim.server.sdk.im.v2.mute.request;

import com.alibaba.fastjson2.annotation.JSONField;


public class RemoveMuteContactRequestV2 {

    private String accountId;
    
    @JSONField(name = "contact_account_id")
    private String contactAccountId;

    
    public String getAccountId() {
        return accountId;
    }

    
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    
    public String getContactAccountId() {
        return contactAccountId;
    }

    
    public void setContactAccountId(String contactAccountId) {
        this.contactAccountId = contactAccountId;
    }
} 