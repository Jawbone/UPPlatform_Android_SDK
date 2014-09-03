package com.jawbone.upplatformsdk.datamodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MealCollection extends DataCollection {

    @JsonProperty("items")
    public List<Meal> mealsList;

    public List<Meal> getMealsList() {
        return mealsList;
    }

    public void setMealsList(List<Meal> mealsList) {
        this.mealsList = mealsList;
    }
}
