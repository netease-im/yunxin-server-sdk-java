package com.netease.nim.im.server.sdk.v1.history.model;

/**
 * Location message with type = 4
 */
public class LocationMessage extends Message {
    /**
     * Location message body
     */
    public static class Body {
        /**
         * 地理位置标题
         */
        private String title;
        
        /**
         * 经度
         */
        private Double lng;
        
        /**
         * 纬度
         */
        private Double lat;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Double getLng() {
            return lng;
        }

        public void setLng(Double lng) {
            this.lng = lng;
        }

        public Double getLat() {
            return lat;
        }

        public void setLat(Double lat) {
            this.lat = lat;
        }
    }
} 