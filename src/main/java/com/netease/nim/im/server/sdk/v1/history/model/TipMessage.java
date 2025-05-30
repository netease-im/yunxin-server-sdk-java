package com.netease.nim.im.server.sdk.v1.history.model;

/**
 * Tip message with type = 10
 */
public class TipMessage extends Message {
    /**
     * Tip message body
     */
    public static class Body {
        /**
         * 提示消息内容
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