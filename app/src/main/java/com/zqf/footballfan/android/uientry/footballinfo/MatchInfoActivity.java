package com.zqf.footballfan.android.uientry.footballinfo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.zqf.footballfan.android.R;
import com.zqf.footballfan.android.uientry.data.AllAdapter;
import com.zqf.footballfan.android.uientry.data.DataParser;
import com.zqf.footballfan.android.widget.TopBarLayout;

/**
 * Created by liyan on 16/4/3.
 */
public class MatchInfoActivity extends Activity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_match_detail);
        init();
        initTopBar();
    }

    protected void init() {
        listView = (ListView) findViewById(R.id.listview);
        AllAdapter adapter = new AllAdapter(this, DataParser.getSores());
        listView.setAdapter(adapter);

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
                if (view.isSelected()) {
                    view.setSelected(false);
                } else {
                    view.setSelected(true);
                }
            }
        });
    }
}
