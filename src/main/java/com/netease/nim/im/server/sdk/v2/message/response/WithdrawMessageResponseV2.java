package com.netease.nim.im.server.sdk.v2.message.response;

/**
 * Response object for withdrawing (recalling or deleting) a message
 * 
 * API: DELETE https://open.yunxinapi.com/im/v2/conversations/{conversation_id}/messages/{message_server_id}
 */
public class WithdrawMessageResponseV2 {
    // This is an empty response class as the API returns an empty data object on success
    // The API returns code 200 and msg "success" when successful
} 