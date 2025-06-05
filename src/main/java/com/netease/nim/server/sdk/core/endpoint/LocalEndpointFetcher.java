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
                endpoints.setDefaultEndpoint(Constants.Endpoint.CN.DEFAULT);
                List<String> backupEndpoints = new ArrayList<>();
                backupEndpoints.add(Constants.Endpoint.CN.BACKUP);
                backupEndpoints.add(Constants.Endpoint.CN.BACKUP_1);
                backupEndpoints.add(Constants.Endpoint.CN.BACKUP_2);
                backupEndpoints.add(Constants.Endpoint.CN.BACKUP_3);
                endpoints.setBackupEndpoints(backupEndpoints);
            } else if (region == Region.SG) {
                endpoints.setDefaultEndpoint(Constants.Endpoint.SG.DEFAULT);
                List<String> backupEndpoints = new ArrayList<>();
                backupEndpoints.add(Constants.Endpoint.SG.BACKUP);
                backupEndpoints.add(Constants.Endpoint.SG.BACKUP_1);
                backupEndpoints.add(Constants.Endpoint.SG.BACKUP_2);
                backupEndpoints.add(Constants.Endpoint.SG.BACKUP_3);
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
