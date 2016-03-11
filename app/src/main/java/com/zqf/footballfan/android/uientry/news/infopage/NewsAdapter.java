package com.zqf.footballfan.android.uientry.news.infopage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zqf.footballfan.android.R;
import com.zqf.footballfan.android.uientry.data.NewsData;

import java.util.List;

/**
 * Created by liyan on 15/12/19.
 */
public class NewsAdapter extends BaseAdapter {

    Context context;
    List<NewsData> dataList;
    View.OnClickListener listener;

    public NewsAdapter(Context context, List<NewsData> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.news_content_item_layout, parent, false);
            holder = new ViewHolder();
            holder.titleTv = (TextView) convertView.findViewById(R.id.title);
            holder.descTv = (TextView) convertView.findViewById(R.id.desc);
            holder.imageView = (ImageView) convertView.findViewById(R.id.image);
            holder.tagView = (TextView) convertView.findViewById(R.id.tag);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        NewsData data = dataList.get(position);
        holder.data = data;
        holder.titleTv.setText(data.title);
        holder.descTv.setText(data.desc);
        if (data.tag == null) {
            holder.tagView.setVisibility(View.GONE);
        } else {
            holder.tagView.setText(data.tag);
            holder.tagView.setVisibility(View.VISIBLE);
        }
        Picasso.with(context).load(data.image).into(holder.imageView);
        if (listener != null) {
            convertView.setOnClickListener(listener);
        }
        return convertView;
    }

    public static class ViewHolder {
        public NewsData data;
        public TextView titleTv;
        public TextView descTv;
        public ImageView imageView;
        public TextView tagView;
    }
}
