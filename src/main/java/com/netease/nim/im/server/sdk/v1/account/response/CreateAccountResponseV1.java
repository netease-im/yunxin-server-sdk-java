package com.netease.nim.im.server.sdk.v1.account.response;


/**
 * Created by caojiajun on 2024/12/11
 */
public class CreateAccountResponseV1 {
    private String accid;
    private String name;
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
