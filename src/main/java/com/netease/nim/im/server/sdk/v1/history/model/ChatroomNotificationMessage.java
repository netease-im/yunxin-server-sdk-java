package com.netease.nim.im.server.sdk.v1.history.model;

import java.util.List;

/**
 * Chatroom notification message with type = 5
 */
public class ChatroomNotificationMessage extends Message {
    /**
     * Chatroom notification message body
     */
    public static class Body {
        /**
         * 聊天室通知类型
         * 301: 成员进入聊天室
         * 302: 成员离开聊天室
         * 303: 成员被加黑
         * 304: 成员被取消黑名单
         * 305: 成员被设置禁言
         * 306: 成员被取消禁言
         * 307: 设置为管理员
         * 308: 取消管理员
         * 309: 成员设定为固定成员
         * 310: 成员取消固定成员
         * 312: 聊天室信息更新
         * 313: 成员被踢
         * 314: 新增临时禁言
         * 315: 主动解除临时禁言
         * 316: 成员更新聊天室内的角色信息
         * 317: 麦序队列中有变更
         * 318: 聊天室禁言
         * 319: 聊天室解除禁言状态
         * 320: 麦序队列中有批量变更
         */
        private Integer id;
        
        /**
         * 聊天室通知数据
         */
        private Data data;
        
        public static class Data {
            /**
             * 操作者昵称
             */
            private String opeNick;
            
            /**
             * 操作者账号
             */
            private String operator;
            
            /**
             * 目标账号列表
             */
            private List<String> target;
            
            /**
             * 目标昵称列表
             */
            private List<String> tarNick;
            
            /**
             * 扩展信息
             */
            private String ext;

            public String getOpeNick() {
                return opeNick;
            }

            public void setOpeNick(String opeNick) {
                this.opeNick = opeNick;
            }

            public String getOperator() {
                return operator;
            }

            public void setOperator(String operator) {
                this.operator = operator;
            }

            public List<String> getTarget() {
                return target;
            }

            public void setTarget(List<String> target) {
                this.target = target;
            }

            public List<String> getTarNick() {
                return tarNick;
            }

            public void setTarNick(List<String> tarNick) {
                this.tarNick = tarNick;
            }

            public String getExt() {
                return ext;
            }

            public void setExt(String ext) {
                this.ext = ext;
            }
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }
    }
} 