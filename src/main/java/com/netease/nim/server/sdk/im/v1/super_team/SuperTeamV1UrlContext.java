package com.netease.nim.server.sdk.im.v1.super_team;

public class SuperTeamV1UrlContext {
    //创建超大群
    static String CREATE_TEAM = "/superteam/create.action";

    //拉人入群
    static String INVITE = "/superteam/invite.action";

    //添加管理员
    static String ADD_MANAGER = "/superteam/addManager.action";

    //移除管理员
    static String REMOVE_MANAGER = "/superteam/removeManager.action";

    //转让群主
    static String CHANGE_OWNER = "/superteam/changeOwner.action";

    //禁言超大群
    static String MUTE = "/superteam/mute.action";

    //禁言超大群
    static String MUTE_TEAM_MEMBER = "/superteam/muteTlist.action";

    //踢人出群
    static String KICK = "/superteam/kick.action";

    //主动退群
    static String LEAVE = "/superteam/leave.action";

    //修改超大群成员昵称
    static String UPDATE_TEAM_NICK = "/superteam/updateTeamNick.action";

    //修改超大群成员信息
    static String UPDATE_T_LIST = "/superteam/updateTlist.action";

    //修改超大群信息
    static String UPDATE_TEAM_INFO = "/superteam/updateTinfo.action";

    //转让群主
    static String DISMISS = "/superteam/dismiss.action";

    //修改超大群人数级别
    static String CHANGE_LEVEL = "/superteam/changeLevel.action";

    //获取超大群信息
    static String GET_TEAM_INFO = "/superteam/getTinfos.action";

    //获取超大群信息
    static String GET_TEAM_MEMBER_LIST = "/superteam/getTlists.action";

    //获取超大群禁言成员信息
    static String GET_MUTE_MEMBER_LIST = "/superteam/getMuteTlists.action";

    //获取已加入的超大群信息
    static String JOIN_TEAMS = "/superteam/joinTeams.action";

    // 查询超大群历史消息
    static String QUERY_HISTORY_MSG = "/superteam/queryHistoryMsg.action";

    // 根据消息 ID 查询超大群历史消息
    static String QUERY_HISTORY_MSG_BY_IDS = "/superteam/queryHistoryMsgByIds.action";

    //发送超大群消息
    static String SEND_MSG = "/superteam/sendMsg.action";

    //发送超大群自定义系统通知
    static String SEND_ATTACH_MSG = "/superteam/sendAttachMsg.action";

    //撤回超大群消息
    static String RECALL_MSG = "/superteam/recallMsg.action";
}

