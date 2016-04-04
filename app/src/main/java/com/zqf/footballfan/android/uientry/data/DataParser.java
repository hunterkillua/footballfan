package com.zqf.footballfan.android.uientry.data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zqf.footballfan.android.R;
import com.zqf.footballfan.android.uientry.data.MatchData;
import com.zqf.footballfan.android.uientry.data.MatchInfoData;
import com.zqf.footballfan.android.uientry.data.TimeLineData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyan on 16/3/14.
 */
public class DataParser {

    public static ResultData getNewsData() {
        ResultData resultData = new ResultData();
        List<Object> list = new ArrayList<Object>();

        Class[] classes = new Class[1];
        classes[0] = ScoreData.class;
        resultData.classList = classes;

        NewsData data;
        data = new NewsData();
        for (int i = 0; i < 10; i++) {
            data = new NewsData();
            data.title = "年终回忆：2015，难说再见";
            data.desc = "盛年不重来，一日难再晨。转眼，我们已经来到了2015年的年尾。在这一年里，也许你为足球欢呼过、哭泣过、沉默过、憧憬过，站在2015"
                    + "年的尾巴上回望，你还记得那些动人的瞬间，曾经熟悉的面孔吗？从A到Z，让我们来一起回忆即将结束的2015年。";
            data.image = "http://img.dongqiudi.com//uploads9/allimg/151219/607-151219140405641.jpg";
            data.url = "http://www.dongqiudi.com/article/142110";
            list.add(data);
        }
        resultData.dataList = list;
        return resultData;
    }

    public static List<MatchData> getMatchData(String url) {
        List<MatchData> list = new ArrayList<MatchData>();
        MatchData data;
        for(int i = 0; i < 20; i++) {
            data = new MatchData();
            data.channel = "直播电视";
            data.leftImage = "http://img.dongqiudi.com/data/pic/2016.png";
            data.rightImage = "http://img.dongqiudi.com/data/pic/2016.png";
            data.leftText = "广东恒大俱乐部";
            data.rightText = "广东恒大";
            data.score = "2-3";
            data.time = "2016年3月14日 17:56";
            data.tag = "http://www.dongqiudi.com/web/images/logo.png";
            list.add(data);
        }
        return list;
    }

    public static ResultData getMatchInfoData(String url) {
        ResultData resultData = new ResultData();
        List<Object> list = new ArrayList<Object>();
        MatchInfoData data;
        TimeLineData timeLineData;
        for(int i = 0; i < 20; i++) {
            if (i == 0 || i == 5) {
                timeLineData = new TimeLineData();
                timeLineData.content = "2016-03-17";
                timeLineData.type = TimeLineData.TYPE_DEFAULT;
            } else {
                data = new MatchInfoData();
                data.info = "西班牙联赛";
                data.flag = "http://img.dongqiudi.com//uploads9/allimg/160315/233-160315200635C7.jpg";
                data.logo = "http://img.dongqiudi.com/data/pic/2016.png";
                list.add(data);
            }

        }
        Class[] classes = new Class[2];
        classes[0] = TimeLineData.class;
        classes[1] = MatchInfoData.class;
        resultData.classList = classes;
        resultData.dataList = list;
        return resultData;
    }

    public static ResultData getInfoTeamData(String url) {
        ResultData resultData = new ResultData();
        List<Object> list = new ArrayList<Object>();
        ImageData[] data;
        TimeLineData timeLineData;
        for(int i = 0; i < 20; i++) {
            if (i == 0 || i == 5) {
                timeLineData = new TimeLineData();
                timeLineData.content = "全部";
                timeLineData.type = TimeLineData.TYPE_DEFAULT;
                list.add(timeLineData);
            } else {
                data = new ImageData[2];
                data[0] = new ImageData();
                data[0].text = "西班牙";
                data[0].image = "http://img.dongqiudi.com//uploads9/allimg/160315/233-160315200635C7.jpg";
                data[1] = new ImageData();
                data[1].image = "http://img.dongqiudi.com/data/pic/2016.png";
                data[1].text = "巴塞罗那";
                list.add(data);
            }

        }
        Class[] classes = new Class[2];
        classes[0] = TimeLineData.class;
        classes[1] = ImageData[].class;
        resultData.classList = classes;
        resultData.dataList = list;
        return resultData;
    }

    public static ResultData getInfoMemberData(String url) {
        ResultData resultData = new ResultData();
        List<Object> list = new ArrayList<Object>();
        ImageData[] data;
        TimeLineData timeLineData;
        for(int i = 0; i < 20; i++) {
            if (i == 0 || i == 5) {
                timeLineData = new TimeLineData();
                timeLineData.content = "全部";
                timeLineData.type = TimeLineData.TYPE_DEFAULT;
                list.add(timeLineData);
            } else {
                data = new ImageData[4];
                data[0] = new ImageData();
                data[0].text = "梅西";
                data[0].image = "http://img.dongqiudi.com//uploads9/allimg/160315/233-160315200635C7.jpg";
                data[1] = new ImageData();
                data[1].image = "http://img.dongqiudi.com/data/pic/2016.png";
                data[1].text = "罗纳尔多";
                data[2] = new ImageData();
                data[2].text = "贝克汉姆";
                data[2].image = "http://img.dongqiudi.com//uploads9/allimg/160315/233-160315200635C7.jpg";
                data[3] = new ImageData();
                data[3].image = "http://img.dongqiudi.com/data/pic/2016.png";
                data[3].text = "C罗";
                list.add(data);
            }

        }
        Class[] classes = new Class[2];
        classes[0] = TimeLineData.class;
        classes[1] = ImageData[].class;
        resultData.classList = classes;
        resultData.dataList = list;
        return resultData;
    }

    public static ResultData getInfoCountryData(String url) {
        ResultData resultData = new ResultData();
        List<Object> list = new ArrayList<Object>();
        CountryData[] data;
        TimeLineData timeLineData;
        for(int i = 0; i < 20; i++) {
            if (i == 0 || i == 5) {
                timeLineData = new TimeLineData();
                timeLineData.content = "全部";
                timeLineData.type = TimeLineData.TYPE_DEFAULT;
                list.add(timeLineData);
            } else {
                data = new CountryData[4];
                data[0] = new CountryData();
                data[0].text = "中国";
                data[0].image = "http://img.dongqiudi.com//uploads9/allimg/160315/233-160315200635C7.jpg";
                data[1] = new CountryData();
                data[1].image = "http://img.dongqiudi.com/data/pic/2016.png";
                data[1].text = "巴塞罗那";
                data[2] = new CountryData();
                data[2].text = "巴西";
                data[2].image = "http://img.dongqiudi.com//uploads9/allimg/160315/233-160315200635C7.jpg";
                data[3] = new CountryData();
                data[3].image = "http://img.dongqiudi.com/data/pic/2016.png";
                data[3].text = "德国";
                list.add(data);
            }

        }
        Class[] classes = new Class[2];
        classes[0] = TimeLineData.class;
        classes[1] = CountryData[].class;
        resultData.classList = classes;
        resultData.dataList = list;
        return resultData;
    }

    public static ResultData getSores() {
        ResultData resultData = new ResultData();
        List<Object> list = new ArrayList<Object>();

        Class[] classes = new Class[1];
        classes[0] = ScoreData.class;
        resultData.classList = classes;
        for (int i = 0; i < 15; i++) {
            list.add(new ScoreData());
        }
        resultData.dataList = list;
        return resultData;
    }

    public static ResultData getSearchData(String url) {
        ResultData resultData = new ResultData();
        List<Object> list = new ArrayList<Object>();
        SearchWordData data;
        TimeLineData timeLineData;
        for(int i = 0; i < 20; i++) {
            if (i == 0 || i == 2 || i == 5) {
                timeLineData = new TimeLineData();
                timeLineData.content = "全部";
                timeLineData.type = TimeLineData.TYPE_DEFAULT;
                list.add(timeLineData);
            } else {
                data = new SearchWordData();
                data.text = "西班牙";
                data.image = "http://img.dongqiudi.com//uploads9/allimg/160315/233-160315200635C7.jpg";
                list.add(data);
            }

        }
        Class[] classes = new Class[2];
        classes[0] = TimeLineData.class;
        classes[1] = SearchWordData.class;
        resultData.classList = classes;
        resultData.dataList = list;
        return resultData;
    }

    public static class ResultData {
        Class[] classList;
        List<Object> dataList;
    }

}
