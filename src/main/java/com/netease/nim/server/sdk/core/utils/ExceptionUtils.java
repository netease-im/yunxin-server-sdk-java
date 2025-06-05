package com.netease.nim.server.sdk.core.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;


public class ExceptionUtils {

    /**
     * 获取实际错误原因
     * @param e 异常
     * @return cause
     */
    public static Throwable getRealCause(Throwable e) {
        while (true) {
            if (e instanceof okhttp3.internal.connection.RouteException) {
                if (e.getCause() == null) {
                    break;
                } else {
                    e = e.getCause();
                }
            } else if (e instanceof ExecutionException) {
                if (e.getCause() == null) {
                    break;
                } else {
                    e = e.getCause();
                }
            } else if (e instanceof InvocationTargetException) {
                Throwable targetException = ((InvocationTargetException) e).getTargetException();
                if (targetException == null) {
                    break;
                } else {
                    e = targetException;
                }
            } else if (e instanceof UndeclaredThrowableException) {
                if (e.getCause() == null) {
                    break;
                } else {
                    e = e.getCause();
                }
            } else {
                break;
            }
        }
        return e;
    }

    /**
     * 是否是连接错误
     * @param t 异常
     * @return 结果
     */
    public static boolean isConnectError(Throwable t) {
        Throwable cause = getRealCause(t);
        if (cause instanceof java.net.ConnectException) {
            return true;
        }
        if (cause instanceof java.net.UnknownHostException) {
            return true;
        }
        if (cause instanceof java.net.SocketTimeoutException) {
            String message = cause.getMessage();
            return message != null && message.contains("connect timed out");
        }
        return false;
    }

    /**
     * 是否超时异常
     * @param t 异常
     * @return 结果
     */
    public static boolean isTimeoutError(Throwable t) {
        Throwable cause = getRealCause(t);
        if (cause instanceof java.net.SocketTimeoutException) {
            return true;
        }
        return false;
    }
}
