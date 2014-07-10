/**
 * @author Omer Muhammed on 03/16/2014.
 * Copyright 2014 (c) Jawbone. All rights reserved.
 *
 */
package com.jawbone.upplatformsdk.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jawbone.upplatformsdk.datamodel.MealCollection;

public class GetMealsListResponse extends UpBaseResponse {

    @JsonProperty("data")
    public MealCollection data;

    public MealCollection getData() {
        return data;
    }

    public void setData(MealCollection data) {
        this.data = data;
    }
}
