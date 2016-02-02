package com.zqf.footballfan.android.uientry.news;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.zqf.footballfan.android.R;
import com.zqf.footballfan.android.uientry.UiEntryTo;
import com.zqf.footballfan.android.uientry.news.infopage.NewsPageFragment;
import com.zqf.footballfan.android.uientry.news.thinkpage.NewsThinkFragment;
import com.zqf.footballfan.android.uientry.news.topicpage.NewsTopicFragment;
import com.zqf.footballfan.android.widget.TitleFragmentAdapter;
import com.zqf.footballfan.android.widget.TopBarLayout;
import com.zqf.footballfan.android.widget.ViewPagerSlidingTabs;

/**
 * Created by liyan on 15/12/19.
 */
public class NewsFragment extends Fragment {
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
        initTopBar();
        viewPager = (ViewPager) getView().findViewById(R.id.viewpager);
        tabsView = (ViewPagerSlidingTabs) getView().findViewById(R.id.tabs);
        titleFragmentAdapter = new TitleFragmentAdapter(getActivity(), getChildFragmentManager());
        Fragment fragment = new NewsPageFragment();
        titleFragmentAdapter.addFragment(fragment, getString(R.string.news_tab_focus));
        fragment = new NewsPageFragment();
        titleFragmentAdapter.addFragment(fragment, getString(R.string.news_tab_match));
        fragment = new NewsPageFragment();
        titleFragmentAdapter.addFragment(fragment, getString(R.string.news_tab_info));
        fragment = new NewsThinkFragment();
        titleFragmentAdapter.addFragment(fragment, getString(R.string.news_tab_think));
        fragment = new NewsTopicFragment();
        titleFragmentAdapter.addFragment(fragment, getString(R.string.news_tab_topic));
        viewPager.setAdapter(titleFragmentAdapter);
        tabsView.initViewPager(viewPager);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout
                .LayoutParams.WRAP_CONTENT);
        tabsView.setTabView(R.layout.main_top_tab_layout, params);
        tabsView.selectPage(0);
    }

    private void initTopBar() {
        TopBarLayout topBarLayout = (TopBarLayout) getView().findViewById(R.id.topbar);
        topBarLayout.setClickListener(new TopBarLayout.ClickListener() {
            @Override
            public void onLeftClick(View view) {
            }

            @Override
            public void onRightClick(View view) {
                UiEntryTo.toWriteArticleActivity(getActivity());
            }
        });
    }
}
