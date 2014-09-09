/**
 * @author Omer Muhammed
 * Copyright 2014 (c) Jawbone. All rights reserved.
 *
 */
package com.jawbone.upplatformsdk.api;

import com.jawbone.upplatformsdk.api.response.OauthAccessTokenResponse;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkConstants;

import java.util.HashMap;

import retrofit.Callback;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.PartMap;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.http.QueryMap;

/**
 * Main interface for all API end points.
 */
public interface RestApiInterface {

    @GET("/auth/oauth2/token?grant_type=authorization_code")
    void getAccessToken(
        @Query("client_id") String clientId,
        @Query("client_secret") String clientSecret,
        @Query("code") String authorizationCode,
        Callback<OauthAccessTokenResponse> response
    );

    /*
     *
     * https://jawbone.com/up/developer/endpoints/meals
     *
     */
    @GET("/nudge/api/{version}/users/@me/meals")
    void getMealEventsList(
        @Path(UpPlatformSdkConstants.API_VERSION) String version,
        @QueryMap HashMap<String, Integer> hashMap,
        Callback<Object> response
    );

    @GET("/nudge/api/{version}/meals/{xid}")
    void getMealEvent(
        @Path(UpPlatformSdkConstants.API_VERSION) String version,
        @Path(UpPlatformSdkConstants.XID) String xid,
        Callback<Object> response
    );

    @DELETE("/nudge/api/{version}/meals/{xid}")
    void deleteMealEvent(
        @Path(UpPlatformSdkConstants.API_VERSION) String version,
        @Path(UpPlatformSdkConstants.XID) String xid,
        Callback<Object> response
    );

    @Multipart
    @POST("/nudge/api/{version}/users/@me/meals")
    void createMealEvent(
        @Path(UpPlatformSdkConstants.API_VERSION) String version,
        @PartMap HashMap<String, Object> hashMap,
        Callback<Object> response
    );

    @Multipart
    @POST("/nudge/api/{version}/meals/{xid}/partialUpdate")
    void updateMealEvent(
        @Path(UpPlatformSdkConstants.API_VERSION) String version,
        @Path(UpPlatformSdkConstants.XID) String xid,
        @PartMap HashMap<String, Object> hashMap,
        Callback<Object> response
    );

    /*
     *
     * https://jawbone.com/up/developer/endpoints/moves
     *
     */
    @GET("/nudge/api/{version}/users/@me/moves")
    void getMoveEventsList(
        @Path(UpPlatformSdkConstants.API_VERSION) String version,
        @QueryMap HashMap<String, Integer> hashMap,
        Callback<Object> response
    );

    @GET("/nudge/api/{version}/moves/{xid}")
    void getMoveEvent(
        @Path(UpPlatformSdkConstants.API_VERSION) String version,
        @Path(UpPlatformSdkConstants.XID) String xid,
        Callback<Object> response
    );

    @GET("/nudge/api/{version}/moves/{xid}/image")
    void getMoveGraph(
        @Path(UpPlatformSdkConstants.API_VERSION) String version,
        @Path(UpPlatformSdkConstants.XID) String xid,
        Callback<Object> response
    );

    @GET("/nudge/api/{version}/moves/{xid}/ticks")
    void getMoveTicks(
        @Path(UpPlatformSdkConstants.API_VERSION) String version,
        @Path(UpPlatformSdkConstants.XID) String xid,
        Callback<Object> response
    );

    /*
     *
     * https://jawbone.com/up/developer/endpoints/custom
     *
     */
    @GET("/nudge/api/{version}/users/@me/generic_events")
    void getCustomEventsList(
        @Path(UpPlatformSdkConstants.API_VERSION) String version,
        @QueryMap HashMap<String, Integer> hashMap,
        Callback<Object> response
    );

    @Multipart
    @POST("/nudge/api/{version}/users/@me/generic_events")
    void createCustomEvent(
        @Path(UpPlatformSdkConstants.API_VERSION) String version,
        @PartMap HashMap<String, Object> hashMap,
        Callback<Object> response
    );

    @Multipart
    @POST("/nudge/api/{version}/generic_events/{xid}/partialUpdate")
    void updateCustomEvent(
        @Path(UpPlatformSdkConstants.API_VERSION) String version,
        @PartMap HashMap<String, Object> hashMap,
        Callback<Object> response
    );

    @DELETE("/nudge/api/{version}/generic_events/{xid}")
    void deleteCustomEvent(
        @Path(UpPlatformSdkConstants.API_VERSION) String version,
        @Path(UpPlatformSdkConstants.XID) String xid,
        Callback<Object> response
    );

    /*
     *
     * https://jawbone.com/up/developer/endpoints/workouts
     *
     */
    @GET("/nudge/api/{version}/users/@me/workouts")
    void getWorkoutEventList(
        @Path(UpPlatformSdkConstants.API_VERSION) String version,
        @QueryMap HashMap<String, Integer> hashMap,
        Callback<Object> response
    );

    @GET("/nudge/api/{version}/workouts/{xid}")
    void getWorkoutEvent(
        @Path(UpPlatformSdkConstants.API_VERSION) String version,
        @Path(UpPlatformSdkConstants.XID) String xid,
        Callback<Object> response
    );

    @GET("/nudge/api/{version}/workouts/{xid}/image")
    void getWorkoutGraph(
        @Path(UpPlatformSdkConstants.API_VERSION) String version,
        @Path(UpPlatformSdkConstants.XID) String xid,
        Callback<Object> response
    );

    @GET("/nudge/api/{version}/workouts/{xid}/ticks")
    void getWorkoutTicks(
        @Path(UpPlatformSdkConstants.API_VERSION) String version,
        @Path(UpPlatformSdkConstants.XID) String xid,
        Callback<Object> response
    );

    @Multipart
    @POST("/nudge/api/{version}/users/@me/workouts")
    void createWorkoutEvent(
        @Path(UpPlatformSdkConstants.API_VERSION) String version,
        @PartMap HashMap<String, Object> hashMap,
        Callback<Object> response
    );

    @Multipart
    @POST("/nudge/api/{version}/workouts/{xid}/partialUpdate")
    void updateWorkoutEvent(
        @Path(UpPlatformSdkConstants.API_VERSION) String version,
        @PartMap HashMap<String, Object> hashMap,
        Callback<Object> response
    );

    @DELETE("/nudge/api/{version}/workouts/{xid}")
    void deleteWorkoutEvent(
        @Path(UpPlatformSdkConstants.API_VERSION) String version,
        @Path(UpPlatformSdkConstants.XID) String xid,
        Callback<Object> response
    );

    /*
     *
     * https://jawbone.com/up/developer/endpoints/sleeps
     *
     */
    @GET("/nudge/api/{version}/users/@me/sleeps")
    void getSleepEventsList(
        @Path(UpPlatformSdkConstants.API_VERSION) String version,
        @QueryMap HashMap<String, Integer> hashMap,
        Callback<Object> response
    );

    @GET("/nudge/api/{version}/sleeps/{xid}")
    void getSleepEvent(
        @Path(UpPlatformSdkConstants.API_VERSION) String version,
        @Path(UpPlatformSdkConstants.XID) String xid,
        Callback<Object> response
    );

    @GET("/nudge/api/{version}/sleeps/{xid}/image")
    void getSleepGraph(
        @Path(UpPlatformSdkConstants.API_VERSION) String version,
        @Path(UpPlatformSdkConstants.XID) String xid,
        Callback<Object> response
    );

    @GET("/nudge/api/{version}/sleeps/{xid}/ticks")
    void getSleepPhases(
        @Path(UpPlatformSdkConstants.API_VERSION) String version,
        @Path(UpPlatformSdkConstants.XID) String xid,
        Callback<Object> response
    );

    @Multipart
    @POST("/nudge/api/{version}/users/@me/sleeps")
    void createSleepEvent(
        @Path(UpPlatformSdkConstants.API_VERSION) String version,
        @PartMap HashMap<String, Object> hashMap,
        Callback<Object> response
    );

    @DELETE("/nudge/api/{version}/sleeps/{xid}")
    void deleteSleepEvent(
        @Path(UpPlatformSdkConstants.API_VERSION) String version,
        @Path(UpPlatformSdkConstants.XID) String xid,
        Callback<Object> response
    );

    /*
     *
     * https://jawbone.com/up/developer/endpoints/body
     *
     */
    @GET("/nudge/api/{version}/users/@me/body_events")
    void getBodyEventsList(
        @Path(UpPlatformSdkConstants.API_VERSION) String version,
        @QueryMap HashMap<String, Integer> hashMap,
        Callback<Object> response
    );

    @GET("/nudge/api/{version}/body_events/{xid}")
    void getBodyEvent(
        @Path(UpPlatformSdkConstants.API_VERSION) String version,
        @Path(UpPlatformSdkConstants.XID) String xid,
        Callback<Object> response
    );

    @Multipart
    @POST("/nudge/api/{version}/users/@me/body_events")
    void createBodyEvent(
        @Path(UpPlatformSdkConstants.API_VERSION) String version,
        @PartMap HashMap<String, Object> hashMap,
        Callback<Object> response
    );

    @DELETE("/nudge/api/{version}/body_events/{xid}")
    void deleteBodyEvent(
        @Path(UpPlatformSdkConstants.API_VERSION) String version,
        @Path(UpPlatformSdkConstants.XID) String xid,
        Callback<Object> response
    );

    /*
     *
     * https://jawbone.com/up/developer/endpoints/bandevents
     *
     */
    @GET("/nudge/api/{version}/users/@me/bandevents")
    void getBandEvents(
        @Path(UpPlatformSdkConstants.API_VERSION) String version,
        @QueryMap HashMap<String, Integer> hashMap,
        Callback<Object> response
    );

    /*
     *
     * https://jawbone.com/up/developer/endpoints/goals
     *
     */
    @GET("/nudge/api/{version}/users/@me/goals")
    void getUsersGoals(
        @Path(UpPlatformSdkConstants.API_VERSION) String version,
        Callback<Object> response
    );

    @Multipart
    @POST("/nudge/api/{version}/users/@me/goals")
    void createOrUpdateUsersGoals(
        @Path(UpPlatformSdkConstants.API_VERSION) String version,
        @PartMap HashMap<String, Object> hashMap,
        Callback<Object> response
    );

    /*
     *
     * https://jawbone.com/up/developer/endpoints/mood
     *
     */
    @GET("/nudge/api/{version}/users/@me/mood")
    void getMoodEventsList(
            @Path(UpPlatformSdkConstants.API_VERSION) String version,
            @Query("date") String date,
            Callback<Object> response
    );

    @GET("/nudge/api/{version}/mood/{xid}")
    void getMoodEvent(
            @Path(UpPlatformSdkConstants.API_VERSION) String version,
            @Path(UpPlatformSdkConstants.XID) String xid,
            Callback<Object> response
    );

    @Multipart
    @POST("/nudge/api/{version}/users/@me/mood")
    void createMoodEvent(
            @Path(UpPlatformSdkConstants.API_VERSION) String version,
            @PartMap HashMap<String, Object> hashMap,
            Callback<Object> response
    );

    @DELETE("/nudge/api/{version}/mood/{xid}")
    void deleteMoodEvent(
            @Path(UpPlatformSdkConstants.API_VERSION) String version,
            @Path(UpPlatformSdkConstants.XID) String xid,
            Callback<Object> response
    );

    /*
     *
     * https://jawbone.com/up/developer/endpoints/refreshtoken
     *
     */
    @Multipart
    @POST("/nudge/api/{version}/users/@me/refreshToken")
    void getRefreshToken(
            @Path(UpPlatformSdkConstants.API_VERSION) String version,
            @Part("secret") String clientSecret,
            Callback<Object> response
    );

    /*
     *
     * https://jawbone.com/up/developer/endpoints/settings
     *
     */
    @GET("/nudge/api/{version}/users/@me/settings")
    void getUserSettings(
            @Path(UpPlatformSdkConstants.API_VERSION) String version,
            Callback<Object> response
    );

    /*
     *
     * https://jawbone.com/up/developer/endpoints/timezone
     *
     */
    @GET("/nudge/api/{version}/users/@me/timezone")
    void getTimeZone(
            @Path(UpPlatformSdkConstants.API_VERSION) String version,
            @QueryMap HashMap<String, Integer> hashMap,
            Callback<Object> response
    );

    /*
     *
     * https://jawbone.com/up/developer/endpoints/trends
     *
     */
    @GET("/nudge/api/{version}/users/@me/trends")
    void getTrends(
            @Path(UpPlatformSdkConstants.API_VERSION) String version,
            @QueryMap HashMap<String, Object> hashMap,
            Callback<Object> response
    );

    /*
     *
     * https://jawbone.com/up/developer/endpoints/user
     *
     */
    @GET("/nudge/api/{version}/users/@me")
    void getUser(
            @Path(UpPlatformSdkConstants.API_VERSION) String version,
            Callback<Object> response
    );

    @GET("/nudge/api/{version}/users/@me/friends")
    void getUsersFriends(
            @Path(UpPlatformSdkConstants.API_VERSION) String version,
            Callback<Object> response
    );
}