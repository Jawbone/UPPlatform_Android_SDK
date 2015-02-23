/**
 * @author Omer Muhammed
 * Copyright 2014 (c) Jawbone. All rights reserved.
 *
 */
package com.jawbone.upplatformsdk.datamodel;

import com.jawbone.upplatformsdk.utils.UpPlatformSdkUtils;

public class Links {

    public String next;
    public String prev;

    public Links() {
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return UpPlatformSdkUtils.toJson(this);
    }
}
