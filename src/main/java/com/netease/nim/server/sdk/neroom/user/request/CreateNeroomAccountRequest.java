package com.netease.nim.server.sdk.neroom.user.request;

import com.alibaba.fastjson2.annotation.JSONField;


/**
 * Created by caojiajun on 2025/6/12
 */
public class CreateNeroomAccountRequest {

    @JSONField(name = "user_uuid")
    private String userUuid;

    @JSONField(name = "user_token")
    private String userToken;

    @JSONField(name = "user_name")
    private String userName;

    @JSONField(name = "icon")
    private String icon;

    @JSONField(name = "im_token")
    private String imToken;

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getImToken() {
        return imToken;
    }

    public void setImToken(String imToken) {
        this.imToken = imToken;
    }
}
