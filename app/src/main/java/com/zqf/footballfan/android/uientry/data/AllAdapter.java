package com.zqf.footballfan.android.uientry.data;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by liyan on 16/3/22.
 */
public class AllAdapter extends BaseAdapter {

    Context context;
    DataParser.ResultData resultData;

    public AllAdapter(Context context, DataParser.ResultData resultData) {
        this.context = context;
        this.resultData = resultData;
    }

    @Override
    public int getViewTypeCount() {
        return resultData.classList.size();
    }

    @Override
    public int getItemViewType(int position) {
        Object data = resultData.dataList.get(position);
        for (int i = 0; i < resultData.classList.size(); i++) {
            if (data.getClass() == resultData.classList.get(i)) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public int getCount() {
        return resultData.dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return resultData.dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        List<Object> list = resultData.dataList;
        Object data = list.get(position);
        View view = null;
        if (data instanceof MatchInfoData) {
            view = ItemView.getMatchInfoView(context, (MatchInfoData) data, position,
                    convertView, parent);
        } else if (data instanceof TimeLineData) {
            view = ItemView.getTimeLineView(context, (TimeLineData) data, position,
                    convertView, parent);
        } else if (data instanceof MatchData) {
            view = ItemView.getMatchDataView(context, (MatchData) data, position, convertView, parent);
        }
        return view;
    }


}
