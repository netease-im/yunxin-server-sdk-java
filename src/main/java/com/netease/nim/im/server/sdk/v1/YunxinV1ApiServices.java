package com.netease.nim.im.server.sdk.v1;

import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.v1.account.AccountV1Service;
import com.netease.nim.im.server.sdk.v1.account.IAccountV1Service;
import com.netease.nim.im.server.sdk.v1.chatroom.ChatRoomV1Service;
import com.netease.nim.im.server.sdk.v1.chatroom.IChatRoomV1Service;
import com.netease.nim.im.server.sdk.v1.team.ITeamV1Service;
import com.netease.nim.im.server.sdk.v1.team.TeamV1Service;

/**
 * Created by caojiajun on 2024/12/11
 */
public class YunxinV1ApiServices {

    private final IAccountV1Service accountService;

    private final ITeamV1Service teamService;

    private final IChatRoomV1Service chatRoomService;

    public YunxinV1ApiServices(YunxinApiHttpClient yunxinApiHttpClient) {
        this.accountService = new AccountV1Service(yunxinApiHttpClient);
        this.teamService = new TeamV1Service(yunxinApiHttpClient);
        this.chatRoomService = new ChatRoomV1Service(yunxinApiHttpClient);
    }

    public IAccountV1Service getAccountService() {
        return accountService;
    }

    public ITeamV1Service getTeamService() {
        return teamService;
    }

    public IChatRoomV1Service getChatRoomService() {
        return chatRoomService;
    }
}
