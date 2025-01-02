package com.netease.nim.im.server.sdk.v1.team.response;

import java.util.List;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class BatchQueryOnlineTeamMemberCountResponseV1 {

    private List<teamOnlineCount> data;

    public List<teamOnlineCount> getData() {
        return data;
    }

    public void setData(List<teamOnlineCount> data) {
        this.data = data;
    }

    public static class teamOnlineCount {
        private Long tid;

        private Integer onlineUserCount;

        private Integer offlineUserCount;

        public Long getTid() {
            return tid;
        }

        public void setTid(Long tid) {
            this.tid = tid;
        }

        public Integer getOnlineUserCount() {
            return onlineUserCount;
        }

        public void setOnlineUserCount(Integer onlineUserCount) {
            this.onlineUserCount = onlineUserCount;
        }

        public Integer getOfflineUserCount() {
            return offlineUserCount;
        }

        public void setOfflineUserCount(Integer offlineUserCount) {
            this.offlineUserCount = offlineUserCount;
        }
    }

}
