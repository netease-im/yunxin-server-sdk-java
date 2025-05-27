package com.netease.nim.im.server.sdk.v1.history.model;

/**
 * File message with type = 6
 */
public class FileMessage extends Message {
    /**
     * File message body
     */
    public static class Body {
        /**
         * 文件名
         */
        private String name;
        
        /**
         * 文件MD5值
         */
        private String md5;
        
        /**
         * 文件URL
         */
        private String url;
        
        /**
         * 文件后缀类型
         */
        private String ext;
        
        /**
         * 文件大小，字节
         */
        private Long size;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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