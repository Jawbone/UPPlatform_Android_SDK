/**
 * @author Omer Muhammed
 * Copyright 2014 (c) Jawbone. All rights reserved.
 *
 */
package com.jawbone.upplatformsdk.datamodel;

public class Meta {

    protected int code;

    protected String message;

    protected String userXid;

    protected Integer time;

    protected String errorType;

    protected String errorDetail;

    protected String errorUserMsg;

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
