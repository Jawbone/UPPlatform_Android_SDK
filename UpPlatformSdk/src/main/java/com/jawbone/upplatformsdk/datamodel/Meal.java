/**
 * @author Omer Muhammed on 03/16/2014.
 * Copyright 2014 (c) Jawbone. All rights reserved.
 *
 */
package com.jawbone.upplatformsdk.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Meal extends DataObject {

    @JsonProperty("title")
    public String mealTitle;

    @JsonProperty("note")
    public String mealNote;

//    @JsonProperty("type")
//    public String mealType;

    @JsonProperty("sub_type")
    public int mealSubtype;

    @JsonProperty("time_created")
    public int mealCreationTime;

    @JsonProperty("time_updated")
    public int mealUpdateTime;

    @JsonProperty("time_completed")
    public int mealCompletionTime;

    @JsonProperty("date")
    public int mealCreationDate;

    @JsonProperty("place_lat")
    public float mealLocationLatitude;

    @JsonProperty("place_lon")
    public float mealLocationLongitude;

    @JsonProperty("place_acc")
    public int mealLocationAccuracy;

    @JsonProperty("place_name")
    public String mealLocationName;

    @JsonProperty("place_type")
    public String mealLocationType;

    @JsonProperty("image_url")
    public String mealImageUrl;

    @JsonProperty("details")
    public MealDetails mealDetails;

    public boolean mealSharingPreference;

    public Object mealPhoto;

    public String getMealTitle() {
        return mealTitle;
    }

    public void setMealTitle(String mealTitle) {
        this.mealTitle = mealTitle;
    }

    public String getMealNote() {
        return mealNote;
    }

    public void setMealNote(String mealNote) {
        this.mealNote = mealNote;
    }

//    public String getMealType() {
//        return mealType;
//    }
//
//    public void setMealType(String mealType) {
//        this.mealType = mealType;
//    }

    public int getMealSubtype() {
        return mealSubtype;
    }

    public void setMealSubtype(int mealSubtype) {
        this.mealSubtype = mealSubtype;
    }

    public int getMealCreationTime() {
        return mealCreationTime;
    }

    public void setMealCreationTime(int mealCreationTime) {
        this.mealCreationTime = mealCreationTime;
    }

    public int getMealUpdateTime() {
        return mealUpdateTime;
    }

    public void setMealUpdateTime(int mealUpdateTime) {
        this.mealUpdateTime = mealUpdateTime;
    }

    public int getMealCompletionTime() {
        return mealCompletionTime;
    }

    public void setMealCompletionTime(int mealCompletionTime) {
        this.mealCompletionTime = mealCompletionTime;
    }

    public int getMealCreationDate() {
        return mealCreationDate;
    }

    public void setMealCreationDate(int mealCreationDate) {
        this.mealCreationDate = mealCreationDate;
    }

    public float getMealLocationLatitude() {
        return mealLocationLatitude;
    }

    public void setMealLocationLatitude(float mealLocationLatitude) {
        this.mealLocationLatitude = mealLocationLatitude;
    }

    public float getMealLocationLongitude() {
        return mealLocationLongitude;
    }

    public void setMealLocationLongitude(float mealLocationLongitude) {
        this.mealLocationLongitude = mealLocationLongitude;
    }

    public int getMealLocationAccuracy() {
        return mealLocationAccuracy;
    }

    public void setMealLocationAccuracy(int mealLocationAccuracy) {
        this.mealLocationAccuracy = mealLocationAccuracy;
    }

    public String getMealLocationName() {
        return mealLocationName;
    }

    public void setMealLocationName(String mealLocationName) {
        this.mealLocationName = mealLocationName;
    }

    public String getMealLocationType() {
        return mealLocationType;
    }

    public void setMealLocationType(String mealLocationType) {
        this.mealLocationType = mealLocationType;
    }

    public String getMealImageUrl() {
        return mealImageUrl;
    }

    public void setMealImageUrl(String mealImageUrl) {
        this.mealImageUrl = mealImageUrl;
    }

    public MealDetails getMealDetails() {
        return mealDetails;
    }

    public void setMealDetails(MealDetails mealDetails) {
        this.mealDetails = mealDetails;
    }

    public void setMealSharingPreference(boolean mealSharingPreference) {
        this.mealSharingPreference = mealSharingPreference;
    }

    public boolean getMealSharingPreference() {
        return mealSharingPreference;
    }

    public Object getMealPhoto() {
        return mealPhoto;
    }

    public void setMealPhoto(Object mealPhoto) {
        this.mealPhoto = mealPhoto;
    }

    @Override
    public String toString() {
        return "Meal{" +
                ", mealTitle='" + mealTitle + '\'' +
                ", mealNote='" + mealNote + '\'' +
                ", mealSubtype=" + mealSubtype +
                ", mealCreationTime=" + mealCreationTime +
                ", mealUpdateTime=" + mealUpdateTime +
                ", mealCompletionTime=" + mealCompletionTime +
                ", mealCreationDate=" + mealCreationDate +
                ", mealLocationLatitude=" + mealLocationLatitude +
                ", mealLocationLongitude=" + mealLocationLongitude +
                ", mealLocationAccuracy=" + mealLocationAccuracy +
                ", mealLocationName='" + mealLocationName + '\'' +
                ", mealLocationType='" + mealLocationType + '\'' +
                ", mealImageUrl='" + mealImageUrl + '\'' +
                ", mealSharingPreference=" + mealSharingPreference +
                ", mealPhoto=" + mealPhoto +
                ", mealDetails=" + mealDetails.toString() +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class MealDetails {

        @JsonProperty("name")
        public String mealItemName;

        @JsonProperty("description")
        public String mealItemDescription;

        @JsonProperty("amount")
        public float mealItemAmount;

        @JsonProperty("measurement")
        public String mealItemUnitOfMeasurement;

        @JsonProperty("type")
        public int mealItemType;

        @JsonProperty("sub_type")
        public int mealItemSubType;

        @JsonProperty("category")
        public String mealItemCategoryName;

        @JsonProperty("food_type")
        public int mealItemFoodType;

        @JsonProperty("num_drinks")
        public int numberOfDrinksInMealItem;

        @JsonProperty("num_foods")
        public int numberOfFoodsInMealItem;

        @JsonProperty("fiber")
        public float mealItemFiberAmount;

        @JsonProperty("polyunsaturated_fat")
        public float mealItemPolyunsaturatedFatAmount;

        @JsonProperty("potassium")
        public float mealItemPotassiumAmount;

        @JsonProperty("fat")
        public float mealItemFatAmount;

        @JsonProperty("carbohydrate")
        public float mealItemCarbohydratesAmount;

        @JsonProperty("saturated_fat")
        public float mealItemSaturatedFatAmount;

        @JsonProperty("protein")
        public float mealItemProteinAmount;

        @JsonProperty("monounsaturated_fat")
        public float mealItemMonounsaturatedFatAmount;

        @JsonProperty("sodium")
        public float mealItemSodiumAmount;

        @JsonProperty("vitamin_c")
        public float mealItemVitaminCAmount;

        @JsonProperty("vitamin_a")
        public float mealItemVitaminAAmount;

        @JsonProperty("calories")
        public int mealItemCaloriesAmount;

        @JsonProperty("unsaturated_fat")
        public float mealItemUnsaturatedFatAmount;

        @JsonProperty("sugar")
        public float mealItemSugarAmount;

        @JsonProperty("calcium")
        public float mealItemCalciumAmount;

        @JsonProperty("iron")
        public float mealItemIronAmount;

        @JsonProperty("cholesterol")
        public float mealItemCholesterolAmount;

        @JsonProperty("caffeine")
        public float mealItemCaffeineAmount;

        @JsonProperty("tz")
        public String mealItemTimeZone;

        public String getMealItemName() {
            return mealItemName;
        }

        public void setMealItemName(String mealItemName) {
            this.mealItemName = mealItemName;
        }

        public String getMealItemDescription() {
            return mealItemDescription;
        }

        public void setMealItemDescription(String mealItemDescription) {
            this.mealItemDescription = mealItemDescription;
        }

        public float getMealItemAmount() {
            return mealItemAmount;
        }

        public void setMealItemAmount(float mealItemAmount) {
            this.mealItemAmount = mealItemAmount;
        }

        public String getMealItemUnitOfMeasurement() {
            return mealItemUnitOfMeasurement;
        }

        public void setMealItemUnitOfMeasurement(String mealItemUnitOfMeasurement) {
            this.mealItemUnitOfMeasurement = mealItemUnitOfMeasurement;
        }

        public int getMealItemType() {
            return mealItemType;
        }

        public void setMealItemType(int mealItemType) {
            this.mealItemType = mealItemType;
        }

        public int getMealItemSubType() {
            return mealItemSubType;
        }

        public void setMealItemSubType(int mealItemSubType) {
            this.mealItemSubType = mealItemSubType;
        }

        public String getMealItemCategoryName() {
            return mealItemCategoryName;
        }

        public void setMealItemCategoryName(String mealItemCategoryName) {
            this.mealItemCategoryName = mealItemCategoryName;
        }

        public int getMealItemFoodType() {
            return mealItemFoodType;
        }

        public void setMealItemFoodType(int mealItemFoodType) {
            this.mealItemFoodType = mealItemFoodType;
        }

        public int getNumberOfDrinksInMealItem() {
            return numberOfDrinksInMealItem;
        }

        public void setNumberOfDrinksInMealItem(int numberOfDrinksInMealItem) {
            this.numberOfDrinksInMealItem = numberOfDrinksInMealItem;
        }

        public int getNumberOfFoodsInMealItem() {
            return numberOfFoodsInMealItem;
        }

        public void setNumberOfFoodsInMealItem(int numberOfFoodsInMealItem) {
            this.numberOfFoodsInMealItem = numberOfFoodsInMealItem;
        }

        public float getMealItemFiberAmount() {
            return mealItemFiberAmount;
        }

        public void setMealItemFiberAmount(float mealItemFiberAmount) {
            this.mealItemFiberAmount = mealItemFiberAmount;
        }

        public float getMealItemPolyunsaturatedFatAmount() {
            return mealItemPolyunsaturatedFatAmount;
        }

        public void setMealItemPolyunsaturatedFatAmount(float mealItemPolyunsaturatedFatAmount) {
            this.mealItemPolyunsaturatedFatAmount = mealItemPolyunsaturatedFatAmount;
        }

        public float getMealItemPotassiumAmount() {
            return mealItemPotassiumAmount;
        }

        public void setMealItemPotassiumAmount(float mealItemPotassiumAmount) {
            this.mealItemPotassiumAmount = mealItemPotassiumAmount;
        }

        public float getMealItemFatAmount() {
            return mealItemFatAmount;
        }

        public void setMealItemFatAmount(float mealItemFatAmount) {
            this.mealItemFatAmount = mealItemFatAmount;
        }

        public float getMealItemCarbohydratesAmount() {
            return mealItemCarbohydratesAmount;
        }

        public void setMealItemCarbohydratesAmount(float mealItemCarbohydratesAmount) {
            this.mealItemCarbohydratesAmount = mealItemCarbohydratesAmount;
        }

        public float getMealItemSaturatedFatAmount() {
            return mealItemSaturatedFatAmount;
        }

        public void setMealItemSaturatedFatAmount(float mealItemSaturatedFatAmount) {
            this.mealItemSaturatedFatAmount = mealItemSaturatedFatAmount;
        }

        public float getMealItemProteinAmount() {
            return mealItemProteinAmount;
        }

        public void setMealItemProteinAmount(float mealItemProteinAmount) {
            this.mealItemProteinAmount = mealItemProteinAmount;
        }

        public float getMealItemMonounsaturatedFatAmount() {
            return mealItemMonounsaturatedFatAmount;
        }

        public void setMealItemMonounsaturatedFatAmount(float mealItemMonounsaturatedFatAmount) {
            this.mealItemMonounsaturatedFatAmount = mealItemMonounsaturatedFatAmount;
        }

        public float getMealItemSodiumAmount() {
            return mealItemSodiumAmount;
        }

        public void setMealItemSodiumAmount(float mealItemSodiumAmount) {
            this.mealItemSodiumAmount = mealItemSodiumAmount;
        }

        public float getMealItemVitaminCAmount() {
            return mealItemVitaminCAmount;
        }

        public void setMealItemVitaminCAmount(float mealItemVitaminCAmount) {
            this.mealItemVitaminCAmount = mealItemVitaminCAmount;
        }

        public float getMealItemVitaminAAmount() {
            return mealItemVitaminAAmount;
        }

        public void setMealItemVitaminAAmount(float mealItemVitaminAAmount) {
            this.mealItemVitaminAAmount = mealItemVitaminAAmount;
        }

        public int getMealItemCaloriesAmount() {
            return mealItemCaloriesAmount;
        }

        public void setMealItemCaloriesAmount(int mealItemCaloriesAmount) {
            this.mealItemCaloriesAmount = mealItemCaloriesAmount;
        }

        public float getMealItemUnsaturatedFatAmount() {
            return mealItemUnsaturatedFatAmount;
        }

        public void setMealItemUnsaturatedFatAmount(float mealItemUnsaturatedFatAmount) {
            this.mealItemUnsaturatedFatAmount = mealItemUnsaturatedFatAmount;
        }

        public float getMealItemSugarAmount() {
            return mealItemSugarAmount;
        }

        public void setMealItemSugarAmount(float mealItemSugarAmount) {
            this.mealItemSugarAmount = mealItemSugarAmount;
        }

        public float getMealItemCalciumAmount() {
            return mealItemCalciumAmount;
        }

        public void setMealItemCalciumAmount(float mealItemCalciumAmount) {
            this.mealItemCalciumAmount = mealItemCalciumAmount;
        }

        public float getMealItemIronAmount() {
            return mealItemIronAmount;
        }

        public void setMealItemIronAmount(float mealItemIronAmount) {
            this.mealItemIronAmount = mealItemIronAmount;
        }

        public float getMealItemCholesterolAmount() {
            return mealItemCholesterolAmount;
        }

        public void setMealItemCholesterolAmount(float mealItemCholesterolAmount) {
            this.mealItemCholesterolAmount = mealItemCholesterolAmount;
        }

        public float getMealItemCaffeineAmount() {
            return mealItemCaffeineAmount;
        }

        public void setMealItemCaffeineAmount(float mealItemCaffeineAmount) {
            this.mealItemCaffeineAmount = mealItemCaffeineAmount;
        }

        public String getMealItemTimeZone() {
            return mealItemTimeZone;
        }

        public void setMealItemTimeZone(String mealItemTimeZone) {
            this.mealItemTimeZone = mealItemTimeZone;
        }

        @Override
        public String toString() {
            return "MealDetails{" +
                    "mealItemName='" + mealItemName + '\'' +
                    ", mealItemDescription='" + mealItemDescription + '\'' +
                    ", mealItemAmount=" + mealItemAmount +
                    ", mealItemUnitOfMeasurement='" + mealItemUnitOfMeasurement + '\'' +
                    ", mealItemType=" + mealItemType +
                    ", mealItemSubType=" + mealItemSubType +
                    ", mealItemCategoryName='" + mealItemCategoryName + '\'' +
                    ", mealItemFoodType=" + mealItemFoodType +
                    ", numberOfDrinksInMealItem=" + numberOfDrinksInMealItem +
                    ", numberOfFoodsInMealItem=" + numberOfFoodsInMealItem +
                    ", mealItemFiberAmount=" + mealItemFiberAmount +
                    ", mealItemPolyunsaturatedFatAmount=" + mealItemPolyunsaturatedFatAmount +
                    ", mealItemPotassiumAmount=" + mealItemPotassiumAmount +
                    ", mealItemFatAmount=" + mealItemFatAmount +
                    ", mealItemCarbohydratesAmount=" + mealItemCarbohydratesAmount +
                    ", mealItemSaturatedFatAmount=" + mealItemSaturatedFatAmount +
                    ", mealItemProteinAmount=" + mealItemProteinAmount +
                    ", mealItemMonounsaturatedFatAmount=" + mealItemMonounsaturatedFatAmount +
                    ", mealItemSodiumAmount=" + mealItemSodiumAmount +
                    ", mealItemVitaminCAmount=" + mealItemVitaminCAmount +
                    ", mealItemVitaminAAmount=" + mealItemVitaminAAmount +
                    ", mealItemCaloriesAmount=" + mealItemCaloriesAmount +
                    ", mealItemUnsaturatedFatAmount=" + mealItemUnsaturatedFatAmount +
                    ", mealItemSugarAmount=" + mealItemSugarAmount +
                    ", mealItemCalciumAmount=" + mealItemCalciumAmount +
                    ", mealItemIronAmount=" + mealItemIronAmount +
                    ", mealItemCholesterolAmount=" + mealItemCholesterolAmount +
                    ", mealItemCaffeineAmount=" + mealItemCaffeineAmount +
                    ", mealItemTimeZone='" + mealItemTimeZone + '\'' +
                    '}';
        }
    }

    public enum MealTypes {
        BREAKFAST(1),
        LUNCH(2),
        DINNER(3);

        private final int type;

        MealTypes(int i) {
            this.type = i;
        }

        public int getType() {
            return type;
        }
    }
}
