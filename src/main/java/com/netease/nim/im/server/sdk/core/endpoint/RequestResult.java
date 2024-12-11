package com.netease.nim.im.server.sdk.core.endpoint;

/**
 * Created by caojiajun on 2024/12/9
 */
public enum RequestResult {

    SUCCESS,//成功
    CONNECT_TIMEOUT,//连接超时
    READ_WRITE_TIMEOUT,//请求读写超时
    HTTP_CODE_502,//http错误码502
    HTTP_CODE_500,//http错误码500
    HTTP_CODE_400,//http错误码400
    HTTP_CODE_NOT_200,//http非200错误码
    OTHER_ERRORS,//其他错误
    ;

}
