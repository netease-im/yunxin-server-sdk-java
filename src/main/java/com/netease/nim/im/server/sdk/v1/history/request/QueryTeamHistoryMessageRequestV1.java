package com.netease.nim.im.server.sdk.v1.history.request;

import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

public class QueryTeamHistoryMessageRequestV1 {

    /**
     * 群 ID
     */
    @YunxinParam("tid")
    private Long tid;

    /**
     * 查询用户对应的账号 ID（`accid`）
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
     * 本次查询的消息条数上限(最多 100 条)
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

    /**
     * true(默认值)：表示需要检查群是否有效,accid 是否为有效的群成员。设置为 false 则仅检测群是否存在，accid 是否曾经为群成员
     */
    @YunxinParam("checkTeamValid")
    private Boolean checkTeamValid;

    /**
     * 查询结果中是否需要包含无感知消息，true：包含，false：不包含，默认为 false
     */
    @YunxinParam("includeNoSenseMsg")
    private String includeNoSenseMsg;

    /**
     * 结束查询的最后一条消息的 msgid（不包含在查询结果中），用于定位锚点
     */
    @YunxinParam("excludeMsgid")
    private String excludeMsgid;

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

    public Boolean getCheckTeamValid() {
        return checkTeamValid;
    }

    public void setCheckTeamValid(Boolean checkTeamValid) {
        this.checkTeamValid = checkTeamValid;
    }

    public String getIncludeNoSenseMsg() {
        return includeNoSenseMsg;
    }

    public void setIncludeNoSenseMsg(String includeNoSenseMsg) {
        this.includeNoSenseMsg = includeNoSenseMsg;
    }

    public String getExcludeMsgid() {
        return excludeMsgid;
    }

    public void setExcludeMsgid(String excludeMsgid) {
        this.excludeMsgid = excludeMsgid;
    }

}
