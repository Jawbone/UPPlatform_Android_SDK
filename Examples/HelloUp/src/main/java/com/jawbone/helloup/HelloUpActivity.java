/**
 * @author Omer Muhammed on 03/01/2014.
 * Copyright 2014 (c) Jawbone. All rights reserved.
 *
 */
package com.jawbone.helloup;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.jawbone.upplatformsdk.api.UpApiWrapper;
import com.jawbone.upplatformsdk.api.response.OauthAccessTokenResponse;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkUtils;
import com.spothero.volley.JacksonRequestListener;

import java.util.ArrayList;
import java.util.List;

public class HelloUpActivity extends Activity {

    private static final String TAG = HelloUpActivity.class.getSimpleName();

    public static final String UP_PLATFORM_ACCESS_TOKEN = "access_token";
    public static final String UP_PLATFORM_REFRESH_TOKEN = "refresh_token";

    // These are obtained after registering on Jawbone Developer Portal
    private static final String CLIENT_ID = "<insert-client-id>";
    private static final String CLIENT_SECRET = "<insert-client-secret";

    // This has to be identical to the callback url setup in Jawbone Developer Portal
    private static final String OAUTH_CALLBACK_URL = "<insert-callback-url>";

    private List<UpPlatformSdkUtils.UpPlatformAuthScope> authScope;

    // Access and Refresh Tokens returned by server after successful OAuth authentication
    private String mAccessTokenFromServer;
    private String mRefreshToken;

    private UpApiWrapper upApiWrapper;

    private TextView mealsText;
    private Button mealsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.hello_up);

        mealsText = (TextView) findViewById(R.id.authorizeText2);
        mealsButton = (Button) findViewById(R.id.authorizeButton2);

        // Set required levels of permissions here
        authScope  = new ArrayList<UpPlatformSdkUtils.UpPlatformAuthScope>();
        authScope.add(UpPlatformSdkUtils.UpPlatformAuthScope.ALL);

        upApiWrapper = UpApiWrapper.getInstance();
        upApiWrapper.init(this);
        upApiWrapper.setUserCredentials(CLIENT_ID, CLIENT_SECRET, OAUTH_CALLBACK_URL, authScope);

        Button oAuthAuthorizeButton = (Button) findViewById(R.id.authorizeButton);
        oAuthAuthorizeButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // launch the WebView ...
                Intent intent = upApiWrapper.getIntentForWebView();
                startActivityForResult(intent, UpPlatformSdkUtils.JAWBONE_AUTHORIZE_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == UpPlatformSdkUtils.JAWBONE_AUTHORIZE_REQUEST_CODE && resultCode == RESULT_OK) {
            String code = data.getStringExtra(UpPlatformSdkUtils.ACCESS_CODE);

            if (code != null)
                upApiWrapper.makeAccessTokenRequest(code, accessTokenRequestListener);
        }
   }

    private JacksonRequestListener<OauthAccessTokenResponse> accessTokenRequestListener = new JacksonRequestListener<OauthAccessTokenResponse>() {
        @Override
        public void onResponse(OauthAccessTokenResponse response, int statusCode, VolleyError error) {
            if (response != null) {
                Log.d(TAG, "--------------------------");
                Log.d(TAG, "expires_in:" + response.expiresIn);
                Log.d(TAG, "token_type:" + response.tokenType);
                Log.d(TAG, "access_token:" + response.accessToken);
                Log.d(TAG, "refresh_token:" + response.refreshToken);
                Log.d(TAG, "--------------------------");

                mAccessTokenFromServer = response.accessToken;
                mRefreshToken = response.refreshToken;

                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(HelloUpActivity.this);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(UP_PLATFORM_ACCESS_TOKEN,mAccessTokenFromServer);
                editor.putString(UP_PLATFORM_REFRESH_TOKEN,mRefreshToken);
                editor.commit();

                Intent intent = new Intent(HelloUpActivity.this, UpApiListActivity.class);
                startActivity(intent);

//                mealsText.setVisibility(View.VISIBLE);
//                mealsButton.setVisibility(View.VISIBLE);
//
//                mealsButton.setOnClickListener(new OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        //Get Meals List
//                        upApiWrapper.getMealsListRequest(getMealsListListener, mAccessTokenFromServer);
//                    }
//                });
            } else {
                Log.e(TAG, Log.getStackTraceString(error));
            }
        }

        @Override
        public JavaType getReturnType() {
            return SimpleType.construct(OauthAccessTokenResponse.class);
        }
    };
}