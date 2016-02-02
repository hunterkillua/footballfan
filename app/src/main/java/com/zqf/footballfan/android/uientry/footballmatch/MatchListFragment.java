package com.zqf.footballfan.android.uientry.footballmatch;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.picasso.Picasso;
import com.zqf.footballfan.android.R;
import com.zqf.footballfan.android.util.DensityUtil;

import java.util.ArrayList;
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
        List<String> imagelist = new ArrayList<String>();
        for (int i = 0; i< 6; i++) {
            imagelist.add("p5.qhimg.com/t01e33eac9e8d68b80b.jpg");
        }
        MatchDetailAdapter adapter = new MatchDetailAdapter(getActivity(), imagelist);
        listView.setAdapter(adapter);
    }

    static class MatchDetailAdapter extends BaseAdapter {

        Context context;
        List<String> list;

        public MatchDetailAdapter(Context context, List<String> list) {
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
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(context);
                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                params.width = DensityUtil.widthPixel;
                params.height = (int) (DensityUtil.widthPixel * 0.3);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                Picasso.with(context).load(list.get(position)).placeholder(R.drawable.match)
                        .into(imageView);
                convertView = imageView;
            }
            return convertView;
        }

    }
}
