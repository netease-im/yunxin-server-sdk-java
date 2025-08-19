package com.netease.nim.server.sdk.im.v1.signal.response;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * 创建信令频道响应
 */
public class CreateSignalRoomResponseV1 {

    @JSONField(name = "channelName")
    private String channelName;

    @JSONField(name = "type")
    private String type;

    @JSONField(name = "channelId")
    private String channelId;

    @JSONField(name = "channelCreateTime")
    private Long channelCreateTime;

    @JSONField(name = "channelExpireTime")
    private Long channelExpireTime;

    @JSONField(name = "creator")
    private String creator;

    @JSONField(name = "ext")
    private String ext;

    @JSONField(name = "members")
    private List<Member> members;

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Long getChannelCreateTime() {
        return channelCreateTime;
    }

    public void setChannelCreateTime(Long channelCreateTime) {
        this.channelCreateTime = channelCreateTime;
    }

    public Long getChannelExpireTime() {
        return channelExpireTime;
    }

    public void setChannelExpireTime(Long channelExpireTime) {
        this.channelExpireTime = channelExpireTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public static class Member {
        @JSONField(name = "accid")
        private String accid;

        @JSONField(name = "uid")
        private Long uid;

        @JSONField(name = "deviceId")
        private String deviceId;

        @JSONField(name = "expireTime")
        private Long expireTime;

        @JSONField(name = "createTime")
        private Long createTime;

        public String getAccid() {
            return accid;
        }

        public void setAccid(String accid) {
            this.accid = accid;
        }

        public Long getUid() {
            return uid;
        }

        public void setUid(Long uid) {
            this.uid = uid;
        }

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public Long getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(Long expireTime) {
            this.expireTime = expireTime;
        }

        public Long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
        }
    }
} 