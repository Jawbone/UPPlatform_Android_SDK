package com.jawbone.upplatformsdk.endpointModels.move;

import com.google.gson.annotations.SerializedName;

/**
 * Created by <a href="mailto:marcusandreog@gmail.com">Marcus Gabilheri</a>
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 2/13/15.
 */
public class HourlyEvent  {

    @SerializedName("distance")
    int distance;

    @SerializedName("calories")
    float calories;

    @SerializedName("steps")
    int steps;

    @SerializedName("inactive_time")
    int inactiveTime;

    @SerializedName("longest_active_time")
    int longestActiveTime;

    @SerializedName("longest_idle_time")
    int longestIdleTime;

    public HourlyEvent() {
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getInactiveTime() {
        return inactiveTime;
    }

    public void setInactiveTime(int inactiveTime) {
        this.inactiveTime = inactiveTime;
    }

    public int getLongestActiveTime() {
        return longestActiveTime;
    }

    public void setLongestActiveTime(int longestActiveTime) {
        this.longestActiveTime = longestActiveTime;
    }

    public int getLongestIdleTime() {
        return longestIdleTime;
    }

    public void setLongestIdleTime(int longestIdleTime) {
        this.longestIdleTime = longestIdleTime;
    }

    @Override
    public String toString() {
        return "HourlyEvent{" +
                "distance=" + distance +
                ", calories=" + calories +
                ", steps=" + steps +
                ", inactiveTime=" + inactiveTime +
                ", longestActiveTime=" + longestActiveTime +
                ", longestIdleTime=" + longestIdleTime +
                '}';
    }
}
