package com.netease.nim.server.sdk.meeting.user.response;

import java.util.List;

/**
 * Created by caojiajun on 2025/6/12
 */
public class CreateMeetingAccountResponse {
    private String userUuid;
    private String userToken;
    private String name;
    private String privateMeetingNum;
    private String shortMeetingNum;
    private String sipCid;
    private String avatar;
    private String phoneNumber;
    private String email;
    private String password;
    private Integer state;
    private List<String> departments;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrivateMeetingNum() {
        return privateMeetingNum;
    }

    public void setPrivateMeetingNum(String privateMeetingNum) {
        this.privateMeetingNum = privateMeetingNum;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public List<String> getDepartments() {
        return departments;
    }

    public void setDepartments(List<String> departments) {
        this.departments = departments;
    }
}
