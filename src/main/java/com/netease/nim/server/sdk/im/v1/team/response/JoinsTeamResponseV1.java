package com.netease.nim.server.sdk.im.v1.team.response;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class JoinsTeamResponseV1 {

    private List<JoinsTinfo> infos;

    public List<JoinsTinfo> getInfos() {
        return infos;
    }

    public void setInfos(List<JoinsTinfo> infos) {
        this.infos = infos;
    }

    public static class JoinsTinfo {
        private String owner;

        private String tname;

        @JSONField(name = "maxusers")
        private Integer maxUsers;

        private Long tid;

        private Integer size;

        private String custom;

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public Integer getMaxUsers() {
            return maxUsers;
        }

        public void setMaxUsers(Integer maxUsers) {
            this.maxUsers = maxUsers;
        }

        public Long getTid() {
            return tid;
        }

        public void setTid(Long tid) {
            this.tid = tid;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public String getCustom() {
            return custom;
        }

        public void setCustom(String custom) {
            this.custom = custom;
        }
    }
}
