package com.netease.nim.server.sdk.im.v1.team.response;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class QueryAllJoinedTeamMemberInfoByAccIdResponseV1 {
    private List<TeamMemberInfo> data;

    public List<TeamMemberInfo> getData() {
        return data;
    }

    public void setData(List<TeamMemberInfo> data) {
        this.data = data;
    }

    public static class TeamMemberInfo {
        private Long tid;

        @JSONField(name = "accid")
        private String accId;

        private String nick;

        private Boolean mute;

        private Boolean managerPushEnable;

        private Boolean pushEnable;

        @JSONField(name = "createtime")
        private Long createTime;

        @JSONField(name = "updatetime")
        private Long updateTime;

        public Long getTid() {
            return tid;
        }

        public void setTid(Long tid) {
            this.tid = tid;
        }

        public String getAccId() {
            return accId;
        }

        public void setAccId(String accId) {
            this.accId = accId;
        }

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public Boolean getMute() {
            return mute;
        }

        public void setMute(Boolean mute) {
            this.mute = mute;
        }

        public Boolean getManagerPushEnable() {
            return managerPushEnable;
        }

        public void setManagerPushEnable(Boolean managerPushEnable) {
            this.managerPushEnable = managerPushEnable;
        }

        public Boolean getPushEnable() {
            return pushEnable;
        }

        public void setPushEnable(Boolean pushEnable) {
            this.pushEnable = pushEnable;
        }

        public Long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
        }

        public Long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Long updateTime) {
            this.updateTime = updateTime;
        }
    }
}
