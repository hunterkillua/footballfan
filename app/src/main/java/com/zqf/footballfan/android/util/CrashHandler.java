package com.zqf.footballfan.android.util;

import android.app.Application;
import android.content.Context;
import android.os.Debug;
import android.os.Looper;

import com.zqf.footballfan.android.util.constants.PATHS;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by liyan on 16/2/5.
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    public static final String TAG = "CrashHandler";
    private static final String OOM = "java.lang.OutOfMemoryError";

    private static final CrashHandler instance = new CrashHandler();
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    private Context mContext;

    private CrashHandler() {
    }

    public static CrashHandler getInstance() {
        return instance;
    }

    public void init(Application app) {
        mContext = app.getApplicationContext();
        // 获取系统默认的UncaughtException处理器
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        // 设置该CrashHandler为程序的默认处理器
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public Thread.UncaughtExceptionHandler getDefaultHandler() {
        if (mDefaultHandler == null) {
            mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        }
        return mDefaultHandler;
    }

    private boolean isOOM(Throwable throwable) {
        throwable.printStackTrace();
        if (OOM.equals(throwable.getClass().getName())) {
            return true;
        } else {
            Throwable cause = throwable.getCause();
            if (cause != null) {
                return isOOM(cause);
            }
            return false;
        }
    }

    @Override
    public void uncaughtException(final Thread thread, final Throwable ex) {
        // 在自定义异常处理没有处理到的时候，就调用系统原来的异常处理方法处理
        if (Logging.DEBUG && isOOM(ex)) {
            try {
                Debug.dumpHprofData(PATHS.HPROF_FILE_PATH);
            } catch (Exception e) {
                Logging.E(TAG, "couldn’t dump hprof", e);
            }
        }
        if (Logging.DEBUG) {
            if (!handleException(thread, ex) && getDefaultHandler() != null) {
                getDefaultHandler().uncaughtException(thread, ex);
            }
        }
    }

    /**
     * 处理异常
     *
     * @param ex
     *
     * @return true 异常已处理 false 异常没处理
     */
    private boolean handleException(final Thread thread, final Throwable ex) {
        if (ex == null) {
            return false;
        }
        new Thread() {
            @Override
            public void run() {
                Looper.prepare();
                String path = PATHS.CRASH_FILE_PATH;
                saveCrashInfo2File(path, ex);
                getDefaultHandler().uncaughtException(thread, ex);
                Looper.loop();
            }
        }.start();
        return true;
    }

    private void saveCrashInfo2File(String path, Throwable ex) {
        FileUtil.saveText(getTrowable(ex), path);
    }

    private String getTrowable(Throwable ex) {
        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        ex.printStackTrace(printWriter);
        Throwable cause = ex.getCause();
        while (cause != null) {
            cause.printStackTrace(printWriter);
            cause = cause.getCause();
        }
        printWriter.close();
        String result = writer.toString();
        Logging.D(TAG, result);
        return result;
    }
}
