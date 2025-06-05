package com.netease.nim.server.sdk.im.v1.team;

/**
 * URL路径常量类，用于所有群组相关的API请求
 */
public class TeamV1UrlContext {
    // 创建群
    static final String CREATE_TEAM = "/team/create.action";
    
    // 解散群
    static final String REMOVE_TEAM = "/team/remove.action";
    
    // 获取群详细信息
    static final String QUERY_TEAM_INFO = "/team/queryDetail.action";
    
    // 批量获取群详细信息
    static final String QUERY_TEAMS_INFO = "/team/query.action";
    
    // 修改群信息
    static final String UPDATE_TEAM_INFO = "/team/update.action";
    
    // 拉人入群
    static final String ADD_TEAM_MEMBERS = "/team/add.action";
    
    // 踢人出群
    static final String KICK_TEAM_MEMBERS = "/team/kick.action";
    
    // 解除禁言
    static final String UNMUTE_TEAM_MEMBER = "/team/muteTlistAll.action";
    
    // 禁言群成员
    static final String MUTE_TEAM_MEMBER = "/team/muteTlist.action";
    
    // 批量更改成员身份
    static final String UPDATE_TEAM_MEMBERS_IDENTITY = "/team/updateIdentity.action";
    
    // 主动退群
    static final String LEAVE_TEAM = "/team/leave.action";
    
    // 修改成员角色
    static final String UPDATE_TEAM_MEMBER_INFO = "/team/updateTeamNick.action";
    
    // 获取群组已读消息的已读详情信息
    static final String QUERY_TEAM_MSG_READ_INFO = "/team/queryMsgReadInfo.action";
    
    // 修改消息提醒开关
    static final String UPDATE_MSG_NOTIFICATION = "/team/muteTeam.action";
    
    // 获取企业群可查询数量上限
    static final String QUERY_TEAM_MEMBER_COUNT = "/team/queryMemberCount.action";
    
    // 获取群组全部成员
    static final String QUERY_TEAM_MEMBERS = "/team/queryMemberList.action";
    
    // 移交群主
    static final String CHANGE_TEAM_OWNER = "/team/changeOwner.action";
    
    // 任命管理员
    static final String ADD_TEAM_MANAGER = "/team/addManager.action";
    
    // 移除管理员
    static final String REMOVE_TEAM_MANAGER = "/team/removeManager.action";
    
    // 获取群组禁言列表
    static final String QUERY_TEAM_MUTE_LIST = "/team/listTeamMute.action";

    // 查询群组成员列表
    static final String QUERY_TEAM_MEMBERS_LIST = "/team/listMemberInfo.action";

    // 查询群组在线成员列表
    static final String QUERY_TEAM_ONLINE_MEMBERS_LIST = "/team/listOnlineUsers.action";
    
    // 查询某用户所加入的群信息
    static final String JOIN_TEAMS = "/team/joinTeams.action";
    
    // 获取群组已读消息的已读详情信息
    static final String GET_MARK_READ_INFO = "/team/getMarkReadInfo.action";
    
    // 查询群组成员信息
    static final String LIST_MEMBER_INFO = "/team/listMemberInfo.action";
    
    // 获取群组在线成员列表
    static final String LIST_ONLINE_USERS = "/team/listOnlineUsers.action";
    
    // 批量获取群组在线人数
    static final String LIST_ONLINE_USER_COUNT = "/team/listOnlineUserCount.action";
} 