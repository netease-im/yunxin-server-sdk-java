package com.netease.nim.server.sdk.im.v1.special_relation.response;

import java.util.List;

public class ListSpecialRelationResponseV1 {
    private List<String> mutelist; // 被设置免打扰的账号列表

    private List<String> blacklist;

    public List<String> getMutelist() {
        return mutelist;
    }

    public void setMutelist(List<String> mutelist) {
        this.mutelist = mutelist;
    }

    public List<String> getBlacklist() {
        return blacklist;
    }

    public void setBlacklist(List<String> blacklist) {
        this.blacklist = blacklist;
    }
}
