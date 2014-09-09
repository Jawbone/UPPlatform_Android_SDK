/**
 * @author Omer Muhammed
 * Copyright 2014 (c) Jawbone. All rights reserved.
 *
 */
package com.jawbone.upplatformsdk.api;

import retrofit.RequestInterceptor;

/**
 * Small class to dynamically add the required headers to the API calls.
 */
public class ApiHeaders implements RequestInterceptor {
    private String accessToken;

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void clearAccessToken() {
        accessToken = null;
    }

    @Override
    public void intercept(RequestInterceptor.RequestFacade request) {
        if (accessToken != null) {
            request.addHeader("Authorization", "Bearer " + accessToken);
            request.addHeader("Accept", "application/json");
        }
    }
}