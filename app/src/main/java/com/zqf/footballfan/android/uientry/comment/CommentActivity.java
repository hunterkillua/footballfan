package com.zqf.footballfan.android.uientry.comment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.zqf.footballfan.android.R;
import com.zqf.footballfan.android.uientry.UiEntryTo;
import com.zqf.footballfan.android.widget.TitleFragmentAdapter;
import com.zqf.footballfan.android.widget.TopBarLayout;
import com.zqf.footballfan.android.widget.ViewPagerSlidingTabs;

/**
 * Created by liyan on 16/1/2.
 */
public class CommentActivity extends FragmentActivity {
    ViewPager viewPager;
    ViewPagerSlidingTabs tabsView;
    TitleFragmentAdapter titleFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        initTopBar();
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabsView = (ViewPagerSlidingTabs) findViewById(R.id.tabs);
        titleFragmentAdapter = new TitleFragmentAdapter(this, getSupportFragmentManager());
        titleFragmentAdapter.addFragment(new CommentFragment(), getString(R.string.comment_hot));
        titleFragmentAdapter.addFragment(new CommentFragment(), getString(R.string.comment_new));

        viewPager.setAdapter(titleFragmentAdapter);
        tabsView.initViewPager(viewPager);
        //tabsView.initTabView();
        tabsView.setSmooth(false);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout
                .LayoutParams.WRAP_CONTENT);
        tabsView.setTabView(R.layout.comment_tab_layout, params);
        tabsView.selectPage(0);
        viewPager.setCurrentItem(0);
    }

    private void initTopBar() {
        TopBarLayout topBarLayout = (TopBarLayout) findViewById(R.id.topbar);
        topBarLayout.setClickListener(new TopBarLayout.ClickListener() {
            @Override
            public void onLeftClick(View view) {
                finish();
            }

            @Override
            public void onRightClick(View view) {
                UiEntryTo.toWriteArticleActivity(CommentActivity.this);
            }
        });
    }
}
