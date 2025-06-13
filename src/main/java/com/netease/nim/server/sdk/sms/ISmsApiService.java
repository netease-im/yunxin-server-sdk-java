package com.netease.nim.server.sdk.sms;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.sms.request.SmsSendCodeRequest;
import com.netease.nim.server.sdk.sms.response.SmsSendCodeResponse;

/**
 * Created by caojiajun on 2025/6/12
 */
public interface ISmsApiService {

    Result<SmsSendCodeResponse> sendCode(SmsSendCodeRequest request);
}
