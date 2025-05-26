package com.netease.nim.im.server.sdk.v2.friend.request;

/**
 * Request class for listing friends with pagination
 */
public class ListFriendsRequestV2 {

    private String accountId;
    private String pageToken;
    private Integer limit;

    public String getAccountId() {
        return accountId;
    }

    /**
     * Set the account ID that initiates the query
     * @param accountId account ID
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPageToken() {
        return pageToken;
    }

    /**
     * Set the page token for pagination
     * @param pageToken token from previous page's next_token, or null for first page
     */
    public void setPageToken(String pageToken) {
        this.pageToken = pageToken;
    }

    public Integer getLimit() {
        return limit;
    }

    /**
     * Set the maximum number of items to return per page
     * @param limit default and max value is 100
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }
} 