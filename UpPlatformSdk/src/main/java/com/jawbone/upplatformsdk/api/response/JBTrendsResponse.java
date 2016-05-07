package com.jawbone.upplatformsdk.api.response;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.jawbone.upplatformsdk.datamodel.Links;

import java.lang.reflect.Type;

/**
 * Created by <a href="mailto:prakash.nadar@gmail.com">Prakash Nadar</a> on 5/7/16.
 */
public class JBTrendsResponse extends JBResponse {
    protected JBTrend data;

    public static class JBTrend {
        protected String earliest;
        protected JBTrendData[] data;
        protected Links links;
    }

    public static class JBTrendData {
        protected String date;
        protected JBTrendMetrics mets;
    }

    public static class JBTrendMetrics {
        protected Integer m_steps;
        protected Integer m_workout_time;
    }

    public static class TrendsDeserializer implements JsonDeserializer<JBTrendData> {

        @Override
        public JBTrendData deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

            JBTrendData jd = new JBTrendData();

            JsonArray jobject = (JsonArray) json;

            jd.date = jobject.get(0).getAsString();
            jd.mets = new Gson().fromJson(jobject.get(1), JBTrendMetrics.class);

            return jd;
        }
    }
}
