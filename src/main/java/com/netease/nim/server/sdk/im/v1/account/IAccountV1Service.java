package com.netease.nim.server.sdk.im.v1.account;

import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.im.v1.account.request.*;
import com.netease.nim.server.sdk.im.v1.account.response.*;

/**
 * Created by caojiajun on 2024/12/11
 */
public interface IAccountV1Service {

    Result<CreateAccountResponseV1> createAccount(CreateAccountRequestV1 request) throws YunxinSdkException;

    Result<UpdateTokenResponseV1> updateToken(UpdateTokenRequestV1 request) throws YunxinSdkException;

    Result<RefreshTokenResponseV1> refreshToken(RefreshTokenRequestV1 request) throws YunxinSdkException;

    Result<BlockAccountResponseV1> block(BlockAccountRequestV1 request) throws YunxinSdkException;

    Result<UnBlockAccountResponseV1> unblock(UnBlockAccountRequestV1 request) throws YunxinSdkException;

    Result<MuteAccountResponseV1> mute(MuteAccountRequestV1 request) throws YunxinSdkException;

    Result<MuteModuleResponseV1> muteModule(MuteModuleRequestV1 request) throws YunxinSdkException;

    Result<SetDonnopResponseV1> setDonnop(SetDonnopRequestV1 request) throws YunxinSdkException;

    Result<QueryAccountOnlineStatusResponseV1> queryOnlineStatus(QueryAccountOnlineStatusRequestV1 request) throws YunxinSdkException;

    Result<QueryUserInfosResponseV1> queryUserInfos(QueryUserInfosRequestV1 request) throws YunxinSdkException;

    Result<UpdateUinfoResponseV1> updateUinfo(UpdateUinfoRequestV1 request) throws YunxinSdkException;
}
