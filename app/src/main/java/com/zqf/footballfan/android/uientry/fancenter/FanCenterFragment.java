package com.zqf.footballfan.android.uientry.fancenter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.zqf.footballfan.android.R;
import com.zqf.footballfan.android.uientry.footballmatch.MatchListFragment;
import com.zqf.footballfan.android.uientry.news.infopage.NewsPageFragment;
import com.zqf.footballfan.android.uientry.news.topicpage.NewsTopicFragment;
import com.zqf.footballfan.android.widget.TitleFragmentAdapter;
import com.zqf.footballfan.android.widget.ViewPagerSlidingTabs;

/**
 * Created by liyan on 15/12/13.
 */
public class FanCenterFragment extends Fragment {
    ViewPager viewPager;
    ViewPagerSlidingTabs tabsView;
    TitleFragmentAdapter titleFragmentAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.news_main_layout, null);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewPager = (ViewPager) getView().findViewById(R.id.viewpager);
        tabsView = (ViewPagerSlidingTabs) getView().findViewById(R.id.tabs);
        titleFragmentAdapter = new TitleFragmentAdapter(getActivity(), getChildFragmentManager());
        Fragment fragment = new UserFragment();
        titleFragmentAdapter.addFragment(fragment, getString(R.string.fan_tab_user));
        fragment = new NewsPageFragment();
        titleFragmentAdapter.addFragment(fragment, getString(R.string.fan_tab_about));
        fragment = new NewsPageFragment();
        titleFragmentAdapter.addFragment(fragment, getString(R.string.fan_tab_match));
        fragment = new NewsPageFragment();
        titleFragmentAdapter.addFragment(fragment, getString(R.string.fan_tab_collect));
        fragment = new NewsTopicFragment();
        titleFragmentAdapter.addFragment(fragment, getString(R.string.fan_tab_act));
        viewPager.setAdapter(titleFragmentAdapter);
        tabsView.initViewPager(viewPager);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout
                .LayoutParams.WRAP_CONTENT);
        tabsView.setTabView(R.layout.main_top_tab_layout, params);
        tabsView.selectPage(0);
    }
}
