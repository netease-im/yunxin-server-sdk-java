package com.netease.nim.im.server.sdk.v1.team.response;

import java.util.List;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class QueryMuteTeamMembersResponseV1 {


    private List<muteInfo> mutes;

    public List<muteInfo> getMutes() {
        return mutes;
    }

    public void setMutes(List<muteInfo> mutes) {
        this.mutes = mutes;
    }

    public static class muteInfo {
        private String nick;

        private String accid;

        private Long tid;

        private Integer type;

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public String getAccid() {
            return accid;
        }

        public void setAccid(String accid) {
            this.accid = accid;
        }

        public Long getTid() {
            return tid;
        }

        public void setTid(Long tid) {
            this.tid = tid;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }
    }
}
