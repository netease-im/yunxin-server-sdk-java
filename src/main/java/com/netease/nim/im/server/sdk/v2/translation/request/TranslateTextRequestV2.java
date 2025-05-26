package com.netease.nim.im.server.sdk.v2.translation.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for translating text
 */
public class TranslateTextRequestV2 {

    /**
     * Operator's account ID
     */
    @JSONField(name = "operator_account_id")
    private String operatorAccountId;
    
    /**
     * Text to be translated
     */
    @JSONField(name = "source_text")
    private String sourceText;
    
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
     * Translation configuration
     */
    @JSONField(name = "translator_config")
    private TranslatorConfig translatorConfig;
    
    /**
     * Default constructor
     */
    public TranslateTextRequestV2() {
    }
    
    /**
     * Get operator's account ID
     * 
     * @return Operator's account ID
     */
    public String getOperatorAccountId() {
        return operatorAccountId;
    }
    
    /**
     * Set operator's account ID
     * 
     * @param operatorAccountId Operator's account ID
     */
    public void setOperatorAccountId(String operatorAccountId) {
        this.operatorAccountId = operatorAccountId;
    }
    
    /**
     * Get source text
     * 
     * @return Source text
     */
    public String getSourceText() {
        return sourceText;
    }
    
    /**
     * Set source text
     * 
     * @param sourceText Source text
     */
    public void setSourceText(String sourceText) {
        this.sourceText = sourceText;
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
    
    /**
     * Get translator configuration
     * 
     * @return Translator configuration
     */
    public TranslatorConfig getTranslatorConfig() {
        return translatorConfig;
    }
    
    /**
     * Set translator configuration
     * 
     * @param translatorConfig Translator configuration
     */
    public void setTranslatorConfig(TranslatorConfig translatorConfig) {
        this.translatorConfig = translatorConfig;
    }
    
    /**
     * Configuration for translation
     */
    public static class TranslatorConfig {
        
        /**
         * Whether to strictly use provided source and target languages
         */
        @JSONField(name = "strict")
        private Boolean strict;
        
        /**
         * Default constructor
         */
        public TranslatorConfig() {
        }
        
        /**
         * Get strict flag
         * 
         * @return Strict flag
         */
        public Boolean getStrict() {
            return strict;
        }
        
        /**
         * Set strict flag
         * 
         * @param strict Strict flag
         */
        public void setStrict(Boolean strict) {
            this.strict = strict;
        }
    }
} 