package com.netease.nim.im.server.sdk.v1.history.request;

import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

public class QueryUserEventsRequestV1 {

    /**
     * 要查询用户的accid
     */
    @YunxinParam("accid")
    private String accid;

    /**
     * 开始时间，毫秒级
     */
    @YunxinParam("begintime")
    private Long begintime;

    /**
     * 截止时间，毫秒级
     */
    @YunxinParam("endtime")
    private Long endtime;

    /**
     * 本次查询的记录数量上限(最多100条)
     */
    @YunxinParam("limit")
    private Integer limit;

    /**
     * 1按时间正序排列，2按时间降序排列
     */
    @YunxinParam("reverse")
    private Integer reverse;

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

    public Long getBegintime() {
        return begintime;
    }

    public void setBegintime(Long begintime) {
        this.begintime = begintime;
    }

    public Long getEndtime() {
        return endtime;
    }

    public void setEndtime(Long endtime) {
        this.endtime = endtime;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getReverse() {
        return reverse;
    }

    public void setReverse(Integer reverse) {
        this.reverse = reverse;
    }

}
