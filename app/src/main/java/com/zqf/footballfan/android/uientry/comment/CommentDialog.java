package com.zqf.footballfan.android.uientry.comment;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.zqf.footballfan.android.R;

/**
 * Created by liyan on 16/1/3.
 */
public class CommentDialog extends Dialog {
    
    public CommentDialog(Context context) {
        this(context, R.style.dialogNoTitleDialog);
    }

    public CommentDialog(Context context, int theme) {
        super(context, R.style.dialogNoTitleDialog);
        setContentView(R.layout.comment_dialog_layout);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        findViewById(R.id.reply).setOnClickListener(mOnClickListener);
        findViewById(R.id.copy).setOnClickListener(mOnClickListener);
        findViewById(R.id.weibo).setOnClickListener(mOnClickListener);
        findViewById(R.id.pengyouquan).setOnClickListener(mOnClickListener);
        findViewById(R.id.weixin).setOnClickListener(mOnClickListener);
        findViewById(R.id.jubao).setOnClickListener(mOnClickListener);
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.reply:
                    break;
                case R.id.copy:
                    break;
                case R.id.weibo:
                    break;
                case R.id.pengyouquan:
                    break;
                case R.id.weixin:
                    break;
                case R.id.jubao:
                    break;
            }
        }
    };
}
