package com.zqf.footballfan.android.image;

import android.content.Context;

/**
 * Created by liyan on 16/1/4.
 */
public class ImageClient {

    private static final ImageClient instance = new ImageClient();

    public static ImageClient getInstance() {
        return instance;
    }

    public ImageRequest load(Context context, String url) {
        return new PicassoRequest(context).load(url);
    }

}
