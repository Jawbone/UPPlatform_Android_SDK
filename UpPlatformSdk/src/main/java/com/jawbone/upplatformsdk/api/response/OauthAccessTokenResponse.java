/**
 * @author Omer Muhammed on 03/16/2014.
 * Copyright 2014 (c) Jawbone. All rights reserved.
 *
 */
package com.jawbone.upplatformsdk.api.response;

//import com.fasterxml.jackson.annotation.JsonProperty;
//
///**
// * Note that since this is the call for accessToken, the server response is not
// * of the form:
// * {
// *      “meta”: { ... Response Metadata ... },
// *      “data”: { ... Resource or Collection ... }
// * }
// *
// * All other API calls have this response format
// */
//public class OauthAccessTokenResponse {
//
//    @JsonProperty("expires_in")
//    public int expiresIn;
//
//    @JsonProperty("token_type")
//    public String tokenType;
//
//    @JsonProperty("access_token")
//    public String accessToken;
//
//    @JsonProperty("refresh_token")
//    public String refreshToken;
//}

public class OauthAccessTokenResponse {
    public int expires_in;
    public String token_type;
    public String access_token;
    public String refresh_token;
}
