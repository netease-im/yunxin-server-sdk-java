package com.netease.nim.server.sdk.im.v1.chatroom.response;

import java.util.List;
import java.util.Map;

/**
 * Response for listing all elements in a chatroom queue in sorted order
 */
public class QueueListResponseV1 {
    
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