/**
 * @author Omer Muhammed on 03/01/2014.
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
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.jawbone.upplatformsdk.R;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkUtils;

/**
 * Simple Webview for OAuth authorization
 */
public class OauthWebViewActivity extends Activity {

    private static final String TAG = OauthWebViewActivity.class.getSimpleName();

    // AccessCode returned from server.
    private String accessCode;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oauth_webview);

        Intent intent = this.getIntent();
        Uri uri = intent.getParcelableExtra(UpPlatformSdkUtils.AUTH_URI);

        WebView webview = (WebView) findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);

        webview.setWebViewClient(new WebViewClient() {
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                String accessCodeFragment = "&code=";
                Log.d(TAG, "oauth response from server: " + url);

                int start = url.indexOf(accessCodeFragment);

                // We hijack the GET request to extract the OAuth parameters
                if(start > -1) {
                    // the GET request contains an authorization code
                    Log.d(TAG, "user accepted, url is :" + url);
                    accessCode = url.substring(start + accessCodeFragment.length(), url.length());
                    Log.d(TAG, "user accepted, code is :" + accessCode);

                    view.clearCache(true);
                    Intent i = getIntent();
                    i.putExtra(UpPlatformSdkUtils.ACCESS_CODE, accessCode);
                    setResult(RESULT_OK, i);
                    finish();
                }
            }
        });
        webview.loadUrl(uri.toString());
    }
}
