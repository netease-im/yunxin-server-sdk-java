package com.netease.nim.server.sdk.im.v1.history.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

/**
 * 查询单聊云端历史消息请求参数
 * 
 * 功能描述：
 * - 查询存储在网易云信服务器中的单人聊天历史消息，只能查询在保存时间范围内的消息
 * - 根据时间段查询点对点消息，每次最多返回 100 条
 * - 不提供分页支持，第三方需要根据时间段来查询
 * - begintime 需要早于 endtime，否则会返回 {"desc": "bad time", "code": 414}
 * - 实际查询结果包含双向的消息，不仅包含 from 发送给 to 的消息，也包含 to 发给 from 的消息
 */
public class QuerySessionHistoryMessageRequestV1 {

    /**
     * 发送者账号 ID（`accid`）
     * 实际查询结果包含双向的消息，不仅包含 from 发送给 to 的消息，也包含 to 发给 from 的消息
     */
    @YunxinParam("from")
    private String from;

    /**
     * 接收者账号 ID（`accid`）
     * 实际查询结果包含双向的消息，不仅包含 from 发送给 to 的消息，也包含 to 发给 from 的消息
     */
    @YunxinParam("to")
    private String to;

    /**
     * 开始时间，毫秒级
     * 必须早于 endtime，否则会返回错误
     */
    @YunxinParam("begintime")
    private Long begintime;

    /**
     * 截止时间，毫秒级
     * 必须晚于 begintime，否则会返回错误
     */
    @YunxinParam("endtime")
    private Long endtime;

    /**
     * 本次查询的消息条数上限(最多 100 条)
     * 小于等于 0，或者大于 100，会提示参数错误
     */
    @YunxinParam("limit")
    private Integer limit;

    /**
     * 排序方式
     * 1 按时间正序排列，2 按时间降序排列
     * 其它返回参数 414 错误，默认是按降序排列，即时间戳最晚的消息排在最前面
     */
    @YunxinParam("reverse")
    private Integer reverse;

    /**
     * 查询指定的多个消息类型，类型之间用","分割，不设置该参数则查询全部类型消息
     * 格式示例：0,1,2,3
     * 类型支持：0:文本，1:图片，2:语音，3:视频，4:地理位置，5:通知，6:文件，10:提示，11:Robot，100:自定义
     */
    @YunxinParam("type")
    private String type;

    /**
     * 查询结果中是否需要包含无感知消息
     * true：包含，false：不包含，默认为 false
     * 
     * 无感知消息具体包括：
     * - 发送消息时，被设置为发送方无感知的消息（即 msgSenderNoSense=1）
     * - 发送消息时，被设置为接收方无感知的消息（即 msgReceiverNoSense=1）
     * - 被单向撤回的消息
     * - 被单向删除的消息
     * 
     * 以下消息不属于无感知消息：
     * - 被双向撤回的消息
     * - 被双向删除的消息
     */
    @YunxinParam("includeNoSenseMsg")
    private Boolean includeNoSenseMsg;

    /**
     * 结束查询的最后一条消息的 msgid（不包含在查询结果中），用于定位锚点
     * 为了保证极端场景下（两条消息的时间戳一致）不丢失消息，建议每次查询时填写该字段，定位最后一次查询到的消息
     */
    @YunxinParam("excludeMsgid")
    private String excludeMsgid;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
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

    public Boolean getIncludeNoSenseMsg() {
        return includeNoSenseMsg;
    }

    public void setIncludeNoSenseMsg(Boolean includeNoSenseMsg) {
        this.includeNoSenseMsg = includeNoSenseMsg;
    }

    public String getExcludeMsgid() {
        return excludeMsgid;
    }

    public void setExcludeMsgid(String excludeMsgid) {
        this.excludeMsgid = excludeMsgid;
    }

}
