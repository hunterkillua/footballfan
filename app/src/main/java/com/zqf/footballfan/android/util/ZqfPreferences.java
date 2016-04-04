package com.zqf.footballfan.android.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ZqfPreferences {
    private static final String KEY_PREFER_NAME = "zqf_spef";
    private static final String KEY_PREFER_OBJECT_NAME = "key_prefer_object";

    public static final String KEY_SEARCH_WORD_HISTORY_ = "key_search_word_history_";
    public static final String KEY_SEARCH_WORD_NUMBER = "key_search_word_number";



    public static String getString(Context context, String key) {
        SharedPreferences multiPref = context.getApplicationContext().getSharedPreferences(KEY_PREFER_NAME, Context
                .MODE_PRIVATE);
        if (multiPref != null) {
            return multiPref.getString(key, null);
        }
        return null;
    }

    public static String getString(Context context, String key, String defValue) {
        SharedPreferences multiPref = context.getApplicationContext().getSharedPreferences(KEY_PREFER_NAME, Context
                .MODE_PRIVATE);
        if (multiPref != null) {
            return multiPref.getString(key, defValue);
        }
        return defValue;
    }

    public static boolean getBoolean(Context context, String key, boolean defValue) {
        SharedPreferences multiPref = context.getApplicationContext().getSharedPreferences(KEY_PREFER_NAME, Context
                .MODE_PRIVATE);
        if (multiPref != null) {
            return multiPref.getBoolean(key, defValue);
        }
        return defValue;
    }

    public static int getInt(Context context, String key, int defValue) {
        SharedPreferences multiPref = context.getApplicationContext().getSharedPreferences(KEY_PREFER_NAME, Context
                .MODE_PRIVATE);
        if (multiPref != null) {
            return multiPref.getInt(key, defValue);
        }
        return defValue;
    }

    public static long getLong(Context context, String key, long defValue) {
        SharedPreferences multiPref = context.getApplicationContext().getSharedPreferences(KEY_PREFER_NAME, Context
                .MODE_PRIVATE);
        if (multiPref != null) {
            return multiPref.getLong(key, defValue);
        }
        return defValue;
    }

    public static void saveLong(Context context, String key, long value) {
        SharedPreferences multiPref = context.getApplicationContext().getSharedPreferences(KEY_PREFER_NAME, Context
                .MODE_PRIVATE);
        if (multiPref != null) {
            SharedPreferences.Editor edit = multiPref.edit();
            edit.putLong(key, value);
            edit.commit();
        }
    }

    public static void saveInt(Context context, String key, int value) {
        SharedPreferences multiPref = context.getApplicationContext().getSharedPreferences(KEY_PREFER_NAME, Context
                .MODE_PRIVATE);
        if (multiPref != null) {
            SharedPreferences.Editor edit = multiPref.edit();
            edit.putInt(key, value);
            edit.commit();
        }
    }

    public static void saveString(Context context, String key, String value) {
        SharedPreferences multiPref = context.getApplicationContext().getSharedPreferences(KEY_PREFER_NAME, Context
                .MODE_PRIVATE);
        if (multiPref != null) {
            SharedPreferences.Editor edit = multiPref.edit();
            edit.putString(key, value);
            edit.commit();
        }
    }

    public static void saveBoolean(Context context, String key, boolean value) {
        SharedPreferences multiPref = context.getApplicationContext().getSharedPreferences(KEY_PREFER_NAME, Context
                .MODE_PRIVATE);
        if (multiPref != null) {
            SharedPreferences.Editor edit = multiPref.edit();
            edit.putBoolean(key, value);
            edit.commit();
        }
    }


    /** 写入某对象 */
    public static void setObject(Context context, String key, Object obj) {
        SharedPreferences objectPref = context.getApplicationContext().getSharedPreferences(
                KEY_PREFER_OBJECT_NAME, Context.MODE_PRIVATE);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            String strBase64 = new String(Base64.encode(baos.toByteArray(), Base64.DEFAULT));

            objectPref.edit().putString(key, strBase64).commit();
        } catch (IOException e) {
        }
    }

    /** 读出某对象 */
    public static Object getObject(Context context, String key) {
        SharedPreferences objectPref = context.getApplicationContext().getSharedPreferences(
                KEY_PREFER_OBJECT_NAME, Context.MODE_PRIVATE);
        String strBase64 = "";
        if (findPreference(context, key)) {
            strBase64 = getPreference(context, key, "");
            objectPref.edit().putString(key, strBase64).commit();
            remove(context, key);
        } else {
            strBase64 = objectPref.getString(key, "");
        }
        ByteArrayInputStream bais = new ByteArrayInputStream(Base64.decode(strBase64, Base64.DEFAULT));
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 查找是否存在对应配置项
     *
     * @param context 上下文
     * @param key 配置项key值
     * @return true - 存在 false - 不存在
     */
    public static boolean findPreference(Context context, String key) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.contains(key);
    }

    public static String getPreference(Context context, String key, String defaultValue) {
        return getString(context, key, defaultValue);
    }

    public static void remove(Context context, String key) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit = pref.edit();
        edit.remove(key);
        edit.commit();
    }
}
