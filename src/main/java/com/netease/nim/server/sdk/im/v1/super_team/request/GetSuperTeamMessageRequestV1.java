package com.netease.nim.server.sdk.im.v1.super_team.request;


import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

public class GetSuperTeamMessageRequestV1 {

    /**
     * 云信服务器产生，超大群唯一标识，创建时会返回，最大长度 64 位长整型
     */
    @YunxinParam("tid")
    private Long tid;

    /**
     * 需要查询的用户账号，accid，最大长度 32 位字符
     */
    @YunxinParam("accid")
    private String accid;

    /**
     * 开始时间，毫秒级别时间戳
     */
    @YunxinParam("begintime")
    private Long begintime;

    /**
     * 截止时间，毫秒级别时间戳
     */
    @YunxinParam("endtime")
    private Long endtime;

    /**
     * 本次查询的消息条数上限，(0,100]
     */
    @YunxinParam("limit")
    private Integer limit;

    /**
     * 查询方向：1，按时间正序排列；2，按时间降序排列（默认）
     */
    @YunxinParam("reverse")
    private Integer reverse;

    /**
     * 查询指定的消息类型，类型之间用","分割
     */
    @YunxinParam("type")
    private String type;

    /**
     * 结束查询的最后一条消息的 msgid（不包含在查询结果中）
     */
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