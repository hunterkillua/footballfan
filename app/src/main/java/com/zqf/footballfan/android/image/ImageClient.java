package com.zqf.footballfan.android.image;


/**
 * Created by liyan on 16/1/4.
 */
public class ImageClient {

    private static final ImageClient instance = new ImageClient();

    public static ImageClient getInstance() {
        return instance;
    }

    public ImageRequest load(String url) {
        return new PicassoRequest().load(url);
    }

}
