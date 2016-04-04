package com.zqf.footballfan.android.uientry.footballinfo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.zqf.footballfan.android.R;
import com.zqf.footballfan.android.uientry.data.AllAdapter;
import com.zqf.footballfan.android.uientry.data.DataParser;
import com.zqf.footballfan.android.uientry.data.ItemView;
import com.zqf.footballfan.android.uientry.data.MatchData;
import com.zqf.footballfan.android.util.ZqfPreferences;
import com.zqf.footballfan.android.widget.TopBarLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyan on 16/4/3.
 */
public class SearchActivity extends Activity {

    ListView listView;
    EditText contentTv;
    TextView searchTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        init();
        initTopBar();
    }

    protected void init() {
        contentTv = (EditText) findViewById(R.id.content);
        searchTv = (TextView) findViewById(R.id.search);
        searchTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchWord = contentTv.getText().toString();
                if (contentTv.getText().length() > 0) {
                    List<String> words = getHistoryWords();
                    if (words.contains(searchWord)) {
                        return;
                    }
                    int curNum = ZqfPreferences.getInt(SearchActivity.this, ZqfPreferences.KEY_SEARCH_WORD_NUMBER, -1);
                    int num = (curNum + 1) % 5;
                    ZqfPreferences
                            .saveString(SearchActivity.this, ZqfPreferences.KEY_SEARCH_WORD_HISTORY_ + num, searchWord);
                    ZqfPreferences.saveInt(SearchActivity.this, ZqfPreferences.KEY_SEARCH_WORD_NUMBER, num);
                    AllAdapter adapter = new AllAdapter(SearchActivity.this, DataParser.getSearchData(""));
                    listView.setAdapter(adapter);
                }
            }
        });
        listView = (ListView) findViewById(R.id.listview);
        List<String> words = getHistoryWords();
        if (words.size() > 0) {
            SearchWordAdapter adapter = new SearchWordAdapter(this, words);
            adapter.setListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String searchWord = (String) v.getTag();
                    AllAdapter adapter = new AllAdapter(SearchActivity.this, DataParser.getSearchData(""));
                    listView.setAdapter(adapter);
                }
            });
            listView.setAdapter(adapter);
        }

    }

    private void initTopBar() {
        TopBarLayout topBarLayout = (TopBarLayout) findViewById(R.id.topbar);
        topBarLayout.setClickListener(new TopBarLayout.ClickListener() {
            @Override
            public void onLeftClick(View view) {
                finish();
            }

            @Override
            public void onRightClick(View view) {

            }
        });
    }

    public List<String> getHistoryWords() {
        int curNum = ZqfPreferences.getInt(this, ZqfPreferences.KEY_SEARCH_WORD_NUMBER, 0);
        List<String> list = new ArrayList<String>();
        for (int i = 5; i > 0; i--) {
            int num = (curNum + i) % 5;
            String str = ZqfPreferences.getString(this, ZqfPreferences.KEY_SEARCH_WORD_HISTORY_ + num, null);
            if (str != null) {
                list.add(str);
            }
        }
        return list;
    }

    static class SearchWordAdapter extends BaseAdapter {

        Context context;
        List<String> list;
        View.OnClickListener listener;

        public SearchWordAdapter(Context context, List<String> list) {
            this.context = context;
            this.list = list;
        }

        public void setListener(View.OnClickListener listener) {
            this.listener = listener;
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
            String searchWord = list.get(position);
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.search_word_item_view, parent, false);
            }
            ((TextView) convertView).setText(searchWord);
            if (listener != null) {
                convertView.setOnClickListener(listener);
            }
            convertView.setTag(searchWord);
            return convertView;
        }

    }
}
