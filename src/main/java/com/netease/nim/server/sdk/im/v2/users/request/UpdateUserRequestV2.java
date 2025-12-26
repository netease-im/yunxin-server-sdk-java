package com.netease.nim.server.sdk.im.v2.users.request;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;


public class UpdateUserRequestV2 {
    
    
    public static final Integer GENDER_UNKNOWN = 0;
    
    
    public static final Integer GENDER_MALE = 1;
    
    
    public static final Integer GENDER_FEMALE = 2;

    private String accountId;
    
    @JSONField(name = "name")
    private String name;
    
    @JSONField(name = "avatar")
    private String avatar;
    
    @JSONField(name = "sign")
    private String sign;
    
    @JSONField(name = "email")
    private String email;
    
    @JSONField(name = "birthday")
    private String birthday;
    
    @JSONField(name = "mobile")
    private String mobile;
    
    @JSONField(name = "gender")
    private Integer gender;

    @JSONField(name = "email_validation_mode")
    private Integer emailValidationMode;
    
    @JSONField(name = "extension")
    private String extension;
    
    @JSONField(name = "antispam_configuration")
    private AntispamConfigurationV2 antispamConfiguration;

    public String getAccountId() {
        return accountId;
    }

    
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSign() {
        return sign;
    }

    
    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getEmail() {
        return email;
    }

    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMobile() {
        return mobile;
    }

    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getGender() {
        return gender;
    }

    
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getExtension() {
        return extension;
    }

    
    public void setExtension(String extension) {
        this.extension = extension;
    }

    public AntispamConfigurationV2 getAntispamConfiguration() {
        return antispamConfiguration;
    }

    
    public void setAntispamConfiguration(AntispamConfigurationV2 antispamConfiguration) {
        this.antispamConfiguration = antispamConfiguration;
    }

    public Integer getEmailValidationMode() {
        return emailValidationMode;
    }

    public void setEmailValidationMode(Integer emailValidationMode) {
        this.emailValidationMode = emailValidationMode;
    }


    public static class AntispamBusinessIdMapV2 {

        
        public static final Integer TYPE_TEXT = 1;

        
        public static final Integer TYPE_IMAGE = 2;

        @JSONField(name = "type")
        private Integer type;

        @JSONField(name = "business_id")
        private String businessId;

        public Integer getType() {
            return type;
        }

        
        public void setType(Integer type) {
            this.type = type;
        }

        public String getBusinessId() {
            return businessId;
        }

        
        public void setBusinessId(String businessId) {
            this.businessId = businessId;
        }
    }

    
    public static class AntispamConfigurationV2 {

        @JSONField(name = "enabled")
        private Boolean enabled;

        @JSONField(name = "business_id_map")
        private List<AntispamBusinessIdMapV2> businessIdMap;

        public Boolean getEnabled() {
            return enabled;
        }

        
        public void setEnabled(Boolean enabled) {
            this.enabled = enabled;
        }

        public List<AntispamBusinessIdMapV2> getBusinessIdMap() {
            return businessIdMap;
        }

        
        public void setBusinessIdMap(List<AntispamBusinessIdMapV2> businessIdMap) {
            this.businessIdMap = businessIdMap;
        }
    }
}