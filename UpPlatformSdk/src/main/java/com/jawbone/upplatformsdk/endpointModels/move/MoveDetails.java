package com.jawbone.upplatformsdk.endpointModels.move;

import com.google.gson.annotations.SerializedName;

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
    int distance;

    @SerializedName("km")
    String km;

    @SerializedName("steps")
    int steps;

    @SerializedName("longest_active")
    int longestActive;

    @SerializedName("inactive_time")
    int inactiveTime;

    @SerializedName("longest_idle")
    int longestIdle;

    @SerializedName("calories")
    float calories;

    @SerializedName("bmr_day")
    float bmrDay;

    @SerializedName("bg_calories")
    float bgCalories;

    @SerializedName("wo_calories")
    float woCalories;

    @SerializedName("wo_time")
    int woTime;

    @SerializedName("wo_active_time")
    int woActiveTime;

    @SerializedName("wo_count")
    int woCount;

    @SerializedName("wo_longest")
    int woLongest;

    @SerializedName("sunrise")
    long sunrise;

    @SerializedName("sunset")
    long sunset;

    @SerializedName("tz")
    String timeZone;

    @SerializedName("tzs")
    Map<Integer, String> tzs;

    @SerializedName("hourly_totals")
    Map<String, HourlyEvent> hourlyTotals;

    public MoveDetails() {
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getLongestActive() {
        return longestActive;
    }

    public void setLongestActive(int longestActive) {
        this.longestActive = longestActive;
    }

    public int getInactiveTime() {
        return inactiveTime;
    }

    public void setInactiveTime(int inactiveTime) {
        this.inactiveTime = inactiveTime;
    }

    public int getLongestIdle() {
        return longestIdle;
    }

    public void setLongestIdle(int longestIdle) {
        this.longestIdle = longestIdle;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    public float getBmrDay() {
        return bmrDay;
    }

    public void setBmrDay(float bmrDay) {
        this.bmrDay = bmrDay;
    }

    public float getBgCalories() {
        return bgCalories;
    }

    public void setBgCalories(float bgCalories) {
        this.bgCalories = bgCalories;
    }

    public float getWoCalories() {
        return woCalories;
    }

    public void setWoCalories(float woCalories) {
        this.woCalories = woCalories;
    }

    public int getWoTime() {
        return woTime;
    }

    public void setWoTime(int woTime) {
        this.woTime = woTime;
    }

    public int getWoActiveTime() {
        return woActiveTime;
    }

    public void setWoActiveTime(int woActiveTime) {
        this.woActiveTime = woActiveTime;
    }

    public int getWoCount() {
        return woCount;
    }

    public void setWoCount(int woCount) {
        this.woCount = woCount;
    }

    public int getWoLongest() {
        return woLongest;
    }

    public void setWoLongest(int woLongest) {
        this.woLongest = woLongest;
    }

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public void setSunset(long sunset) {
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
        return "MoveDetails{" +
                "\n\tdistance=" + distance +
                ",\n\t km='" + km + '\'' +
                ",\n\t steps=" + steps +
                ",\n\t longestActive=" + longestActive +
                ",\n\t inactiveTime=" + inactiveTime +
                ",\n\t longestIdle=" + longestIdle +
                ",\n\t calories=" + calories +
                ",\n\t bmrDay=" + bmrDay +
                ",\n\t bgCalories=" + bgCalories +
                ",\n\t woCalories=" + woCalories +
                ",\n\t woTime=" + woTime +
                ",\n\t woActiveTime=" + woActiveTime +
                ",\n\t woCount=" + woCount +
                ",\n\t woLongest=" + woLongest +
                ",\n\t sunrise=" + sunrise +
                ",\n\t sunset=" + sunset +
                ",\n\t timeZone='" + timeZone + '\'' +
                ",\n\t tzs=" + tzs +
                ",\n\t hourlyTotals=" + hourlyTotals +
                "\n}\n";
    }
}




