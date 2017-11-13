package net.pubnative.candemotest;

import android.app.Application;

import net.pubnative.sdk.core.Pubnative;
import net.pubnative.sdk.core.request.PNAdTargetingModel;

/**
 * Created by erosgarciaponte on 13.11.17.
 */

public class CanDemoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        PNAdTargetingModel targetingModel = new PNAdTargetingModel();
        targetingModel.age = 27;
        targetingModel.gender = "male";
        Pubnative.setTargeting(targetingModel);

        Pubnative.init(getApplicationContext(), "87960ef9e8d14200bc9fa7f7ed2354f2");
    }
}
