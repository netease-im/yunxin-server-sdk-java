package com.netease.nim.im.server.sdk.v1.history.model;

/**
 * Video message with type = 3
 */
public class VideoMessage extends Message {
    /**
     * Video message body
     */
    public static class Body {
        /**
         * 视频持续时长，毫秒
         */
        private Long dur;
        
        /**
         * 视频文件MD5值
         */
        private String md5;
        
        /**
         * 视频文件URL
         */
        private String url;
        
        /**
         * 视频宽度，像素
         */
        private Integer w;
        
        /**
         * 视频高度，像素
         */
        private Integer h;
        
        /**
         * 视频文件格式
         */
        private String ext;
        
        /**
         * 视频文件大小，字节
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