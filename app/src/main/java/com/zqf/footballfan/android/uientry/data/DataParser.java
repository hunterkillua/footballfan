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
        List<Class> classes = new ArrayList<Class>();
        MatchInfoData data;
        TimeLineData timeLineData;
        for(int i = 0; i < 20; i++) {
            if (i == 0 || i == 5) {
                timeLineData = new TimeLineData();
                timeLineData.content = "2016-03-17";
                timeLineData.type = TimeLineData.TYPE_DEFAULT;
            } else {
                data = new MatchInfoData();
                data.info = "直播电视";
                data.flag = "http://img.dongqiudi.com//uploads9/allimg/160315/233-160315200635C7.jpg";
                data.logo = "http://img.dongqiudi.com/data/pic/2016.png";
                list.add(data);
            }

        }
        classes.add(TimeLineData.class);
        classes.add(MatchInfoData.class);
        resultData.classList = classes;
        resultData.dataList = list;
        return resultData;
    }


    public static class ResultData {
        List<Class> classList;
        List<Object> dataList;
    }

}
