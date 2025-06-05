package com.netease.nim.server.sdk.im.v2.mute.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request class for adding a mute contact
 */
public class AddMuteContactRequestV2 {

    @JSONField(name = "account_id")
    private String accountId;
    
    @JSONField(name = "contact_account_id")
    private String contactAccountId;

    /**
     * Get the account ID that initiates the mute operation
     * @return account ID
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Set the account ID that initiates the mute operation
     * @param accountId account ID
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * Get the contact account ID to be muted
     * @return contact account ID
     */
    public String getContactAccountId() {
        return contactAccountId;
    }

    /**
     * Set the contact account ID to be muted
     * @param contactAccountId contact account ID
     */
    public void setContactAccountId(String contactAccountId) {
        this.contactAccountId = contactAccountId;
    }
} 