package com.netease.nim.im.server.sdk.v2.users.request;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Antispam configuration
 */
public class AntispamConfigurationV2 {
    
    @JSONField(name = "enabled")
    private Boolean enabled;
    
    @JSONField(name = "business_id_map")
    private List<AntispamBusinessIdMapV2> businessIdMap;

    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * Set whether to enable antispam
     * @param enabled true to enable, false to disable
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<AntispamBusinessIdMapV2> getBusinessIdMap() {
        return businessIdMap;
    }

    /**
     * Set the business ID mapping list
     * @param businessIdMap list of business ID mappings
     */
    public void setBusinessIdMap(List<AntispamBusinessIdMapV2> businessIdMap) {
        this.businessIdMap = businessIdMap;
    }
} 