/**
 * @author Omer Muhammed on 03/16/2014.
 * Copyright 2014 (c) Jawbone. All rights reserved.
 *
 */
package com.jawbone.upplatformsdk.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jawbone.upplatformsdk.datamodel.Meta;

public class UpBaseResponse {

    @JsonProperty("meta")
    public Meta meta;

    public Meta getMeta() {
        return meta;
    }
}
