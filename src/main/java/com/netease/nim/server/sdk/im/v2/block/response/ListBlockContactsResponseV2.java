package com.netease.nim.server.sdk.im.v2.block.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for listing block contacts
 * 
 * API: GET https://open.yunxinapi.com/im/v2/block_contacts
 * 
 * Response Example:
 * {
 *   "code": 200,
 *   "msg": "success",
 *   "data": {
 *     "has_more": true,
 *     "next_token": "eyJsaW1pdCI6MiwicGFnZSI6Mn0=",
 *     "items": ["account1", "account2"]
 *   }
 * }
 */
public class ListBlockContactsResponseV2 {
    
    /**
     * Indicates if there are more results available
     * If true, additional results can be retrieved by using the next_token value
     */
    @JSONField(name = "has_more")
    private Boolean hasMore;
    
    /**
     * Token for next page of results
     * Should be included in the next request as the page_token parameter
     */
    @JSONField(name = "next_token")
    private String nextToken;
    
    /**
     * List of contact account IDs that are blocked
     * This is an array of strings, each being a contact account ID
     */
    @JSONField(name = "items")
    private List<String> items;
    
    /**
     * Check if there are more results available
     * @return true if more results are available, false otherwise
     */
    public Boolean getHasMore() {
        return hasMore;
    }
    
    /**
     * Set whether there are more results available
     * @param hasMore true if more results are available, false otherwise
     */
    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }
    
    /**
     * Get the token for the next page of results
     * @return the next page token
     */
    public String getNextToken() {
        return nextToken;
    }
    
    /**
     * Set the token for the next page of results
     * @param nextToken the next page token
     */
    public void setNextToken(String nextToken) {
        this.nextToken = nextToken;
    }
    
    /**
     * Get the list of blocked contact account IDs
     * @return the list of contact account IDs
     */
    public List<String> getItems() {
        return items;
    }
    
    /**
     * Set the list of blocked contact account IDs
     * @param items the list of contact account IDs
     */
    public void setItems(List<String> items) {
        this.items = items;
    }
} 