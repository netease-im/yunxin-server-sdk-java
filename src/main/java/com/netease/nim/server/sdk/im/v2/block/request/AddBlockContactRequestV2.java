package com.netease.nim.server.sdk.im.v2.block.request;

import com.alibaba.fastjson2.annotation.JSONField;


public class AddBlockContactRequestV2 {

    @JSONField(name = "account_id")
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