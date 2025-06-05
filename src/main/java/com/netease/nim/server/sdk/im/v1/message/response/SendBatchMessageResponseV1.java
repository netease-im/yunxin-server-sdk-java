package com.netease.nim.server.sdk.im.v1.message.response;

import java.util.List;
import java.util.Map;

public class SendBatchMessageResponseV1 {

    /**
     * toAccids 列表中存在的未注册用户
     */
    private List<String> unregister;

    /**
     * 消息发送的时间戳
     */
    private Long timetag;

    /**
     * 发送给每个 accid 的消息 ID 映射，key为accid，value为消息ID
     */
    private Map<String, Long> msgids;

    public List<String> getUnregister() {
        return unregister;
    }

    public void setUnregister(List<String> unregister) {
        this.unregister = unregister;
    }

    public Long getTimetag() {
        return timetag;
    }

    public void setTimetag(Long timetag) {
        this.timetag = timetag;
    }

    public Map<String, Long> getMsgids() {
        return msgids;
    }

    public void setMsgids(Map<String, Long> msgids) {
        this.msgids = msgids;
    }

}
