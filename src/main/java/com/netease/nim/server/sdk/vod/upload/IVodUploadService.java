package com.netease.nim.server.sdk.vod.upload;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.vod.upload.request.VodUploadInitRequest;
import com.netease.nim.server.sdk.vod.upload.response.VodUploadInitResponse;

/**
 * Created by caojiajun on 2025/6/12
 */
public interface IVodUploadService {

    Result<VodUploadInitResponse> uploadInit(VodUploadInitRequest request);
}
