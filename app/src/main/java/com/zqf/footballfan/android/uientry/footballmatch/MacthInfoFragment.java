package com.zqf.footballfan.android.uientry.footballmatch;

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
import com.zqf.footballfan.android.uientry.news.infopage.NewsPageFragment;
import com.zqf.footballfan.android.uientry.news.topicpage.NewsTopicFragment;
import com.zqf.footballfan.android.widget.TitleFragmentAdapter;
import com.zqf.footballfan.android.widget.ViewPagerSlidingTabs;

/**
 * Created by liyan on 15/12/19.
 */
public class MacthInfoFragment extends Fragment {

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
        Fragment fragment = new MatchListFragment();
        titleFragmentAdapter.addFragment(fragment, getString(R.string.match_tab_focus));
        fragment = new NewsPageFragment();
        titleFragmentAdapter.addFragment(fragment, getString(R.string.match_tab_info));
        fragment = new NewsPageFragment();
        titleFragmentAdapter.addFragment(fragment, getString(R.string.match_tab_cup));
        fragment = new NewsPageFragment();
        titleFragmentAdapter.addFragment(fragment, getString(R.string.match_tab_match));
        fragment = new NewsTopicFragment();
        titleFragmentAdapter.addFragment(fragment, getString(R.string.match_tab_other));
        viewPager.setAdapter(titleFragmentAdapter);
        tabsView.initViewPager(viewPager);
        tabsView.setTabView(R.layout.main_top_tab_layout);
        tabsView.addStripLayout(R.layout.view_pager_tab_strip_layout);
        tabsView.selectPage(0);
    }
}
