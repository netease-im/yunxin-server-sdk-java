package com.netease.nim.im.server.sdk.v1.chatroom.reponse;


import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class QueryMembersByPageResponseV1 {

    private List<QueryMembersByPage> data;

    public List<QueryMembersByPage> getData() {
        return data;
    }

    public void setData(List<QueryMembersByPage> data) {
        this.data = data;
    }

    public static class QueryMembersByPage {
        @JSONField(name = "roomid")
        private Long roomId;

        private String accid;

        private String nick;

        private String avator;

        private String ext;

        private String type;

        private Integer level;

        private Boolean onlineStat;

        private Long enterTime;

        private Boolean blacklisted;

        private Boolean muted;

        private Boolean tempMuted;

        private Long tempMuteTtl;

        private Boolean isRobot;

        @JSONField(name = "robotExpirAt")
        private Integer robotExpireAt;

        public Long getRoomId() {
            return roomId;
        }

        public void setRoomId(Long roomId) {
            this.roomId = roomId;
        }

        public String getAccid() {
            return accid;
        }

        public void setAccid(String accid) {
            this.accid = accid;
        }

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public String getAvator() {
            return avator;
        }

        public void setAvator(String avator) {
            this.avator = avator;
        }

        public String getExt() {
            return ext;
        }

        public void setExt(String ext) {
            this.ext = ext;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Integer getLevel() {
            return level;
        }

        public void setLevel(Integer level) {
            this.level = level;
        }

        public Boolean getOnlineStat() {
            return onlineStat;
        }

        public void setOnlineStat(Boolean onlineStat) {
            this.onlineStat = onlineStat;
        }

        public Long getEnterTime() {
            return enterTime;
        }

        public void setEnterTime(Long enterTime) {
            this.enterTime = enterTime;
        }

        public Boolean getBlacklisted() {
            return blacklisted;
        }

        public void setBlacklisted(Boolean blacklisted) {
            this.blacklisted = blacklisted;
        }

        public Boolean getMuted() {
            return muted;
        }

        public void setMuted(Boolean muted) {
            this.muted = muted;
        }

        public Boolean getTempMuted() {
            return tempMuted;
        }

        public void setTempMuted(Boolean tempMuted) {
            this.tempMuted = tempMuted;
        }

        public Long getTempMuteTtl() {
            return tempMuteTtl;
        }

        public void setTempMuteTtl(Long tempMuteTtl) {
            this.tempMuteTtl = tempMuteTtl;
        }

        public Boolean getRobot() {
            return isRobot;
        }

        public void setRobot(Boolean robot) {
            isRobot = robot;
        }

        public Integer getRobotExpireAt() {
            return robotExpireAt;
        }

        public void setRobotExpireAt(Integer robotExpireAt) {
            this.robotExpireAt = robotExpireAt;
        }
    }

}
