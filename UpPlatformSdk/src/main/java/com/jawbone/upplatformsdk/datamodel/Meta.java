/**
 * @author Omer Muhammed
 * Copyright 2014 (c) Jawbone. All rights reserved.
 *
 * Edited by Marcus Gabilheri.
 *
 */
package com.jawbone.upplatformsdk.datamodel;
import com.google.gson.annotations.SerializedName;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkUtils;

public class Meta {

    @SerializedName("code")
    public Integer code;

    @SerializedName("message")
    public String message;

    @SerializedName("user_xid")
    public String userXid;

    @SerializedName("time")
    public Integer time;

    @SerializedName("error_type")
    public String errorType;

    @SerializedName("error_detail")
    public String errorDetail;

    @SerializedName("error_user_msg")
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

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUserXid(String userXid) {
        this.userXid = userXid;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public void setErrorDetail(String errorDetail) {
        this.errorDetail = errorDetail;
    }

    public void setErrorUserMsg(String errorUserMsg) {
        this.errorUserMsg = errorUserMsg;
    }

    @Override
    public String toString() {
        return UpPlatformSdkUtils.toJson(this);
    }
}
