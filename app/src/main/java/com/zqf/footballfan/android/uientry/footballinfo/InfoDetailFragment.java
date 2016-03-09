package com.zqf.footballfan.android.uientry.footballinfo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.zqf.footballfan.android.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyan on 15/12/19.
 */
public class InfoDetailFragment extends Fragment {

    GridView mGridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fbinfo_main_layout, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initGridView();
    }

    private void initGridView() {
        mGridView = (GridView) getView().findViewById(R.id.gridview);

        List<FootBallInfoData> list = new ArrayList<FootBallInfoData>();
        for (int i = 0; i < 20; i++) {
            FootBallInfoData data = new FootBallInfoData();
            data.image = "http://pic.6188.com/upload_6188s/Small_paper/tiyu/5008/s800/sjbzqbz_006.jpg";
            data.title = "足球";
            list.add(data);
        }

        InfoGridAdapter adapter = new InfoGridAdapter(getActivity(), list);
        mGridView.setAdapter(adapter);

    }

}