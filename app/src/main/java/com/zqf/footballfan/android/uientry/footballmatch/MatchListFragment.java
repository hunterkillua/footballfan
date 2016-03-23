package com.zqf.footballfan.android.uientry.footballmatch;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.zqf.footballfan.android.uientry.data.DataParser;
import com.zqf.footballfan.android.uientry.data.ItemView;
import com.zqf.footballfan.android.uientry.data.MatchData;

import java.util.List;

/**
 * Created by liyan on 15/12/19.
 */
public class MatchListFragment extends Fragment {

    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        listView = new ListView(getActivity());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams
                .MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        listView.setLayoutParams(layoutParams);
        initListView();
        return listView;
    }

    private void initListView(){
        MatchDetailAdapter adapter = new MatchDetailAdapter(getActivity(), DataParser.getMatchData(""));
        listView.setAdapter(adapter);
    }

    static class MatchDetailAdapter extends BaseAdapter {

        Context context;
        List<MatchData> list;

        public MatchDetailAdapter(Context context, List<MatchData> list) {
            this.context = context;
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return ItemView.getMatchDataView(context, list.get(position), position, convertView, parent);
        }

    }
}
