package com.netease.nim.server.sdk.im.v2.translation.response;

import com.alibaba.fastjson2.annotation.JSONField;


public class TranslateTextResponseV2 {

    
    @JSONField(name = "translated_text")
    private String translatedText;
    
    
    @JSONField(name = "source_language")
    private String sourceLanguage;
    
    
    @JSONField(name = "target_language")
    private String targetLanguage;
    
    
    public TranslateTextResponseV2() {
    }
    
    
    public String getTranslatedText() {
        return translatedText;
    }
    
    
    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }
    
    
    public String getSourceLanguage() {
        return sourceLanguage;
    }
    
    
    public void setSourceLanguage(String sourceLanguage) {
        this.sourceLanguage = sourceLanguage;
    }
    
    
    public String getTargetLanguage() {
        return targetLanguage;
    }
    
    
    public void setTargetLanguage(String targetLanguage) {
        this.targetLanguage = targetLanguage;
    }
} 