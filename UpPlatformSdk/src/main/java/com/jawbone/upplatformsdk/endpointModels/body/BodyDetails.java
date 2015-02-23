package com.jawbone.upplatformsdk.endpointModels.body;

import com.google.gson.annotations.SerializedName;

/**
 * Created by <a href="mailto:marcusandreog@gmail.com">Marcus Gabilheri</a>
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 2/14/15.
 */
public class BodyDetails {

    @SerializedName("tz")
    String timeZone;

    public BodyDetails() {
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @Override
    public String toString() {
        return "BodyDetails {" +
                "\n\ttimeZone='" + timeZone + '\'' +
                "\n}\n";
    }
}
