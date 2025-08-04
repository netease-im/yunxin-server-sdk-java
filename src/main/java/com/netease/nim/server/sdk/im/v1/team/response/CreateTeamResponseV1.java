package com.netease.nim.server.sdk.im.v1.team.response;


import java.util.List;

/**
 * Created by hekaijie on 2024/12/24
 */
public class CreateTeamResponseV1 {
    private Long tid;

    private TeamFailAccids faccid = new TeamFailAccids();

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public TeamFailAccids getFaccid() {
        return faccid;
    }

    public void setFaccid(TeamFailAccids faccid) {
        this.faccid = faccid;
    }

    public static class TeamFailAccids {
        private List<String> accidList;
        private String msg;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public List<String> getAccidList() {
            return accidList;
        }

        public void setAccidList(List<String> accidList) {
            this.accidList = accidList;
        }
    }
}
