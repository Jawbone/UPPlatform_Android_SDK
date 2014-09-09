/**
 * @author Omer Muhammed
 * Copyright 2014 (c) Jawbone. All rights reserved.
 *
 */
package com.jawbone.upplatformsdk.datamodel;

public class Meta {

    public Integer code;

    public String message;

    public String userXid;

    public Integer time;

    public String errorType;

    public String errorDetail;

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
