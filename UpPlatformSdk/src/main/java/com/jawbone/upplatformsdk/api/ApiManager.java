package com.jawbone.upplatformsdk.api;

import retrofit.ErrorHandler;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ApiManager {
    private static final String API_URL = "https://jawbone.com";

    private static RestAdapter restAdapter;
    private static RestApiInterface restApiInterface;

    private static RestAdapter getRestAdapter() {
        if (restAdapter == null) {
            restAdapter = new RestAdapter.Builder()
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setErrorHandler(new MyErrorHandler())
                    .setEndpoint(API_URL)
                    .build();
        }
        return restAdapter;
    }

    public static RestApiInterface getRestApiInterface() {
        restAdapter = getRestAdapter();
        if (restApiInterface == null) {
            restApiInterface = restAdapter.create(RestApiInterface.class);
        }
        return restApiInterface;
    }

    //Omer TODO elaborate on this to handle 401 more clearly
    private static class MyErrorHandler implements ErrorHandler {
        @Override public Throwable handleError(RetrofitError cause) {
            Response r = cause.getResponse();
            if (r != null && r.getStatus() == 401) {
                return cause.getCause();
            }
            return cause;
        }
    }
}