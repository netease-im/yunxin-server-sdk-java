package com.netease.nim.server.sdk.im.v1.account.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

/**
 * Created by caojiajun on 2024/12/26
 */
public class MuteModuleRequestV1 {

    @YunxinParam("accid")
    private String accid;

    @YunxinParam("muteP2P")
    private Boolean muteP2P;

    @YunxinParam("muteTeam")
    private Boolean muteTeam;

    @YunxinParam("muteRoom")
    private Boolean muteRoom;

    @YunxinParam("muteQChat")
    private Boolean muteQChat;

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

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
