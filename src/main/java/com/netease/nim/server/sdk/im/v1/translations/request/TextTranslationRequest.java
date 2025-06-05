package com.netease.nim.server.sdk.im.v1.translations.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

public class TextTranslationRequest {
    /**
     * 云信帐号
     */
    @YunxinParam("accid")
    private String accid;

    /**
     * 需要翻译的文本
     */
    @YunxinParam("text")
    private String text;

    /**
     * 目标语言
     */
    @YunxinParam("to")
    private String to;

    /**
     * 源语言，不传会自动识别源语言
     */
    @YunxinParam("from")
    private String from;

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
