/**
 * @author Omer Muhammed on 03/16/2014.
 * Copyright 2014 (c) Jawbone. All rights reserved.
 *
 */
package com.jawbone.upplatformsdk.api.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.jawbone.upplatformsdk.datamodel.DataCollection;

import java.util.Map;

public class UpDataCollectionResponse extends UpBaseResponse {

    private final DataCollection data;

    @JsonCreator
    public UpDataCollectionResponse(Map<String, Object> delegate) {
        data = (DataCollection) delegate.get("data");
    }
}
