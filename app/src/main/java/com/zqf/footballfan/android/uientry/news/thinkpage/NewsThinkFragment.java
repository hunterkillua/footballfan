package com.zqf.footballfan.android.uientry.news.thinkpage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.zqf.footballfan.android.R;
import com.zqf.footballfan.android.uientry.data.TimeLineData;
import com.zqf.footballfan.android.uientry.data.ThinkData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyan on 16/1/2.
 */
public class NewsThinkFragment extends Fragment {


    public boolean mLoaded = false;
    ListView listView;
    NewsThinkAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        listView = (ListView) inflater.inflate(R.layout.news_list_view, null);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams
                .MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        listView.setLayoutParams(layoutParams);
        return listView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initListView();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && !mLoaded) {
            mLoaded = true;
        }
    }

    private void initListView() {
        List<Object> dataList = new ArrayList<Object>();
        ThinkData data;
        TimeLineData timeLineData;

        timeLineData = new TimeLineData();
        timeLineData.content = "2016-01-02";
        timeLineData.type = TimeLineData.TYPE_FIRST;
        dataList.add(timeLineData);


        data = new ThinkData();
        data.title = "足彩前瞻：德甲第17轮因戈斯塔特vs勒沃库森";
        data.desc = "因戈斯塔特在过去3场比赛中有2次败北，眼下就要迎来他们在德甲的首个冬歇期了，对他们来说总算可以喘口气了。";
        data.image = "http://img.dongqiudi.com//uploads9/allimg/151219/607-151219134245b4.jpg";
        data.url = "http://www.dongqiudi.com/article/142110";
        data.author = "足球风";
        data.identity = "资深评论员";
        dataList.add(data);

        data = new ThinkData();
        data.title = "年终回忆：2015，难说再见";
        data.desc = "盛年不重来，一日难再晨。转眼，我们已经来到了2015年的年尾。";
        data.image = "http://img.dongqiudi.com//uploads9/allimg/151219/607-151219140405641.jpg";
        data.url = "http://www.dongqiudi.com/article/142110";
        data.author = "足球风";
        data.identity = "资深评论员";
        dataList.add(data);

        timeLineData = new TimeLineData();
        timeLineData.content = "2016-01-01";
        timeLineData.type = TimeLineData.TYPE_DEFAULT;
        dataList.add(timeLineData);

        data = new ThinkData();
        data.title = "马克-休斯：博扬肯定不会转会";
        data.desc = "斯托克城在马克-休斯的带领下已经逐步走上了技术流的路线，尤其是前场博扬、沙奇里、阿瑙托维奇和阿费莱的组合更是让人赞叹。";
        data.image = "http://img.dongqiudi.com//uploads9/allimg/151219/511-15121ZU629537.jpg";
        data.url = "http://www.dongqiudi.com/article/142110";
        data.author = "足球风";
        data.identity = "资深评论员";
        dataList.add(data);

        for (int i = 0; i < 10; i++) {
            data = new ThinkData();
            data.title = "年终回忆：2015，难说再见";
            data.desc = "盛年不重来，一日难再晨。转眼，我们已经来到了2015年的年尾。在这一年里，也许你为足球欢呼过、哭泣过、沉默过、憧憬过，站在2015"
                    + "年的尾巴上回望，你还记得那些动人的瞬间，曾经熟悉的面孔吗？从A到Z，让我们来一起回忆即将结束的2015年。";
            data.image = "http://img.dongqiudi.com//uploads9/allimg/151219/607-151219140405641.jpg";
            data.url = "http://www.dongqiudi.com/article/142110";
            data.author = "足球风";
            data.identity = "资深评论员";
            dataList.add(data);
        }

        ////////////////////////
        mAdapter = new NewsThinkAdapter(getActivity(), dataList);
        listView.setAdapter(mAdapter);
    }
}
