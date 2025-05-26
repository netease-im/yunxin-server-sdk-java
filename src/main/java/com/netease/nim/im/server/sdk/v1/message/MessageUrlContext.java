package com.netease.nim.im.server.sdk.v1.message;

/**
 * URL路径常量类，用于所有消息相关的API请求
 */
public class MessageUrlContext {
    // 发送普通消息
    static final String SEND_MSG = "/msg/sendMsg.action";
    
    // 批量发送点对点普通消息
    static final String SEND_BATCH_MSG = "/msg/sendBatchMsg.action";
    
    // 标记消息已读
    static final String MARK_READ_MSG = "/msg/markReadMsg.action";
    
    // 标记群消息已读
    static final String MARK_READ_TEAM_MSG = "/msg/markReadTeamMsg.action";
    
    // 消息撤回
    static final String RECALL_MSG = "/msg/recall.action";
    
    // 单向删除消息
    static final String DEL_MSG_ONE_WAY = "/msg/delMsgOneWay.action";
    
    // 发送广播消息
    static final String BROADCAST_MSG = "/msg/broadcastMsg.action";
    
    // 删除广播消息
    static final String DEL_BROADCAST_MSG_BY_ID = "/history/delBroadcastMsgById.action";
    
    // 消息附件上传
    static final String UPLOAD = "/msg/upload.action";
    
    // 删除文件
    static final String DELETE_FILE = "/job/nos/del.action";
    
    // 删除消息
    static final String DEL_MSG = "/msg/delMsg.action";
    
    // 删除漫游会话
    static final String DEL_ROAM_SESSION = "/msg/delRoamSession.action";
} 