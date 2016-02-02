package com.zqf.footballfan.android.image;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by liyan on 16/1/4.
 */
public abstract class ImageRequest {
    protected boolean setPlaceholder = false;
    protected int placeholderResId;
    protected Drawable placeholderDrawable;
    protected int width;
    protected int height;
    protected String url;

    public ImageRequest() {

    }

    public ImageRequest load(String url) {
        this.url = url;
        return this;
    }

    public ImageRequest placeholder(int placeholderResId) {
        setPlaceholder = true;
        this.placeholderResId = placeholderResId;
        return this;
    }

    public ImageRequest placeholder(Drawable placeholderDrawable) {
        setPlaceholder = true;
        this.placeholderDrawable = placeholderDrawable;
        return this;
    }

    public ImageRequest resize(int width, int height) {
        this.width = width;
        this.height = height;
        return this;
    }

    public abstract void into(ImageView imageView);
}
