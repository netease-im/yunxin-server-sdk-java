package com.netease.nim.server.sdk.im.v2.account.response;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Response class for kicking account devices offline
 */
public class KickAccountResponseV2 {

    @JSONField(name = "success_list")
    private List<KickedDevice> successList;
    
    @JSONField(name = "failed_list")
    private List<FailedKick> failedList;

    public List<KickedDevice> getSuccessList() {
        return successList;
    }

    public void setSuccessList(List<KickedDevice> successList) {
        this.successList = successList;
    }

    public List<FailedKick> getFailedList() {
        return failedList;
    }

    public void setFailedList(List<FailedKick> failedList) {
        this.failedList = failedList;
    }

    /**
     * Information about a successfully kicked device
     */
    public static class KickedDevice {
        
        @JSONField(name = "device_id")
        private String deviceId;
        
        @JSONField(name = "client_type")
        private Integer clientType;
        
        @JSONField(name = "consid")
        private String consid;
        
        @JSONField(name = "login_time")
        private Long loginTime;

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public Integer getClientType() {
            return clientType;
        }

        public void setClientType(Integer clientType) {
            this.clientType = clientType;
        }

        public String getConsid() {
            return consid;
        }

        public void setConsid(String consid) {
            this.consid = consid;
        }

        public Long getLoginTime() {
            return loginTime;
        }

        public void setLoginTime(Long loginTime) {
            this.loginTime = loginTime;
        }
    }

    /**
     * Information about a failed kick operation
     */
    public static class FailedKick {
        
        @JSONField(name = "device_id")
        private String deviceId;
        
        @JSONField(name = "error_code")
        private Integer errorCode;
        
        @JSONField(name = "error_msg")
        private String errorMsg;

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
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
} 