package com.zqf.footballfan.android.uientry.footballmatch;

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
public class MatchInfoFragment extends BaseFragment {

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

//    static class MatchInfoAdapter extends BaseAdapter {
//
//        Context context;
//        List<Object> list;
//
//        public MatchInfoAdapter(Context context, List<Object> list) {
//            this.context = context;
//            this.list = list;
//        }
//
//        @Override
//        public int getItemViewType(int position) {
//            // TODO Auto-generated method stub
//            Object object = list.get(position);
//            int type = -1;
//            if (object instanceof MatchInfoData) {
//                type = 0;
//            } else if (object instanceof TimeLineData) {
//                type = 1;
//            }
//            return type;
//        }
//
//        @Override
//        public int getCount() {
//            return list.size();
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return list.get(position);
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            int type = getItemViewType(position);
//            if (type == 0) {
//                return ItemView.getMatchInfoView(context, (MatchInfoData) list.get(position), position, convertView, parent);
//
//            } else{
//                return ItemView.getTimeLineView(context, (TimeLineData) list.get(position), position, convertView,
//                        parent);
//            }
//        }
//
//    }
}
