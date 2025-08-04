package com.netease.nim.server.sdk.im.v2.block.request;

import com.alibaba.fastjson2.annotation.JSONField;


public class ListBlockContactsRequestV2 {

    @JSONField(name = "account_id")
    private String accountId;

    @JSONField(name = "page_token")
    private String pageToken;

    @JSONField(name = "limit")
    private Integer limit;
    
    public String getAccountId() {
        return accountId;
    }
    
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPageToken() {
        return pageToken;
    }
    
    public void setPageToken(String pageToken) {
        this.pageToken = pageToken;
    }

    public Integer getLimit() {
        return limit;
    }
    
    public void setLimit(Integer limit) {
        this.limit = limit;
    }
} 