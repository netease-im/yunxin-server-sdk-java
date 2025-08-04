package com.netease.nim.server.sdk.im.v2.ai.response;

import com.alibaba.fastjson2.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * AI Chat Assistant response
 */
public class ChatAssistResponseV2 implements Serializable {

    @JSONField(name = "items")
    private List<AssistItem> items;

    public static class AssistItem implements Serializable {
        @JSONField(name = "style")
        private String style;

        @JSONField(name = "style_name")
        private String styleName;

        @JSONField(name = "answer")
        private String answer;

        public String getStyle() {
            return style;
        }

        public void setStyle(String style) {
            this.style = style;
        }

        public String getStyleName() {
            return styleName;
        }

        public void setStyleName(String styleName) {
            this.styleName = styleName;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }
    }

    public List<AssistItem> getItems() {
        return items;
    }

    public void setItems(List<AssistItem> items) {
        this.items = items;
    }
}
