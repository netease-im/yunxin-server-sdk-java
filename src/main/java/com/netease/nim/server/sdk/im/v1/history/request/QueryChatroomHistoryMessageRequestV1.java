package com.netease.nim.server.sdk.im.v1.history.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

public class QueryChatroomHistoryMessageRequestV1 {

    /**
     * 聊天室 ID
     */
    @YunxinParam("roomid")
    private Long roomid;

    /**
     * 用户账号
     */
    @YunxinParam("accid")
    private String accid;

    /**
     * 查询的时间戳锚点，13 位。reverse=1 时 timetag 为起始时间戳，reverse=2 时 timetag 为终止时间戳
     */
    @YunxinParam("timetag")
    private Long timetag;

    /**
     * 本次查询的消息条数上限(最多 200 条)
     */
    @YunxinParam("limit")
    private Integer limit;

    /**
     * 1 按时间正序排列，2 按时间降序排列
     */
    @YunxinParam("reverse")
    private Integer reverse;

    /**
     * 查询指定的多个消息类型，类型之间用","分割，不设置该参数则查询全部类型消息
     */
    @YunxinParam("type")
    private String type;

    public Long getRoomid() {
        return roomid;
    }

    public void setRoomid(Long roomid) {
        this.roomid = roomid;
    }

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
