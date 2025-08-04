package com.netease.nim.server.sdk.im.v2.mute;

/**
 * URL context for Mute V2 API endpoints
 */
public class MuteV2UrlContext {
    
    /**
     * Add mute contact endpoint
     */
    static final String ADD_MUTE_CONTACT = "/im/v2/mute_contacts";
    
    /**
     * Remove mute contact endpoint
     */
    static final String REMOVE_MUTE_CONTACT = "/im/v2/mute_contacts/{account_id}";
    
    /**
     * List mute contacts endpoint
     */
    static final String LIST_MUTE_CONTACTS = "/im/v2/mute_contacts";
} 