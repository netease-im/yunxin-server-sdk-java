package com.netease.nim.im.server.sdk.v2.block.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for removing a contact from the block list
 * 
 * API: DELETE https://open.yunxinapi.com/im/v2/block_contacts/{account_id}
 */
public class RemoveBlockContactRequestV2 {
    
    /**
     * Account ID initiating the unblock operation (required)
     * This will be substituted in the URL path
     */
    @JSONField(name = "account_id")
    private String accountId;
    
    /**
     * Contact account ID to be unblocked (required)
     * This will be passed as a query parameter
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
     * @return this request for chaining
     */
    public RemoveBlockContactRequestV2 setAccountId(String accountId) {
        this.accountId = accountId;
        return this;
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
     * @return this request for chaining
     */
    public RemoveBlockContactRequestV2 setContactAccountId(String contactAccountId) {
        this.contactAccountId = contactAccountId;
        return this;
    }
} 