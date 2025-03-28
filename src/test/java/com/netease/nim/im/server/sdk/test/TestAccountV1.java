package com.netease.nim.im.server.sdk.test;

import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.v1.YunxinV1ApiServices;
import com.netease.nim.im.server.sdk.v1.account.IAccountV1Service;
import com.netease.nim.im.server.sdk.v1.account.request.*;
import com.netease.nim.im.server.sdk.v1.account.response.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by caojiajun on 2025/2/10
 */
public class TestAccountV1 {

    private YunxinV1ApiServices services = null;

    String accid = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);

    @Before
    public void before() {
        String appkey = System.getProperty("appkey");
        String appsecret = System.getProperty("appsecret");
        if (appkey == null || appsecret == null) {
            return;
        }
        int timeoutMillis = 5000;
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .build();
        services = new YunxinV1ApiServices(client);
    }


    @Test
    public void test() {
        if (services == null) return;
        IAccountV1Service accountService = services.getAccountService();
        String name = "zhangsan-" + UUID.randomUUID();
        {
            CreateAccountRequestV1 request = new CreateAccountRequestV1();
            request.setAccid(accid);
            request.setName(name);
            request.setEx("ex");
            request.setBirth("1970-01-01");
            request.setGender(1);
            request.setIcon("https://icon-xxx.jpg");
            request.setMobile("13811110000");
            request.setToken(UUID.randomUUID().toString().replaceAll("-", ""));
            request.setSign("sign");
            request.setEmail("zhangsan@163.com");
            Result<CreateAccountResponseV1> result = accountService.createAccount(request);
            Assert.assertEquals(200, result.getCode());
            CreateAccountResponseV1 response = result.getResponse();
            Assert.assertEquals(request.getAccid(), response.getAccid());
            Assert.assertEquals(request.getName(), response.getName());
            Assert.assertNotNull(response.getToken());
        }
        {
            UpdateTokenRequestV1 request = new UpdateTokenRequestV1();
            request.setAccid(accid);
            request.setToken(UUID.randomUUID().toString().replaceAll("-", ""));
            Result<UpdateTokenResponseV1> result = accountService.updateToken(request);
            Assert.assertEquals(200, result.getCode());
        }
        {
            RefreshTokenRequestV1 request = new RefreshTokenRequestV1();
            request.setAccid(accid);
            Result<RefreshTokenResponseV1> result = accountService.refreshToken(request);
            Assert.assertEquals(200, result.getCode());
            Assert.assertEquals(accid, result.getResponse().getAccid());
            Assert.assertNotNull(result.getResponse().getToken());
        }
        {
            BlockAccountRequestV1 request = new BlockAccountRequestV1();
            request.setAccid(accid);
            request.setNeedKick(true);
            request.setKickNotifyExt("axx");
            request.setNeedUnbindPushToken(true);
            Result<BlockAccountResponseV1> result = accountService.block(request);
            Assert.assertEquals(200, result.getCode());
        }
        {
            UnBlockAccountRequestV1 request = new UnBlockAccountRequestV1();
            request.setAccid(accid);
            Result<UnBlockAccountResponseV1> result = accountService.unblock(request);
            Assert.assertEquals(200, result.getCode());
        }
        {
            MuteAccountRequestV1 request = new MuteAccountRequestV1();
            request.setAccid(accid);
            request.setMute(true);
            Result<MuteAccountResponseV1> result = accountService.mute(request);
            Assert.assertEquals(200, result.getCode());
        }
        {
            MuteModuleRequestV1 request = new MuteModuleRequestV1();
            request.setAccid(accid);
            request.setMuteP2P(true);
            request.setMuteRoom(true);
            request.setMuteTeam(true);
            request.setMuteQChat(true);
            Result<MuteModuleResponseV1> result = accountService.muteModule(request);
            Assert.assertEquals(200, result.getCode());
            Assert.assertEquals(true, result.getResponse().getMuteP2P());
            Assert.assertEquals(true, result.getResponse().getMuteQChat());
            Assert.assertEquals(true, result.getResponse().getMuteTeam());
            Assert.assertEquals(true, result.getResponse().getMuteRoom());
        }
        {
            SetDonnopRequestV1 request = new SetDonnopRequestV1();
            request.setAccid(accid);
            request.setDonnopOpen(true);
            Result<SetDonnopResponseV1> result = accountService.setDonnop(request);
            Assert.assertEquals(414, result.getCode());
        }
        {
            QueryAccountOnlineStatusRequestV1 request = new QueryAccountOnlineStatusRequestV1();
            String invalidAccid = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
            request.setAccids(Arrays.asList(accid, invalidAccid));
            Result<QueryAccountOnlineStatusResponseV1> result = accountService.queryOnlineStatus(request);
            Assert.assertEquals(200, result.getCode());
            QueryAccountOnlineStatusResponseV1 response = result.getResponse();
            List<String> invalidAccids = response.getInvalidAccids();
            Assert.assertEquals(1, invalidAccids.size());
            Assert.assertEquals(invalidAccids.get(0), invalidAccid);
            List<QueryAccountOnlineStatusResponseV1.OnlineStatus> onlineStatusList = response.getOnlineStatusList();
            Assert.assertEquals(0, onlineStatusList.size());
        }
        {
            QueryUserInfosRequestV1 request = new QueryUserInfosRequestV1();
            List<String> accids = new ArrayList<>();
            accids.add(accid);
            request.setAccids(accids);
            request.setMuteStatus(true);
            Result<QueryUserInfosResponseV1> result = accountService.queryUserInfos(request);
            Assert.assertEquals(200, result.getCode());
            QueryUserInfosResponseV1 response = result.getResponse();
            Assert.assertEquals(1, response.getUserInfoList().size());
            QueryUserInfosResponseV1.UserInfo userInfo = response.getUserInfoList().get(0);
            Assert.assertEquals(userInfo.getName(), name);
        }
    }

}

