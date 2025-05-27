package com.netease.nim.im.server.sdk.v1.history.model;

import com.alibaba.fastjson2.JSONObject;

/**
 * Custom message with type >= 100
 */
public class CustomMessage extends Message {
    // For custom messages, body can be any arbitrary JSON content
    // Use the getBody() method from the parent class and cast it to JSONObject if needed
} 