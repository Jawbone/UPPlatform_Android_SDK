/**
 * @author Omer Muhammed
 * Copyright 2014 (c) Jawbone. All rights reserved.
 *
 */
package com.jawbone.upplatformsdk.oauth;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.jawbone.upplatformsdk.R;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkConstants;

/**
 * Simple Web View for Oauth authorization, we display the web page so that
 * user can agree to, or cancel the permissions requested
 */
public class OauthWebViewActivity extends Activity {

    private static final String TAG = OauthWebViewActivity.class.getSimpleName();

    // AccessCode returned from server.
    private String accessCode;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.oauth_webview);

        Intent intent = this.getIntent();
        Uri uri = intent.getParcelableExtra(UpPlatformSdkConstants.AUTH_URI);

        WebView webview = (WebView) findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);

        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Uri uri = Uri.parse(url);

                String code = uri.getQueryParameter("code");
                Log.e(TAG, "oauth response from server: " + url);

                // We hijack the GET request to extract the OAuth parameters
                if(code != null) {
                    // the GET request contains an authorization code
                    Log.d(TAG, "user accepted, url is :" + url);
                    accessCode = code;
                    Log.d(TAG, "user accepted, code is :" + accessCode);

                    view.clearCache(true);
                    Intent i = getIntent();
                    i.putExtra(UpPlatformSdkConstants.ACCESS_CODE, accessCode);
                    setResult(RESULT_OK, i);
                    finish();
                    return true;
                }

                return false;
            }
        });
        webview.loadUrl(uri.toString());
    }
}
