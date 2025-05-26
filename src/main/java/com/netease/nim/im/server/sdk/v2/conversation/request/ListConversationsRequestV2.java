package com.netease.nim.im.server.sdk.v2.conversation.request;

/**
 * Request object for listing conversations
 * 
 * API: GET https://open.yunxinapi.com/im/v2/conversations
 */
public class ListConversationsRequestV2 {
    
    /**
     * Account ID for which to list conversations (required, query parameter)
     */
    private String accountId;
    
    /**
     * Pagination token (optional, query parameter)
     * Used for paginating through the results.
     * To get the next page, use the 'next_page_token' from the previous response.
     */
    private String pageToken;
    
    /**
     * Maximum number of conversations to return (optional, query parameter)
     * Default: 100
     * Valid range: 1-100
     */
    private Integer limit;
    
    /**
     * Default constructor
     */
    public ListConversationsRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     *
     * @param accountId the account ID
     */
    public ListConversationsRequestV2(String accountId) {
        this.accountId = accountId;
    }
    
    /**
     * Full constructor
     *
     * @param accountId the account ID
     * @param pageToken the pagination token
     * @param limit the maximum number of conversations to return
     */
    public ListConversationsRequestV2(String accountId, String pageToken, Integer limit) {
        this.accountId = accountId;
        this.pageToken = pageToken;
        this.limit = limit;
    }
    
    /**
     * Get the account ID
     *
     * @return the account ID
     */
    public String getAccountId() {
        return accountId;
    }
    
    /**
     * Set the account ID
     *
     * @param accountId the account ID to set
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    
    /**
     * Get the page token
     *
     * @return the page token
     */
    public String getPageToken() {
        return pageToken;
    }
    
    /**
     * Set the page token
     *
     * @param pageToken the page token to set
     */
    public void setPageToken(String pageToken) {
        this.pageToken = pageToken;
    }
    
    /**
     * Get the limit
     *
     * @return the limit
     */
    public Integer getLimit() {
        return limit;
    }
    
    /**
     * Set the limit
     *
     * @param limit the limit to set
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }
} 