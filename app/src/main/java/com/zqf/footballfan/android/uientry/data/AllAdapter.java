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
        return resultData.classList.length;
    }

    @Override
    public int getItemViewType(int position) {
        Object data = resultData.dataList.get(position);
        for (int i = 0; i < resultData.classList.length; i++) {
            if (data.getClass() == resultData.classList[i]) {
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
        } else if (data instanceof ImageData[]) {
            if (((ImageData[]) data).length == 2) {
                view = ItemView.getInfoTeamView(context, (ImageData[]) data, position, convertView, parent);
            } else if (((ImageData[]) data).length == 4) {
                view = ItemView.getInfoMemberItem(context, (ImageData[]) data, position, convertView, parent);
            }
        } else if (data instanceof CountryData[]) {
            view = ItemView.getInfoCountry(context, (CountryData[]) data, position, convertView, parent);
        }
        return view;
    }


}
