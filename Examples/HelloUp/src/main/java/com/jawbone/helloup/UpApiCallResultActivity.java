package com.jawbone.helloup;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class UpApiCallResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.up_api_call_result);

        Bundle extras = getIntent().getExtras();

        TextView textView1 = (TextView) findViewById(R.id.textview1);

        String textToDisplay;

        if (extras != null) {
            textToDisplay = extras.getString("data_to_display");
            textView1.setText(textToDisplay);
        }
    }
}
