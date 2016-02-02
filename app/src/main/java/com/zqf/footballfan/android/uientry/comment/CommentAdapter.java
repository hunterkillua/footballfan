package com.zqf.footballfan.android.uientry.comment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.zqf.footballfan.android.R;

import java.util.List;


/**
 * Created by liyan on 16/1/2.
 */
public class CommentAdapter extends BaseAdapter {

    private Context mContext;
    private List<CommentData> mList;
    private View.OnClickListener mListener;

    public CommentAdapter(Context context, List<CommentData> list) {
        mContext = context;
        mList = list;
    }

    public void setOnClickListener(View.OnClickListener listener) {
        mListener = listener;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.comment_item_layout, parent, false);
            holder = new ViewHolder();
            holder.commentLayout = convertView.findViewById(R.id.comment_layout);
            holder.author = (TextView) convertView.findViewById(R.id.author);
            holder.identity = (TextView) convertView.findViewById(R.id.identity);
            holder.comment = (TextView) convertView.findViewById(R.id.comment);
            holder.icon = (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        CommentData data = mList.get(position);
        holder.author.setText(data.author);
        holder.identity.setText(data.identity);
        holder.comment.setText(data.comment);
        holder.commentLayout.setTag(data);
        if (mListener != null) {
            holder.commentLayout.setOnClickListener(mListener);
        }
        return convertView;
    }

    class ViewHolder {
        View commentLayout;
        TextView author;
        TextView identity;
        TextView comment;
        ImageView icon;
        TextView voteCount;
    }
}
