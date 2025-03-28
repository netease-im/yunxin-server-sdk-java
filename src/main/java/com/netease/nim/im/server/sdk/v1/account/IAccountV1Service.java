package com.netease.nim.im.server.sdk.v1.account;

import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.v1.account.request.*;
import com.netease.nim.im.server.sdk.v1.account.response.*;

/**
 * Created by caojiajun on 2024/12/11
 */
public interface IAccountV1Service {

    /**
     * create yunxin account
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<CreateAccountResponseV1> createAccount(CreateAccountRequestV1 request) throws YunxinSdkException;


    /**
     * update token
     * @param request request
     * @return result
     * @throws YunxinSdkException exception
     */
    Result<UpdateTokenResponseV1> updateToken(UpdateTokenRequestV1 request) throws YunxinSdkException;

    /**
     * refresh token
     * @param request request
     * @return result
     * @throws YunxinSdkException exception
     */
    Result<RefreshTokenResponseV1> refreshToken(RefreshTokenRequestV1 request) throws YunxinSdkException;

    /**
     * block account
     * @param request request
     * @return result
     * @throws YunxinSdkException exception
     */
    Result<BlockAccountResponseV1> block(BlockAccountRequestV1 request) throws YunxinSdkException;

    /**
     * unblock account
     * @param request request
     * @return result
     * @throws YunxinSdkException exception
     */
    Result<UnBlockAccountResponseV1> unblock(UnBlockAccountRequestV1 request) throws YunxinSdkException;

    /**
     * mute account
     * @param request request
     * @return result
     * @throws YunxinSdkException exception
     */
    Result<MuteAccountResponseV1> mute(MuteAccountRequestV1 request) throws YunxinSdkException;

    /**
     * mute module of account
     * @param request request
     * @return result
     * @throws YunxinSdkException exception
     */
    Result<MuteModuleResponseV1> muteModule(MuteModuleRequestV1 request) throws YunxinSdkException;

    /**
     * set donnop of account
     * @param request request
     * @return result
     * @throws YunxinSdkException exception
     */
    Result<SetDonnopResponseV1> setDonnop(SetDonnopRequestV1 request) throws YunxinSdkException;

    /**
     * query online status of accounts
     * @param request request
     * @return result
     * @throws YunxinSdkException exception
     */
    Result<QueryAccountOnlineStatusResponseV1> queryOnlineStatus(QueryAccountOnlineStatusRequestV1 request) throws YunxinSdkException;

    /**
     * query user infos
     * @param request request
     * @return result
     * @throws YunxinSdkException exception
     */
    Result<QueryUserInfosResponseV1> queryUserInfos(QueryUserInfosRequestV1 request) throws YunxinSdkException;
}
