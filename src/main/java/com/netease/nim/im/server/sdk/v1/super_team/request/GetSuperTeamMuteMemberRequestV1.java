package com.netease.nim.im.server.sdk.v1.super_team.request;

import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

public class GetSuperTeamMuteMemberRequestV1 {

    /**
     * 云信服务器产生，超大群唯一标识，创建时会返回，最大长度 64 位长整型
     */
    @YunxinParam("tid")
    private Long tid;

    /**
     * 毫秒级别时间戳，查询的时间起点
     */
    @YunxinParam("timetag")
    private Long timetag;

    /**
     * 本次查询的条数上限，(0,2000]
     */
    @YunxinParam("limit")
    private Integer limit;

    /**
     * 查询方向：1，按时间正序排列（默认）；2，按时间降序排列
     */
    @YunxinParam("reverse")
    private Integer reverse;

    // Getters and Setters
    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Long getTimetag() {
        return timetag;
    }

    public void setTimetag(Long timetag) {
        this.timetag = timetag;
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