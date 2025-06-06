package com.netease.nim.server.sdk.im.v2.block;

/**
 * URL context for Block V2 API endpoints
 */
public class BlockV2UrlContext {
    
    /**
     * Add block contact endpoint
     */
    static final String ADD_BLOCK_CONTACT = "/im/v2/block_contacts";
    
    /**
     * Remove block contact endpoint
     */
    static final String REMOVE_BLOCK_CONTACT = "/im/v2/block_contacts/{account_id}";
    
    /**
     * List block contacts endpoint
     */
    static final String LIST_BLOCK_CONTACTS = "/im/v2/block_contacts";
} 