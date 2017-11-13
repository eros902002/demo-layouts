package net.pubnative.candemotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import net.pubnative.sdk.layouts.PNLayout;
import net.pubnative.sdk.layouts.PNSmallLayout;

public class CanDemoActivity extends AppCompatActivity implements PNLayout.LoadListener {
    private static final String TAG = CanDemoActivity.class.getSimpleName();

    private static final String APP_TOKEN = "87960ef9e8d14200bc9fa7f7ed2354f2";
    private static final String PLACEMENT_SMALL = "ad_small";
    private static final String PLACEMENT_MEDIUM = "ad_medium";
    private static final String PLACEMENT_LARGE = "ad_large";

    private FrameLayout adContainer;
    private PNSmallLayout smallLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_can_demo);

        adContainer = findViewById(R.id.ad_container);

        initSmallLayout();
    }

    private void initSmallLayout() {
        smallLayout = new PNSmallLayout();

        smallLayout.setTrackListener(new PNLayout.TrackListener() {
            @Override
            public void onPNLayoutTrackImpression(PNLayout pnLayout) {

            }

            @Override
            public void onPNLayoutTrackClick(PNLayout pnLayout) {

            }
        });

        smallLayout.load(this, APP_TOKEN, PLACEMENT_SMALL, this);
    }

    @Override
    public void onPNLayoutLoadFinish(PNLayout pnLayout) {
        adContainer.addView(smallLayout.getView(this));
        smallLayout.startTrackingView();
    }

    @Override
    public void onPNLayoutLoadFail(PNLayout pnLayout, Exception e) {
        Log.e(TAG, e.getMessage());
    }

    @Override
    protected void onDestroy() {
        if(smallLayout != null) {
            smallLayout.stopTrackingView();
        }
        super.onDestroy();
    }
}
