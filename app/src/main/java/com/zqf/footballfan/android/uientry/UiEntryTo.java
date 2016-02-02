package com.zqf.footballfan.android.uientry;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.zqf.footballfan.android.uientry.comment.CommentActivity;
import com.zqf.footballfan.android.uientry.comment.WriteArticleActivity;
import com.zqf.footballfan.android.uientry.news.newsdetail.NewsDetailActivity;
import com.zqf.footballfan.android.uientry.news.topicact.NewsTopicActivity;

/**
 * Created by liyan on 15/12/19.
 */
public class UiEntryTo {

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
}
