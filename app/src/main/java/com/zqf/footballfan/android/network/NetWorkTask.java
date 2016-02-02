package com.zqf.footballfan.android.network;

import android.os.AsyncTask;
import android.os.Build;

import java.lang.reflect.Field;

/**
 * Created by liyan on 15/12/8.
 */
public abstract class NetWorkTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {

    public NetWorkTask() {
        super();
    }

//    public void startExecute(Params... paramses) {
//        if (Build.VERSION.SDK_INT >= 11) {
//            executeOnExecutor(ThreadManager.bgThreadExecutor, paramses);
//        } else {
//            try {
//                Field f = AsyncTask.class.getDeclaredField("sExecutor");
//                f.setAccessible(true);
//                f.set(this, ThreadManager.bgThreadExecutor);
//            } catch (NoSuchFieldException e) {
//                e.printStackTrace();
//            } catch (IllegalArgumentException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//            execute(paramses);
//        }
//    }

}
