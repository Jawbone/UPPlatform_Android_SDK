/**
 * @author Omer Muhammed
 * Copyright 2014 (c) Jawbone. All rights reserved.
 *
 */
package com.jawbone.helloup;

import android.os.Bundle;

import com.jawbone.helloup.base.BaseActivity;
import com.jawbone.helloup.utils.FragmentUtils;

/**
 * Activity that provides a list view of all the API calls available
 * for UP Platform
 */
public class UpApiListActivity extends BaseActivity {

    private static final String TAG = UpApiListActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("List of UP Platform API Calls");
        FragmentList fragmentList = new FragmentList();
        FragmentUtils.addFragmentToContainer(fragmentList, R.id.container, this);

    }
}
