package com.netease.nim.server.sdk.im.v1.super_team.request;


import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

public class GetSuperTeamMessageRequestV1 {

    @YunxinParam("tid")
    private Long tid;

    @YunxinParam("accid")
    private String accid;

    @YunxinParam("begintime")
    private Long begintime;

    @YunxinParam("endtime")
    private Long endtime;

    @YunxinParam("limit")
    private Integer limit;

    @YunxinParam("reverse")
    private Integer reverse;

    @YunxinParam("type")
    private String type;

    @YunxinParam("excludeMsgid")
    private String excludeMsgid;

    // Getters and Setters
    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExcludeMsgid() {
        return excludeMsgid;
    }

    public void setExcludeMsgid(String excludeMsgid) {
        this.excludeMsgid = excludeMsgid;
    }
}