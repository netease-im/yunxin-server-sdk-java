package com.netease.nim.im.server.sdk.v2.users.response;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Response class for getting multiple users information
 */
public class BatchGetUsersResponseV2 {

    @JSONField(name = "success_list")
    private List<UserInfo> successList;

    @JSONField(name = "failed_list")
    private List<FailedInfo> failedList;

    /**
     * User information for successfully queried accounts
     */
    public static class UserInfo {
        @JSONField(name = "account_id")
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
    }

    /**
     * Information about failed queries
     */
    public static class FailedInfo {
        @JSONField(name = "account_id")
        private String accountId;
        
        @JSONField(name = "error_code")
        private Integer errorCode;
        
        @JSONField(name = "error_msg")
        private String errorMsg;

        public String getAccountId() {
            return accountId;
        }

        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }

        public Integer getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(Integer errorCode) {
            this.errorCode = errorCode;
        }

        public String getErrorMsg() {
            return errorMsg;
        }

        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }
    }

    public List<UserInfo> getSuccessList() {
        return successList;
    }

    public void setSuccessList(List<UserInfo> successList) {
        this.successList = successList;
    }

    public List<FailedInfo> getFailedList() {
        return failedList;
    }

    public void setFailedList(List<FailedInfo> failedList) {
        this.failedList = failedList;
    }
} 