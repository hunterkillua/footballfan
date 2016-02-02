package com.zqf.footballfan.android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zqf.footballfan.android.R;

/**
 * Created by liyan on 16/1/2.
 */
public class TitleTabView extends RelativeLayout {

    TextView textView;
    ImageView imageView;
    String text;
    Drawable drawable;

    public TitleTabView(Context context) {
        this(context, null, 0);
    }

    public TitleTabView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleTabView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs , R.styleable.TitleTabView, defStyle, 0);
        text = a.getString(R.styleable.TitleTabView_text);
        drawable = a.getDrawable(R.styleable.TitleTabView_icon);
        a.recycle();
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater.from(getContext()).inflate(R.layout.title_tab_view, this);
        textView = (TextView) findViewById(R.id.text);
        imageView = (ImageView) findViewById(R.id.image);
        textView.setText(text);
        imageView.setImageDrawable(drawable);
    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        textView.setSelected(selected);
        imageView.setSelected(selected);
        if (selected) {
            textView.getPaint().setFakeBoldText(true);
        } else {
            textView.getPaint().setFakeBoldText(false);
        }
    }
}
