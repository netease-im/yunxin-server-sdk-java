package com.netease.nim.im.server.sdk.v2.account;

/**
 * URL context for Account V2 API endpoints
 */
public class AccountUrlContextV2 {
    
    /**
     * Base account endpoint
     */
    static final String ACCOUNTS = "/im/v2/accounts";
    
    /**
     * Account endpoint with account ID parameter
     */
    static final String ACCOUNT_WITH_ID = "/im/v2/accounts/{account_id}";
    
    /**
     * Disable account endpoint
     */
    static final String DISABLE_ACCOUNT = "/im/v2/accounts/{account_id}/actions/disable";
    
    /**
     * Set push configuration endpoint
     */
    static final String SET_PUSH_CONFIG = "/im/v2/accounts/{account_id}/actions/push_config";
    
    /**
     * Path for kicking account devices offline
     */
    static final String KICK_ACCOUNT = "/im/v2/accounts/{account_id}/actions/kick";
} 