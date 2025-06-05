package com.netease.nim.server.sdk.im.v2.translation.response;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Response for translating text
 */
public class TranslateTextResponseV2 {

    /**
     * Translated text
     */
    @JSONField(name = "translated_text")
    private String translatedText;
    
    /**
     * Source language
     */
    @JSONField(name = "source_language")
    private String sourceLanguage;
    
    /**
     * Target language
     */
    @JSONField(name = "target_language")
    private String targetLanguage;
    
    /**
     * Default constructor
     */
    public TranslateTextResponseV2() {
    }
    
    /**
     * Get translated text
     * 
     * @return Translated text
     */
    public String getTranslatedText() {
        return translatedText;
    }
    
    /**
     * Set translated text
     * 
     * @param translatedText Translated text
     */
    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }
    
    /**
     * Get source language
     * 
     * @return Source language
     */
    public String getSourceLanguage() {
        return sourceLanguage;
    }
    
    /**
     * Set source language
     * 
     * @param sourceLanguage Source language
     */
    public void setSourceLanguage(String sourceLanguage) {
        this.sourceLanguage = sourceLanguage;
    }
    
    /**
     * Get target language
     * 
     * @return Target language
     */
    public String getTargetLanguage() {
        return targetLanguage;
    }
    
    /**
     * Set target language
     * 
     * @param targetLanguage Target language
     */
    public void setTargetLanguage(String targetLanguage) {
        this.targetLanguage = targetLanguage;
    }
} 