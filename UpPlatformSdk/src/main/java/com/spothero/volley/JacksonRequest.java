/*
 * Copyright (C) 2013 SpotHero
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.spothero.volley;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpStatus;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JacksonRequest<T> extends Request<T> {

    private static final int DEFAULT_TIMEOUT = 30000; // 30 seconds
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private Map<String, String> mParams;
    private List<Integer> mAcceptedStatusCodes;
    private final JacksonRequestListener<T> mListener;

    public JacksonRequest(int method, String url, JacksonRequestListener<T> listener) {
        this(DEFAULT_TIMEOUT, method, url, null, listener);
    }

    public JacksonRequest(int timeout, int method, String url, JacksonRequestListener<T> listener) {
        this(timeout, method, url, null, listener);
    }

    public JacksonRequest(int method, String baseUrl, String endpoint, Map<String, String> params, JacksonRequestListener<T> listener) {
        this(DEFAULT_TIMEOUT, method, baseUrl, endpoint, params, listener);
    }

    public JacksonRequest(int timeout, int method, String baseUrl, String endpoint, Map<String, String> params, JacksonRequestListener<T> listener) {
        this(timeout, method, getUrl(method, baseUrl, endpoint, params), params, listener);
    }

    public JacksonRequest(int method, String url, Map<String, String> params, JacksonRequestListener<T> listener) {
        this(DEFAULT_TIMEOUT, method, url, params, listener);
    }

    public JacksonRequest(int timeout, int method, String url, Map<String, String> params, JacksonRequestListener<T> listener) {
        super(method, url, null);

        setShouldCache(false);

        mListener = listener;

        mAcceptedStatusCodes = new ArrayList<Integer>();
        mAcceptedStatusCodes.add(HttpStatus.SC_OK);
        mAcceptedStatusCodes.add(HttpStatus.SC_NO_CONTENT);

        setRetryPolicy(new DefaultRetryPolicy(timeout, 1, 1));

        if (method == Method.POST || method == Method.PUT) {
            mParams = params;
        }
    }

    /**
     * Gets the ObjectMapper instance used when mapping network responses. Use this to customize the mapper in any way you see fit.
     *
     * @return The ObjectMapper instance used when mapping network responses
     */
    public static ObjectMapper getObjectMapper() {
        return OBJECT_MAPPER;
    }

    /**
     * Allows you to add additional status codes (besides 200 and 204) that will be parsed.
     *
     * @param statusCodes An array of additional status codes to parse network responses for
     */
    public void addAcceptedStatusCodes(int[] statusCodes) {
        for (int statusCode : statusCodes) {
            mAcceptedStatusCodes.add(statusCode);
        }
    }

    /**
     * Gets all status codes that will be parsed as successful (Note: some {@link com.android.volley.toolbox.HttpStack}
     * implementations, including the default, may not allow certain status codes to be parsed. To get around this
     * limitation, use a custom HttpStack, such as the one provided with the excellent OkHttp library
     *
     * @return A list of all status codes that will be counted as successful
     */
    public List<Integer> getAcceptedStatusCodes() {
        return mAcceptedStatusCodes;
    }

    /**
     * Converts a base URL, endpoint, and parameters into a full URL
     *
     * @param method The {@link com.android.volley.Request.Method} of the URL
     * @param baseUrl The base URL
     * @param endpoint The endpoint being hit
     * @param params The parameters to be appended to the URL if a GET method is used
     *
     * @return The full URL
     */
    private static String getUrl(int method, String baseUrl, String endpoint, Map<String, String> params) {
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                if (entry.getValue() == null || entry.getValue().equals("null")) {
                    entry.setValue("");
                }
            }
        }

        if (method == Method.GET && params != null && !params.isEmpty()) {
            final StringBuilder result = new StringBuilder(baseUrl + endpoint);
            final int startLength = result.length();
            for (String key : params.keySet()) {
                try {
                    final String encodedKey = URLEncoder.encode(key, "UTF-8");
                    final String encodedValue = URLEncoder.encode(params.get(key), "UTF-8");
                    if (result.length() > startLength) {
                        result.append("&");
                    } else {
                        result.append("?");
                    }
                    result.append(encodedKey);
                    result.append("=");
                    result.append(encodedValue);
                } catch (Exception e) { }
            }
            return result.toString();
        } else {
            return baseUrl + endpoint;
        }
    }

    @Override
    protected void deliverResponse(T response) {
        mListener.onResponse(response, HttpStatus.SC_OK, null);
    }

    @Override
    public void deliverError(VolleyError error) {
        int statusCode;
        if (error != null && error.networkResponse != null) {
            statusCode = error.networkResponse.statusCode;
        } else {
            statusCode = 0;
        }

        mListener.onResponse(null, statusCode, error);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        JavaType returnType = mListener.getReturnType();
        T returnData = null;
        if (returnType != null) {
            try {
                if (response.data != null) {
                    returnData = OBJECT_MAPPER.readValue(response.data, returnType);
                } else if (response instanceof JacksonNetworkResponse) {
                    returnData = OBJECT_MAPPER.readValue(((JacksonNetworkResponse)response).inputStream, returnType);
                }
            } catch (Exception e) {
                VolleyLog.e(e, "An error occurred while parsing network response:");
                return Response.error(new ParseError(response));
            }
        }
        return mListener.onParseResponseComplete(Response.success(returnData, HttpHeaderParser.parseCacheHeaders(response)));
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Accept", "application/json");

        if (getMethod() == Method.POST || getMethod() == Method.PUT) {
            headers.put("Content-Type", "application/x-www-form-urlencoded; charset=utf8");
        }

        return headers;
    }

    @Override
    public Map<String, String> getParams() {
        return mParams;
    }
}