package com.zqf.footballfan.android.uientry.footballinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zqf.footballfan.android.R;
import java.util.List;

/**
 * Created by liyan on 15/12/19.
 */
public class InfoGridAdapter extends BaseAdapter {

    Context context;
    List<FootBallInfoData> list;

    public InfoGridAdapter(Context context, List<FootBallInfoData> list) {
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
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.circle_image_item_layout, null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.image);
            holder.textView = (TextView) convertView.findViewById(R.id.text);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        FootBallInfoData data = list.get(position);
        Picasso.with(context).load(data.image).into(holder.imageView);
        holder.textView.setText(data.title);
        convertView.setTag(holder);
        return convertView;
    }

    public static class ViewHolder {
        public ImageView imageView;
        public TextView textView;
    }

}