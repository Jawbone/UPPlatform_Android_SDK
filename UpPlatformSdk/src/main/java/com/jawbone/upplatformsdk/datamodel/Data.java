/**
 * @author Omer Muhammed
 * Copyright 2014 (c) Jawbone. All rights reserved.
 *
 */
package com.jawbone.upplatformsdk.datamodel;

import com.jawbone.upplatformsdk.utils.UpPlatformSdkUtils;

public class Data {

    public String xid;

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    @Override
    public String toString() {
        return UpPlatformSdkUtils.toJson(this);
    }
}

