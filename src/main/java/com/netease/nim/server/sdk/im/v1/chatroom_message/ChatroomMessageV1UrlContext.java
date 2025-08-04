package com.netease.nim.server.sdk.im.v1.chatroom_message;

public class ChatroomMessageV1UrlContext {
    //发送聊天室消息
    static String SEND_MSG = "/chatroom/sendMsg.action";

    //批量发送聊天室消息
    static String BATCH_SEND_MSG = "/chatroom/batchSendMsg.action";

    //撤回聊天室消息
    static String RECALL = "/chatroom/recall.action";

    //发送聊天室定向消息
    static String SEND_MSG_TO_SOMEONE = "/chatroom/sendMsgToSomeone.action";

    //批量发送聊天室定向消息
    static String BATCH_SEND_MSG_TO_SOMEONE = "/chatroom/batchSendMsgToSomeone.action";

    //发送聊天室全服广播消息
    static String BROADCAST = "/chatroom/broadcast.action";
}

