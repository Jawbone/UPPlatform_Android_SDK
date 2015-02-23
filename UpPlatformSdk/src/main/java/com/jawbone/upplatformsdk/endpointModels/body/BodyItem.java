package com.jawbone.upplatformsdk.endpointModels.body;

import com.google.gson.annotations.SerializedName;
import com.jawbone.upplatformsdk.endpointModels.DefaultItem;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkUtils;

/**
 * Created by <a href="mailto:marcusandreog@gmail.com">Marcus Gabilheri</a>
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 2/14/15.
 */
public class BodyItem extends DefaultItem {

    @SerializedName("place_lat")
    protected Float placeLat;

    @SerializedName("place_lon")
    protected Float placeLon;

    @SerializedName("place_acc")
    protected Integer placeAcc;

    @SerializedName("place_name")
    protected String placeName;

    @SerializedName("note")
    protected String note;

    @SerializedName("lean_mass")
    protected Float leanMass;

    @SerializedName("weight")
    protected Float weight;

    @SerializedName("body_fat")
    protected Float bodyFat;

    @SerializedName("bmi")
    protected Float bmi;

    @SerializedName("details")
    protected BodyDetails details;

    public BodyItem() {
    }

    public Float getPlaceLat() {
        return placeLat;
    }

    public void setPlaceLat(Float placeLat) {
        this.placeLat = placeLat;
    }

    public Float getPlaceLon() {
        return placeLon;
    }

    public void setPlaceLon(Float placeLon) {
        this.placeLon = placeLon;
    }

    public Integer getPlaceAcc() {
        return placeAcc;
    }

    public void setPlaceAcc(Integer placeAcc) {
        this.placeAcc = placeAcc;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Float getLeanMass() {
        return leanMass;
    }

    public void setLeanMass(Float leanMass) {
        this.leanMass = leanMass;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getBodyFat() {
        return bodyFat;
    }

    public void setBodyFat(Float bodyFat) {
        this.bodyFat = bodyFat;
    }

    public Float getBmi() {
        return bmi;
    }

    public void setBmi(Float bmi) {
        this.bmi = bmi;
    }

    public BodyDetails getDetails() {
        return details;
    }

    public void setDetails(BodyDetails details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return UpPlatformSdkUtils.toJson(this);
    }
}
