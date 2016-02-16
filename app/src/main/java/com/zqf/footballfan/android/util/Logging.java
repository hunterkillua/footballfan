package com.zqf.footballfan.android.util;

import android.util.Log;

import com.zqf.footballfan.android.BuildConfig;

/**
 * Created by liyan on 16/2/5.
 */
public final class Logging {

    public static final boolean DEBUG = BuildConfig.DEBUG;

    public static void E(String tag, String msg, Throwable tr) {
        if (DEBUG) {
            Log.e(tag, msg, tr);
        }
    }

    public static void E(String tag, String msg) {
        if (DEBUG) {
            Log.e(tag, msg);
        }
    }

    public static void V(String TAG, final String msg) {
        if (DEBUG) {
            Log.v(TAG, msg);
        }
    }

    public static void D(String tag, String msg) {
        if (DEBUG) {
            Log.d(tag, msg);
        }
    }
}
