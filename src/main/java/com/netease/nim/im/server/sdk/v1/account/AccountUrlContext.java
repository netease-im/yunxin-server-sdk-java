package com.netease.nim.im.server.sdk.v1.account;

/**
 * URL路径常量类，用于所有账户相关的API请求
 */
public class AccountUrlContext {
    // 创建账户
    static final String CREATE_ACCOUNT = "/user/create.action";
    
    // 更新Token
    static final String UPDATE_TOKEN = "/user/update.action";
    
    // 刷新Token
    static final String REFRESH_TOKEN = "/user/refreshToken.action";
    
    // 封禁账户
    static final String BLOCK_ACCOUNT = "/user/block.action";
    
    // 解除账户封禁
    static final String UNBLOCK_ACCOUNT = "/user/unblock.action";
    
    // 账户禁言
    static final String MUTE_ACCOUNT = "/user/mute.action";
    
    // 模块禁言
    static final String MUTE_MODULE = "/user/muteModule.action";
    
    // 设置免打扰
    static final String SET_DONNOP = "/user/setDonnop.action";
    
    // 查询账户在线状态
    static final String QUERY_ONLINE_STATUS = "/user/userOnlineStatus.action";
    
    // 获取用户信息
    static final String QUERY_USER_INFOS = "/user/getUinfos.action";
    
    // 更新用户信息
    static final String UPDATE_UINFO = "/user/updateUinfo.action";
}