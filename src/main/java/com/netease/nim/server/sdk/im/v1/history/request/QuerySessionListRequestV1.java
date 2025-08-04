package com.netease.nim.server.sdk.im.v1.history.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

public class QuerySessionListRequestV1 {

    /**
     * 账号
     */
    @YunxinParam("accid")
    private String accid;

    /**
     * 查询的最小时间戳，单位毫秒，默认 0
     */
    @YunxinParam("minTimestamp")
    private Long minTimestamp;

    /**
     * 查询的最大时间戳，单位毫秒，默认当前时间戳
     */
    @YunxinParam("maxTimestamp")
    private Long maxTimestamp;

    /**
     * 最大 100，默认 100
     */
    @YunxinParam("limit")
    private Integer limit;

    /**
     * 是否需要同步返回最后一条消息，0 表示不需要，1 表示需要，默认不需要
     */
    @YunxinParam("needLastMsg")
    private Integer needLastMsg;

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

    public Long getMinTimestamp() {
        return minTimestamp;
    }

    public void setMinTimestamp(Long minTimestamp) {
        this.minTimestamp = minTimestamp;
    }

    public Long getMaxTimestamp() {
        return maxTimestamp;
    }

    public void setMaxTimestamp(Long maxTimestamp) {
        this.maxTimestamp = maxTimestamp;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getNeedLastMsg() {
        return needLastMsg;
    }

    public void setNeedLastMsg(Integer needLastMsg) {
        this.needLastMsg = needLastMsg;
    }

}
