package com.jawbone.upplatformsdk.endpointModels.move;

import com.google.gson.annotations.SerializedName;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkUtils;

/**
 * Created by <a href="mailto:marcusandreog@gmail.com">Marcus Gabilheri</a>
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 2/13/15.
 */
public class HourlyEvent  {

    @SerializedName("distance")
    Integer distance;

    @SerializedName("calories")
    Float calories;

    @SerializedName("steps")
    Integer steps;

    @SerializedName("inactive_time")
    Integer inactiveTime;

    @SerializedName("longest_active_time")
    Integer longestActiveTime;

    @SerializedName("longest_idle_time")
    Integer longestIdleTime;

    public HourlyEvent() {
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Float getCalories() {
        return calories;
    }

    public void setCalories(Float calories) {
        this.calories = calories;
    }

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    public Integer getInactiveTime() {
        return inactiveTime;
    }

    public void setInactiveTime(Integer inactiveTime) {
        this.inactiveTime = inactiveTime;
    }

    public Integer getLongestActiveTime() {
        return longestActiveTime;
    }

    public void setLongestActiveTime(Integer longestActiveTime) {
        this.longestActiveTime = longestActiveTime;
    }

    public Integer getLongestIdleTime() {
        return longestIdleTime;
    }

    public void setLongestIdleTime(Integer longestIdleTime) {
        this.longestIdleTime = longestIdleTime;
    }

    @Override
    public String toString() {
        return UpPlatformSdkUtils.toJson(this);
    }
}
