package com.netease.nim.im.server.sdk.v1.account.response;

import java.util.List;

/**
 * Created by caojiajun on 2024/12/26
 */
public class QueryAccountOnlineStatusResponseV1 {

    private List<String> invalidAccids;

    private List<OnlineStatus> onlineStatusList;

    public List<String> getInvalidAccids() {
        return invalidAccids;
    }

    public void setInvalidAccids(List<String> invalidAccids) {
        this.invalidAccids = invalidAccids;
    }

    public List<OnlineStatus> getOnlineStatusList() {
        return onlineStatusList;
    }

    public void setOnlineStatusList(List<OnlineStatus> onlineStatusList) {
        this.onlineStatusList = onlineStatusList;
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
