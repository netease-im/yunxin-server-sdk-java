package com.netease.nim.server.sdk.im.v1.chatroom.request;


import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

import java.util.List;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class AddRobotRequestV1 {

    @YunxinParam("roomid")
    private Long roomId;

    @YunxinParam("accids")
    private List<String> accids;

    @YunxinParam("roleExt")
    private String roleExt;

    @YunxinParam("notifyExt")
    private String notifyExt;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public List<String> getAccids() {
        return accids;
    }

    public void setAccids(List<String> accids) {
        this.accids = accids;
    }

    public String getRoleExt() {
        return roleExt;
    }

    public void setRoleExt(String roleExt) {
        this.roleExt = roleExt;
    }

    public String getNotifyExt() {
        return notifyExt;
    }

    public void setNotifyExt(String notifyExt) {
        this.notifyExt = notifyExt;
    }
}
