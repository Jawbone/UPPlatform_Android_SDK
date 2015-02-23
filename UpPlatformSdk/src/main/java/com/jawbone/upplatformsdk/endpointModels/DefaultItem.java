package com.jawbone.upplatformsdk.endpointModels;

import com.google.gson.annotations.SerializedName;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkUtils;

/**
 * Created by <a href="mailto:marcusandreog@gmail.com">Marcus Gabilheri</a>
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 2/14/15.
 */
public class DefaultItem {

    @SerializedName("xid")
    protected String xid;

    @SerializedName("title")
    protected String title;

    @SerializedName("type")
    protected String type;

    @SerializedName("time_created")
    protected Long timeCreated;

    @SerializedName("time_completed")
    protected Long timeCompleted;

    @SerializedName("date")
    protected Integer date;

    public DefaultItem() {
    }

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Long timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Long getTimeCompleted() {
        return timeCompleted;
    }

    public void setTimeCompleted(Long timeCompleted) {
        this.timeCompleted = timeCompleted;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return UpPlatformSdkUtils.toJson(this);
    }
}
