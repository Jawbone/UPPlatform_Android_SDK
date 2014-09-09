/**
 * @author Omer Muhammed
 * Copyright 2014 (c) Jawbone. All rights reserved.
 *
 */
package com.jawbone.upplatformsdk.api.response;

/**
 * Note that since this is the call for accessToken, the server response is not
 * of the form:
 * {
 *      “meta”: { ... Response Metadata ... },
 *      “data”: { ... Resource or Collection ... }
 * }
 *
 * All other API calls have this response format
*/

public class OauthAccessTokenResponse {
    public int expires_in;
    public String token_type;
    public String access_token;
    public String refresh_token;
}
