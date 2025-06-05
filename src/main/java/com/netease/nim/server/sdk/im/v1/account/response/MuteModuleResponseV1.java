package com.netease.nim.server.sdk.im.v1.account.response;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Created by caojiajun on 2024/12/26
 */
public class MuteModuleResponseV1 {

    @JSONField(name = "muteP2P")
    private Boolean muteP2P;

    @JSONField(name = "muteTeam")
    private Boolean muteTeam;

    @JSONField(name = "muteRoom")
    private Boolean muteRoom;

    @JSONField(name = "muteQChat")
    private Boolean muteQChat;

    public Boolean getMuteP2P() {
        return muteP2P;
    }

    public void setMuteP2P(Boolean muteP2P) {
        this.muteP2P = muteP2P;
    }

    public Boolean getMuteTeam() {
        return muteTeam;
    }

    public void setMuteTeam(Boolean muteTeam) {
        this.muteTeam = muteTeam;
    }

    public Boolean getMuteRoom() {
        return muteRoom;
    }

    public void setMuteRoom(Boolean muteRoom) {
        this.muteRoom = muteRoom;
    }

    public Boolean getMuteQChat() {
        return muteQChat;
    }

    public void setMuteQChat(Boolean muteQChat) {
        this.muteQChat = muteQChat;
    }
}
