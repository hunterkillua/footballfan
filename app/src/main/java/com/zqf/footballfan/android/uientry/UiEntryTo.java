package com.zqf.footballfan.android.uientry;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.zqf.footballfan.android.uientry.comment.CommentActivity;
import com.zqf.footballfan.android.uientry.comment.WriteArticleActivity;
import com.zqf.footballfan.android.uientry.footballinfo.MatchInfoActivity;
import com.zqf.footballfan.android.uientry.footballinfo.MemberInfoActivity;
import com.zqf.footballfan.android.uientry.footballinfo.SearchActivity;
import com.zqf.footballfan.android.uientry.footballmatch.MatchDetailActivity;
import com.zqf.footballfan.android.uientry.news.newsdetail.NewsDetailActivity;
import com.zqf.footballfan.android.uientry.news.topicact.NewsTopicActivity;

/**
 * Created by liyan on 15/12/19.
 */
public class UiEntryTo {
    public static final String URL = "url";
    public static final int NEWS_DETAIL = 0;
    public static final int TOPIC = 1;
    public static final int COMMENT = 2;
    public static final int WRITEARTICLE = 3;
    public static final int MATCH_DETAIL = 4;
    public static final int MEMBER_DETAIL = 5;
    public static final int DATA_MATCH = 6;

    public static void toActivity(Context context, int type, String action) {
        switch (type) {
            case MATCH_DETAIL:
                toMatchDetailActivity(context, action);
                break;
            case NEWS_DETAIL:
                toNewsDetailActivity(context, action);
                break;
            case MEMBER_DETAIL:
                toMatcMemberActivity(context, action);
                break;
            case DATA_MATCH:
                toDataMatchActivity(context, action);
                break;
            default:
                break;
        }
    }

    public static void toNewsDetailActivity(Context context, String url) {
        Intent intent = new Intent(context, NewsDetailActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setData(Uri.parse(url));
        context.startActivity(intent);
    }

    public static void toTopicActivity(Context context) {
        Intent intent = new Intent(context, NewsTopicActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static void toWriteArticleActivity(Context context) {
        Intent intent = new Intent(context, WriteArticleActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static void toCommentActivity(Context context) {
        Intent intent = new Intent(context, CommentActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static void toMatchDetailActivity(Context context, String url) {
        Intent intent = new Intent(context, MatchInfoActivity.class);
        intent.setData(Uri.parse(url));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static void toMatcMemberActivity(Context context, String url) {
        Intent intent = new Intent(context, MemberInfoActivity.class);
        intent.setData(Uri.parse(url));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static void toSearchActivity(Context context) {
        Intent intent = new Intent(context, SearchActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static void toDataMatchActivity(Context context, String url) {
        Intent intent = new Intent(context, MatchDetailActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
