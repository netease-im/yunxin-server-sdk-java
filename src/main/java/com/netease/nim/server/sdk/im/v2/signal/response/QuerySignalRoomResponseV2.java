package com.netease.nim.server.sdk.im.v2.signal.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * 查询信令房间响应 V2
 * 包含房间的详细信息和成员列表
 */
public class QuerySignalRoomResponseV2 {

    @JSONField(name = "channel_name")
    private String channelName;

    @JSONField(name = "channel_id")
    private String channelId;

    @JSONField(name = "creator_account_id")
    private String creatorAccountId;

    @JSONField(name = "channel_extension")
    private String channelExtension;

    /**
     * 注意：查询接口返回的是 type 而不是 channel_type
     */
    @JSONField(name = "channel_type")
    private Integer channelType;

    @JSONField(name = "create_time")
    private Long createTime;

    @JSONField(name = "expire_time")
    private Long expireTime;

    @JSONField(name = "member_list")
    private List<Member> memberList;


    /**
     * 房间成员信息
     */
    public static class Member {
        @JSONField(name = "account_id")
        private String accountId;

        @JSONField(name = "uid")
        private Long uid;

        @JSONField(name = "device_id")
        private String deviceId;

        @JSONField(name = "join_time")
        private Long joinTime;

        @JSONField(name = "expire_time")
        private Long expireTime;

        public String getAccountId() {
            return accountId;
        }

        public void setAccountId(String accountId) {
            this.accountId = accountId;
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

        public Long getJoinTime() {
            return joinTime;
        }

        public void setJoinTime(Long joinTime) {
            this.joinTime = joinTime;
        }

        public Long getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(Long expireTime) {
            this.expireTime = expireTime;
        }
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getCreatorAccountId() {
        return creatorAccountId;
    }

    public void setCreatorAccountId(String creatorAccountId) {
        this.creatorAccountId = creatorAccountId;
    }

    public String getChannelExtension() {
        return channelExtension;
    }

    public void setChannelExtension(String channelExtension) {
        this.channelExtension = channelExtension;
    }


    public Integer getChannelType() {
        return channelType;
    }

    public void setChannelType(Integer channelType) {
        this.channelType = channelType;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }
} 