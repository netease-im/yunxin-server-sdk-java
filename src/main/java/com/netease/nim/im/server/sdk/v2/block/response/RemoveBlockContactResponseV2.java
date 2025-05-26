package com.netease.nim.im.server.sdk.v2.block.response;

/**
 * Response for removing a contact from the block list
 * 
 * API: DELETE https://open.yunxinapi.com/im/v2/block_contacts/{account_id}
 * 
 * Response Example:
 * {
 *   "code": 200,
 *   "msg": "success",
 *   "data": {}
 * }
 * 
 * This is an empty response class as the API returns an empty object on success.
 * The actual status is determined by the code field in the Result object.
 */
public class RemoveBlockContactResponseV2 {
    // Empty class as the API returns an empty object on success
} 