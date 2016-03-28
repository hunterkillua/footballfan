package com.zqf.footballfan.android.uientry.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.widget.LinearLayout;

import com.zqf.footballfan.android.R;
import com.zqf.footballfan.android.uientry.fancenter.FanCenterFragment;
import com.zqf.footballfan.android.uientry.footballinfo.FootBallInfoFragment;
import com.zqf.footballfan.android.uientry.footballmatch.MacthFragment;
import com.zqf.footballfan.android.uientry.news.NewsFragment;
import com.zqf.footballfan.android.uientry.usercenter.LoginFragment;
import com.zqf.footballfan.android.widget.PagerFragmentAdapter;
import com.zqf.footballfan.android.widget.TitleFragmentAdapter;
import com.zqf.footballfan.android.widget.ViewPagerSlidingTabs;


public class MainActivity extends FragmentActivity {
    ViewPager viewPager;
    ViewPagerSlidingTabs tabsView;
    TitleFragmentAdapter titleFragmentAdapter;
    PagerFragmentAdapter pagerFragmentAdapter;
    Class<? extends Fragment>[] fragments = new Class[] {NewsFragment.class, MacthFragment.class,
            LoginFragment.class, FootBallInfoFragment.class, FanCenterFragment.class};
    int[] titlesRes = new int[] {R.string.main_news, R.string.main_match, R.string.main_football, R.string.main_footballinfo,
            R.string.main_fancenter};
//    String[] titles = new String[] {"资讯", "看球", "数据", "球迷圈"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabsView = (ViewPagerSlidingTabs) findViewById(R.id.tabs);
//        titleFragmentAdapter = new TitleFragmentAdapter(this, getSupportFragmentManager());
//        for (int i = 0; i< 3; i++) {
//            Fragment fragment = new NewsFragment();
//            titleFragmentAdapter.addFragment(fragment, "fragment" + i);
//        }
//        titleFragmentAdapter.addFragment(new FanCenterFragment(), "footballfragment");
//        pagerFragmentAdapter = new PagerFragmentAdapter(this, getSupportFragmentManager());

        pagerFragmentAdapter = new PagerFragmentAdapter(this, getSupportFragmentManager());
        pagerFragmentAdapter.setData(fragments, titlesRes);
        viewPager.setAdapter(pagerFragmentAdapter);
        tabsView.initViewPager(viewPager);
        tabsView.setSmooth(false);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout
                .LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;
        tabsView.setTabView(R.layout.main_bottom_tab_layout0, params);
        tabsView.selectPage(0);
        viewPager.setCurrentItem(0);
    }
}
