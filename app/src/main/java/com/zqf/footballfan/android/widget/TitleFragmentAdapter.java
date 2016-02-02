package com.zqf.footballfan.android.widget;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyan on 15/12/13.
 */
public class TitleFragmentAdapter extends FragmentPagerAdapter{
    private Context mContext;

    private List<Fragment> mFragments;
    private List<String> mTitles;


    public TitleFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    public void addFragment(Fragment fragment, String title) {
        if (mFragments == null) {
            mFragments = new ArrayList<Fragment>();
        }
        if (mTitles == null) {
            mTitles = new ArrayList<String>();
        }
        mFragments.add(fragment);
        mTitles.add(title);
    }



    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mFragments.get(position).hashCode();
    }

    @Override
    public int getCount() {
        return mFragments != null ? mFragments.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position < mTitles.size()) {
            return mTitles.get(position);
        }
        return super.getPageTitle(position);
    }

    @Override
    public int getItemPosition(Object object) {
        if (object instanceof Fragment) {
            if (mFragments != null) {
                int index = mFragments.indexOf(object);
                if (index == -1) {
                    return PagerAdapter.POSITION_NONE;
                }
                return index;
            }
        }
        return PagerAdapter.POSITION_NONE;
    }
}
