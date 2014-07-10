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

    private static final String JAWBONE_API_VERSION = "v.1.1";
    private static final String JAWBONE_API_PREFIX = "nudge/api/";

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

    /**
     * Set up parameters for OAuth call
     * @param clientId Generated when we register on Jawbone Developer Portal
     * @param scope Scope of permissions requested
     * @return Appropriately populated builder
     */
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

    public static Uri.Builder setAccessTokenRequestParameters(String clientId, String clientSecret, Uri.Builder builder, String authorizationCode) {
        builder.appendPath("auth");
        builder.appendPath("oauth2");
        builder.appendPath("token");
        builder.appendQueryParameter("grant_type", "authorization_code");
        builder.appendQueryParameter("client_id", clientId);
        builder.appendQueryParameter("client_secret", clientSecret);
        builder.appendQueryParameter("code", authorizationCode);

        return builder;
    }

    public static Uri.Builder setBaseParameters() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https");
        builder.authority("jawbone.com");

        return builder;
    }

    /* ---------------------------- Meals API ---------------------------- */
    public static String getMealsListUrl(int date, int pageToken, int startTime, int endTime, int updatedAfter) {
        Uri.Builder builder = setBaseParameters();

        String uriString = JAWBONE_API_PREFIX + JAWBONE_API_VERSION + "/users/@me/meals";
        builder.encodedPath(uriString);
        if (date != -1)
            builder.appendQueryParameter("date", String.valueOf(date));
        if (pageToken != -1)
            builder.appendQueryParameter("page_token", String.valueOf(pageToken));
        if (startTime != -1)
            builder.appendQueryParameter("start_time", String.valueOf(startTime));
        if (endTime != -1)
            builder.appendQueryParameter("end_time", String.valueOf(endTime));
        if (updatedAfter != -1)
            builder.appendQueryParameter("updated_after", String.valueOf(updatedAfter));

        builder.build();
        return builder.toString();
    }

    //https://jawbone.com/nudge/api/v.1.0/meals/gsXiJtiwCAlFrTCm5LeA2A
    public static String getMealUrl(String xid) {
        Uri.Builder builder = setBaseParameters();

        String uriString = JAWBONE_API_PREFIX + JAWBONE_API_VERSION + "/meals";
        builder.encodedPath(uriString);
        builder.appendPath(xid);

        builder.build();
        return builder.toString();
    }
}
