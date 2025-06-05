package com.netease.nim.server.sdk.im.v2.team.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for listing online team members
 * 
 * This class represents the response containing a list of online team members
 * and their login information.
 */
public class ListOnlineTeamMembersResponseV2 {
    
    @JSONField(name = "items")
    private List<OnlineTeamMember> items;
    
    /**
     * Online team member information
     */
    public static class OnlineTeamMember {
        @JSONField(name = "account_id")
        private String accountId;
        
        @JSONField(name = "online_status")
        private List<LoginInfo> onlineStatus;
        
        /**
         * Login information including login time and client type
         */
        public static class LoginInfo {
            @JSONField(name = "login_time")
            private Long loginTime;
            
            @JSONField(name = "client_type")
            private Integer clientType;
            
            // Getters and Setters
            
            public Long getLoginTime() {
                return loginTime;
            }
            
            public void setLoginTime(Long loginTime) {
                this.loginTime = loginTime;
            }
            
            public Integer getClientType() {
                return clientType;
            }
            
            public void setClientType(Integer clientType) {
                this.clientType = clientType;
            }
        }
        
        // Getters and Setters
        
        public String getAccountId() {
            return accountId;
        }
        
        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }
        
        public List<LoginInfo> getOnlineStatus() {
            return onlineStatus;
        }
        
        public void setOnlineStatus(List<LoginInfo> onlineStatus) {
            this.onlineStatus = onlineStatus;
        }
    }
    
    // Getters and Setters for the root class
    
    public List<OnlineTeamMember> getItems() {
        return items;
    }
    
    public void setItems(List<OnlineTeamMember> items) {
        this.items = items;
    }
} 