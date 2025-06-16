package com.netease.nim.im.server.sdk.test;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.BizName;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.vod.YunxinVodApiServices;
import com.netease.nim.server.sdk.vod.upload.IVodUploadService;
import com.netease.nim.server.sdk.vod.upload.request.VodUploadInitRequest;
import com.netease.nim.server.sdk.vod.upload.response.VodUploadInitResponse;

/**
 * Created by caojiajun on 2025/6/16
 */
public class Test18 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(BizName.VOD, appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .build();

        YunxinVodApiServices vodApiServices = new YunxinVodApiServices(client);
        IVodUploadService vodUploadService = vodApiServices.getVodUploadService();

        VodUploadInitRequest request = new VodUploadInitRequest();
        request.setOriginFileName("xxxx");
        Result<VodUploadInitResponse> result = vodUploadService.uploadInit(request);
        if (result.isSuccess()) {
            System.out.println(JSONObject.toJSONString(result.getResponse()));
        } else {
            System.out.println(JSONObject.toJSONString(result));
        }
    }
}
