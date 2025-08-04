package com.netease.nim.server.sdk.im.v2.team.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class BatchQueryTeamOnlineMembersCountResponseV2 {
    
    
    @JSONField(name = "success_list")
    private List<SuccessTeam> successList;
    
    
    @JSONField(name = "failed_list")
    private List<FailedTeam> failedList;
    
    
    public static class SuccessTeam {
        
        @JSONField(name = "team_id")
        private Long teamId;
        
        
        @JSONField(name = "online_count")
        private Integer onlineCount;
        
        
        @JSONField(name = "offline_count")
        private Integer offlineCount;
        
        // Getters and Setters
        
        public Long getTeamId() {
            return teamId;
        }
        
        public void setTeamId(Long teamId) {
            this.teamId = teamId;
        }
        
        public Integer getOnlineCount() {
            return onlineCount;
        }
        
        public void setOnlineCount(Integer onlineCount) {
            this.onlineCount = onlineCount;
        }
        
        public Integer getOfflineCount() {
            return offlineCount;
        }
        
        public void setOfflineCount(Integer offlineCount) {
            this.offlineCount = offlineCount;
        }
    }
    
    
    public static class FailedTeam {
        
        @JSONField(name = "team_id")
        private Long teamId;
        
        
        @JSONField(name = "error_code")
        private Integer errorCode;
        
        
        @JSONField(name = "error_msg")
        private String errorMsg;
        
        // Getters and Setters
        
        public Long getTeamId() {
            return teamId;
        }
        
        public void setTeamId(Long teamId) {
            this.teamId = teamId;
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
    
    // Getters and Setters for the root class
    
    public List<SuccessTeam> getSuccessList() {
        return successList;
    }
    
    public void setSuccessList(List<SuccessTeam> successList) {
        this.successList = successList;
    }
    
    public List<FailedTeam> getFailedList() {
        return failedList;
    }
    
    public void setFailedList(List<FailedTeam> failedList) {
        this.failedList = failedList;
    }
} 