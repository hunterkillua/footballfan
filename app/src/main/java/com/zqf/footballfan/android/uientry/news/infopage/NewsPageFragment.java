package com.zqf.footballfan.android.uientry.news.infopage;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.picasso.Picasso;
import com.zqf.footballfan.android.R;
import com.zqf.footballfan.android.uientry.UiEntryTo;
import com.zqf.footballfan.android.uientry.data.NewsData;
import com.zqf.footballfan.android.util.DensityUtil;
import com.zqf.footballfan.android.widget.AutoPlayViewPager;
import com.zqf.footballfan.android.widget.CirclePageIndicator;
import com.zqf.footballfan.android.widget.ImagePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyan on 15/12/12.
 */
public class NewsPageFragment extends Fragment{

    ListView listView;
    View headerView;
    AutoPlayViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        listView = (ListView) inflater.inflate(R.layout.news_list_view, container, false);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams
                .MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        listView.setLayoutParams(layoutParams);
//        view.setBackgroundColor(getActivity().getResources().getColor(R.color.colorPrimary));
        return listView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        headerView = getHeaderView(getActivity());
        initHeaderView();
        listView.addHeaderView(headerView);
        initListView();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            onShow();
        } else {
            onHide();
        }
    }

    protected void onShow() {
        if (viewPager != null) {
            viewPager.stopPlay();
            viewPager.startPlay();
        }
    }

    protected void onHide() {
        if (viewPager != null) {
            viewPager.stopPlay();
        }
    }

    private View getHeaderView(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(R.layout.news_top_layout, null);
    }

    private void initHeaderView() {
        List<String> imagelist = new ArrayList<String>();
        imagelist.add("http://img.dongqiudi.com//uploads9/allimg/151219/443-15121Z53HR05.jpg");
        imagelist.add("http://img.dongqiudi.com//uploads9/allimg/151219/443-15121Z53R14Y.png");
        imagelist.add("http://img.dongqiudi.com//uploads9/allimg/151219/443-15121Z53SX00.jpg");
        viewPager = (AutoPlayViewPager) headerView.findViewById(R.id.viewpager);
        ImagePagerAdapter adapter = new ImagePagerAdapter(getActivity());
        int width = DensityUtil.widthPixel;
        int height = (int) (DensityUtil.widthPixel * 0.3);
        adapter.setImageList(imagelist, width, height);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UiEntryTo.toNewsDetailActivity(getActivity(), "http://www.dongqiudi.com/article/142791");
            }
        });
        viewPager.setAdapter(adapter);

        final CirclePageIndicator indicator = (CirclePageIndicator) headerView.findViewById(R.id.cindicator);
        indicator.setViewPager(viewPager);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                indicator.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        ImageView imageView1 = (ImageView) headerView.findViewById(R.id.image1);
        Picasso.with(getActivity()).load(imagelist.get(0)).into(imageView1);
        ImageView imageView2 = (ImageView) headerView.findViewById(R.id.image2);
        Picasso.with(getActivity()).load(imagelist.get(1)).placeholder(R.drawable.icon_logo).into(imageView2);
        ImageView imageView3 = (ImageView) headerView.findViewById(R.id.image3);
        Picasso.with(getActivity()).load(imagelist.get(2)).into(imageView3);
    }

    private void initListView(){
        List<NewsData> dataList = new ArrayList<NewsData>();
        NewsData data;
        data = new NewsData();
        data.title = "haha足彩前瞻：德甲第17轮因戈斯塔特vs勒沃库森";
        data.desc = "因戈斯塔特在过去3场比赛中有2次败北，眼下就要迎来他们在德甲的首个冬歇期了，对他们来说总算可以喘口气了。";
        data.image = "http://img.dongqiudi.com//uploads9/allimg/151219/607-151219134245b4.jpg";
        data.url = "http://infoapp.3g.qq.com/g/s?aid=video&iarea=213&i_f=905#play/id=z0019gx45nh";
        data.tag = "活动";
        dataList.add(data);

        data = new NewsData();
        data.title = "懂球帝年终回忆：2015，难说再见";
        data.desc = "盛年不重来，一日难再晨。转眼，我们已经来到了2015年的年尾。";
        data.image = "http://img.dongqiudi.com//uploads9/allimg/151219/607-151219140405641.jpg";
        data.url = "https://api.dongqiudi.com/article/158322.html";
        data.tag = "活动";
        dataList.add(data);

        data = new NewsData();
        data.title = "马克-休斯：博扬肯定不会转会";
        data.desc = "斯托克城在马克-休斯的带领下已经逐步走上了技术流的路线，尤其是前场博扬、沙奇里、阿瑙托维奇和阿费莱的组合更是让人赞叹。";
        data.image = "http://img.dongqiudi.com//uploads9/allimg/151219/511-15121ZU629537.jpg";
        data.url = "https://api.dongqiudi.com/article/158322.html";
        dataList.add(data);

        for (int i = 0; i < 10; i++) {
            data = new NewsData();
            data.title = "年终回忆：2015，难说再见";
            data.desc = "盛年不重来，一日难再晨。转眼，我们已经来到了2015年的年尾。在这一年里，也许你为足球欢呼过、哭泣过、沉默过、憧憬过，站在2015"
                    + "年的尾巴上回望，你还记得那些动人的瞬间，曾经熟悉的面孔吗？从A到Z，让我们来一起回忆即将结束的2015年。";
            data.image = "http://img.dongqiudi.com//uploads9/allimg/151219/607-151219140405641.jpg";
            data.url = "http://www.dongqiudi.com/article/142110";
            dataList.add(data);
        }

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
