package com.netease.nim.im.server.sdk.v1.history.model;

/**
 * Audio message with type = 2
 */
public class AudioMessage extends Message {
    /**
     * Audio message body
     */
    public static class Body {
        /**
         * 语音持续时长，毫秒
         */
        private Long dur;
        
        /**
         * 语音文件MD5值
         */
        private String md5;
        
        /**
         * 语音文件URL
         */
        private String url;
        
        /**
         * 语音文件格式，只能是aac格式
         */
        private String ext;
        
        /**
         * 语音文件大小，字节
         */
        private Long size;

        public Long getDur() {
            return dur;
        }

        public void setDur(Long dur) {
            this.dur = dur;
        }

        public String getMd5() {
            return md5;
        }

        public void setMd5(String md5) {
            this.md5 = md5;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getExt() {
            return ext;
        }

        public void setExt(String ext) {
            this.ext = ext;
        }

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }
    }
} 