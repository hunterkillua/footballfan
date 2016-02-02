package com.zqf.footballfan.android.image;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import java.io.File;

/**
 * Created by liyan on 16/1/4.
 */
public class PicassoRequest extends ImageRequest {
    Context context;

    public PicassoRequest(Context context) {
        this.context = context;
    }

    @Override
    public void into(ImageView imageView) {
        if (imageView == null) {
            return;
        }
        RequestCreator requestCreator = null;
        if (url != null && url.length() > 0) {
            if (url.startsWith("http")) {
                requestCreator = Picasso.with(context).load(url);
            } else {
                File file = new File(url);
                if (file.exists()) {
                    requestCreator = Picasso.with(context).load(new File(url));
                }
            }
        }

        if (requestCreator != null) {
            if (setPlaceholder) {
                if (placeholderDrawable != null) {
                    requestCreator.placeholder(placeholderDrawable);
                } else if (placeholderResId > 0) {
                    requestCreator.placeholder(placeholderResId);
                }

            }
            if (width > 0 && height > 0) {
                requestCreator.resize(width, height);
            }
            requestCreator.into(imageView);
        }
    }
}