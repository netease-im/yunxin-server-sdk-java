package com.netease.nim.server.sdk.im.v1.system_notification;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v1.annotation.YunxinParamUtils;
import com.netease.nim.server.sdk.im.v1.system_notification.request.SendAttachMsgRequestV1;
import com.netease.nim.server.sdk.im.v1.system_notification.request.SendBatchAttachMsgRequestV1;
import com.netease.nim.server.sdk.im.v1.system_notification.response.SendAttachMsgResponseV1;
import com.netease.nim.server.sdk.im.v1.system_notification.response.SendBatchAttachMsgResponseV1;

import java.util.Map;

/**
 * 系统通知服务实现类
 */
public class SystemNotificationV1Service implements ISystemNotificationV1Service {

    private final YunxinApiHttpClient httpClient;
    
    private final static String CODE = "code";
    private final static String DESC = "desc";
    private final static String UNREGISTER = "unregister";

    public SystemNotificationV1Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Result<SendAttachMsgResponseV1> sendAttachMsg(SendAttachMsgRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        
        // 处理forcePushList列表，转为JSON数组字符串
        if (request.getForcePushList() != null && !request.getForcePushList().isEmpty()) {
            paramMap.put("forcePushList", JSONArray.toJSONString(request.getForcePushList()));
        }

        YunxinApiResponse apiResponse = httpClient.executeV1Api(SystemNotificationV1UrlContext.SEND_ATTACH_MSG, paramMap);

        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);

        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        SendAttachMsgResponseV1 response = new SendAttachMsgResponseV1();

        // 处理未注册的账号列表（如果有）
        if (object.containsKey("desc")&&object.get("desc")!=null) {
            response.setDesc(object.getString("desc"));
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }
    
    @Override
    public Result<SendBatchAttachMsgResponseV1> sendBatchAttachMsg(SendBatchAttachMsgRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        
        // 处理接收者列表，转为JSON数组字符串
        if (request.getToAccids() != null && !request.getToAccids().isEmpty()) {
            paramMap.put("toAccids", JSONArray.toJSONString(request.getToAccids()));
        }

        YunxinApiResponse apiResponse = httpClient.executeV1Api(SystemNotificationV1UrlContext.SEND_BATCH_ATTACH_MSG, paramMap);

        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);

        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        SendBatchAttachMsgResponseV1 response = new SendBatchAttachMsgResponseV1();
        
        // 处理未注册的账号列表（如果有）
        if (object.containsKey(UNREGISTER)) {
            String unregisterStr = object.getString(UNREGISTER);
            if (unregisterStr != null && !unregisterStr.isEmpty()) {
                response.setUnregister(JSON.parseArray(unregisterStr, String.class));
            }
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }
} 