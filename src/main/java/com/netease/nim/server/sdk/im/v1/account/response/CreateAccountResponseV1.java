package com.netease.nim.server.sdk.im.v1.account.response;


import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Created by caojiajun on 2024/12/11
 */
public class CreateAccountResponseV1 {

    @JSONField(name = "accid")
    private String accid;

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "token")
    private String token;

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
