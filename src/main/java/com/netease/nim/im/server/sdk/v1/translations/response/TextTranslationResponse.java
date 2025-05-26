package com.netease.nim.im.server.sdk.v1.translations.response;

public class TextTranslationResponse {
    /**
     * 翻译结果。
     */
    private String translation;

    /**
     * 源语言和目标语言，由 "2" 分割，"2" 前面是源语言，后面是目标语言。
     */
    private String language;

    /**
     * 翻译完成的时间。
     */
    private Long  timestamp;

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
