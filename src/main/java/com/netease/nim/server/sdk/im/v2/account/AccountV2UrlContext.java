package com.netease.nim.server.sdk.im.v2.account;

/**
 * URL context for Account V2 API endpoints
 */
public class AccountV2UrlContext {
    
    /**
     * Accounts endpoint
     */
    static final String ACCOUNTS = "/im/v2/accounts";
    
    /**
     * Account with ID endpoint template
     */
    static final String ACCOUNT_WITH_ID = "/im/v2/accounts/{account_id}";
    
    /**
     * Set push config endpoint template
     */
    static final String SET_PUSH_CONFIG = "/im/v2/accounts/{account_id}/configuration/push";
    
    /**
     * Disable account endpoint template
     */
    static final String DISABLE_ACCOUNT = "/im/v2/accounts/{account_id}/actions/disable";
    
    /**
     * Kick account endpoint template
     */
    static final String KICK_ACCOUNT = "/im/v2/accounts/{account_id}/actions/kick";
    
    /**
     * Refresh token URL pattern
     */
    static final String REFRESH_TOKEN = "/im/v2/accounts/{account_id}/actions/refresh_token";
} 