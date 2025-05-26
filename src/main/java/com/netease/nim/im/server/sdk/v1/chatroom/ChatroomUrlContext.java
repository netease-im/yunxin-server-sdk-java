package com.netease.nim.im.server.sdk.v1.chatroom;

public class ChatroomUrlContext {
    // 创建聊天室
    static final String CREATE = "/chatroom/create.action";
    
    // 更新聊天室信息
    static final String UPDATE = "/chatroom/update.action";
    
    // 查询聊天室地址
    static final String REQUEST_ADDR = "/chatroom/requestAddr.action";
    
    // 获取聊天室信息
    static final String GET = "/chatroom/get.action";
    
    // 批量获取聊天室信息
    static final String GET_BATCH = "/chatroom/getBatch.action";
    
    // 切换聊天室关闭状态
    static final String TOGGLE_CLOSE_STAT = "/chatroom/toggleCloseStat.action";
    
    // 更新聊天室延迟关闭策略
    static final String UPDATE_DELAY_CLOSE_POLICY = "/chatroom/updateDelayClosePolicy.action";
    
    // 更新聊天室进出通知
    static final String UPDATE_IN_OUT_NOTIFICATION = "/chatroom/updateInOutNotification.action";
    
    // 踢出聊天室成员
    static final String KICK_MEMBER = "/chatroom/kickMember.action";
    
    // 设置聊天室成员角色
    static final String SET_MEMBER_ROLE = "/chatroom/setMemberRole.action";
    
    // 更新我的聊天室角色
    static final String UPDATE_MY_ROOM_ROLE = "/chatroom/updateMyRoomRole.action";
    
    // 分页获取聊天室成员
    static final String MEMBERS_BY_PAGE = "/chatroom/membersByPage.action";
    
    // 按角色获取聊天室成员
    static final String QUERY_MEMBERS_BY_ROLE = "/chatroom/queryMembersByRole.action";
    
    // 查询聊天室成员
    static final String QUERY_MEMBERS = "/chatroom/queryMembers.action";
    
    // 添加机器人
    static final String ADD_ROBOT = "/chatroom/addRobot.action";
    
    // 移除机器人
    static final String REMOVE_ROBOT = "/chatroom/removeRobot.action";
    
    // 清空机器人
    static final String CLEAN_ROBOT = "/chatroom/cleanRobot.action";
    
    // 设置临时禁言状态
    static final String TEMPORARY_MUTE = "/chatroom/temporaryMute.action";
    
    // 将聊天室整体禁言
    static final String MUTE_ROOM = "/chatroom/muteRoom.action";
    
    // 标签临时禁言
    static final String TAG_MUTE = "/chatroom/tagTemporaryMute.action";
    
    // 标签成员计数
    static final String TAG_COUNT = "/chatroom/tagMembersCount.action";
    
    // 标签成员查询
    static final String TAG_QUERY = "/chatroom/tagMembersQuery.action";
    
    // 查询标签历史消息
    static final String QUERY_TAG_MSG = "/history/queryTagHistoryMsg.action";
    
    // 更新聊天室角色标签
    static final String UPDATE_CHAT_ROOM_ROLE_TAG = "/chatroom/updateChatRoomRoleTag.action";

    //查询开放状态的聊天室
    static final String QUERY_USER_ROOM_IDS = "/chatroom/queryUserRoomIds.action";
    
    //初始化队列
    static final String QUEUE_INIT = "/chatroom/queueInit.action";
    
    //删除清理队列
    static final String QUEUE_DROP = "/chatroom/queueDrop.action";
    
    //新加元素到队列
    static final String QUEUE_OFFER = "/chatroom/queueOffer.action";
    
    //批量添加队列元素
    static final String QUEUE_BATCH_OFFER = "/chatroom/queueBatchOffer.action";
    
    //批量更新队列元素
    static final String QUEUE_BATCH_UPDATE = "/chatroom/queueBatchUpdateElements.action";
    
    //排序列出队列中所有元素
    static final String QUEUE_LIST = "/chatroom/queueList.action";
    
    //从队列中取出元素
    static final String QUEUE_POLL = "/chatroom/queuePoll.action";
    
    //获取指定的队列元素
    static final String QUEUE_GET = "/chatroom/queueMultiGet.action";
}
