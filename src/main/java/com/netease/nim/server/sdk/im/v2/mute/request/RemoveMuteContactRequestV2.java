package com.netease.nim.server.sdk.im.v2.mute.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request class for removing a mute contact
 */
public class RemoveMuteContactRequestV2 {

    private String accountId;
    
    @JSONField(name = "contact_account_id")
    private String contactAccountId;

    /**
     * Get the account ID that initiates the unmute operation
     * @return account ID
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Set the account ID that initiates the unmute operation
     * @param accountId account ID
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * Get the contact account ID to be unmuted
     * @return contact account ID
     */
    public String getContactAccountId() {
        return contactAccountId;
    }

    /**
     * Set the contact account ID to be unmuted
     * @param contactAccountId contact account ID
     */
    public void setContactAccountId(String contactAccountId) {
        this.contactAccountId = contactAccountId;
    }
} 