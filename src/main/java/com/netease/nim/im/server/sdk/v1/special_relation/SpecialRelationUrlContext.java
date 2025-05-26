package com.netease.nim.im.server.sdk.v1.special_relation;

/**
 * URL路径常量类，用于所有特殊关系相关的API请求
 */
public class SpecialRelationUrlContext {
    // 加入黑名单
    static final String ADD_TO_BLACKLIST = "/user/setSpecialRelation.action";
    
    // 从黑名单移除
    static final String REMOVE_FROM_BLACKLIST = "/user/removeSpecialRelation.action";
    
    // 查询黑名单列表
    static final String QUERY_BLACKLIST = "/user/listBlackAndMuteList.action";
} 