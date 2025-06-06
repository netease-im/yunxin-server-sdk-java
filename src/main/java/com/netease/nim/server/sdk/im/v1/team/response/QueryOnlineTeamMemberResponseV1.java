package com.netease.nim.server.sdk.im.v1.team.response;

import java.util.List;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class QueryOnlineTeamMemberResponseV1 {
    private Integer count;

    private List<OnlineStatus> status;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<OnlineStatus> getStatus() {
        return status;
    }

    public void setStatus(List<OnlineStatus> status) {
        this.status = status;
    }

    public static class OnlineStatus {
        private String accid;
        private List<Status> statusList;

        public List<Status> getStatusList() {
            return statusList;
        }

        public void setStatusList(List<Status> statusList) {
            this.statusList = statusList;
        }

        public String getAccid() {
            return accid;
        }

        public void setAccid(String accid) {
            this.accid = accid;
        }
    }

    public static class Status {
        private long loginTime;

        private int clientType;

        public long getLoginTime() {
            return loginTime;
        }

        public void setLoginTime(long loginTime) {
            this.loginTime = loginTime;
        }

        public int getClientType() {
            return clientType;
        }

        public void setClientType(int clientType) {
            this.clientType = clientType;
        }
    }
}
