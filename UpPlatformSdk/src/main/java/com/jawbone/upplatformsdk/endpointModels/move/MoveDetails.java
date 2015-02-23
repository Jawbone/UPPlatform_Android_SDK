package com.jawbone.upplatformsdk.endpointModels.move;

import com.google.gson.annotations.SerializedName;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkUtils;

import java.util.Map;

/**
 * Created by <a href="mailto:marcusandreog@gmail.com">Marcus Gabilheri</a>
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 2/13/15.
 */
public class MoveDetails {

    @SerializedName("distance")
    Integer distance;

    @SerializedName("km")
    String km;

    @SerializedName("steps")
    Integer steps;

    @SerializedName("longest_active")
    Integer longestActive;

    @SerializedName("inactive_time")
    Integer inactiveTime;

    @SerializedName("longest_idle")
    Integer longestIdle;

    @SerializedName("calories")
    Float calories;

    @SerializedName("bmr_day")
    Float bmrDay;

    @SerializedName("bg_calories")
    Float bgCalories;

    @SerializedName("wo_calories")
    Float woCalories;

    @SerializedName("wo_time")
    Integer woTime;

    @SerializedName("wo_active_time")
    Integer woActiveTime;

    @SerializedName("wo_count")
    Integer woCount;

    @SerializedName("wo_longest")
    Integer woLongest;

    @SerializedName("sunrise")
    Long sunrise;

    @SerializedName("sunset")
    Long sunset;

    @SerializedName("tz")
    String timeZone;

    @SerializedName("tzs")
    Map<Integer, String> tzs;

    @SerializedName("hourly_totals")
    Map<String, HourlyEvent> hourlyTotals;

    public MoveDetails() {
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    public Integer getLongestActive() {
        return longestActive;
    }

    public void setLongestActive(Integer longestActive) {
        this.longestActive = longestActive;
    }

    public Integer getInactiveTime() {
        return inactiveTime;
    }

    public void setInactiveTime(Integer inactiveTime) {
        this.inactiveTime = inactiveTime;
    }

    public Integer getLongestIdle() {
        return longestIdle;
    }

    public void setLongestIdle(Integer longestIdle) {
        this.longestIdle = longestIdle;
    }

    public Float getCalories() {
        return calories;
    }

    public void setCalories(Float calories) {
        this.calories = calories;
    }

    public Float getBmrDay() {
        return bmrDay;
    }

    public void setBmrDay(Float bmrDay) {
        this.bmrDay = bmrDay;
    }

    public Float getBgCalories() {
        return bgCalories;
    }

    public void setBgCalories(Float bgCalories) {
        this.bgCalories = bgCalories;
    }

    public Float getWoCalories() {
        return woCalories;
    }

    public void setWoCalories(Float woCalories) {
        this.woCalories = woCalories;
    }

    public Integer getWoTime() {
        return woTime;
    }

    public void setWoTime(Integer woTime) {
        this.woTime = woTime;
    }

    public Integer getWoActiveTime() {
        return woActiveTime;
    }

    public void setWoActiveTime(Integer woActiveTime) {
        this.woActiveTime = woActiveTime;
    }

    public Integer getWoCount() {
        return woCount;
    }

    public void setWoCount(Integer woCount) {
        this.woCount = woCount;
    }

    public Integer getWoLongest() {
        return woLongest;
    }

    public void setWoLongest(Integer woLongest) {
        this.woLongest = woLongest;
    }

    public Long getSunrise() {
        return sunrise;
    }

    public void setSunrise(Long sunrise) {
        this.sunrise = sunrise;
    }

    public Long getSunset() {
        return sunset;
    }

    public void setSunset(Long sunset) {
        this.sunset = sunset;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public Map<Integer, String> getTzs() {
        return tzs;
    }

    public void setTzs(Map<Integer, String> tzs) {
        this.tzs = tzs;
    }

    public Map<String, HourlyEvent> getHourlyTotals() {
        return hourlyTotals;
    }

    public void setHourlyTotals(Map<String, HourlyEvent> hourlyTotals) {
        this.hourlyTotals = hourlyTotals;
    }

    @Override
    public String toString() {
        return UpPlatformSdkUtils.toJson(this);
    }
}




