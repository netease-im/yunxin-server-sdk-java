package com.netease.nim.im.server.sdk.v1.history.model;

/**
 * Text message with type = 0
 */
public class TextMessage extends Message {
    /**
     * Text message body
     */
    public static class Body {
        /**
         * 消息内容
         */
        private String msg;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
} 