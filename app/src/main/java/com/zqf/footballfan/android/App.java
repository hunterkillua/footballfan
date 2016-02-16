package com.zqf.footballfan.android;

import android.app.Application;

import com.zqf.footballfan.android.util.CrashHandler;
import com.zqf.footballfan.android.util.DensityUtil;

/**
 * Created by liyan on 15/12/19.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler.getInstance().init(this);
        DensityUtil.initDensityConstants(this);
    }
}
