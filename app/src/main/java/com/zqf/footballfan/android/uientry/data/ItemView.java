package com.zqf.footballfan.android.uientry.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zqf.footballfan.android.R;
import com.zqf.footballfan.android.image.ImageClient;

/**
 * Created by liyan on 16/3/14.
 */
public class ItemView {

    public static View getNewsDataView(Context context, NewsData data, View.OnClickListener listener, int position,
                                View convertView, ViewGroup parent) {
        NewsDataViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.news_content_item_layout, parent, false);
            holder = new NewsDataViewHolder();
            holder.titleTv = (TextView) convertView.findViewById(R.id.title);
            holder.descTv = (TextView) convertView.findViewById(R.id.desc);
            holder.imageView = (ImageView) convertView.findViewById(R.id.image);
            holder.tagView = (TextView) convertView.findViewById(R.id.tag);
            convertView.setTag(holder);
        } else {
            holder = (NewsDataViewHolder) convertView.getTag();
        }
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

    public static class NewsDataViewHolder {
        public NewsData data;
        public TextView titleTv;
        public TextView descTv;
        public ImageView imageView;
        public TextView tagView;
    }

    public static View getMatchDataView(Context context, MatchData data, int position,
                                View convertView, ViewGroup parent) {
        MatchDataViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.data_match_item_layout, parent, false);
            holder = new MatchDataViewHolder();
            holder.leftTv = (TextView) convertView.findViewById(R.id.left_name);
            holder.rightTv = (TextView) convertView.findViewById(R.id.right_name);
            holder.leftImg = (ImageView) convertView.findViewById(R.id.left_icon);
            holder.rightImg = (ImageView) convertView.findViewById(R.id.right_icon);
            holder.timeTv = (TextView) convertView.findViewById(R.id.time);
            holder.scroreTv = (TextView) convertView.findViewById(R.id.score);
            holder.channelTv = (TextView) convertView.findViewById(R.id.channel);
            holder.tagImg = (ImageView) convertView.findViewById(R.id.tag);
            convertView.setTag(holder);
        } else {
            holder = (MatchDataViewHolder) convertView.getTag();
        }
        holder.leftTv.setText(data.leftText);
        holder.rightTv.setText(data.rightText);
        holder.timeTv.setText(data.time);
        holder.channelTv.setText(data.channel);
        holder.scroreTv.setText(data.score);
        ImageClient.getInstance().load(context, data.leftImage).into(holder.leftImg);
        ImageClient.getInstance().load(context, data.rightImage).into(holder.rightImg);
        ImageClient.getInstance().load(context, data.tag).into(holder.tagImg);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return convertView;
    }

    public static class MatchDataViewHolder {
        public MatchData data;
        public TextView leftTv;
        public TextView rightTv;
        public ImageView leftImg;
        public ImageView rightImg;
        public ImageView tagImg;
        public TextView timeTv;
        public TextView scroreTv;
        public TextView channelTv;
    }

    public static View getThinkView(Context context, ThinkData data, View.OnClickListener listener, int position,
                                View convertView, ViewGroup parent) {
        ThinkViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.news_think_item_layout, parent, false);
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

    public static class ThinkViewHolder {
        TextView title;
        TextView desc;
        TextView author;
        TextView identity;
        ImageView image;
    }

    public static View getMatchInfoView(Context context, MatchInfoData data, int position,
                                        View convertView, ViewGroup parent) {
        MatchInfoHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.match_info_item_layout, parent, false);
            holder = new MatchInfoHolder();
            holder.logo = (ImageView) convertView.findViewById(R.id.logo);
            holder.flag = (ImageView) convertView.findViewById(R.id.flag);
            holder.info = (TextView) convertView.findViewById(R.id.info);
            convertView.setTag(holder);
        } else {
            holder = (MatchInfoHolder) convertView.getTag();
        }
        holder.info.setText(data.info);
        ImageClient.getInstance().load(context, data.logo).into(holder.logo);
        ImageClient.getInstance().load(context, data.flag).into(holder.flag);
        return convertView;
    }

    public static class MatchInfoHolder {
        ImageView logo;
        ImageView flag;
        TextView info;
    }

    public static View getTimeLineView(Context context, TimeLineData data, int position, View convertView, ViewGroup
            parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.timeline_layout, parent, false);
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
}