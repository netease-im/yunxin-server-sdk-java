package com.netease.nim.server.sdk.im.v1.friend.response;

import java.util.List;

public class GetFriendListResponseV1 {
    private List<FriendInfo> friends;

    public List<FriendInfo> getFriends() {
        return friends;
    }

    public void setFriends(List<FriendInfo> friends) {
        this.friends = friends;
    }

    public static class FriendInfo {
        private Long createtime;

        private Boolean bidirection;

        private String faccid;

        private String alias;

        public Long getCreatetime() {
            return createtime;
        }

        public void setCreatetime(Long createtime) {
            this.createtime = createtime;
        }

        public Boolean getBidirection() {
            return bidirection;
        }

        public void setBidirection(Boolean bidirection) {
            this.bidirection = bidirection;
        }

        public String getFaccid() {
            return faccid;
        }

        public void setFaccid(String faccid) {
            this.faccid = faccid;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }
    }
}
