package com.zqf.footballfan.android.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by liyan on 16/2/5.
 */
public class IoUtil {

    public static void closeStream(Closeable close) {
        if (close != null) {
            try {
                close.close();
            } catch (IOException e) {
            }
        }
    }
}
