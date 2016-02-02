package com.zqf.footballfan.android.network;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 * Created by liyan on 15/12/9.
 */
public class NetClient {

    private static final NetClient client = new NetClient();
    NetRequest netRequest;

    private NetClient() {

    }

    public static NetClient getInstance() {
        return client;
    }

    public NetRequest getRequest() {
        if (netRequest == null) {
            synchronized (this) {
                if (netRequest == null) {
                    netRequest = new OkhttpNetRequest();
                }
            }
        }
        return netRequest;
    }

    public String doHttpGet(String url) {
        return getRequest().doHttpGet(url, null, false);
    }

    public String doHttpGetWithoutSslVerify(String url) {
        return getRequest().doHttpGet(url, null, true);
    }

    public String doHttpGet(String url, String userAgent) {
        List<NameValuePair> headers = new ArrayList<NameValuePair>();
        headers.add(new BasicNameValuePair("User-Agent", userAgent));
        return getRequest().doHttpGet(url, headers, false);
    }

    public String doHttpPost(String url, List<NameValuePair> params) {
        return getRequest().doHttpPost(url, params);
    }

}
