package com.zqf.footballfan.android.uientry.fancenter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.zqf.footballfan.android.R;
import com.zqf.footballfan.android.uientry.UiEntryTo;
import com.zqf.footballfan.android.uientry.news.NewsData;
import com.zqf.footballfan.android.uientry.news.infopage.NewsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyan on 15/12/19.
 */
public class UserFragment extends Fragment{

    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fancenter_main_layout, null);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initListView();
    }

    private void initListView() {
        listView = (ListView) getView().findViewById(R.id.listview);

        List<NewsData> dataList = new ArrayList<NewsData>();
        NewsData data;
        data = new NewsData();
        data.title = "足彩前瞻：德甲第17轮因戈斯塔特vs勒沃库森";
        data.desc = "因戈斯塔特在过去3场比赛中有2次败北，眼下就要迎来他们在德甲的首个冬歇期了，对他们来说总算可以喘口气了。";
        data.image = "http://img.dongqiudi.com//uploads9/allimg/151219/607-151219134245b4.jpg";
        data.url = "http://www.dongqiudi.com/article/142110";
        dataList.add(data);

        data = new NewsData();
        data.title = "年终回忆：2015，难说再见";
        data.desc = "盛年不重来，一日难再晨。转眼，我们已经来到了2015年的年尾。";
        data.image = "http://img.dongqiudi.com//uploads9/allimg/151219/607-151219140405641.jpg";
        data.url = "http://www.dongqiudi.com/article/142110";
        dataList.add(data);

        data = new NewsData();
        data.title = "马克-休斯：博扬肯定不会转会";
        data.desc = "斯托克城在马克-休斯的带领下已经逐步走上了技术流的路线，尤其是前场博扬、沙奇里、阿瑙托维奇和阿费莱的组合更是让人赞叹。";
        data.image = "http://img.dongqiudi.com//uploads9/allimg/151219/511-15121ZU629537.jpg";
        data.url = "http://www.dongqiudi.com/article/142110";
        dataList.add(data);

        NewsAdapter adapter = new NewsAdapter(getActivity(), dataList);
        adapter.setListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if (v.getTag() != null && (v.getTag() instanceof NewsAdapter.ViewHolder)) {
                    NewsAdapter.ViewHolder holder = (NewsAdapter.ViewHolder) v.getTag();
                    NewsData newsData = holder.data;
                    if (newsData != null && newsData.url != null) {
                        UiEntryTo.toNewsDetailActivity(getActivity(), newsData.url);
                    }

                }
            }
        });
        listView.setAdapter(adapter);
    }
}

