package com.netease.nim.im.server.sdk.test.v1;

import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.test.YunxinApiHttpClientInit;
import com.netease.nim.im.server.sdk.v1.YunxinV1ApiServices;
import com.netease.nim.im.server.sdk.v1.account.IAccountV1Service;
import com.netease.nim.im.server.sdk.v1.account.request.*;
import com.netease.nim.im.server.sdk.v1.account.response.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

/**
 * Created by caojiajun on 2025/2/10
 */
public class TestAccountV1 {

    private static YunxinV1ApiServices services = null;
    private static IAccountV1Service accountService = null;
    private static String accid = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    private static String accid1 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);

    @BeforeClass
    public static void setup() {
        YunxinApiHttpClient client = YunxinApiHttpClientInit.init();
        if (client == null) {
            return;
        }
        services = new YunxinV1ApiServices(client);
        accountService = services.getAccountService();
    }

    @Test
    public void testCreateAccount() {
        if (accountService == null) return;
        String name = "zhangsan-" + UUID.randomUUID();
        createAccount(accid,name);
    }
    
    @Test
    public void testUpdateToken() {
        if (accountService == null) return;
        updateToken();
    }
    
    @Test
    public void testRefreshToken() {
        if (accountService == null) return;
        refreshToken();
    }
    
    @Test
    public void testBlock() {
        if (accountService == null) return;
        block();
    }
    
    @Test
    public void testUnblock() {
        if (accountService == null) return;
        unblock();
    }
    
    @Test
    public void testMute() {
        if (accountService == null) return;
        mute();
    }
    
    @Test
    public void testMuteModule() {
        if (accountService == null) return;
        muteModule();
    }
    
    @Test
    public void testSetDonnop() {
        if (accountService == null) return;
        setDonnop();
    }
    
    @Test
    public void testQueryOnlineStatus() {
        if (accountService == null) return;
        queryOnlineStatus();
    }
    
    @Test
    public void testQueryUserInfos() {
        if (accountService == null) return;
        String name = "zhangsan-" + UUID.randomUUID();
        createAccount(accid1,name);
        queryUserInfos(accid1,name);
    }
    
    @Test
    public void testUpdateUinfo() {
        if (accountService == null) return;
        updateUinfo();
    }

    private static void createAccount(String accid,String name) {
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

    private static void updateToken() {
        UpdateTokenRequestV1 request = new UpdateTokenRequestV1();
        request.setAccid(accid);
        request.setToken(UUID.randomUUID().toString().replaceAll("-", ""));
        
        Result<UpdateTokenResponseV1> result = accountService.updateToken(request);
        Assert.assertEquals(200, result.getCode());
    }

    private static void refreshToken() {
        RefreshTokenRequestV1 request = new RefreshTokenRequestV1();
        request.setAccid(accid);
        
        Result<RefreshTokenResponseV1> result = accountService.refreshToken(request);
        Assert.assertEquals(200, result.getCode());
        Assert.assertEquals(accid, result.getResponse().getAccid());
        Assert.assertNotNull(result.getResponse().getToken());
    }

    private static void block() {
        BlockAccountRequestV1 request = new BlockAccountRequestV1();
        request.setAccid(accid);
        request.setNeedKick(true);
        request.setKickNotifyExt("axx");
        request.setNeedUnbindPushToken(true);
        
        Result<BlockAccountResponseV1> result = accountService.block(request);
        Assert.assertEquals(200, result.getCode());
    }

    private static void unblock() {
        UnBlockAccountRequestV1 request = new UnBlockAccountRequestV1();
        request.setAccid(accid);
        
        Result<UnBlockAccountResponseV1> result = accountService.unblock(request);
        Assert.assertEquals(200, result.getCode());
    }

    private static void mute() {
        MuteAccountRequestV1 request = new MuteAccountRequestV1();
        request.setAccid(accid);
        request.setMute(true);
        
        Result<MuteAccountResponseV1> result = accountService.mute(request);
        Assert.assertEquals(200, result.getCode());
    }

    private static void muteModule() {
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

    private static void setDonnop() {
        SetDonnopRequestV1 request = new SetDonnopRequestV1();
        request.setAccid(accid);
        request.setDonnopOpen(true);
        
        Result<SetDonnopResponseV1> result = accountService.setDonnop(request);
        Assert.assertEquals(414, result.getCode());
    }

    private static void queryOnlineStatus() {
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

    private static void queryUserInfos(String accid,String name) {
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

    private static void updateUinfo() {
        UpdateUinfoRequestV1 request = new UpdateUinfoRequestV1();
        String name = "lisi-" + UUID.randomUUID();
        request.setName(name);
        request.setAccid(accid);
        
        Result<UpdateUinfoResponseV1> result = accountService.updateUinfo(request);
        Assert.assertEquals(200, result.getCode());
        queryUserInfos(accid,name);
    }
}

