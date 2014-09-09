/**
 * @author Omer Muhammed
 * Copyright 2014 (c) Jawbone. All rights reserved.
 *
 */
package com.jawbone.upplatformsdk.oauth;

import android.net.Uri;
import android.util.Log;

import com.jawbone.upplatformsdk.utils.UpPlatformSdkConstants;

import java.util.List;

/**
 * This class provide the API end point to make the OAuth Web View request.
 * Note that it does not use Retrofit library.
 */
public class OauthUtils {

    private static final String TAG = OauthUtils.class.getSimpleName();

    public static Uri.Builder setOauthParameters(String clientId, String callbackUrl, List<UpPlatformSdkConstants.UpPlatformAuthScope> scope) {
        Uri.Builder builder = setBaseParameters();

        builder.appendPath("auth");
        builder.appendPath("oauth2");
        builder.appendPath("auth");
        builder.appendQueryParameter("response_type", "code");
        builder.appendQueryParameter("client_id", clientId);
        builder = setOauthScopeParameters(scope, builder);
        builder.appendQueryParameter("redirect_uri", callbackUrl);

        return builder;
    }

    public static Uri.Builder setOauthScopeParameters(List<UpPlatformSdkConstants.UpPlatformAuthScope> scopeArrayList, Uri.Builder builder) {
        StringBuilder scopeValues = new StringBuilder();

        for (UpPlatformSdkConstants.UpPlatformAuthScope scope : scopeArrayList) {
            switch (scope) {
                case BASIC_READ:
                    scopeValues.append("basic_read ");
                    break;
                case EXTENDED_READ:
                    scopeValues.append("extended_read ");
                    break;
                case LOCATION_READ:
                    scopeValues.append("location_read ");
                    break;
                case FRIENDS_READ:
                    scopeValues.append("friends_read ");
                    break;
                case MOOD_READ:
                    scopeValues.append("mood_read ");
                    break;
                case MOOD_WRITE:
                    scopeValues.append("mood_write ");
                    break;
                case MOVE_READ:
                    scopeValues.append("move_read ");
                    break;
                case MOVE_WRITE:
                    scopeValues.append("move_write ");
                    break;
                case SLEEP_READ:
                    scopeValues.append("sleep_read ");
                    break;
                case SLEEP_WRITE:
                    scopeValues.append("sleep_write ");
                    break;
                case MEAL_READ:
                    scopeValues.append("meal_read ");
                    break;
                case MEAL_WRITE:
                    scopeValues.append("meal_write ");
                    break;
                case WEIGHT_READ:
                    scopeValues.append("weight_read ");
                    break;
                case WEIGHT_WRITE:
                    scopeValues.append("weight_write ");
                    break;
                case CARDIAC_READ:
                    scopeValues.append("cardiac_read ");
                    break;
                case CARDIAC_WRITE:
                    scopeValues.append("cardiac_write ");
                    break;
                case GENERIC_EVENT_READ:
                    scopeValues.append("generic_event_read ");
                    break;
                case GENERIC_EVENT_WRITE:
                    scopeValues.append("generic_event_write ");
                    break;
                case ALL:
                    scopeValues.append("basic_read ");
                    scopeValues.append("extended_read ");
                    scopeValues.append("location_read ");
                    scopeValues.append("friends_read ");
                    scopeValues.append("mood_read ");
                    scopeValues.append("mood_write ");
                    scopeValues.append("move_read ");
                    scopeValues.append("move_write ");
                    scopeValues.append("sleep_read ");
                    scopeValues.append("sleep_write ");
                    scopeValues.append("meal_read ");
                    scopeValues.append("meal_write ");
                    scopeValues.append("weight_read ");
                    scopeValues.append("weight_write ");
                    scopeValues.append("cardiac_read ");
                    scopeValues.append("cardiac_write ");
                    scopeValues.append("generic_event_read ");
                    scopeValues.append("generic_event_write ");
                    break;
                default:
                    scopeValues = null;
                    Log.e(TAG, "unknown scope:" + scope + ", setting it to null");
                    break;
            }
        }

        if (scopeValues != null && scopeValues.length() > 0) {
            scopeValues.setLength(scopeValues.length() - 1);
            builder.appendQueryParameter("scope", scopeValues.toString());
            return builder;
        } else {
            return builder;
        }
    }

    public static Uri.Builder setBaseParameters() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(UpPlatformSdkConstants.URI_SCHEME);
        builder.authority(UpPlatformSdkConstants.AUTHORITY);

        return builder;
    }
}
