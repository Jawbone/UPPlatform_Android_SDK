/**
 * @author Omer Muhammed on 03/01/2014.
 * Copyright 2014 (c) Jawbone. All rights reserved.
 *
 */
package com.jawbone.upplatformsdk.utils;

import android.net.Uri;
import android.util.Log;

import java.util.List;

/**
 * A small utility class for handy methods for SDK.
 */
public class UpPlatformSdkUtils {

    private static final String TAG = UpPlatformSdkUtils.class.getSimpleName();

    private static final String JAWBONE_API_PREFIX = "nudge/api/";
    public static final String JAWBONE_API_VERSION = "v.1.1";

    public static final int JAWBONE_AUTHORIZE_REQUEST_CODE = 120501;

    public static final String AUTH_URI = "auth_uri";

    public static final String ACCESS_CODE = "code";

    /**
     * Different types of permissions that can be requested, defined as an enum
     */
    public enum UpPlatformAuthScope {
        BASIC_READ,
        EXTENDED_READ,
        LOCATION_READ,
        FRIENDS_READ,
        MOOD_READ,
        MOOD_WRITE,
        MOVE_READ,
        MOVE_WRITE,
        SLEEP_READ,
        SLEEP_WRITE,
        MEAL_READ,
        MEAL_WRITE,
        WEIGHT_READ,
        WEIGHT_WRITE,
        CARDIAC_READ,
        CARDIAC_WRITE,
        GENERIC_EVENT_READ,
        GENERIC_EVENT_WRITE,
        ALL;
    }

    public static Uri.Builder setOauthParameters(String clientId, String callbackUrl, List<UpPlatformAuthScope> scope) {
        Uri.Builder builder = UpPlatformSdkUtils.setBaseParameters();

        builder.appendPath("auth");
        builder.appendPath("oauth2");
        builder.appendPath("auth");
        builder.appendQueryParameter("response_type", "code");
        builder.appendQueryParameter("client_id", clientId);
        builder = setOauthScopeParameters(scope, builder);
        builder.appendQueryParameter("redirect_uri", callbackUrl);

        return builder;
    }

    public static Uri.Builder setOauthScopeParameters(List<UpPlatformAuthScope> scopeArrayList, Uri.Builder builder) {
        StringBuilder scopeValues = new StringBuilder();

        for (UpPlatformAuthScope scope : scopeArrayList) {
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
        builder.scheme("https");
        builder.authority("jawbone.com");

        return builder;
    }
}
