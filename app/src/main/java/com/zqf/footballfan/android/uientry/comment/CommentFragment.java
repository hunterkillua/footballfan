package com.zqf.footballfan.android.uientry.comment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.zqf.footballfan.android.R;
import com.zqf.footballfan.android.uientry.news.topicpage.TopicData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyan on 16/1/2.
 */
public class CommentFragment extends Fragment {

    ListView listView;
    CommentAdapter adapter;

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

    private void initListView() {
        List<CommentData> dataList = new ArrayList<CommentData>();
        CommentData data = new CommentData();
        data.comment = "斯托克城在马克-休斯的带领下已经逐步走上了技术流的路线，尤其是前场博扬、沙奇里、阿瑙托维奇和阿费莱的组合更是让人赞叹。";
        data.author = "足球风";
        data.identity = "资深评论员";
        dataList.add(data);

        for (int i = 0; i < 10; i++) {
            data = new CommentData();
            data.comment = "盛年不重来，一日难再晨。转眼，我们已经来到了2015年的年尾。在这一年里，也许你为足球欢呼过、哭泣过、沉默过、憧憬过，站在2015"
                    + "年的尾巴上回望，你还记得那些动人的瞬间，曾经熟悉的面孔吗？从A到Z，让我们来一起回忆即将结束的2015年。";
            data.author = "足球风";
            data.identity = "资深评论员";
            dataList.add(data);
        }

        adapter = new CommentAdapter(getActivity(), dataList);
        adapter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                CommentData commentData;
                if (v.getTag() instanceof CommentData) {
                    commentData = (CommentData) v.getTag();
                    showCommentDialog(commentData);
                    //showLoadingDialog();
                }

            }
        });
        listView.setAdapter(adapter);
    }

    private void showCommentDialog(CommentData data) {
        Dialog dialog = new CommentDialog(getActivity());
        dialog.show();
    }

    private void showLoadingDialog() {
        Dialog mLoadingDialog = null;
        if (mLoadingDialog == null) {
            mLoadingDialog = new Dialog(getActivity(), R.style.dialogNoTitleDialog);
            mLoadingDialog.setContentView(R.layout.comment_dialog_layout);
            mLoadingDialog.setCanceledOnTouchOutside(false);
        }
        if (!mLoadingDialog.isShowing()) {
            try {
                mLoadingDialog.show();
            } catch (Exception e) {

            }
        }
    }
}
