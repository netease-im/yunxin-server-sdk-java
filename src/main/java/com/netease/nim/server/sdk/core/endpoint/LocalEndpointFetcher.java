package com.netease.nim.server.sdk.core.endpoint;

import com.netease.nim.server.sdk.core.Constants;
import com.netease.nim.server.sdk.core.exception.EndpointFetchException;
import com.netease.nim.server.sdk.core.BizName;
import okhttp3.OkHttpClient;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by caojiajun on 2024/12/10
 */
public class LocalEndpointFetcher implements EndpointFetcher {

    private final Endpoints endpoints;

    public LocalEndpointFetcher(Region region) {
        this(BizName.IM, region);
    }

    public LocalEndpointFetcher(BizName bizName, Region region) {
        this.endpoints = new Endpoints();
        if (bizName == BizName.IM) {
            if (region == Region.CN) {
                endpoints.setDefaultEndpoint(Constants.Endpoint.IM.CN.DEFAULT);
                List<String> backupEndpoints = new ArrayList<>();
                backupEndpoints.add(Constants.Endpoint.IM.CN.BACKUP);
                backupEndpoints.add(Constants.Endpoint.IM.CN.BACKUP_1);
                backupEndpoints.add(Constants.Endpoint.IM.CN.BACKUP_2);
                backupEndpoints.add(Constants.Endpoint.IM.CN.BACKUP_3);
                endpoints.setBackupEndpoints(backupEndpoints);
            } else if (region == Region.SG) {
                endpoints.setDefaultEndpoint(Constants.Endpoint.IM.SG.DEFAULT);
                List<String> backupEndpoints = new ArrayList<>();
                backupEndpoints.add(Constants.Endpoint.IM.SG.BACKUP);
                backupEndpoints.add(Constants.Endpoint.IM.SG.BACKUP_1);
                backupEndpoints.add(Constants.Endpoint.IM.SG.BACKUP_2);
                backupEndpoints.add(Constants.Endpoint.IM.SG.BACKUP_3);
                endpoints.setBackupEndpoints(backupEndpoints);
            } else {
                throw new EndpointFetchException("unknown region");
            }
        } else if (bizName == BizName.RTC) {
            if (region == Region.CN) {
                endpoints.setDefaultEndpoint(Constants.Endpoint.RTC.CN.DEFAULT);
                List<String> backupEndpoints = new ArrayList<>();
                backupEndpoints.add(Constants.Endpoint.RTC.CN.BACKUP_1);
                backupEndpoints.add(Constants.Endpoint.RTC.CN.BACKUP_2);
                endpoints.setBackupEndpoints(backupEndpoints);
            } else if (region == Region.SG) {
                endpoints.setDefaultEndpoint(Constants.Endpoint.RTC.SG.DEFAULT);
                List<String> backupEndpoints = new ArrayList<>();
                backupEndpoints.add(Constants.Endpoint.RTC.SG.BACKUP_1);
                endpoints.setBackupEndpoints(backupEndpoints);
            } else {
                throw new EndpointFetchException("unknown region");
            }
        } else if (bizName == BizName.SMS) {
            if (region == Region.CN) {
                endpoints.setDefaultEndpoint(Constants.Endpoint.SMS.CN.DEFAULT);
                List<String> backupEndpoints = new ArrayList<>();
                backupEndpoints.add(Constants.Endpoint.SMS.CN.BACKUP_1);
                endpoints.setBackupEndpoints(backupEndpoints);
            } else {
                throw new EndpointFetchException("unknown region");
            }
        } else {
            throw new EndpointFetchException("unknown bizName");
        }
    }

    @Override
    public void init(OkHttpClient okHttpClient) {
    }

    @Override
    public Endpoints get() {
        return endpoints;
    }
}
