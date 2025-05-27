package com.netease.nim.im.server.sdk.v1.history.model;

/**
 * Image message with type = 1
 */
public class ImageMessage extends Message {
    /**
     * Image message body
     */
    public static class Body {
        /**
         * 图片名称
         */
        private String name;
        
        /**
         * 图片MD5值
         */
        private String md5;
        
        /**
         * 图片URL
         */
        private String url;
        
        /**
         * 图片文件后缀
         */
        private String ext;
        
        /**
         * 图片宽度，像素
         */
        private Integer w;
        
        /**
         * 图片高度，像素
         */
        private Integer h;
        
        /**
         * 图片大小，字节
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

        public Integer getW() {
            return w;
        }

        public void setW(Integer w) {
            this.w = w;
        }

        public Integer getH() {
            return h;
        }

        public void setH(Integer h) {
            this.h = h;
        }

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }
    }
} 