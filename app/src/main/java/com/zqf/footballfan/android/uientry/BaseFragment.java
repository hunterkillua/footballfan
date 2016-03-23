package com.zqf.footballfan.android.uientry;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.zqf.footballfan.android.R;
import com.zqf.footballfan.android.widget.RefreshLayout;

/**
 * Created by liyan on 16/3/15.
 */
public abstract class BaseFragment extends Fragment {

    protected View progressView;
    protected RefreshLayout swipeRefreshLayout;
    protected boolean hasLoad = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FrameLayout parent = (FrameLayout) inflater.inflate(R.layout.base_fragment_layout, container, false);
        swipeRefreshLayout = (RefreshLayout) parent.findViewById(R.id.swiperefresh);
        swipeRefreshLayout.addView(createView(inflater, parent));
        return parent;
    }

    protected abstract View createView(LayoutInflater inflater, ViewGroup parent);

    protected void loadData() {

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(getUserVisibleHint() && !hasLoad) {
            loadData();
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        progressView = getView().findViewById(R.id.progress);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshTop();
            }
        });
        swipeRefreshLayout.setOnLoadListener(new RefreshLayout.OnLoadListener() {
            @Override
            public void onLoad() {
                refreshBottom();
            }
        });
        swipeRefreshLayout
                .setColorSchemeResources(R.color.theme_color_main, R.color.theme_color_main, R.color.theme_color_main,
                        R.color.theme_color_main);
    }

    protected abstract void refreshTop();

    protected abstract void refreshBottom();

}
