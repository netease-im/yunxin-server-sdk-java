package com.netease.nim.server.sdk.im.v2;

import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.im.v2.account.AccountV2Service;
import com.netease.nim.server.sdk.im.v2.account.IAccountV2Service;
import com.netease.nim.server.sdk.im.v2.block.BlockV2Service;
import com.netease.nim.server.sdk.im.v2.block.IBlockV2Service;
import com.netease.nim.server.sdk.im.v2.broadcast.BroadcastV2Service;
import com.netease.nim.server.sdk.im.v2.broadcast.IBroadcastV2Service;
import com.netease.nim.server.sdk.im.v2.chatroom.ChatroomV2Service;
import com.netease.nim.server.sdk.im.v2.chatroom.IChatroomV2Service;
import com.netease.nim.server.sdk.im.v2.chatroom_member.ChatroomMemberV2Service;
import com.netease.nim.server.sdk.im.v2.chatroom_member.IChatroomMemberV2Service;
import com.netease.nim.server.sdk.im.v2.chatroom_message.ChatroomMessageV2Service;
import com.netease.nim.server.sdk.im.v2.chatroom_message.IChatroomMessageV2Service;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.ChatroomQueueV2Service;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.IChatroomQueueV2Service;
import com.netease.nim.server.sdk.im.v2.conversation.ConversationV2Service;
import com.netease.nim.server.sdk.im.v2.conversation.IConversationV2Service;
import com.netease.nim.server.sdk.im.v2.conversation_group.ConversationGroupV2Service;
import com.netease.nim.server.sdk.im.v2.conversation_group.IConversationGroupV2Service;
import com.netease.nim.server.sdk.im.v2.conversation_unread.ConversationUnreadV2Service;
import com.netease.nim.server.sdk.im.v2.conversation_unread.IConversationUnreadV2Service;
import com.netease.nim.server.sdk.im.v2.system_notification.CustomNotificationV2Service;
import com.netease.nim.server.sdk.im.v2.system_notification.ICustomNotificationV2Service;
import com.netease.nim.server.sdk.im.v2.friend.FriendV2Service;
import com.netease.nim.server.sdk.im.v2.friend.IFriendV2Service;
import com.netease.nim.server.sdk.im.v2.message.IMessageV2Service;
import com.netease.nim.server.sdk.im.v2.message.MessageV2Service;
import com.netease.nim.server.sdk.im.v2.mute.IMuteV2Service;
import com.netease.nim.server.sdk.im.v2.mute.MuteV2Service;
import com.netease.nim.server.sdk.im.v2.subscription.ISubscriptionV2Service;
import com.netease.nim.server.sdk.im.v2.subscription.SubscriptionV2Service;
import com.netease.nim.server.sdk.im.v2.team.ITeamV2Service;
import com.netease.nim.server.sdk.im.v2.team.TeamV2Service;
import com.netease.nim.server.sdk.im.v2.team_member.ITeamMemberV2Service;
import com.netease.nim.server.sdk.im.v2.team_member.TeamMemberV2Service;
import com.netease.nim.server.sdk.im.v2.translation.ITranslationV2Service;
import com.netease.nim.server.sdk.im.v2.translation.TranslationV2Service;
import com.netease.nim.server.sdk.im.v2.users.IUserV2Service;
import com.netease.nim.server.sdk.im.v2.users.UserV2Service;

/**
 * Created by caojiajun on 2024/12/11
 */
public class YunxinV2ApiServices {

    private final IAccountV2Service accountService;
    private final IUserV2Service userService;
    private final IFriendV2Service friendService;
    private final ITeamV2Service teamService;
    private final ITeamMemberV2Service teamMemberService;
    private final IChatroomV2Service chatroomService;
    private final IChatroomMemberV2Service chatroomMemberService;
    private final IChatroomMessageV2Service chatroomMessageService;
    private final IChatroomQueueV2Service chatroomQueueService;
    private final IMessageV2Service messageService;
    private final IConversationV2Service conversationService;
    private final IConversationGroupV2Service conversationGroupService;
    private final IConversationUnreadV2Service conversationUnreadService;
    private final IMuteV2Service muteService;
    private final IBlockV2Service blockService;
    private final IBroadcastV2Service broadcastService;
    private final ICustomNotificationV2Service customNotificationService;
    private final ISubscriptionV2Service subscriptionService;
    private final ITranslationV2Service translationService;

    public YunxinV2ApiServices(YunxinApiHttpClient yunxinApiHttpClient) {
        this.accountService = new AccountV2Service(yunxinApiHttpClient);
        this.userService = new UserV2Service(yunxinApiHttpClient);
        this.friendService = new FriendV2Service(yunxinApiHttpClient);
        this.teamService = new TeamV2Service(yunxinApiHttpClient);
        this.teamMemberService = new TeamMemberV2Service(yunxinApiHttpClient);
        this.chatroomService = new ChatroomV2Service(yunxinApiHttpClient);
        this.chatroomMemberService = new ChatroomMemberV2Service(yunxinApiHttpClient);
        this.chatroomMessageService = new ChatroomMessageV2Service(yunxinApiHttpClient);
        this.chatroomQueueService = new ChatroomQueueV2Service(yunxinApiHttpClient);
        this.messageService = new MessageV2Service(yunxinApiHttpClient);
        this.conversationService = new ConversationV2Service(yunxinApiHttpClient);
        this.conversationGroupService = new ConversationGroupV2Service(yunxinApiHttpClient);
        this.conversationUnreadService = new ConversationUnreadV2Service(yunxinApiHttpClient);
        this.muteService = new MuteV2Service(yunxinApiHttpClient);
        this.blockService = new BlockV2Service(yunxinApiHttpClient);
        this.broadcastService = new BroadcastV2Service(yunxinApiHttpClient);
        this.customNotificationService = new CustomNotificationV2Service(yunxinApiHttpClient);
        this.subscriptionService = new SubscriptionV2Service(yunxinApiHttpClient);
        this.translationService = new TranslationV2Service(yunxinApiHttpClient);
    }

    public IAccountV2Service getAccountService() {
        return accountService;
    }
    
    public IUserV2Service getUserService() {
        return userService;
    }
    
    public IFriendV2Service getFriendService() {
        return friendService;
    }
    
    public ITeamV2Service getTeamService() {
        return teamService;
    }
    
    public ITeamMemberV2Service getTeamMemberService() {
        return teamMemberService;
    }
    
    public IChatroomV2Service getChatroomService() {
        return chatroomService;
    }
    
    public IChatroomMemberV2Service getChatroomMemberService() {
        return chatroomMemberService;
    }
    
    public IChatroomMessageV2Service getChatroomMessageService() {
        return chatroomMessageService;
    }
    
    public IChatroomQueueV2Service getChatroomQueueService() {
        return chatroomQueueService;
    }
    
    public IMessageV2Service getMessageService() {
        return messageService;
    }
    
    public IConversationV2Service getConversationService() {
        return conversationService;
    }
    
    public IConversationGroupV2Service getConversationGroupService() {
        return conversationGroupService;
    }
    
    public IConversationUnreadV2Service getConversationUnreadService() {
        return conversationUnreadService;
    }
    
    public IMuteV2Service getMuteService() {
        return muteService;
    }
    
    public IBlockV2Service getBlockService() {
        return blockService;
    }
    
    public IBroadcastV2Service getBroadcastService() {
        return broadcastService;
    }
    
    public ICustomNotificationV2Service getCustomNotificationService() {
        return customNotificationService;
    }
    
    public ISubscriptionV2Service getSubscriptionService() {
        return subscriptionService;
    }
    
    public ITranslationV2Service getTranslationService() {
        return translationService;
    }
}
