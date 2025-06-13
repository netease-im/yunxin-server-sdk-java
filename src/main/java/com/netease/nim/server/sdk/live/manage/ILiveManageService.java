package com.netease.nim.server.sdk.live.manage;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.live.manage.request.LiveCreateChannelRequest;
import com.netease.nim.server.sdk.live.manage.response.LiveCreateChannelResponse;

/**
 * Created by caojiajun on 2025/6/12
 */
public interface ILiveManageService {

    Result<LiveCreateChannelResponse> createChannel(LiveCreateChannelRequest request);
}
