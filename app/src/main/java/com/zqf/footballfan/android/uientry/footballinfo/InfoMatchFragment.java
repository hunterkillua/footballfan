package com.zqf.footballfan.android.uientry.footballinfo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.zqf.footballfan.android.R;
import com.zqf.footballfan.android.uientry.BaseFragment;
import com.zqf.footballfan.android.uientry.data.AllAdapter;
import com.zqf.footballfan.android.uientry.data.DataParser;
import com.zqf.footballfan.android.uientry.data.ItemView;
import com.zqf.footballfan.android.uientry.data.MatchInfoData;
import com.zqf.footballfan.android.uientry.data.TimeLineData;

import java.util.List;

/**
 * Created by liyan on 16/3/15.
 */
public class InfoMatchFragment extends BaseFragment {
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
        DataParser.ResultData data = DataParser.getMatchInfoData("");
        AllAdapter adapter = new AllAdapter(getContext(), data);
        listView.setAdapter(adapter);
    }

    @Override
    protected void refreshTop() {

    }

    @Override
    protected void refreshBottom() {

    }
}