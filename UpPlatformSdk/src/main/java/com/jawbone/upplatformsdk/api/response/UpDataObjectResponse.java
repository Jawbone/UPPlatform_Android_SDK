/**
 * @author Omer Muhammed on 03/16/2014.
 * Copyright 2014 (c) Jawbone. All rights reserved.
 *
 */
package com.jawbone.upplatformsdk.api.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.jawbone.upplatformsdk.datamodel.DataObject;

import java.util.Map;

public class UpDataObjectResponse extends UpBaseResponse {

    private final DataObject data;

    @JsonCreator
    public UpDataObjectResponse(Map<String, Object> delegate) {
        data = (DataObject) delegate.get("data");
    }

}
