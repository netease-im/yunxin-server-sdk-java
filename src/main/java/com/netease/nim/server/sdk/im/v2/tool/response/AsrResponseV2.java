package com.netease.nim.server.sdk.im.v2.tool.response;


import com.alibaba.fastjson2.annotation.JSONField;

/**
 * V2 speech-to-text response
 */
public class AsrResponseV2{

    @JSONField(name = "text")
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
