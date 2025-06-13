package com.netease.nim.server.sdk.im.v1.chatroom.response;

import java.util.List;

/**
 * Response for listing all elements in a chatroom queue in sorted order
 */
public class QueueListResponseV1 {
    
    /**
     * List of queue elements, where each element is a Map with key as the element key and value as the element value
     */
    private List<QueueElement> list;

    public List<QueueElement> getList() {
        return list;
    }

    public void setList(List<QueueElement> list) {
        this.list = list;
    }

    public static class QueueElement {
        private final String key;
        private final String value;

        public QueueElement(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }
} 