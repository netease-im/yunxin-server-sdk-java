package com.netease.nim.im.server.sdk.v1.special_relation.request;

import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

public class SetSpecialRelationRequestV1 {
    /**
     * 用户账号 ID
     **/
    @YunxinParam("accid")
    private String accid;

    /**
     * 被拉黑或被设置免打扰的账号 ID
     **/
    @YunxinParam("targetAcc")
    private String targetAcc;

    /**
     * 本次操作的类型: 1 - 黑名单操作，2 - 设置免打扰操作
     **/
    @YunxinParam("relationType")
    private int relationType;

    /**
     * 操作值: 0 - 取消拉黑或取消免打扰，1 - 加入黑名单或设置免打扰
     **/
    @YunxinParam("value")
    private int value;

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

    public String getTargetAcc() {
        return targetAcc;
    }

    public void setTargetAcc(String targetAcc) {
        this.targetAcc = targetAcc;
    }

    public int getRelationType() {
        return relationType;
    }

    public void setRelationType(int relationType) {
        this.relationType = relationType;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
