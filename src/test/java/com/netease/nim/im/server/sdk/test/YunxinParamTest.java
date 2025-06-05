package com.netease.nim.im.server.sdk.test;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;
import com.netease.nim.server.sdk.im.v1.annotation.YunxinParamUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * Created by caojiajun on 2024/12/12
 */
public class YunxinParamTest {

    @Test
    public void test() {
        Request request = new Request();
        request.setParam1("p1");
        request.setParam3(1);
        request.setParam5(2);
        request.setParam7(3L);
        request.setParam9(4);

        Map<String, String> map = YunxinParamUtils.convert(request);
        Assert.assertEquals(map.size(), 7);
        Assert.assertEquals(map.get("a"), "p1");
        Assert.assertFalse(map.containsKey("b"));
        Assert.assertEquals(map.get("c"), "1");
        Assert.assertFalse(map.containsKey("d"));
        Assert.assertEquals(map.get("e"), "2");
        Assert.assertEquals(map.get("f"), "0");
        Assert.assertEquals(map.get("g"), "3");
        Assert.assertFalse(map.containsKey("h"));
        Assert.assertEquals(map.get("i"), "4");
        Assert.assertEquals(map.get("j"), "0");
    }

    public static class Request {
        @YunxinParam("a")
        private String param1;

        @YunxinParam("b")
        private String param2;

        @YunxinParam("c")
        private Integer param3;

        @YunxinParam("d")
        private Integer param4;

        @YunxinParam("e")
        private int param5;

        @YunxinParam("f")
        private int param6;

        @YunxinParam("g")
        private Long param7;

        @YunxinParam("h")
        private Long param8;

        @YunxinParam("i")
        private long param9;

        @YunxinParam("j")
        private long param10;

        public String getParam1() {
            return param1;
        }

        public void setParam1(String param1) {
            this.param1 = param1;
        }

        public String getParam2() {
            return param2;
        }

        public void setParam2(String param2) {
            this.param2 = param2;
        }

        public Integer getParam3() {
            return param3;
        }

        public void setParam3(Integer param3) {
            this.param3 = param3;
        }

        public Integer getParam4() {
            return param4;
        }

        public void setParam4(Integer param4) {
            this.param4 = param4;
        }

        public int getParam5() {
            return param5;
        }

        public void setParam5(int param5) {
            this.param5 = param5;
        }

        public int getParam6() {
            return param6;
        }

        public void setParam6(int param6) {
            this.param6 = param6;
        }

        public Long getParam7() {
            return param7;
        }

        public void setParam7(Long param7) {
            this.param7 = param7;
        }

        public Long getParam8() {
            return param8;
        }

        public void setParam8(Long param8) {
            this.param8 = param8;
        }

        public long getParam9() {
            return param9;
        }

        public void setParam9(long param9) {
            this.param9 = param9;
        }

        public long getParam10() {
            return param10;
        }

        public void setParam10(long param10) {
            this.param10 = param10;
        }
    }
}
