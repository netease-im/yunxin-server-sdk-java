package com.netease.nim.im.server.sdk.v2.users.request;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Request class for updating user information
 */
public class UpdateUserRequestV2 {
    
    /**
     * Unknown gender
     */
    public static final Integer GENDER_UNKNOWN = 0;
    
    /**
     * Male gender
     */
    public static final Integer GENDER_MALE = 1;
    
    /**
     * Female gender
     */
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
    
    @JSONField(name = "extension")
    private String extension;
    
    @JSONField(name = "antispam_configuration")
    private AntispamConfigurationV2 antispamConfiguration;

    public String getAccountId() {
        return accountId;
    }

    /**
     * Set the account ID to update
     * @param accountId account ID
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    /**
     * Set the user's name
     * @param name user name, max 64 characters
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    /**
     * Set the user's avatar URL
     * @param avatar avatar URL, max 1024 characters
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSign() {
        return sign;
    }

    /**
     * Set the user's signature
     * @param sign signature, max 256 characters
     */
    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getEmail() {
        return email;
    }

    /**
     * Set the user's email
     * @param email email address, max 64 characters
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    /**
     * Set the user's birthday
     * @param birthday birthday in format "YYYY-MM-DD", max 16 characters
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMobile() {
        return mobile;
    }

    /**
     * Set the user's mobile number
     * @param mobile mobile number, max 32 characters
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getGender() {
        return gender;
    }

    /**
     * Set the user's gender
     * @param gender 0: unknown, 1: male, 2: female
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getExtension() {
        return extension;
    }

    /**
     * Set the extension field, recommended JSON format
     * @param extension extension data, max 1024 characters
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    public AntispamConfigurationV2 getAntispamConfiguration() {
        return antispamConfiguration;
    }

    /**
     * Set antispam configuration
     * @param antispamConfiguration antispam configuration
     */
    public void setAntispamConfiguration(AntispamConfigurationV2 antispamConfiguration) {
        this.antispamConfiguration = antispamConfiguration;
    }

    /**
     * Antispam business ID mapping
     */
    public static class AntispamBusinessIdMapV2 {

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

    /**
     * Antispam configuration
     */
    public static class AntispamConfigurationV2 {

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
}