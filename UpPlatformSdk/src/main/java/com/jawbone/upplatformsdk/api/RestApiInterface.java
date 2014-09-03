package com.jawbone.upplatformsdk.api;

import com.jawbone.upplatformsdk.api.response.OauthAccessTokenResponse;

import retrofit.Callback;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.Path;
import retrofit.http.Query;

public interface RestApiInterface {

    @GET("/auth/oauth2/token?grant_type=authorization_code")
    void getAccessToken(
            @Query("client_id") String clientId,
            @Query("client_secret") String clientSecret,
            @Query("code") String authorizationCode,
            Callback<OauthAccessTokenResponse> response
    );

    @GET("/nudge/api/{version}/users/@me/meals")
    void getMealsList(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Query("date") String date,
            @Query("page_token") String pageToken,
            @Query("start_time") String startTime,
            @Query("end_time") String endTime,
            @Query("updated_after") String updatedAfter,
            Callback<Object> response
    );

    @GET("/nudge/api/{version}/meals/{xid}")
    void getMealEvent(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Path("xid") String xid,
            Callback<Object> response
    );

    @DELETE("/nudge/api/{version}/meals/{xid}")
    void deleteMealEvent(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Path("xid") String xid,
            Callback<Object> response
    );

    @Multipart
    @POST("/nudge/api/{version}/users/@me/meals")
    void createMealEvent(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Part("note") String title,
            @Part("sub_type") String subType,
            @Part("image_url") String image_url,
            @Part("photo") String photo,
            Callback<Object> response
    );

    @Multipart
    @POST("/nudge/api/{version}/meals/{xid}/partialUpdate")
    void updateMealEvent(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Path("xid") String xid,
            @Part("note") String title,
            @Part("sub_type") String subType,
            @Part("image_url") String image_url,
            @Part("photo") String photo,
            Callback<Object> response
    );

    @GET("/nudge/api/{version}/users/@me/moves")
    void getMoveEventsList(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Query("date") String date,
            @Query("page_token") String pageToken,
            @Query("start_time") String startTime,
            @Query("end_time") String endTime,
            @Query("updated_after") String updatedAfter,
            Callback<Object> response
    );

    @GET("/nudge/api/{version}/moves/{xid}")
    void getMoveEvent(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Path("xid") String xid,
            Callback<Object> response
    );

    @GET("/nudge/api/{version}/moves/{xid}/image")
    void getMoveGraph(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Path("xid") String xid,
            Callback<Object> response
    );

    @GET("/nudge/api/{version}/moves/{xid}/ticks")
    void getMoveTicks(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Path("xid") String xid,
            Callback<Object> response
    );

    @GET("/nudge/api/{version}/users/@me/generic_events")
    void getCustomEventsList(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Query("date") String date,
            @Query("page_token") String pageToken,
            @Query("start_time") String startTime,
            @Query("end_time") String endTime,
            @Query("updated_after") String updatedAfter,
            @Query("limit") String limit,
            Callback<Object> response
    );

    @Multipart
    @POST("/nudge/api/{version}/users/@me/generic_events")
    void createCustomEvent(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Part("title") String title,
            @Part("verb") String verb,
            @Part("attributes") String attributes,
            @Part("note") String note,
            @Part("image_url") String image_url,
            Callback<Object> response
    );

    @Multipart
    @POST("/nudge/api/{version}/generic_events/{xid}/partialUpdate")
    void updateCustomEvent(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Path("xid") String xid,
            @Part("title") String title,
            @Part("verb") String verb,
            @Part("attributes") String attributes,
            @Part("note") String note,
            @Part("image_url") String image_url,
            Callback<Object> response
    );

    @DELETE("/nudge/api/{version}/generic_events/{xid}")
    void deleteCustomEvent(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Path("xid") String xid,
            Callback<Object> response
    );

    @GET("/nudge/api/{version}/users/@me/workouts")
    void getWorkoutEventList(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Query("date") String date,
            @Query("page_token") String pageToken,
            @Query("start_time") String startTime,
            @Query("end_time") String endTime,
            @Query("updated_after") String updatedAfter,
            @Query("limit") String limit,
            Callback<Object> response
    );

    @GET("/nudge/api/{version}/workouts/{xid}")
    void getWorkoutEvent(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Path("xid") String xid,
            Callback<Object> response
    );

    @GET("/nudge/api/{version}/workouts/{xid}/image")
    void getWorkoutGraph(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Path("xid") String xid,
            Callback<Object> response
    );

    @GET("/nudge/api/{version}/workouts/{xid}/ticks")
    void getWorkoutTicks(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Path("xid") String xid,
            Callback<Object> response
    );

    @Multipart
    @POST("/nudge/api/{version}/users/@me/workouts")
    void createWorkoutEvent(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Part("sub_type") String subType,
            @Part("time_created") String timeCreated,
            @Part("time_completed") String timeCompleted,
            Callback<Object> response
    );

    @Multipart
    @POST("/nudge/api/{version}/workouts/{xid}/partialUpdate")
    void updateWorkoutEvent(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Part("sub_type") String subType,
            @Part("time_created") String timeCreated,
            @Part("time_completed") String timeCompleted,
            Callback<Object> response
    );

    @DELETE("/nudge/api/{version}/workouts/{xid}")
    void deleteWorkoutEvent(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Path("xid") String xid,
            Callback<Object> response
    );

    @GET("/nudge/api/{version}/users/@me/sleeps")
    void getSleepEventsList(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Query("date") String date,
            @Query("page_token") String pageToken,
            @Query("start_time") String startTime,
            @Query("end_time") String endTime,
            @Query("updated_after") String updatedAfter,
            Callback<Object> response
    );

    @GET("/nudge/api/{version}/sleeps/{xid}")
    void getSleepEvent(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Path("xid") String xid,
            Callback<Object> response
    );

    @GET("/nudge/api/{version}/sleeps/{xid}/image")
    void getSleepGraph(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Path("xid") String xid,
            Callback<Object> response
    );

    @GET("/nudge/api/{version}/sleeps/{xid}/ticks")
    void getSleepPhases(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Path("xid") String xid,
            Callback<Object> response
    );

    @Multipart
    @POST("/nudge/api/{version}/users/@me/sleeps")
    void createSleepEvent(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Part("time_created") String timeCreated,
            @Part("time_completed") String timeCompleted,
            @Part("tz") String timeZone,
            @Part("share") boolean shareSleep,
            Callback<Object> response
    );

    @DELETE("/nudge/api/{version}/sleeps/{xid}")
    void deleteSleepEvent(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Path("xid") String xid,
            Callback<Object> response
    );

    @GET("/nudge/api/{version}/users/@me/body_events")
    void getBodyEventsList(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Query("date") String date,
            @Query("page_token") String pageToken,
            @Query("start_time") String startTime,
            @Query("end_time") String endTime,
            @Query("updated_after") String updatedAfter,
            @Query("limit") String limit,
            Callback<Object> response
    );

    @GET("/nudge/api/{version}/body_events/{xid}")
    void getBodyEvent(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Path("xid") String xid,
            Callback<Object> response
    );

    @Multipart
    @POST("/nudge/api/{version}/users/@me/body_events")
    void createBodyEvent(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Part("title") String title,
            @Part("weight") String weight,
            @Part("body_fat") String bodyFat,
            @Part("lean_mass") String leanMass,
            @Part("bmi") String bmi,
            @Part("note") String note,
            @Part("time_completed") String timeCompleted,
            @Part("tz") String timeZone,
            @Part("share") boolean shareSleep,
            Callback<Object> response
    );

    @DELETE("/nudge/api/{version}/body_events/{xid}")
    void deleteBodyEvent(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Path("xid") String xid,
            Callback<Object> response
    );

    @GET("/nudge/api/{version}/users/@me/bandevents")
    void getBandEvents(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Query("date") String date,
            @Query("start_time") String startTime,
            @Query("end_time") String endTime,
            @Query("created_after") String createdAfter,
            Callback<Object> response
    );

    @GET("/nudge/api/{version}/users/@me/goals")
    void getUsersGoals(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            Callback<Object> response
    );

    @Multipart
    @POST("/nudge/api/{version}/users/@me/goals")
    void createOrUpdateUsersGoals(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Part("move_steps") String moveGoal,
            @Part("sleep_total") String sleepGoal,
            @Part("body_weight") String weightGoal,
            @Part("body_weight_intent") String weightGoalIntent,
            Callback<Object> response
    );

    @GET("/nudge/api/{version}/users/@me/mood")
    void getMoodsList(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Query("date") String date,
            Callback<Object> response
    );

    @GET("/nudge/api/{version}/mood/{xid}")
    void getSingleMood(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Path("xid") String xid,
            Callback<Object> response
    );

    @Multipart
    @POST("/nudge/api/{version}/users/@me/mood")
    void createMoodEvent(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Part("title") String title,
            @Part("sub_type") String subType,
            @Part("time_created") String timeCreated,
            @Part("tz") String timeZone,
            @Part("share") boolean shareSleep,
            Callback<Object> response
    );

    @DELETE("/nudge/api/{version}/mood/{xid}")
    void deleteSingleMood(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Path("xid") String xid,
            Callback<Object> response
    );

    @Multipart
    @POST("/nudge/api/{version}/users/@me/refreshToken")
    void getRefreshToken(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Part("secret") String clientSecret,
            Callback<Object> response
    );

    @GET("/nudge/api/{version}/users/@me/settings")
    void getUserSettings(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            Callback<Object> response
    );

    @GET("/nudge/api/{version}/users/@me/timezone")
    void getTimeZone(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Query("date") String date,
            @Query("start_time") String startTime,
            @Query("end_time") String endTime,
            @Query("timestamp") String timestamp,
            Callback<Object> response
    );

    @GET("/nudge/api/{version}/users/@me/trends")
    void getTrends(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            @Query("end_date") String date,
            @Query("bucket_size") String bucketSize,
            @Query("num_buckets") String numberOfBuckets,
            Callback<Object> response
    );

    @GET("/nudge/api/{version}/users/@me")
    void getUser(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            Callback<Object> response
    );

    @GET("/nudge/api/{version}/users/@me/friends")
    void getUsersFriends(
            @Header("Authorization") String authorization,
            @Header("Accept") String applicationType,
            @Path("version") String version,
            Callback<Object> response
    );
}