package com.zqf.footballfan.android.uientry.footballinfo;

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
import com.zqf.footballfan.android.uientry.UiEntryTo;
import com.zqf.footballfan.android.uientry.news.infopage.NewsPageFragment;
import com.zqf.footballfan.android.uientry.news.topicpage.NewsTopicFragment;
import com.zqf.footballfan.android.widget.TitleFragmentAdapter;
import com.zqf.footballfan.android.widget.TopBarLayout;
import com.zqf.footballfan.android.widget.ViewPagerSlidingTabs;

/**
 * Created by liyan on 15/12/19.
 */
public class FootBallInfoFragment extends Fragment {
    ViewPager viewPager;
    ViewPagerSlidingTabs tabsView;
    TitleFragmentAdapter titleFragmentAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.info_main_layout, null);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewPager = (ViewPager) getView().findViewById(R.id.viewpager);
        tabsView = (ViewPagerSlidingTabs) getView().findViewById(R.id.tabs);
        titleFragmentAdapter = new TitleFragmentAdapter(getActivity(), getChildFragmentManager());
        Fragment fragment;

        fragment = new InfoMatchFragment();
        titleFragmentAdapter.addFragment(fragment, getString(R.string.info_tab_match));
        fragment = new InfoTeamFragment();
        titleFragmentAdapter.addFragment(fragment, getString(R.string.info_tab_team));
        fragment = new InfoMemberFragment();
        titleFragmentAdapter.addFragment(fragment, getString(R.string.info_tab_member));
        fragment = new InfoCountryFragment();
        titleFragmentAdapter.addFragment(fragment, getString(R.string.info_tab_country));
        fragment = new NewsTopicFragment();
        titleFragmentAdapter.addFragment(fragment, getString(R.string.info_tab_other));
        viewPager.setAdapter(titleFragmentAdapter);
        tabsView.initViewPager(viewPager);
        tabsView.setTabView(R.layout.main_top_tab_layout);
        tabsView.addStripLayout(R.layout.view_pager_tab_strip_layout);
        tabsView.selectPage(0);

        initTopBar();
    }

    private void initTopBar() {
        TopBarLayout topBarLayout = (TopBarLayout) getView().findViewById(R.id.topbar);
        topBarLayout.setClickListener(new TopBarLayout.ClickListener() {
            @Override
            public void onLeftClick(View view) {

            }

            @Override
            public void onRightClick(View view) {
                UiEntryTo.toSearchActivity(getActivity());
            }
        });
    }
}
