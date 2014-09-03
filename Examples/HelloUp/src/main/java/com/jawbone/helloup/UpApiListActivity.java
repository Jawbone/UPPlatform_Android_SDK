package com.jawbone.helloup;

import android.app.ListActivity;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.jawbone.upplatformsdk.api.ApiManager;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class UpApiListActivity extends ListActivity {

    private static final String TAG = UpApiListActivity.class.getSimpleName();

    private static final String[] UP_API_CALLS = new String[] {
            "Get Meals List",
            "Get Meal Event",
            "Delete Meal",
            "Create Meal",
            "Update Meal",
            "Get Moves List",
            "Get Moves Event",
            "Get Moves Graph",
            "Get Moves Ticks",
            "Get Custom Events List",
            "Create Custom Event",
            "Update Custom Event",
            "Delete Custom Event",
            "Get Workouts List",
            "Get Workout Event",
            "Get Workout Graph",
            "Get Workout Ticks",
            "Create Workout Event",
            "Update Workout Event",
            "Delete Workout Event",
            "Get Sleeps List",
            "Get Sleep Event",
            "Get Sleep Graph",
            "Get Sleep Ticks",
            "Create Sleep Event",
            "Delete Sleep Event",
            "Get Body Events List",
            "Get Body Event",
            "Create Body Event",
            "Delete Body Event",
            "Get Band Events",
            "Get User's Goals",
            "Create or Update User's Goals",
            "Get Moods List",
            "Get Mood Event",
            "Create Mood Event",
            "Delete Mood Event",
            "Get Refresh Token",
            "Get User Settings",
            "Get Time Zone",
            "Get Trends",
            "Get User",
            "Get User's Friends"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawableResource(R.color.white_test);
        setListAdapter(new ArrayAdapter<String>(this, R.layout.up_api_list, UP_API_CALLS));

        ListView listView = getListView();
        int[] colors = {0xF, 0x66000000, 0xF}; // red for the example

        listView.setDivider(new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, colors));
        listView.setTextFilterEnabled(true);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        final String accessToken = preferences.getString("access_token", null);

        if (accessToken != null) {
            listView.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    switch (position) {
                        case 0:
                            //Omer TODO use @QueryMap to pass in optional parameters
                            ApiManager.getRestApiInterface().getMealsList(
                                    "Bearer " + accessToken,
                                    "application/json",
                                    "v.1.1",
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    mealsListCallback);
                            break;
                        case 1:
                            ApiManager.getRestApiInterface().getMealEvent(
                                    "Bearer " + accessToken,
                                    "application/json",
                                    "v.1.1",
                                    "wZ3pxuSAHA9mnOxjz3yw5w", //hardcoded value, should be dynamic
                                    mealEventCallback);
                            break;
                        case 2:
                            // note, you can only delete meals that you created
                            // so first create it then delete
                            ApiManager.getRestApiInterface().deleteMealEvent(
                                    "Bearer " + accessToken,
                                    "application/json",
                                    "v.1.1",
                                    "O-IjYEIQFz6dU0FWTA0U-w", //hardcoded value, should be dynamic
                                    deleteMealEventCallback);
                            break;
                        case 3:
                            ApiManager.getRestApiInterface().createMealEvent(
                                    "Bearer " + accessToken,
                                    "application/json",
                                    "v.1.1",
                                    "Test Meal 1",
                                    "1",
                                    null,
                                    null,
                                    createMealEventCallback);
                            break;
                        case 4:
                            ApiManager.getRestApiInterface().updateMealEvent(
                                    "Bearer " + accessToken,
                                    "application/json",
                                    "v.1.1",
                                    "O-IjYEIQFz5-Doy4gpS2tQ",
                                    "Test Meal 777",
                                    "2",
                                    null,
                                    null,
                                    createMealEventCallback);
                            break;
                        default:
                            Log.e(TAG, "api endpoint not yet defined");
                    }
                }
            });
        }
    }

    //Omer TODO the callbacks are not yet backed by data model, but will get json response, these will be added in future
    private Callback mealsListCallback = new Callback<Object>() {
        @Override
        public void success(Object o, Response response) {
            Log.e(TAG,  "meal events list: " + o.toString());
        }

        @Override
        public void failure(RetrofitError retrofitError) {
            Log.e(TAG,  "meal events list not returned, Error: " + retrofitError.getMessage());
            Toast.makeText(getApplicationContext(), retrofitError.getMessage(), Toast.LENGTH_SHORT).show();

        }
    };

    private Callback mealEventCallback = new Callback<Object>() {
        @Override
        public void success(Object o, Response response) {
            Log.e(TAG,  "get meal event: " + o.toString());
        }

        @Override
        public void failure(RetrofitError retrofitError) {
            Log.e(TAG,  "get meals event Error: " + retrofitError.getMessage());
            Toast.makeText(getApplicationContext(), retrofitError.getMessage(), Toast.LENGTH_SHORT).show();
        }
    };

    private Callback deleteMealEventCallback = new Callback<Object>() {
        @Override
        public void success(Object o, Response response) {
            Log.e(TAG,  "delete meal event: " + o.toString());
        }

        @Override
        public void failure(RetrofitError retrofitError) {
            Log.e(TAG,  "delete meals event Error: " + retrofitError.getMessage());
            Toast.makeText(getApplicationContext(), retrofitError.getMessage(), Toast.LENGTH_SHORT).show();
        }
    };

    private Callback createMealEventCallback = new Callback<Object>() {
        @Override
        public void success(Object o, Response response) {
            Log.e(TAG,  "create meal event: " + o.toString());
        }

        @Override
        public void failure(RetrofitError retrofitError) {
            Log.e(TAG,  "create meals event Error: " + retrofitError.getMessage());
            Toast.makeText(getApplicationContext(), retrofitError.getMessage(), Toast.LENGTH_SHORT).show();
        }
    };
}