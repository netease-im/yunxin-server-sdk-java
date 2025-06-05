package com.netease.nim.server.sdk.im.v2.block.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for listing block contacts
 * 
 * API: GET https://open.yunxinapi.com/im/v2/block_contacts
 */
public class ListBlockContactsRequestV2 {
    
    /**
     * Account ID to list block contacts for (required)
     */
    @JSONField(name = "account_id")
    private String accountId;
    
    /**
     * Page token for pagination (optional)
     * If empty, defaults to the first page
     */
    @JSONField(name = "page_token")
    private String pageToken;
    
    /**
     * Limit for number of results per page (optional)
     * Default and maximum value is 100
     */
    @JSONField(name = "limit")
    private Integer limit;
    
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
    public void  setAccountId(String accountId) {
        this.accountId = accountId;
    }
    
    /**
     * Get the page token
     * @return the page token
     */
    public String getPageToken() {
        return pageToken;
    }
    
    /**
     * Set the page token (optional)
     * @param pageToken the page token to set
     * @return this request for chaining
     */
    public ListBlockContactsRequestV2 setPageToken(String pageToken) {
        this.pageToken = pageToken;
        return this;
    }
    
    /**
     * Get the limit
     * @return the limit
     */
    public Integer getLimit() {
        return limit;
    }
    
    /**
     * Set the limit (optional, default and max is 100)
     * @param limit the limit to set
     * @return this request for chaining
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }
} 