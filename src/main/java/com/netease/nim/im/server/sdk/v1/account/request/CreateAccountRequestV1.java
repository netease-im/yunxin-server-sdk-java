package com.netease.nim.im.server.sdk.v1.account.request;


import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

/**
 * Created by caojiajun on 2024/12/11
 */
public class CreateAccountRequestV1 {

    @YunxinParam("accid")
    private String accid;

    @YunxinParam("token")
    private String token;

    @YunxinParam("name")
    private String name;

    @YunxinParam("icon")
    private String icon;

    @YunxinParam("sign")
    private String sign;

    @YunxinParam("email")
    private String email;

    @YunxinParam("birth")
    private String birth;

    @YunxinParam("mobile")
    private String mobile;

    @YunxinParam("gender")
    private String gender;

    @YunxinParam("ex")
    private String ex;

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }
}
