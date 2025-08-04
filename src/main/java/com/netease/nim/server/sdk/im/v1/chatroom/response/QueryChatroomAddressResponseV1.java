package com.netease.nim.server.sdk.im.v1.chatroom.response;


import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Created by hekaijie on 2024/12/24
 */
public class QueryChatroomAddressResponseV1 {
    @JSONField(name = "addr")
    List<String> chatroomAddress;

    public List<String> getChatroomAddress() {
        return chatroomAddress;
    }

    public void setChatroomAddress(List<String> chatroomAddress) {
        this.chatroomAddress = chatroomAddress;
    }
}
