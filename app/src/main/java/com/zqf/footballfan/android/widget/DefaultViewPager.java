package com.zqf.footballfan.android.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by liyan on 15/12/18.
 */
public class DefaultViewPager extends ViewPager {

    public DefaultViewPager(Context context) {
        this(context,null);
    }

    public DefaultViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        try{
            return super.dispatchTouchEvent(ev);
        } catch (IllegalArgumentException ex){
            ex.printStackTrace();
            return false;
        }
    }


        @Override
    public boolean onTouchEvent(MotionEvent ev) {
        try{
            return super.onTouchEvent(ev);
        } catch (IllegalArgumentException ex){
            ex.printStackTrace();
            return false;
        }
    }
}
