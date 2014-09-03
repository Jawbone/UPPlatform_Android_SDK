/**
 * @author Omer Muhammed on 03/01/2014.
 * Copyright 2014 (c) Jawbone. All rights reserved.
 *
 */
package com.jawbone.helloup;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

import com.jawbone.upplatformsdk.api.ApiManager;
import com.jawbone.upplatformsdk.api.response.OauthAccessTokenResponse;
import com.jawbone.upplatformsdk.oauth.OauthWebViewActivity;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class HelloUpActivity extends Activity {

    private static final String TAG = HelloUpActivity.class.getSimpleName();

    public static final String UP_PLATFORM_ACCESS_TOKEN = "access_token";
    public static final String UP_PLATFORM_REFRESH_TOKEN = "refresh_token";

    // These are obtained after registering on Jawbone Developer Portal
    private static final String CLIENT_ID = "CCVLFloNu8c";
    private static final String CLIENT_SECRET = "e239462834aa6fc899f84a754f855f56";
//    private static final String CLIENT_ID = "<insert-client-id>";
//    private static final String CLIENT_SECRET = "<insert-client-secret>";

    // This has to be identical to the callback url setup in Jawbone Developer Portal
    private static final String OAUTH_CALLBACK_URL = "http://localhost/helloup?";
//    private static final String OAUTH_CALLBACK_URL = "<insert-callback-url>";

    private List<UpPlatformSdkUtils.UpPlatformAuthScope> authScope;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.hello_up);

        // Set required levels of permissions here
        authScope  = new ArrayList<UpPlatformSdkUtils.UpPlatformAuthScope>();
        authScope.add(UpPlatformSdkUtils.UpPlatformAuthScope.ALL);

        Button oAuthAuthorizeButton = (Button) findViewById(R.id.authorizeButton);
        oAuthAuthorizeButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = getIntentForWebView();
            startActivityForResult(intent, UpPlatformSdkUtils.JAWBONE_AUTHORIZE_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == UpPlatformSdkUtils.JAWBONE_AUTHORIZE_REQUEST_CODE && resultCode == RESULT_OK) {

            String code = data.getStringExtra(UpPlatformSdkUtils.ACCESS_CODE);
            if (code != null) {
                ApiManager.getRestApiInterface().getAccessToken(
                    CLIENT_ID,
                    CLIENT_SECRET,
                    code,
                    accessTokenRequestListener);
            }
        }
   }

    private Callback accessTokenRequestListener = new Callback<OauthAccessTokenResponse>() {
        @Override
        public void success(OauthAccessTokenResponse result, Response response) {

            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(HelloUpActivity.this);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(UP_PLATFORM_ACCESS_TOKEN, result.access_token);
            editor.putString(UP_PLATFORM_REFRESH_TOKEN, result.refresh_token);
            editor.commit();

            Intent intent = new Intent(HelloUpActivity.this, UpApiListActivity.class);
            startActivity(intent);

            Log.e(TAG, "accessToken:" + result.access_token);
        }

        @Override
        public void failure(RetrofitError retrofitError) {
            Log.e(TAG, "failed to get accessToken:" + retrofitError.getMessage());
        }
    };

    private Intent getIntentForWebView() {
        Uri.Builder builder = UpPlatformSdkUtils.setOauthParameters(CLIENT_ID, OAUTH_CALLBACK_URL, authScope);

        Intent intent = new Intent(OauthWebViewActivity.class.getName());
        intent.putExtra(UpPlatformSdkUtils.AUTH_URI, builder.build());
        return intent;
    }

}