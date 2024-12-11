package com.netease.nim.im.server.sdk.v2.account.request;

import java.util.List;

/**
 * Created by caojiajun on 2024/12/11
 */
public class BatchQueryAccountsRequestV2 {

    private List<String> accountList;

    public List<String> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<String> accountList) {
        this.accountList = accountList;
    }
}
