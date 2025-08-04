package com.netease.nim.server.sdk.im.v1.super_team.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

import java.util.List;

public class SendSuperTeamMessageRequestV1 {

    @YunxinParam("tid")
    private Long tid;

    @YunxinParam("fromAccid")
    private String fromAccid;

    @YunxinParam("type")
    private Integer type;

    @YunxinParam("body")
    private String body;

    @YunxinParam("msgDesc")
    private String msgDesc;

    @YunxinParam("antispam")
    private Boolean antispam;

    @YunxinParam("antispamCustom")
    private String antispamCustom;

    @YunxinParam("useYidun")
    private Integer useYidun;

    @YunxinParam("yidunAntiCheating")
    private String yidunAntiCheating;

    @YunxinParam("yidunAntiSpamExt")
    private String yidunAntiSpamExt;

    @YunxinParam("bid")
    private String bid;

    @YunxinParam("option")
    private String option;

    @YunxinParam("ext")
    private String ext;

    @YunxinParam("pushContent")
    private String pushContent;

    @YunxinParam("pushPayload")
    private String pushPayload;

    @YunxinParam("isForcePush")
    private Boolean isForcePush;

    @YunxinParam("forcePushContent")
    private String forcePushContent;

    @YunxinParam("forcePushAll")
    private Boolean forcePushAll;

    private List<String> forcePushList;

    @YunxinParam("subType")
    private Integer subType;

    @YunxinParam("env")
    private String env;

    @YunxinParam("isCheckMute")
    private Boolean isCheckMute;

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getFromAccid() {
        return fromAccid;
    }

    public void setFromAccid(String fromAccid) {
        this.fromAccid = fromAccid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getMsgDesc() {
        return msgDesc;
    }

    public void setMsgDesc(String msgDesc) {
        this.msgDesc = msgDesc;
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

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getPushContent() {
        return pushContent;
    }

    public void setPushContent(String pushContent) {
        this.pushContent = pushContent;
    }

    public String getPushPayload() {
        return pushPayload;
    }

    public void setPushPayload(String pushPayload) {
        this.pushPayload = pushPayload;
    }

    public Boolean getForcePush() {
        return isForcePush;
    }

    public void setForcePush(Boolean forcePush) {
        isForcePush = forcePush;
    }

    public String getForcePushContent() {
        return forcePushContent;
    }

    public void setForcePushContent(String forcePushContent) {
        this.forcePushContent = forcePushContent;
    }

    public Boolean getForcePushAll() {
        return forcePushAll;
    }

    public void setForcePushAll(Boolean forcePushAll) {
        this.forcePushAll = forcePushAll;
    }

    public List<String> getForcePushList() {
        return forcePushList;
    }

    public void setForcePushList(List<String> forcePushList) {
        this.forcePushList = forcePushList;
    }

    public Integer getSubType() {
        return subType;
    }

    public void setSubType(Integer subType) {
        this.subType = subType;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public Boolean getCheckMute() {
        return isCheckMute;
    }

    public void setCheckMute(Boolean checkMute) {
        isCheckMute = checkMute;
    }
}