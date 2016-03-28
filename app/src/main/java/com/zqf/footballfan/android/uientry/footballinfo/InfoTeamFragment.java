package com.zqf.footballfan.android.uientry.footballinfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.zqf.footballfan.android.R;
import com.zqf.footballfan.android.uientry.BaseFragment;
import com.zqf.footballfan.android.uientry.data.AllAdapter;
import com.zqf.footballfan.android.uientry.data.DataParser;

/**
 * Created by liyan on 16/3/26.
 */
public class InfoTeamFragment extends BaseFragment {
    protected ListView listView;
    protected View footView;

    @Override
    protected View createView(LayoutInflater inflater, ViewGroup parent) {
        listView = (ListView) inflater.inflate(R.layout.news_list_view, parent, false);
        footView = inflater.inflate(R.layout.loading_footview, null, false);
        listView.addFooterView(footView);
        return listView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        swipeRefreshLayout.setChildView(listView);
    }


    @Override
    protected void loadData() {
        progressView.setVisibility(View.INVISIBLE);
        DataParser.ResultData data = DataParser.getInfoTeamData("");
        AllAdapter adapter = new AllAdapter(getContext(), data);
        listView.setAdapter(adapter);
    }

    @Override
    protected void refreshTop() {

        swipeRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 2000);

    }

    @Override
    protected void refreshBottom() {

        swipeRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setLoading(false);
            }
        }, 2000);

    }
}
