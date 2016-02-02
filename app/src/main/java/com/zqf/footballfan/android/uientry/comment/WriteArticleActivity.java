package com.zqf.footballfan.android.uientry.comment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.zqf.footballfan.android.R;
import com.zqf.footballfan.android.widget.TopBarLayout;

/**
 * Created by liyan on 16/1/2.
 */
public class WriteArticleActivity extends Activity {

    TopBarLayout topBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_article);
        initTopBar();
    }

    private void initTopBar() {
        topBarLayout = (TopBarLayout) findViewById(R.id.topbar);
        topBarLayout.setClickListener(new TopBarLayout.ClickListener() {
            @Override
            public void onLeftClick(View view) {
                finish();
            }

            @Override
            public void onRightClick(View view) {
            }
        });
    }
}
