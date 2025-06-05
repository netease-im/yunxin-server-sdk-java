package com.netease.nim.server.sdk.im.v2.team.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for batch querying online members count in teams
 * 
 * This class represents the response containing the online and offline member counts
 * for multiple teams along with any failed team queries.
 */
public class BatchQueryTeamOnlineMembersCountResponseV2 {
    
    /**
     * List of teams that were successfully queried
     */
    @JSONField(name = "success_list")
    private List<SuccessTeam> successList;
    
    /**
     * List of teams that failed to be queried
     */
    @JSONField(name = "failed_list")
    private List<FailedTeam> failedList;
    
    /**
     * Information about a successfully queried team
     */
    public static class SuccessTeam {
        /**
         * Team ID
         */
        @JSONField(name = "team_id")
        private String teamId;
        
        /**
         * Number of online team members
         */
        @JSONField(name = "online_count")
        private Integer onlineCount;
        
        /**
         * Number of offline team members
         */
        @JSONField(name = "offline_count")
        private Integer offlineCount;
        
        // Getters and Setters
        
        public String getTeamId() {
            return teamId;
        }
        
        public void setTeamId(String teamId) {
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
    
    /**
     * Information about a team that failed to be queried
     */
    public static class FailedTeam {
        /**
         * Team ID
         */
        @JSONField(name = "team_id")
        private String teamId;
        
        /**
         * Error code
         */
        @JSONField(name = "error_code")
        private Integer errorCode;
        
        /**
         * Error message
         */
        @JSONField(name = "error_msg")
        private String errorMsg;
        
        // Getters and Setters
        
        public String getTeamId() {
            return teamId;
        }
        
        public void setTeamId(String teamId) {
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