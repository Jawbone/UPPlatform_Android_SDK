package com.jawbone.upplatformsdk.builders;

import android.support.annotation.NonNull;

import java.util.HashMap;

/**
 * Created by <a href="mailto:marcusandreog@gmail.com">Marcus Gabilheri</a>
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 2/14/15.
 */
public class Params {

    private static final String DATE = "date";
    private static final String PAGE_TOKEN = "page_token";
    private static final String START_TIME = "start_time";
    private static final String END_TIME = "end_time";
    private static final String UPDATED_AFTER = "updated_after";

    public static class Builder {

        Integer date, pageToken, startTime, endTime, updatedAfter;

        public Builder() {
        }

        public Builder setDate(@NonNull Integer date) {
            this.date = date;
            return this;
        }

        public Builder setPageToken(@NonNull Integer pageToken) {
            this.pageToken = pageToken;
            return this;
        }

        public Builder setStartTime(@NonNull Integer startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder setEndTime(@NonNull Integer endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder setUpdatedAfter(@NonNull Integer updatedAfter) {
            this.updatedAfter = updatedAfter;
            return this;
        }

        public HashMap<String, Integer> build() {
            HashMap<String, Integer> queryHashMap = new HashMap<>();

            if (date != null) queryHashMap.put(DATE, this.date);

            if (pageToken != null) queryHashMap.put(PAGE_TOKEN, this.pageToken);

            if (startTime != null) queryHashMap.put(START_TIME, this.startTime);

            if (endTime != null) queryHashMap.put(END_TIME, this.endTime);

            if (updatedAfter != null) queryHashMap.put(UPDATED_AFTER, this.updatedAfter);

            return queryHashMap;
        }
    }
}
