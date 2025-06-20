package com.netease.nim.server.sdk.im.v1.chatroom.response;


import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Created by hekaijie on 2024/12/24
 */
public class TagMembersQueryResponseV1 {

    private List<TagMemberQueryBean> data;

    public List<TagMemberQueryBean> getData() {
        return data;
    }

    public void setData(List<TagMemberQueryBean> data) {
        this.data = data;
    }

    public static class TagMemberQueryBean {
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

        private Integer tempMuteTtl;

        private Boolean isRobot;

        private Integer robotExpirAt;

        private String tags;

        private String notifyTargetTags;

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

        public Integer getTempMuteTtl() {
            return tempMuteTtl;
        }

        public void setTempMuteTtl(Integer tempMuteTtl) {
            this.tempMuteTtl = tempMuteTtl;
        }

        public Boolean getRobot() {
            return isRobot;
        }

        public void setRobot(Boolean robot) {
            isRobot = robot;
        }

        public Integer getRobotExpirAt() {
            return robotExpirAt;
        }

        public void setRobotExpirAt(Integer robotExpirAt) {
            this.robotExpirAt = robotExpirAt;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public String getNotifyTargetTags() {
            return notifyTargetTags;
        }

        public void setNotifyTargetTags(String notifyTargetTags) {
            this.notifyTargetTags = notifyTargetTags;
        }
    }
}
