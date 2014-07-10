package com.jawbone.helloup;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.android.volley.VolleyError;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.jawbone.upplatformsdk.api.UpApiWrapper;
import com.jawbone.upplatformsdk.api.response.GetMealsListResponse;
import com.spothero.volley.JacksonRequestListener;

public class UpApiListActivity extends ListActivity {

    private static final String TAG = UpApiListActivity.class.getSimpleName();

    private static final String[] UP_API_CALLS = new String[] {
            "Get Meals List",
            "Avocado",
            "Banana"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(this, R.layout.up_api_list, UP_API_CALLS));

        ListView listView = getListView();
        listView.setTextFilterEnabled(true);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        final String accessToken = preferences.getString("access_token", null);

        if (accessToken != null) {
            listView.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    // When clicked, show a toast with the TextView text
                    switch (position) {
                        case 0:
                            UpApiWrapper.getInstance().getMealsListRequest(getMealsListListener, accessToken);
                            break;
                        case 1:
                        case 2:
                        default:
                            Toast.makeText(getApplicationContext(),
                                    ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private JacksonRequestListener<GetMealsListResponse> getMealsListListener = new JacksonRequestListener<GetMealsListResponse>() {
        @Override
        public void onResponse(GetMealsListResponse response, int statusCode, VolleyError error) {
            if (response != null) {
                Log.d(TAG, "--------------------------");
                Log.d(TAG, "getMealsListListener, meta->message:" + response.getMeta().getMessage());
                Log.d(TAG, "getMealsListListener, meta->user_xid:" + response.getMeta().getUserXid());
                Log.d(TAG, "getMealsListListener, meta->code:" + response.getMeta().getCode());
                if (response.getData().getSize() > 0) {
                    Log.d(TAG, "getMealsListListener, data->links->size:" + response.getData().getSize());
                    Log.d(TAG, "getMealsListListener, data->links->next:" + response.getData().getLinks().getNext());
                    Log.d(TAG, "getMealsListListener, data->items->item 1->xid:" + response.getData().getMealsList().get(1).getXid());
                    Log.d(TAG, "getMealsListListener, data->items->item 1->title:" + response.getData().getMealsList().get(1).getMealTitle());
                    Log.d(TAG, "getMealsListListener, data->items->item 1->date:" + response.getData().getMealsList().get(1).getMealCreationDate());
                    Log.d(TAG, "getMealsListListener, data->items->item 1->details->sodium:" + response.getData().getMealsList().get(1).getMealDetails().getMealItemSodiumAmount());
                }
                Log.d(TAG, "--------------------------");

                Intent intent = new Intent(UpApiListActivity.this, UpApiCallResultActivity.class);
                intent.putExtra("data_to_display",response.getData().getMealsList().get(1).getMealTitle());
                startActivity(intent);

            } else {
                Log.e(TAG, Log.getStackTraceString(error));
            }
        }

        @Override
        public JavaType getReturnType() {
            return SimpleType.construct(GetMealsListResponse.class);
        }
    };


}