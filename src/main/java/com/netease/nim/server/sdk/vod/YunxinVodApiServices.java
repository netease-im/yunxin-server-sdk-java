package com.netease.nim.server.sdk.vod;

import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.vod.upload.IVodUploadService;
import com.netease.nim.server.sdk.vod.upload.VodUploadService;

/**
 * Created by caojiajun on 2025/6/5
 */
public class YunxinVodApiServices {

    private final IVodUploadService vodUploadService;

    public YunxinVodApiServices(YunxinApiHttpClient yunxinApiHttpClient) {
        vodUploadService = new VodUploadService(yunxinApiHttpClient);
    }

    public IVodUploadService getVodUploadService() {
        return vodUploadService;
    }
}
