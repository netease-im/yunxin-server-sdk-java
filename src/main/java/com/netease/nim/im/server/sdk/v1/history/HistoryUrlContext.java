package com.netease.nim.im.server.sdk.v1.history;

/**
 * URL路径常量类，用于所有历史记录相关的API请求
 */
public class HistoryUrlContext {
    // 查询单聊云端历史记录
    static final String QUERY_SESSION_MSG = "/history/querySessionMsg.action";
    
    // 批量查询云端历史记录
    static final String QUERY_SESSION_MSGS = "/history/querySessionMsgs.action";
    
    // 删除云端历史记录
    static final String DELETE_HISTORY_MSG = "/history/deleteHistoryMsg.action";
    
    // 查询群聊云端历史记录
    static final String QUERY_TEAM_MSG = "/history/queryTeamMsg.action";
    
    // 批量查询聊天室云端历史记录
    static final String QUERY_CHATROOM_MSGS = "/history/querySessionMsgs.action";
    
    // 查询聊天室云端历史记录
    static final String QUERY_CHATROOM_MSG = "/history/queryChatroomMsg.action";

    // 删除聊天室云端历史记录
    static final String DELETE_CHATROOM_HISTORY_MESSAGE = "/chatroom/deleteHistoryMessage.action";

    // 查询会话列表
    static final String QUERY_SESSION_LIST = "/history/querySessionList.action";

    // 根据ID查询广播消息
    static final String QUERY_BROADCAST_MSG_BY_ID = "/history/queryBroadcastMsgById.action";

    // 查询广播消息
    static final String QUERY_BROADCAST_MSG = "/history/queryBroadcastMsg.action";

    // 查询用户事件
    static final String QUERY_USER_EVENTS = "/history/queryUserEvents.action";
} 