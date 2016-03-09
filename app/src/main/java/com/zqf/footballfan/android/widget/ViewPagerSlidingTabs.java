package com.zqf.footballfan.android.widget;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.TextView;

import com.zqf.footballfan.android.R;


/**
 * Created by liyan on 15/12/13.
 */
public class ViewPagerSlidingTabs extends HorizontalScrollView implements
        ViewPager.OnPageChangeListener {
    private ViewPager mViewPager;

    private PagerAdapter mAdapter;

    private ViewGroup mTabsContainer;
    private LinearLayout mcontainer;
    private LinearLayout.LayoutParams mTabLayoutParams;



    private boolean mSmooth = true;


    public ViewPagerSlidingTabs(Context context) {
        this(context, null);
    }

    public ViewPagerSlidingTabs(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewPagerSlidingTabs(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        setHorizontalScrollBarEnabled(false);
        mcontainer = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.viewpager_container_layout, this, false);
        addView(mcontainer);
        setFillViewport(true);
        setWillNotDraw(false);
    }

    public void setSmooth(boolean b) {
        mSmooth = b;
    }

    public void initViewPager(ViewPager pager) {
        if (mViewPager != null) {
            mViewPager.setOnPageChangeListener(null);
        }
        mViewPager = pager;
        mViewPager.setOnPageChangeListener(this);

        mAdapter = pager.getAdapter();
        if (mAdapter == null) {
            throw new RuntimeException("init() 应该在ViewPager设置完Adapter之后调用.");
        }
    }

//    public void initTabView() {
//        LinearLayout tabsContainer = new LinearLayout(getContext());
//        tabsContainer.setOrientation(LinearLayout.HORIZONTAL);
//        mTabsContainer = tabsContainer;
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT);
//        mcontainer.addView(mTabsContainer);
//        mTabLayoutParams = true ?
//                new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1.0f) :
//                new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
//        for (int i = 0 ; i < mAdapter.getCount(); i++) {
//            View tabView = View.inflate(getContext(), R.layout.viewpager_tab_layout, null);
//            addTab(i, mAdapter.getPageTitle(i), tabView);
//        }
//    }

    public void setTabView(LinearLayout tabsContainer, LinearLayout.LayoutParams params) {
        mTabsContainer = tabsContainer;
        addView(mTabsContainer, params);
        initChildTab();
    }

    public void setTabView(int id, ViewGroup.LayoutParams params) {
        mTabsContainer = (ViewGroup) LayoutInflater.from(getContext()).inflate(id, null);
        if (params != null) {
            mcontainer.addView(mTabsContainer, params);
        } else {
            mcontainer.addView(mTabsContainer);
        }
        initChildTab();
    }

    public void setTabView(int id) {
        mTabsContainer = (ViewGroup) LayoutInflater.from(getContext()).inflate(id, mcontainer, false);
        mcontainer.addView(mTabsContainer);
        initChildTab();
    }

    private void initChildTab() {
        View tabView;
        for(int i = 0; i < mTabsContainer.getChildCount(); i++) {
            final int position = i;
            tabView = mTabsContainer.getChildAt(position);
            if (tabView instanceof TextView) {
                ((TextView) tabView).setText(mAdapter.getPageTitle(position));
            } else {
                TextView textView = (TextView) tabView.findViewById(R.id.tab_textivew);
                if (textView != null) {
                    textView.setText(mAdapter.getPageTitle(position));
                }
            }
            tabView.setFocusable(true);
            tabView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mViewPager.getCurrentItem() != position) {
                        View tab = mTabsContainer.getChildAt(mViewPager.getCurrentItem());
                        unSelect(tab);
                        mViewPager.setCurrentItem(position, mSmooth);
                    }
                }
            });
        }
    }

//    private void addTab(final int position, CharSequence title, View tabView) {
//        TextView textView = (TextView) tabView.findViewById(R.id.tab_textivew);
//        if (textView != null) {
//            if (title != null) textView.setText(title);
//        }
//
//        tabView.setFocusable(true);
//        tabView.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mViewPager.getCurrentItem() != position) {
//                    View tab = mTabsContainer.getChildAt(mViewPager.getCurrentItem());
//                    unSelect(tab);
//                    mViewPager.setCurrentItem(position);
//                }
//            }
//        });
//
//        mTabsContainer.addView(tabView, position, mTabLayoutParams);
//    }

    private void unSelect(View tab) {
        if (tab != null) {
            TextView tab_title = (TextView) tab.findViewById(R.id.tab_textivew);
            if (tab_title != null) {
                tab_title.setSelected(false);
            }
            if (tab instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) tab;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    viewGroup.getChildAt(i).setSelected(false);
                }
            }
            tab.setSelected(false);
        }
    }

    private void select(View tab) {
        if (tab != null) {
            TextView tab_title = (TextView) tab.findViewById(R.id.tab_textivew);
            if (tab_title != null) {
                tab_title.setSelected(true);
            }
            if (tab instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) tab;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    viewGroup.getChildAt(i).setSelected(false);
                }
            }
            tab.setSelected(true);
        }
    }

    public void selectPage(int position) {
        for (int i = 0; i < mAdapter.getCount(); ++i) {
            View tv = mTabsContainer.getChildAt(i);
            final boolean selected = i == position;
            if (selected) {
                select(tv);
            } else {
                unSelect(tv);
            }
        }
        View tv = mTabsContainer.getChildAt(position);
        select(tv);

////////////////////////////////////
        if (canScroll()) {
            mLastSelection = mSelection;
            mSelection = position;
            // 选中位置需要变化
            mStripSelection = -1;
            mNextSelection = -1;
            View view = mTabsContainer.getChildAt(position);
            int measureWidth = view.getMeasuredWidth();
            ViewGroup.LayoutParams params = mStripView.getLayoutParams();
            int currentWidth = mStripView.getMeasuredWidth();
            int endWidth = measureWidth;
            mStripView.setLayoutParams(params);
            if (mLastSelection == -1) {
                mLastSelection = 0;
            }
            View oldView = mTabsContainer.getChildAt(mLastSelection);
            View newView = mTabsContainer.getChildAt(mSelection);
            int currX = oldView.getLeft();
            int lastX = newView.getLeft();

            smoothScrollToPosition(currX, lastX, currentWidth, endWidth);
            // 如果长度超出了当前可视长度，那么ViewPagerTabs也应该跟着滑动.
            View current = mTabsContainer.getChildAt(mSelection);
            final int left = current.getLeft();
            final int right = current.getRight();
            final int scrollX = getScrollX();
            if (left < scrollX) {
                smoothScrollTo(left, 0);
            } else if (right > scrollX + getMeasuredWidth()) {
                smoothScrollTo(right - current.getMeasuredWidth(), 0);
            }
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        selectPage(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    private Scroller mScroller;
    private LinearLayout mStripViewContainer;
    private View mStripView;
    private int mLastSelection = -1;
    private int mSelection = -1;
    private int mNextSelection = -1;
    private int mStripSelection = -1;

    /**
     * 平滑移动至指定位置.
     *
     * @param from
     * @param to
     * @param fromWidth
     * @param toWidth
     */
    private void smoothScrollToPosition(int from, int to, int fromWidth, int toWidth) {
        if (mScroller != null) {
            mScroller.abortAnimation();
        }
        mScroller = new Scroller(getContext());
        mScroller.startScroll(-from, fromWidth, from - to, toWidth - fromWidth, 800);
        invalidate();
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (canScroll()) {
            if (mScroller != null) {
                if (!mScroller.isFinished()) {
                    mScroller.computeScrollOffset();
                    int x = mScroller.getCurrX();
                    // 同时对宽度进行处理，防止宽度突变.
                    int width = mScroller.getCurrY();
                    ViewGroup.LayoutParams params = mStripView.getLayoutParams();
                    params.width = width;
                    mStripView.setLayoutParams(params);
                    mStripViewContainer.scrollTo(x, 0);
                    invalidate();
                    return;
                }
            }
            if (mSelection != -1 && mStripSelection != mSelection) {
                // 防止反复调用，导致重复绘制.
                mStripSelection = mSelection;
                View view = mTabsContainer.getChildAt(mSelection);
                ViewGroup.LayoutParams params = mStripView.getLayoutParams();
                params.width = view.getMeasuredWidth();
                mStripView.setLayoutParams(params);
                mStripViewContainer.scrollTo(-view.getLeft(), 0);
            }
        }
    }

    protected boolean canScroll() {
        return mStripViewContainer != null && mStripView != null;
    }

    public void addStripLayout(int id) {
//        mStripViewContainer = (LinearLayout) mcontainer.findViewById(R.id.view_pager_tab_strip);
//        View view = LayoutInflater.from(getContext())
//                .inflate(R.layout.view_pager_tab_strip_layout, mStripViewContainer, false);
//        mStripView = view;
//        mStripViewContainer.addView(mStripView);

        mStripViewContainer = (LinearLayout) LayoutInflater.from(getContext()).inflate(id, mcontainer, false);
        mStripView = mStripViewContainer.findViewById(R.id.view_pager_tab_strip_view);
        mcontainer.addView(mStripViewContainer);
    }
}
