package com.netease.nim.im.server.sdk.v1.special_relation.request;

import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

public class ListSpecialRelationRequestV1 {
    @YunxinParam("accid")
    private String accid;

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }
}
