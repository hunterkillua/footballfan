package com.zqf.footballfan.android.widget;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.lang.ref.SoftReference;
import java.util.List;

/**
 * Created by liyan on 15/12/19.
 */
public class ImagePagerAdapter extends PagerAdapter {

    List<String> imageList;
    SparseArray<SoftReference<View>> views=new SparseArray<SoftReference<View>>();
    int width = 0;
    int height = 0;
    private Context mContext;
    View.OnClickListener listener;
    int count;

    public ImagePagerAdapter(Context context){
        mContext = context;
    }

    public void setImageList(List<String> imageList, int width, int height) {
        this.imageList = imageList;
        this.width = width < 0 ? 0 : width;
        this.height = height < 0 ? 0 : height;
        count = imageList.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return imageList.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        // TODO Auto-generated method stub
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view;
        ImageView imageView = null;
        SoftReference<View> sr=views.get(position);
        if(sr!=null&&sr.get()!=null){
            view=sr.get();
        }else{
            imageView = new ImageView(mContext);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            if (width > 0) {
                params.width = width;
            }
            if (height > 0) {
                params.height = height;
            }
            Picasso.with(mContext).load(imageList.get(position)).resize(params.width, params.height)
                    .into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            view = imageView;
            if (listener != null) {
                view.setOnClickListener(listener);
            }
            views.put(position, new SoftReference<View>(view));
        }
        container.addView(view);
        return view;
    }
}
