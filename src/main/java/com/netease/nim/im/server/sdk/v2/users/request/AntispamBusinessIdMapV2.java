package com.netease.nim.im.server.sdk.v2.users.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Antispam business ID mapping
 */
public class AntispamBusinessIdMapV2 {
    
    /**
     * Text detection type
     */
    public static final Integer TYPE_TEXT = 1;
    
    /**
     * Image detection type
     */
    public static final Integer TYPE_IMAGE = 2;
    
    @JSONField(name = "type")
    private Integer type;
    
    @JSONField(name = "business_id")
    private String businessId;

    public Integer getType() {
        return type;
    }

    /**
     * Set the detection type
     * @param type 1: text, 2: image
     */
    public void setType(Integer type) {
        this.type = type;
    }

    public String getBusinessId() {
        return businessId;
    }

    /**
     * Set the business ID for antispam detection
     * @param businessId antispam business ID
     */
    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }
} 