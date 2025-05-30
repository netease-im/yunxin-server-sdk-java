package com.netease.nim.im.server.sdk.v2.block.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for adding a contact to the block list
 * 
 * API: POST https://open.yunxinapi.com/im/v2/block_contacts
 */
public class AddBlockContactRequestV2 {
    
    /**
     * Account ID initiating the block operation (required)
     */
    @JSONField(name = "account_id")
    private String accountId;
    
    /**
     * Contact account ID to be blocked (required)
     */
    @JSONField(name = "contact_account_id")
    private String contactAccountId;
    
    /**
     * Get the account ID
     * @return the account ID
     */
    public String getAccountId() {
        return accountId;
    }
    
    /**
     * Set the account ID (required)
     * @param accountId the account ID to set
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    
    /**
     * Get the contact account ID
     * @return the contact account ID
     */
    public String getContactAccountId() {
        return contactAccountId;
    }
    
    /**
     * Set the contact account ID (required)
     * @param contactAccountId the contact account ID to set
     */
    public AddBlockContactRequestV2 setContactAccountId(String contactAccountId) {
        this.contactAccountId = contactAccountId;
        return this;
    }
} 