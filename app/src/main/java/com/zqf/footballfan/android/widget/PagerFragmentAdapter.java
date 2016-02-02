package com.zqf.footballfan.android.widget;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by liyan on 15/12/18.
 */
public class PagerFragmentAdapter extends FragmentPagerAdapter {

    private Context mContext;

    private Class<? extends Fragment>[] mFragments;

    private int[] mTitles;

    public PagerFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    public void setData(Class<? extends Fragment>[] fragments, int[] titles) {
        mFragments = fragments;
        mTitles = titles;
        if (mFragments == null && mTitles == null) {
            notifyDataSetChanged();
            return;
        } else if (mFragments != null && mTitles != null) {
            if (mFragments.length == mTitles.length) {
                notifyDataSetChanged();
                return;
            }
        }
        throw new IllegalArgumentException("");
    }

    @Override
    public Fragment getItem(int position) {
        try {
            return mFragments[position].newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getCount() {
        return mFragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position < mTitles.length) {
            return mContext.getResources().getString(mTitles[position]);
        }
        return super.getPageTitle(position);
    }

}
