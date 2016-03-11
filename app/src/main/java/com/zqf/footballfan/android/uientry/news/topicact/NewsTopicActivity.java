package com.zqf.footballfan.android.uientry.news.topicact;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.zqf.footballfan.android.R;
import com.zqf.footballfan.android.uientry.data.NewsData;
import com.zqf.footballfan.android.uientry.news.infopage.NewsAdapter;
import com.zqf.footballfan.android.uientry.data.TopicData;
import com.zqf.footballfan.android.widget.TopBarLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyan on 15/12/19.
 */
public class NewsTopicActivity extends Activity {

    ListView listView;
    View headerView;
    TopBarLayout topBarLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_topic);
        listView = (ListView) findViewById(R.id.listview);
        initTopBar();
        initHeaderView();
        initListView();
    }

    private void initHeaderView() {
//
//        headerView = LayoutInflater.from(this).inflate(R.layout.news_user_content_layout, null);
//        ImageView imageView = (ImageView) headerView.findViewById(R.id.image);
//        Picasso.with(this).load("http://img5.duitang.com/uploads/item/201412/08/20141208030216_UAFh4.thumb.700_0.jpeg")
//                .placeholder(R.drawable.test).into(imageView);
//        listView.addHeaderView(headerView);


        TopicData data = new TopicData();
        data.title = "足彩前瞻：德甲第17轮因戈斯塔特vs勒沃库森";
        data.desc = "因戈斯塔特在过去3场比赛中有2次败北，眼下就要迎来他们在德甲的首个冬歇期了，对他们来说总算可以喘口气了。";
        data.url = "http://www.dongqiudi.com/article/142110";
        data.author = "足球风";
        data.identity = "资深评论员";
        initHeaderView(data);

    }

    private void initHeaderView(TopicData data) {
        TextView title = (TextView) findViewById(R.id.title);
        TextView desc = (TextView) findViewById(R.id.desc);
        TextView author = (TextView) findViewById(R.id.author);
        TextView identity = (TextView) findViewById(R.id.identity);

        title.setText(data.title);
        desc.setText(data.desc);
        author.setText(data.author);
        identity.setText(data.identity);
    }


    private void initListView(){

        List<NewsData> dataList = new ArrayList<NewsData>();
        NewsData data;
        for (int i = 0; i < 10; i++) {
            data = new NewsData();
            data.title = "年终回忆：2015，难说再见";
            data.desc = "盛年不重来，一日难再晨。转眼，我们已经来到了2015年的年尾。在这一年里，也许你为足球欢呼过、哭泣过、沉默过、憧憬过，站在2015"
                    + "年的尾巴上回望，你还记得那些动人的瞬间，曾经熟悉的面孔吗？从A到Z，让我们来一起回忆即将结束的2015年。";
            data.image = "http://img.dongqiudi.com//uploads9/allimg/151219/607-151219140405641.jpg";
            data.url = "http://www.dongqiudi.com/article/142110";
            dataList.add(data);
        }

        NewsAdapter adapter = new NewsAdapter(this, dataList);
        listView.setAdapter(adapter);
    }

    private void initTopBar() {
        topBarLayout = (TopBarLayout) findViewById(R.id.topbar);
        topBarLayout.setClickListener(new TopBarLayout.ClickListener() {
            @Override
            public void onLeftClick(View view) {
                finish();
            }

            @Override
            public void onRightClick(View view) {
                view.setSelected(true);
            }
        });
    }
}
