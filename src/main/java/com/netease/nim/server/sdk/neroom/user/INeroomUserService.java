package com.netease.nim.server.sdk.neroom.user;

import com.netease.nim.server.sdk.neroom.NeroomResult;
import com.netease.nim.server.sdk.neroom.user.request.CreateNeroomAccountRequest;
import com.netease.nim.server.sdk.neroom.user.response.CreateNeroomAccountResponse;

/**
 * Created by caojiajun on 2025/6/12
 */
public interface INeroomUserService {

    NeroomResult<CreateNeroomAccountResponse> createAccount(CreateNeroomAccountRequest request);
}
