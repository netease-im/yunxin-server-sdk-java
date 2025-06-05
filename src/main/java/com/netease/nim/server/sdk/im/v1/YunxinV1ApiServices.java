package com.netease.nim.server.sdk.im.v1;

import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.im.v1.account.AccountV1Service;
import com.netease.nim.server.sdk.im.v1.account.IAccountV1Service;
import com.netease.nim.server.sdk.im.v1.chatroom.ChatRoomV1Service;
import com.netease.nim.server.sdk.im.v1.chatroom.IChatRoomV1Service;
import com.netease.nim.server.sdk.im.v1.chatroom_message.ChatroomMessageV1Service;
import com.netease.nim.server.sdk.im.v1.chatroom_message.IChatroomMessageV1Service;
import com.netease.nim.server.sdk.im.v1.event_subscribe.EventSubscribeV1Service;
import com.netease.nim.server.sdk.im.v1.event_subscribe.IEventSubscribeV1Service;
import com.netease.nim.server.sdk.im.v1.friend.FriendV1Service;
import com.netease.nim.server.sdk.im.v1.friend.IFriendV1Service;
import com.netease.nim.server.sdk.im.v1.history.HistoryV1Service;
import com.netease.nim.server.sdk.im.v1.history.IHistoryV1Service;
import com.netease.nim.server.sdk.im.v1.message.IMessageV1Service;
import com.netease.nim.server.sdk.im.v1.message.MessageV1Service;
import com.netease.nim.server.sdk.im.v1.special_relation.ISpecialRelationV1Service;
import com.netease.nim.server.sdk.im.v1.special_relation.SpecialRelationV1Service;
import com.netease.nim.server.sdk.im.v1.super_team.ISuperTeamV1Service;
import com.netease.nim.server.sdk.im.v1.super_team.SuperTeamV1Service;
import com.netease.nim.server.sdk.im.v1.system_notification.ISystemNotificationV1Service;
import com.netease.nim.server.sdk.im.v1.system_notification.SystemNotificationV1Service;
import com.netease.nim.server.sdk.im.v1.team.ITeamV1Service;
import com.netease.nim.server.sdk.im.v1.team.TeamV1Service;
import com.netease.nim.server.sdk.im.v1.translations.ITranslationV1Service;
import com.netease.nim.server.sdk.im.v1.translations.TranslationV1Service;

/**
 * Created by caojiajun on 2024/12/11
 */
public class YunxinV1ApiServices {

    private final IAccountV1Service accountService;
    private final IFriendV1Service friendService;
    private final IHistoryV1Service historyService;
    private final ITeamV1Service teamService;
    private final IChatRoomV1Service chatRoomService;
    private final ISuperTeamV1Service superTeamV1Service;
    private final IChatroomMessageV1Service chatroomMessageV1Service;
    private final ITranslationV1Service translationV1Service;
    private final ISpecialRelationV1Service specialRelationV1Service;
    private final IMessageV1Service messageV1Service;
    private final ISystemNotificationV1Service systemNotificationService;
    private final IEventSubscribeV1Service eventSubscribeV1Service;

    public YunxinV1ApiServices(YunxinApiHttpClient yunxinApiHttpClient) {
        this.accountService = new AccountV1Service(yunxinApiHttpClient);
        this.friendService = new FriendV1Service(yunxinApiHttpClient);
        this.historyService = new HistoryV1Service(yunxinApiHttpClient);
        this.teamService = new TeamV1Service(yunxinApiHttpClient);
        this.chatRoomService = new ChatRoomV1Service(yunxinApiHttpClient);
        this.superTeamV1Service = new SuperTeamV1Service(yunxinApiHttpClient);
        this.chatroomMessageV1Service = new ChatroomMessageV1Service(yunxinApiHttpClient);
        this.translationV1Service = new TranslationV1Service(yunxinApiHttpClient);
        this.specialRelationV1Service = new SpecialRelationV1Service(yunxinApiHttpClient);
        this.messageV1Service = new MessageV1Service(yunxinApiHttpClient);
        this.systemNotificationService = new SystemNotificationV1Service(yunxinApiHttpClient);
        this.eventSubscribeV1Service = new EventSubscribeV1Service(yunxinApiHttpClient);
    }

    public IAccountV1Service getAccountService() {
        return accountService;
    }

    public IFriendV1Service getFriendV1Service() {
        return friendService;
    }

    public IHistoryV1Service getHistoryV1Service() {
        return historyService;
    }

    public ITeamV1Service getTeamService() {
        return teamService;
    }

    public IChatRoomV1Service getChatRoomService() {
        return chatRoomService;
    }

    public ISuperTeamV1Service getSuperTeamV1Service() {
        return superTeamV1Service;
    }

    public IChatroomMessageV1Service getChatroomMessageV1Service() {
        return chatroomMessageV1Service;
    }

    public ITranslationV1Service getTranslationV1Service() {
        return translationV1Service;
    }

    public ISpecialRelationV1Service getSpecialRelationV1Service() {
        return specialRelationV1Service;
    }

    public IMessageV1Service getMessageV1Service() {
        return messageV1Service;
    }

    public ISystemNotificationV1Service getSystemNotificationService() {
        return systemNotificationService;
    }
    
    public IEventSubscribeV1Service getEventSubscribeV1Service() {
        return eventSubscribeV1Service;
    }
}
