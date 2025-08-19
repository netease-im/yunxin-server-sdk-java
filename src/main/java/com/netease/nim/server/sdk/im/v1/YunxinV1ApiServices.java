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
import com.netease.nim.server.sdk.im.v1.signal.ISignalV1Service;
import com.netease.nim.server.sdk.im.v1.signal.SignalV1Service;
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
    private final ISuperTeamV1Service superTeamService;
    private final IChatroomMessageV1Service chatroomMessageService;
    private final ITranslationV1Service translationService;
    private final ISpecialRelationV1Service specialRelationService;
    private final IMessageV1Service messageService;
    private final ISystemNotificationV1Service systemNotificationService;
    private final ISignalV1Service signalService;
    private final IEventSubscribeV1Service eventSubscribeService;

    public YunxinV1ApiServices(YunxinApiHttpClient yunxinApiHttpClient) {
        this.accountService = new AccountV1Service(yunxinApiHttpClient);
        this.friendService = new FriendV1Service(yunxinApiHttpClient);
        this.historyService = new HistoryV1Service(yunxinApiHttpClient);
        this.teamService = new TeamV1Service(yunxinApiHttpClient);
        this.chatRoomService = new ChatRoomV1Service(yunxinApiHttpClient);
        this.superTeamService = new SuperTeamV1Service(yunxinApiHttpClient);
        this.chatroomMessageService = new ChatroomMessageV1Service(yunxinApiHttpClient);
        this.translationService = new TranslationV1Service(yunxinApiHttpClient);
        this.specialRelationService = new SpecialRelationV1Service(yunxinApiHttpClient);
        this.messageService = new MessageV1Service(yunxinApiHttpClient);
        this.systemNotificationService = new SystemNotificationV1Service(yunxinApiHttpClient);
        this.signalService = new SignalV1Service(yunxinApiHttpClient);
        this.eventSubscribeService = new EventSubscribeV1Service(yunxinApiHttpClient);
    }

    public IAccountV1Service getAccountService() {
        return accountService;
    }

    public IFriendV1Service getFriendService() {
        return friendService;
    }

    public IHistoryV1Service getHistoryService() {
        return historyService;
    }

    public ITeamV1Service getTeamService() {
        return teamService;
    }

    public IChatRoomV1Service getChatRoomService() {
        return chatRoomService;
    }

    public ISuperTeamV1Service getSuperTeamService() {
        return superTeamService;
    }

    public IChatroomMessageV1Service getChatroomMessageService() {
        return chatroomMessageService;
    }

    public ITranslationV1Service getTranslationService() {
        return translationService;
    }

    public ISpecialRelationV1Service getSpecialRelationService() {
        return specialRelationService;
    }

    public IMessageV1Service getMessageService() {
        return messageService;
    }

    public ISystemNotificationV1Service getSystemNotificationService() {
        return systemNotificationService;
    }

    public IEventSubscribeV1Service getEventSubscribeService() {
        return eventSubscribeService;
    }

    public ISignalV1Service getSignalService() {
        return signalService;
    }
}
