package com.netease.nim.server.sdk.rtc.room.response;

/**
 * Created by caojiajun on 2025/6/12
 */
public class RtcGetRoomResponse {

    private Long cid;
    private String cname;
    private Long uid;
    private Integer total;
    private Integer stats;
    private Long createtime;
    private Long destroytime;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getStats() {
        return stats;
    }

    public void setStats(Integer stats) {
        this.stats = stats;
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }

    public Long getDestroytime() {
        return destroytime;
    }

    public void setDestroytime(Long destroytime) {
        this.destroytime = destroytime;
    }
}
