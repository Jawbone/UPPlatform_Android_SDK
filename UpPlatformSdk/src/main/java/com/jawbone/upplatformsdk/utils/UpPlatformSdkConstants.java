/**
 * @author Omer Muhammed
 * Copyright 2014 (c) Jawbone. All rights reserved.
 *
 */
package com.jawbone.upplatformsdk.utils;

/**
 * Small class to hold the constants
 */
public class UpPlatformSdkConstants {

    public static final String URI_SCHEME = "https";
    public static final String AUTHORITY = "jawbone.com";

    public static final String API_VERSION = "version";
    public static final String API_VERSION_STRING = "v.1.1";
    public static final String XID = "xid";

    public static final String UP_PLATFORM_ACCESS_TOKEN = "access_token";
    public static final String UP_PLATFORM_REFRESH_TOKEN = "refresh_token";

    public static final String AUTH_URI = "auth_uri";
    public static final String ACCESS_CODE = "code";
    public static final String CLIENT_SECRET = "client_secret";
    public static final int JAWBONE_AUTHORIZE_REQUEST_CODE = 120501;
    public static final String API_URL = "https://jawbone.com";

    /**
     * Different types of API permissions that can be requested, defined as an enum
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
     * Different API calls, defined in an enum, to facilitate reuse.
     */
    public static enum RestApiRequestType {
        GET_MEALS_EVENTS_LIST("Get Meals Events List"), //0
        GET_MEALS_EVENT("Get Meals Event"), //1
        DELETE_MEAL("Delete Meal"), //2
        CREATE_MEAL("Create Meal"), //3
        UPDATE_MEAL("Update Meal"), //4
        GET_MOVES_EVENTS_LIST("Get Moves Events List"), //5
        GET_MOVES_EVENT("Get Moves Event"), //6
        GET_MOVES_GRAPH("Get Moves Graph"), //7
        GET_MOVES_TICKS("Get Moves Ticks"), //8
        GET_CUSTOM_EVENTS_LIST("Get Custom Events List"), //9
        CREATE_CUSTOM_EVENT("Create Custom Event"), //10
        UPDATE_CUSTOM_EVENT("Update Custom Event"), //11
        DELETE_CUSTOM_EVENT("Delete Custom Event"), //12
        GET_WORKOUTS_EVENTS_LIST("Get Workouts Events List"), //13
        GET_WORKOUTS_EVENT("Get Workouts Event"), //14
        GET_WORKOUTS_GRAPH("Get Workouts Graph"), //15
        GET_WORKOUTS_TICKS("Get Workouts Ticks"), //16
        CREATE_WORKOUT_EVENT("Create Workout Event"), //17
        UPDATE_WORKOUT_EVENT("Update Workout Event"), //18
        DELETE_WORKOUT_EVENT("Delete Workout Event"), //19
        GET_SLEEP_EVENTS_LIST("Get Sleep Events List"), //20
        GET_SLEEP_EVENT("Get Sleep Event"), //21
        GET_SLEEP_GRAPH("Get Sleep Graph"), //22
        GET_SLEEP_TICKS("Get Sleep Ticks"), //23
        CREATE_SLEEP_EVENT("Create Sleep Event"), //24
        DELETE_SLEEP_EVENT("Delete Sleep Event"), //25
        GET_BODY_EVENTS_LIST("Get Body Events List"), //26
        GET_BODY_EVENT("Get Body Event"), //27
        CREATE_BODY_EVENT("Create Body Event"), //28
        DELETE_BODY_EVENT("Delete Body Event"), //29
        GET_BAND_EVENTS("Get Band Events"), //30
        GET_GOALS("Get Goals"), //31
        CREATE_OR_UPDATE_GOALS("Create or Update Goals"), //32
        GET_MOOD_EVENTS_LIST("Get Moods Events List"), //33
        GET_MOOD_EVENT("Get Mood Event"), //34
        CREATE_MOOD_EVENT("Create Mood Event"), //35
        DELETE_MOOD_EVENT("Delete Mood Event"), //36
        GET_REFRESH_TOKEN("Get Refresh Token"), //37
        GET_SETTINGS("Get Settings"), //38
        GET_TIME_ZONE("Get Time Zone"), //39
        GET_TRENDS("Get Trends"), //40
        GET_USER("Get User"), //41
        GET_USERS_FRIENDS("Get Users Friends"); //42

        private String displayTitle;

        RestApiRequestType(String s) {
            this.displayTitle = s;
        }

        @Override
        public String toString() {
            return displayTitle;
        }

        public static final int size = RestApiRequestType.values().length;
    }
}
