package com.zqf.footballfan.android.uientry.news.newsdetail;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zqf.footballfan.android.R;
import com.zqf.footballfan.android.uientry.UiEntryTo;
import com.zqf.footballfan.android.widget.TopBarLayout;

/**
 * Created by liyan on 15/12/19.
 */
public class NewsDetailActivity extends Activity {

    private WebView mWebView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_detail_act_layout);
        initTopBar();
        initWebView();
    }

    private void initWebView() {
        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
                    mWebView.goBack();
                    return true;
                }
                return false;
            }
        });
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setPluginsEnabled(true);
        mWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        mWebView.getSettings().setSupportZoom(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.setWebChromeClient(new WebChromeClient() {

        });
        mWebView.setWebViewClient(new WebViewClient() {

            public void onReceivedError(WebView view, int errorCode,
                                        String description, String failingUrl) {
            }

            public void onPageFinished(WebView view, String url) {

            }
        });
        Intent intent = getIntent();
        if (intent != null) {
            mWebView.loadUrl(intent.getData().toString());
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
                UiEntryTo.toCommentActivity(NewsDetailActivity.this);
            }
        });
    }
}
