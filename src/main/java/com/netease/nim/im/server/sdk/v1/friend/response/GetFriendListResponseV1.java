package com.netease.nim.im.server.sdk.v1.friend.response;

import java.util.List;

public class GetFriendListResponseV1 {
    private List<FriendInfo> friends;

    public List<FriendInfo> getFriends() {
        return friends;
    }

    public void setFriends(List<FriendInfo> friends) {
        this.friends = friends;
    }

    public class FriendInfo {
        /**
         * 好友关系创建时间
         **/
        private long createtime;

        /**
         * 双向好友标志
         **/
        private boolean bidirection;

        /**
         * 好友的云信IM账号
         **/
        private String faccid;

        /**
         * 备注名
         **/
        private String alias;

        public long getCreatetime() {
            return createtime;
        }

        public void setCreatetime(long createtime) {
            this.createtime = createtime;
        }

        public boolean isBidirection() {
            return bidirection;
        }

        public void setBidirection(boolean bidirection) {
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
