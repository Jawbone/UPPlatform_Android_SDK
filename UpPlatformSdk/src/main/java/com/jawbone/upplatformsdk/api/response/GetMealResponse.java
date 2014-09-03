package com.jawbone.upplatformsdk.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jawbone.upplatformsdk.datamodel.Meal;

public class GetMealResponse extends UpBaseResponse {

    @JsonProperty("data")
    public Meal data;

    public Meal getData() {
        return data;
    }

    public void setData(Meal data) {
        this.data = data;
    }
}
