/**
 * @author Omer Muhammed on 03/01/2014.
 * Copyright 2014 (c) Jawbone. All rights reserved.
 *
 */
package com.jawbone.upplatformsdk.api;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.jawbone.upplatformsdk.api.response.GetMealsListResponse;
import com.jawbone.upplatformsdk.api.response.OauthAccessTokenResponse;
import com.jawbone.upplatformsdk.oauth.OauthWebViewActivity;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkUtils;
import com.spothero.volley.JacksonNetwork;
import com.spothero.volley.JacksonRequest;
import com.spothero.volley.JacksonRequestListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Wrapper class of UP Platform API calls, all requests are managed from here
 */
public class UpApiWrapper {

    private String mClientId;
    private String mClientSecret;
    private String mCallbackUrl;
    private List<UpPlatformSdkUtils.UpPlatformAuthScope> mScopeArrayList;
    private RequestQueue mRequestQueue;

    private static UpApiWrapper INSTANCE = null;

    private UpApiWrapper() {
        if (INSTANCE != null) {
            throw new IllegalStateException("Already instantiated");
        }
    }
    public static UpApiWrapper getInstance() {
        synchronized (UpApiWrapper.class) {
            if (INSTANCE == null) {
                INSTANCE = new UpApiWrapper();
            }
        }
        return INSTANCE;
    }

    public void init(Context context) {
        mRequestQueue = JacksonNetwork.newRequestQueue(context);
    }

    public void setUserCredentials(String id,
                                   String secret,
                                   String callbackUrl,
                                   List<UpPlatformSdkUtils.UpPlatformAuthScope> scopeArray) {
        mClientId = id;
        mClientSecret = secret;
        mCallbackUrl = callbackUrl;
        mScopeArrayList = scopeArray;
    }

    public Intent getIntentForWebView() {
        Uri.Builder builder = UpPlatformSdkUtils.setOauthParameters(mClientId, mCallbackUrl, mScopeArrayList);

        Intent intent = new Intent(OauthWebViewActivity.class.getName());
        intent.putExtra(UpPlatformSdkUtils.AUTH_URI, builder.build());

        return intent;
    }

    public Request<?> makeAccessTokenRequest(String authorizationCode, JacksonRequestListener<OauthAccessTokenResponse> listener) {
        Uri.Builder builder = UpPlatformSdkUtils.setBaseParameters();

        builder = UpPlatformSdkUtils.setAccessTokenRequestParameters(mClientId, mClientSecret, builder, authorizationCode);
        Uri accessTokenUri = builder.build();

        JacksonRequest req = new JacksonRequest<OauthAccessTokenResponse>(
                Request.Method.GET,
                accessTokenUri.toString(),
                listener);
        return mRequestQueue.add(req);
    }

    /* ---------------------------- Meals API ---------------------------- */
    public Request<?> getMealsListRequest(JacksonRequestListener<GetMealsListResponse> listener, final String accessToken) {
        String accessTokenUrl = UpPlatformSdkUtils.getMealsListUrl(-1, -1, -1, -1, -1);

        JacksonRequest req = new JacksonRequest<GetMealsListResponse>(
                Request.Method.GET,
                accessTokenUrl,
                listener) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("Authorization", "Bearer " + accessToken);
                params.put("Accept", "application/json");

                return params;
            }
        };
        return mRequestQueue.add(req);
    }
}
