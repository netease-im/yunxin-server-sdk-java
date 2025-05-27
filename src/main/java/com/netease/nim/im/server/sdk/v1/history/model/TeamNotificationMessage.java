package com.netease.nim.im.server.sdk.v1.history.model;

import java.util.List;

/**
 * Team notification message with type = 5
 */
public class TeamNotificationMessage extends Message {
    /**
     * Team notification message body
     */
    public static class Body {
        /**
         * 群ID
         */
        private Long tid;
        
        /**
         * 群名称（某些操作会有）
         */
        private String tname;
        
        /**
         * 通知类型
         * 0: 群拉人
         * 1: 群踢人
         * 2: 退出群
         * 3: 群信息更新
         * 4: 群解散
         * 5: 申请加入群成功
         * 6: 退出并移交群主
         * 7: 增加管理员
         * 8: 删除管理员
         * 9: 接受邀请进群
         * 10: 禁言群成员
         */
        private Integer ope;
        
        /**
         * 被操作的对象（群成员操作时才有）
         */
        private List<String> accids;
        
        /**
         * 群介绍（ope=3时群信息修改项）
         */
        private String intro;
        
        /**
         * 群公告（ope=3时群信息修改项）
         */
        private String announcement;
        
        /**
         * 加入群的模式 0不需要认证，1需要认证（ope=3时群信息修改项）
         */
        private Integer joinmode;
        
        /**
         * 第三方服务器配制修改项（ope=3时群信息修改项）
         */
        private String config;
        
        /**
         * 通知后台更新时间（群操作时有）
         */
        private Long updatetime;

        public Long getTid() {
            return tid;
        }

        public void setTid(Long tid) {
            this.tid = tid;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public Integer getOpe() {
            return ope;
        }

        public void setOpe(Integer ope) {
            this.ope = ope;
        }

        public List<String> getAccids() {
            return accids;
        }

        public void setAccids(List<String> accids) {
            this.accids = accids;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getAnnouncement() {
            return announcement;
        }

        public void setAnnouncement(String announcement) {
            this.announcement = announcement;
        }

        public Integer getJoinmode() {
            return joinmode;
        }

        public void setJoinmode(Integer joinmode) {
            this.joinmode = joinmode;
        }

        public String getConfig() {
            return config;
        }

        public void setConfig(String config) {
            this.config = config;
        }

        public Long getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(Long updatetime) {
            this.updatetime = updatetime;
        }
    }
} 