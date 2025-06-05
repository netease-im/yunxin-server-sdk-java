package com.netease.nim.server.sdk.im.v1.team.response;

import java.util.List;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class QueryTeamMsgMarkReadInfoResponseV1 {

    private TeamMsgMarkReadInfo data;

    public TeamMsgMarkReadInfo getData() {
        return data;
    }

    public void setData(TeamMsgMarkReadInfo data) {
        this.data = data;
    }

    public static class TeamMsgMarkReadInfo {
        private Integer readSize;

        private Integer unreadSize;

        private List<String> readAccids;

        private List<String> unreadAccids;

        public Integer getReadSize() {
            return readSize;
        }

        public void setReadSize(Integer readSize) {
            this.readSize = readSize;
        }

        public Integer getUnreadSize() {
            return unreadSize;
        }

        public void setUnreadSize(Integer unreadSize) {
            this.unreadSize = unreadSize;
        }

        public List<String> getReadAccids() {
            return readAccids;
        }

        public void setReadAccids(List<String> readAccids) {
            this.readAccids = readAccids;
        }

        public List<String> getUnreadAccids() {
            return unreadAccids;
        }

        public void setUnreadAccids(List<String> unreadAccids) {
            this.unreadAccids = unreadAccids;
        }
    }
}
