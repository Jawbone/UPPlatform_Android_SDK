package com.jawbone.helloup;

import android.content.Intent;
import android.os.Bundle;

import com.jawbone.helloup.base.BaseActivity;
import com.jawbone.helloup.base.DefaultFragment;
import com.jawbone.helloup.detailFragments.FragmentMoves;
import com.jawbone.helloup.utils.ApiConstants;
import com.jawbone.helloup.utils.FragmentUtils;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkConstants;


public class DetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        getSupportActionBar().setTitle(intent.getStringExtra(ApiConstants.ACTIVITY_TITLE));
        UpPlatformSdkConstants.RestApiRequestType apiRequestType = UpPlatformSdkConstants.RestApiRequestType.values()[intent.getIntExtra(ApiConstants.FRAGMENT_NUM, 0)];
        DefaultFragment activeFragment = null;
        switch (apiRequestType) {
            case GET_MOVES_EVENTS_LIST:
                activeFragment = new FragmentMoves();
                break;
        }

        if(activeFragment != null) {
            FragmentUtils.addFragmentToContainer(activeFragment, R.id.container, this);
        }


    }
}
