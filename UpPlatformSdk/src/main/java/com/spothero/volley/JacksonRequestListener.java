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

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.fasterxml.jackson.databind.JavaType;

public abstract class JacksonRequestListener<T> {
	/**
	 * Called when the network call has returned and the result has been parsed
	 *
	 * @param response The parsed response, or null if an error occurred
	 * @param statusCode The status code of the response
	 * @param error The error that occurred, or null if successful
	 */
	public abstract void onResponse(T response, int statusCode, VolleyError error);

	/**
	 * Called by the library to get the {@link com.fasterxml.jackson.databind.JavaType}
	 * used to parse the network response. For simple POJOs, return a
	 * {@link com.fasterxml.jackson.databind.type.SimpleType}. For lists and arrays,
	 * return one of the values constructed using {@link com.fasterxml.jackson.databind.type.TypeFactory}
	 *
	 * @return The type that the network response should be parsed into.
	 */
	public abstract JavaType getReturnType();

	/**
	 * Optional method that is called on the networking thread used to further process
	 * responses before delivering them to the UI thread.
	 */
	public Response<T> onParseResponseComplete(Response<T> response) { return response; } 
}
