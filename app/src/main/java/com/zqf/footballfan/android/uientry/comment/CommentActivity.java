package com.zqf.footballfan.android.uientry.comment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
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
    private ViewPager mViewPager;
    private ViewPagerSlidingTabs mTabsView;
    private TitleFragmentAdapter mTitleFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        initTopBar();
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mTabsView = (ViewPagerSlidingTabs) findViewById(R.id.tabs);
        mTitleFragmentAdapter = new TitleFragmentAdapter(this, getSupportFragmentManager());
        mTitleFragmentAdapter.addFragment(new CommentFragment(), getString(R.string.comment_hot));
        mTitleFragmentAdapter.addFragment(new CommentFragment(), getString(R.string.comment_new));

        mViewPager.setAdapter(mTitleFragmentAdapter);
        mTabsView.initViewPager(mViewPager);
        //mTabsView.initTabView();
        mTabsView.setSmooth(false);
        mTabsView.setTabView(R.layout.comment_tab_layout);
        mTabsView.addStripLayout(R.layout.view_pager_tab_strip_layout);
        mTabsView.selectPage(0);
        mViewPager.setCurrentItem(0);
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
