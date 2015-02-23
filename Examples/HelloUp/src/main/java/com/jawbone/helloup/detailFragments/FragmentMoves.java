package com.jawbone.helloup.detailFragments;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.jawbone.helloup.R;
import com.jawbone.helloup.base.DefaultFragment;
import com.jawbone.upplatformsdk.api.ApiManager;
import com.jawbone.upplatformsdk.builders.MoveListParams;
import com.jawbone.upplatformsdk.endpointModels.move.Move;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkConstants;

import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDateTime;

import java.util.HashMap;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by <a href="mailto:marcusandreog@gmail.com">Marcus Gabilheri</a>
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 2/13/15.
 */
public class FragmentMoves extends DefaultFragment {

    private static final String TAG = FragmentMoves.class.getSimpleName();

    @InjectView(R.id.moveListText)
    TextView movesListText;

    //TODO make a design to actually show the Data in a more readable way.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ButterKnife.inject(this, view);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startDate = now.withTime(0, 0, 0, 0).withDayOfWeek(DateTimeConstants.MONDAY);
        LocalDateTime endDate = now.withTime(23, 59, 59, 999).withDayOfWeek(DateTimeConstants.SUNDAY);

        String date = startDate.getYear() + "" +
                (startDate.getMonthOfYear() > 9 ? startDate.getMonthOfYear() : "0" + startDate.getMonthOfYear()) +
                (startDate.getDayOfMonth() > 9 ? startDate.getDayOfMonth() : "0" + startDate.getDayOfMonth());
        Log.d(TAG, "DATE: " + date);
        Log.d(TAG, "START TIME: " + (startDate.toDateTime().getMillis() / 1000));
        Log.d(TAG, "END TIME: " + (endDate.toDateTime().getMillis() / 1000));

        HashMap<String, Integer> moveListParams = new MoveListParams.Builder()
                .setStartTime((int) (startDate.toDateTime().getMillis() / 1000))
                .setEndTime((int) (endDate.toDateTime().getMillis() / 1000))
                .build();


        ApiManager.getRestApiInterface().getMoveEventsList(
                UpPlatformSdkConstants.API_VERSION_STRING,
                moveListParams,
                new Callback<Move>() {
                    @Override
                    public void success(Move move, Response response) {
                        movesListText.setText(move.toString());
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.d(TAG, error.getMessage());
                    }
                });
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_move_list;
    }

    private static HashMap<String, Integer> getMoveEventsListRequestParams() {
        HashMap<String, Integer> queryHashMap = new HashMap<>();

        //uncomment to add as needed parameters
//        queryHashMap.put("date", "<insert-date>");
//        queryHashMap.put("page_token", "<insert-page-token>");
//        queryHashMap.put("start_time", "<insert-time>");
//        queryHashMap.put("end_time", "<insert-time>");
//        queryHashMap.put("updated_after", "<insert-time>");

        return queryHashMap;
    }

}
