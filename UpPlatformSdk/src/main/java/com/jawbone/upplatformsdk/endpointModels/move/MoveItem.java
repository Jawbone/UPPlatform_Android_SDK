package com.jawbone.upplatformsdk.endpointModels.move;

import com.google.gson.annotations.SerializedName;

/**
 * Created by <a href="mailto:marcusandreog@gmail.com">Marcus Gabilheri</a>
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 2/13/15.
 */
public class MoveItem {

    @SerializedName("xid")
    String xid;

    @SerializedName("title")
    String title;

    @SerializedName("type")
    String type;

    @SerializedName("time_created")
    long timeCreated;

    @SerializedName("time_completed")
    long timeCompleted;

    @SerializedName("date")
    int date;

    @SerializedName("snapshot_image")
    String snapshotImage;

    @SerializedName("details")
    MoveDetails details;

    public MoveItem() {
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

    public long getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(long timeCreated) {
        this.timeCreated = timeCreated;
    }

    public long getTimeCompleted() {
        return timeCompleted;
    }

    public void setTimeCompleted(long timeCompleted) {
        this.timeCompleted = timeCompleted;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getSnapshotImage() {
        return snapshotImage;
    }

    public void setSnapshotImage(String snapshotImage) {
        this.snapshotImage = snapshotImage;
    }

    public MoveDetails getDetails() {
        return details;
    }

    public void setDetails(MoveDetails details) {
        this.details = details;
    }


    @Override
    public String toString() {
        return "MoveItem {" + "\n" +
                "\t\nxid='" + xid + '\'' +
                ",\n\title='" + title + '\'' +
                ",\n\ttype='" + type + '\'' +
                ",\n\ttimeCreated=" + timeCreated +
                ",\n\ttimeCompleted=" + timeCompleted +
                ",\n\tdate=" + date +
                ",\n\tsnapshotImage='" + snapshotImage + '\'' +
                ",\n\tdetails=" + details +
                "\n}\n";
    }
}
