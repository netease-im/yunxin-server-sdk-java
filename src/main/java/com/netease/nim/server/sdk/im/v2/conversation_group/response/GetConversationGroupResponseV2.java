package com.netease.nim.server.sdk.im.v2.conversation_group.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class GetConversationGroupResponseV2 {

    
    @JSONField(name = "group_id")
    private Long groupId;

    
    @JSONField(name = "name")
    private String name;

    
    @JSONField(name = "server_extension")
    private String serverExtension;

    @JSONField(name ="create_time")
    private Long createTime;

    @JSONField(name ="update_time")
    private Long updateTime;

    
    public Long getGroupId() {
        return groupId;
    }

    
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    
    public String getServerExtension() {
        return serverExtension;
    }

    
    public void setServerExtension(String serverExtension) {
        this.serverExtension = serverExtension;
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