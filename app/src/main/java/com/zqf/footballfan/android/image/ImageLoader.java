package com.zqf.footballfan.android.image;

import android.widget.ImageView;

/**
 * Created by liyan on 15/12/11.
 */
public class ImageLoader {
    private static ImageLoader instance = new ImageLoader();

    private ImageLoader() {

    }

    public static ImageLoader getInstance() {
        return instance;
    }

    public void load(ImageView imageView, String path, int placeId, int errId) {
        if (imageView == null) {
            return;
        }
        if (path == null || "".equals(path)) {
            imageView.setImageResource(placeId);
        } else {

        }
    }

}
