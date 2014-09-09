/**
 * @author Omer Muhammed
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
import com.jawbone.upplatformsdk.oauth.OauthUtils;
import com.jawbone.upplatformsdk.oauth.OauthWebViewActivity;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkConstants;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Main activity of the Hello Up test app, it makes the OAuth API
 * call and obtains the access token.
 */
public class HelloUpActivity extends Activity {

    private static final String TAG = HelloUpActivity.class.getSimpleName();

    // These are obtained after registering on Jawbone Developer Portal
    // Credentials used here are created for "Test-App1"
    private static final String CLIENT_ID = "_W1Vw3ksfpQ";
    private static final String CLIENT_SECRET = "ed46a27e5d3441317607bac4ea99de9617790637";

    // This has to be identical to the OAuth redirect url setup in Jawbone Developer Portal
    private static final String OAUTH_CALLBACK_URL = "http://localhost/helloup?";

    private List<UpPlatformSdkConstants.UpPlatformAuthScope> authScope;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.hello_up);

        // Set required levels of permissions here, for demonstration purpose
        // we are requesting all permissions
        authScope  = new ArrayList<UpPlatformSdkConstants.UpPlatformAuthScope>();
        authScope.add(UpPlatformSdkConstants.UpPlatformAuthScope.ALL);

        Button oAuthAuthorizeButton = (Button) findViewById(R.id.authorizeButton);
        oAuthAuthorizeButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = getIntentForWebView();
            startActivityForResult(intent, UpPlatformSdkConstants.JAWBONE_AUTHORIZE_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == UpPlatformSdkConstants.JAWBONE_AUTHORIZE_REQUEST_CODE && resultCode == RESULT_OK) {

            String code = data.getStringExtra(UpPlatformSdkConstants.ACCESS_CODE);
            if (code != null) {
                //first clear older accessToken, if it exists..
                ApiManager.getRequestInterceptor().clearAccessToken();

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

            if (result.access_token != null) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(HelloUpActivity.this);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(UpPlatformSdkConstants.UP_PLATFORM_ACCESS_TOKEN, result.access_token);
                editor.putString(UpPlatformSdkConstants.UP_PLATFORM_REFRESH_TOKEN, result.refresh_token);
                editor.commit();

                Intent intent = new Intent(HelloUpActivity.this, UpApiListActivity.class);
                intent.putExtra(UpPlatformSdkConstants.CLIENT_SECRET, CLIENT_SECRET);
                startActivity(intent);

                Log.e(TAG, "accessToken:" + result.access_token);
            } else {
                Log.e(TAG, "accessToken not returned by Oauth call, exiting...");
            }
        }

        @Override
        public void failure(RetrofitError retrofitError) {
            Log.e(TAG, "failed to get accessToken:" + retrofitError.getMessage());
        }
    };

    private Intent getIntentForWebView() {
        Uri.Builder builder = OauthUtils.setOauthParameters(CLIENT_ID, OAUTH_CALLBACK_URL, authScope);

        Intent intent = new Intent(OauthWebViewActivity.class.getName());
        intent.putExtra(UpPlatformSdkConstants.AUTH_URI, builder.build());
        return intent;
    }
}