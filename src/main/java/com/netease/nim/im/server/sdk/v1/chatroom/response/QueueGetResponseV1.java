package com.netease.nim.im.server.sdk.v1.chatroom.response;

import java.util.List;
import java.util.Map;

/**
 * Response for retrieving specified queue elements from a chatroom
 */
public class QueueGetResponseV1 {
    
    /**
     * List of queue elements, where each element is a Map with key as the element key and value as the element value
     */
    private List<Map> list;

    public List<Map> getList() {
        return list;
    }

    public void setList(List<Map> list) {
        this.list = list;
    }
} 