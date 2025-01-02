package com.netease.nim.im.server.sdk.v1.team.response;


import java.util.List;

/**
 * Created by hekaijie on 2024/12/24
 */
public class CreateTeamResponseV1 {
    private Long tid;

    private TeamFailAccids failAccidList = new TeamFailAccids();

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public TeamFailAccids getFailAccidList() {
        return failAccidList;
    }

    public void setFailAccidList(TeamFailAccids failAccidList) {
        this.failAccidList = failAccidList;
    }

    public static class TeamFailAccids {
        private List<String> accid;
        private String msg;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public List<String> getAccid() {
            return accid;
        }

        public void setAccid(List<String> accid) {
            this.accid = accid;
        }
    }
}
