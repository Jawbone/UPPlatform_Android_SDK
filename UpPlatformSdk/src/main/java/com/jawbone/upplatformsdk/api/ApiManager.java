/**
 * @author Omer Muhammed
 * Copyright 2014 (c) Jawbone. All rights reserved.
 *
 */
package com.jawbone.upplatformsdk.api;

import com.jawbone.upplatformsdk.utils.UpPlatformSdkConstants;

import retrofit.ErrorHandler;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Main class that handles all the API calls
 */
public class ApiManager {

    private static RestAdapter restAdapter;
    private static RestApiInterface restApiInterface;
    private static ApiHeaders restApiHeaders;

    private static RestAdapter getRestAdapter() {
        if (restAdapter == null) {
            restAdapter = new RestAdapter.Builder()
                .setRequestInterceptor(getRequestInterceptor())
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setErrorHandler(new CustomErrorHandler())
                .setEndpoint(UpPlatformSdkConstants.API_URL)
                .build();
        }
        return restAdapter;
    }

    //TODO make this more robust
    private static class CustomErrorHandler implements ErrorHandler {
        @Override public Throwable handleError(RetrofitError cause) {
            Response r = cause.getResponse();
            if (r != null && r.getStatus() == 401) {
                return cause.getCause();
            }
            return cause;
        }
    }

    public static RestApiInterface getRestApiInterface() {
        restAdapter = getRestAdapter();
        if (restApiInterface == null) {
            restApiInterface = restAdapter.create(RestApiInterface.class);
        }
        return restApiInterface;
    }

    public static ApiHeaders getRequestInterceptor() {
        if (restApiHeaders == null) {
            restApiHeaders = new ApiHeaders();
        }
        return restApiHeaders;
    }
}