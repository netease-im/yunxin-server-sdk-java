package com.netease.nim.im.server.sdk.v1.chatroom_message.request;

import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

import java.util.List;

public class BatchChatroomTargetMsgRequestV1 {

    /**
     * 聊天室 ID
     */
    @YunxinParam("roomid")
    private Long roomId;

    /**
     * 需要发送的消息列表，JSONArray，最多可发送 10 条消息
     */
    @YunxinParam("msgList")
    private String msgList;

    /**
     * 发送消息的用户账号，accid
     */
    @YunxinParam("fromAccid")
    private String fromAccid;

    /**
     * 消息接收者 accid 列表，JSONArray，最多 100 个账号
     */
    @YunxinParam("toAccids")
    private List<String> toAccids;

    /**
     * 消息是否需要抄送
     */
    @YunxinParam("route")
    private Integer route;

    /**
     * 单条消息是否使用安全通（即易盾反垃圾）
     */
    @YunxinParam("useYidun")
    private Integer useYidun;

    /**
     * 透传给易盾的反作弊检测参数
     */
    @YunxinParam("yidunAntiCheating")
    private String yidunAntiCheating;

    /**
     * 透传给易盾的反垃圾检测参数
     */
    @YunxinParam("yidunAntiSpamExt")
    private String yidunAntiSpamExt;

    /**
     * 安全通的自定义反垃圾（即内容审核）业务的 ID
     */
    @YunxinParam("bid")
    private String bid;

    /**
     * 本消息是否需要指定经由易盾检测的内容
     */
    @YunxinParam("antispam")
    private Boolean antispam;

    /**
     * 自定义的反垃圾检测内容
     */
    @YunxinParam("antispamCustom")
    private String antispamCustom;

    /**
     * 消息需要抄送到的环境的名称
     */
    @YunxinParam("env")
    private String env;

    // Getters and Setters

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getMsgList() {
        return msgList;
    }

    public void setMsgList(String msgList) {
        this.msgList = msgList;
    }

    public String getFromAccid() {
        return fromAccid;
    }

    public void setFromAccid(String fromAccid) {
        this.fromAccid = fromAccid;
    }

    public List<String> getToAccids() {
        return toAccids;
    }

    public void setToAccids(List<String> toAccids) {
        this.toAccids = toAccids;
    }

    public Integer getRoute() {
        return route;
    }

    public void setRoute(Integer route) {
        this.route = route;
    }

    public Integer getUseYidun() {
        return useYidun;
    }

    public void setUseYidun(Integer useYidun) {
        this.useYidun = useYidun;
    }

    public String getYidunAntiCheating() {
        return yidunAntiCheating;
    }

    public void setYidunAntiCheating(String yidunAntiCheating) {
        this.yidunAntiCheating = yidunAntiCheating;
    }

    public String getYidunAntiSpamExt() {
        return yidunAntiSpamExt;
    }

    public void setYidunAntiSpamExt(String yidunAntiSpamExt) {
        this.yidunAntiSpamExt = yidunAntiSpamExt;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public Boolean getAntispam() {
        return antispam;
    }

    public void setAntispam(Boolean antispam) {
        this.antispam = antispam;
    }

    public String getAntispamCustom() {
        return antispamCustom;
    }

    public void setAntispamCustom(String antispamCustom) {
        this.antispamCustom = antispamCustom;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public static class Message {
        /**
         * 消息 ID，String，必填
         */
        @YunxinParam("msgId")
        private String msgId;

        /**
         * 消息类型，Integer，必填
         */
        @YunxinParam("msgType")
        private Integer msgType;

        /**
         * 消息内容，String，最大长度 4096 位字符
         */
        @YunxinParam("attach")
        private String attach;

        /**
         * 扩展字段，String，最大长度 4096 位字符
         */
        @YunxinParam("ext")
        private String ext;

        /**
         * 自定义消息子类型，Integer，大于 0
         */
        @YunxinParam("subType")
        private Integer subType;

        /**
         * 重发消息标记，Integer
         */
        @YunxinParam("resendFlag")
        private Integer resendFlag;

        // Getters and Setters

        public String getMsgId() {
            return msgId;
        }

        public void setMsgId(String msgId) {
            this.msgId = msgId;
        }

        public Integer getMsgType() {
            return msgType;
        }

        public void setMsgType(Integer msgType) {
            this.msgType = msgType;
        }

        public String getAttach() {
            return attach;
        }

        public void setAttach(String attach) {
            this.attach = attach;
        }

        public String getExt() {
            return ext;
        }

        public void setExt(String ext) {
            this.ext = ext;
        }

        public Integer getSubType() {
            return subType;
        }

        public void setSubType(Integer subType) {
            this.subType = subType;
        }

        public Integer getResendFlag() {
            return resendFlag;
        }

        public void setResendFlag(Integer resendFlag) {
            this.resendFlag = resendFlag;
        }

    }

}
