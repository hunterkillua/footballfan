package com.zqf.footballfan.android.uientry.news.thinkpage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zqf.footballfan.android.R;
import com.zqf.footballfan.android.uientry.data.TimeLineData;
import com.zqf.footballfan.android.uientry.data.ThinkData;

import java.util.List;

/**
 * Created by liyan on 16/1/2.
 */
public class NewsThinkAdapter extends BaseAdapter {
    public static final int TYPE_NEWS_TIMELINE = 0;
    public static final int TYPE_NEWS_THINK = 1;
    public static final int TYPE_COUNT = 2;

    Context mContext;
    List<Object> mList;

    public NewsThinkAdapter(Context context, List<Object> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        // TODO Auto-generated method stub
        Object object = mList.get(position);
        int type = -1;
        if (object instanceof ThinkData) {
            type = TYPE_NEWS_THINK;
        } else if (object instanceof TimeLineData) {
            type = TYPE_NEWS_TIMELINE;
        }
        return type;
    }

    @Override
    public int getViewTypeCount() {
        // TODO Auto-generated method stub
        return TYPE_COUNT;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        switch (type) {
            case TYPE_NEWS_THINK:
                return getThinkView(position, convertView, parent);
            case TYPE_NEWS_TIMELINE:
                return getTimeLineView(position, convertView, parent);
        }
        return null;
    }

    protected View getTimeLineView(int position, View convertView, ViewGroup parent) {
        TimeLineData data = (TimeLineData) mList.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.timeline_layout, parent, false);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.text);
        textView.setText(data.content);
        if (data.type == TimeLineData.TYPE_FIRST) {
            textView.setBackgroundResource(R.drawable.timeline_text_bg2);
        } else {
            textView.setBackgroundResource(R.drawable.timeline_text_bg1);
        }
        return convertView;
    }

    protected View getThinkView(int position, View convertView, ViewGroup parent) {
        ThinkData data = (ThinkData) mList.get(position);
        ThinkViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.news_think_item_layout, parent, false);
            holder = new ThinkViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.desc = (TextView) convertView.findViewById(R.id.desc);
            holder.author = (TextView) convertView.findViewById(R.id.author);
            holder.identity = (TextView) convertView.findViewById(R.id.identity);
            holder.image = (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(holder);
        } else {
            holder = (ThinkViewHolder) convertView.getTag();
        }
        holder.title.setText(data.title);
        holder.desc.setText(data.desc);
        holder.author.setText(data.author);
        holder.identity.setText(data.identity);

        return convertView;
    }

    class ThinkViewHolder {
        TextView title;
        TextView desc;
        TextView author;
        TextView identity;
        ImageView image;
    }
}
