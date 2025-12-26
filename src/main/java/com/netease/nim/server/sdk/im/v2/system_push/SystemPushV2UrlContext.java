package com.netease.nim.server.sdk.im.v2.system_push;

/**
 * URL context for system push API V2
 */
public class SystemPushV2UrlContext {

    /**
     * URL for sending push notifications to all users
     */
    public static final String PUSH_NOTIFICATION = "/im/v2/push_notification";
    
    /**
     * URL template for getting a single push notification
     * {push_id} should be replaced with the push notification ID
     */
    public static final String GET_PUSH_NOTIFICATION = "/im/v2/push_notification/{push_id}";
}

