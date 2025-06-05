package com.netease.nim.server.sdk.im.v1.history.response;

import java.util.List;

public class QuerySessionListResponseV1 {

    /**
     * 返回是否完整了
     */
    private Boolean hasMore;

    /**
     * 会话列表
     */
    private List<Session> sessions;

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

}
