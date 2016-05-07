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
        //User Metrics
        protected Float gender;
        protected Float weight;
        protected Float height;
        protected Float age;

        //Food Metrics
        protected Float e_protein;
        protected Float e_cholesterol;
        protected Float e_calcium;
        protected Float e_calories;
        protected Float e_unsat_fat;
        protected Float e_sodium;
        protected Float e_sugar;
        protected Float e_carbs;
        protected Float e_fiber;
        protected Float e_sat_fat;

        //Sleep Metrics
        protected Float s_quality;
        protected Float s_light;
        protected Float s_bedtime;
        protected Float s_awake_time;
        protected Float s_asleep_time;
        protected Float s_awake;
        protected Float s_duration;
        protected Float s_rem;
        protected Float s_sound;

        //Workout / Move metrics
        protected Float m_steps;
        protected Float m_workout_time;
        protected Float m_distance;
        protected Float m_lcat;
        protected Float m_lcit;
        protected Float m_calories;
        protected Float m_total_calories;
        protected Float m_active_time;

        //Other
        protected Float goal_body_weight_intent;
        protected Float goal_body_weight;
        protected Float body_fat;
        protected Float pal;
        protected Float rhr;
        protected Float bmr;
    }

    public static class TrendsDeserializer implements JsonDeserializer<JBTrendData> {

        @Override
        public JBTrendData deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

            JBTrendData trend = new JBTrendData();

            JsonArray jobject = (JsonArray) json;

            trend.date = jobject.get(0).getAsString();
            trend.mets = new Gson().fromJson(jobject.get(1), JBTrendMetrics.class);

            return trend;
        }
    }
}
