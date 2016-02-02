package com.zqf.footballfan.android.uientry.fancenter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.zqf.footballfan.android.R;
import com.zqf.footballfan.android.uientry.news.infopage.NewsPageFragment;
import com.zqf.footballfan.android.uientry.news.topicpage.NewsTopicFragment;
import com.zqf.footballfan.android.widget.TitleFragmentAdapter;
import com.zqf.footballfan.android.widget.ViewPagerSlidingTabs;

/**
 * Created by liyan on 15/12/13.
 */
public class FanCenterFragment extends Fragment {
    private ViewPager mViewPager;
    private ViewPagerSlidingTabs mTabsView;
    private TitleFragmentAdapter mTitleFragmentAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.news_main_layout, null);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewPager = (ViewPager) getView().findViewById(R.id.viewpager);
        mTabsView = (ViewPagerSlidingTabs) getView().findViewById(R.id.tabs);
        mTitleFragmentAdapter = new TitleFragmentAdapter(getActivity(), getChildFragmentManager());
        Fragment fragment = new UserFragment();
        mTitleFragmentAdapter.addFragment(fragment, getString(R.string.fan_tab_user));
        fragment = new NewsPageFragment();
        mTitleFragmentAdapter.addFragment(fragment, getString(R.string.fan_tab_about));
        fragment = new NewsPageFragment();
        mTitleFragmentAdapter.addFragment(fragment, getString(R.string.fan_tab_match));
        fragment = new NewsPageFragment();
        mTitleFragmentAdapter.addFragment(fragment, getString(R.string.fan_tab_collect));
        fragment = new NewsTopicFragment();
        mTitleFragmentAdapter.addFragment(fragment, getString(R.string.fan_tab_act));
        mViewPager.setAdapter(mTitleFragmentAdapter);
        mTabsView.initViewPager(mViewPager);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout
                .LayoutParams.WRAP_CONTENT);
        mTabsView.setTabView(R.layout.main_top_tab_layout, params);
        mTabsView.selectPage(0);
    }
}
