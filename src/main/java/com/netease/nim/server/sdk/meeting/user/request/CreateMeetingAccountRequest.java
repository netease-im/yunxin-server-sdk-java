package com.netease.nim.server.sdk.meeting.user.request;

import java.util.List;

/**
 * Created by caojiajun on 2025/6/12
 */
public class CreateMeetingAccountRequest {
    private String userUuid;
    private String imToken;
    private String name;
    private String shortMeetingNum;
    private String sipCid;
    private String avatar;
    private String phoneNumber;
    private String email;
    private Boolean returnGeneratedPassword;
    private List<String> departments;

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getImToken() {
        return imToken;
    }

    public void setImToken(String imToken) {
        this.imToken = imToken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortMeetingNum() {
        return shortMeetingNum;
    }

    public void setShortMeetingNum(String shortMeetingNum) {
        this.shortMeetingNum = shortMeetingNum;
    }

    public String getSipCid() {
        return sipCid;
    }

    public void setSipCid(String sipCid) {
        this.sipCid = sipCid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getReturnGeneratedPassword() {
        return returnGeneratedPassword;
    }

    public void setReturnGeneratedPassword(Boolean returnGeneratedPassword) {
        this.returnGeneratedPassword = returnGeneratedPassword;
    }

    public List<String> getDepartments() {
        return departments;
    }

    public void setDepartments(List<String> departments) {
        this.departments = departments;
    }
}
