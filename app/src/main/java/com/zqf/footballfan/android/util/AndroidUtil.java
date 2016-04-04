package com.zqf.footballfan.android.util;

import android.content.Context;

/**
 * Created by liyan on 16/3/30.
 */
public class AndroidUtil {

    public static void copyTextToClipboard(Context context, String text) {
        if (android.os.Build.VERSION.SDK_INT > 11) {
            android.content.ClipboardManager c =
                    (android.content.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            c.setText(text);
        } else {
            android.text.ClipboardManager c =
                    (android.text.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            c.setText(text);
        }
    }
}
