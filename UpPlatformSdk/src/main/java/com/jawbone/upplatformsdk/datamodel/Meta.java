/**
 * @author Omer Muhammed on 03/16/2014.
 * Copyright 2014 (c) Jawbone. All rights reserved.
 *
 */
package com.jawbone.upplatformsdk.datamodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Meta {

    @JsonProperty("code")
    public Integer code;

    @JsonProperty("message")
    public String message;

    @JsonProperty("user_xid")
    public String userXid;

    @JsonProperty("time")
    public Integer time;

    @JsonProperty("error_type")
    public String errorType;

    @JsonProperty("error_detail")
    public String errorDetail;

    @JsonProperty("error_user_msg")
    public String errorUserMsg;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getUserXid() {
        return userXid;
    }

    public Integer getTime() {
        return time;
    }

    public String getErrorType() {
        return errorType;
    }

    public String getErrorDetail() {
        return errorDetail;
    }

    public String getErrorUserMsg() {
        return errorUserMsg;
    }
}
