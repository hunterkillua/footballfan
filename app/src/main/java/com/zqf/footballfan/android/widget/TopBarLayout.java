package com.zqf.footballfan.android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zqf.footballfan.android.R;

/**
 * Created by liyan on 16/1/2.
 */
public class TopBarLayout extends RelativeLayout {

    ImageView leftView;
    ImageView rightView;
    TextView textView;

    String text;
    Drawable leftDrawable;
    Drawable rightDrawable;

    ClickListener clickListener;

    public TopBarLayout(Context context) {
        this(context, null, 0);
    }

    public TopBarLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TopBarLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray a = context.obtainStyledAttributes(attrs , R.styleable.TopBarLayout, defStyle, 0);
        text = a.getString(R.styleable.TopBarLayout_topbarTitle);
        leftDrawable = a.getDrawable(R.styleable.TopBarLayout_topbarLeftIcon);
        rightDrawable = a.getDrawable(R.styleable.TopBarLayout_topbarRightIcon);
        a.recycle();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater.from(getContext()).inflate(R.layout.main_title_layout, this);
        textView = (TextView) findViewById(R.id.center);
        leftView = (ImageView) findViewById(R.id.left);
        rightView = (ImageView) findViewById(R.id.right);

        leftView.setOnClickListener(viewListener);
        rightView.setOnClickListener(viewListener);

        if (text != null) {
            textView.setText(text);
        }
        if (leftDrawable != null) {
            leftView.setImageDrawable(leftDrawable);
        }
        if (rightDrawable != null) {
            rightView.setImageDrawable(rightDrawable);
        }
    }

    public void setClickListener(ClickListener listener) {
        clickListener = listener;
    }

    public interface ClickListener {
        public void onLeftClick(View view);
        public void onRightClick(View view);
    }

    private View.OnClickListener viewListener = new View.OnClickListener () {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.left:
                    if (clickListener != null) {
                        clickListener.onLeftClick(v);
                    }
                    break;
                case  R.id.right:
                    if (clickListener != null) {
                        clickListener.onRightClick(v);
                    }
                    break;
                default:
                    break;
            }

        }
    };
}
