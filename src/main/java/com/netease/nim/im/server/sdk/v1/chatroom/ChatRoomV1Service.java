package com.netease.nim.im.server.sdk.v1.chatroom;

import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;

/**
 * Created by caojiajun on 2024/12/11
 */
public class ChatRoomV1Service implements IChatRoomV1Service {

    private final YunxinApiHttpClient httpClient;

    public ChatRoomV1Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }
}
