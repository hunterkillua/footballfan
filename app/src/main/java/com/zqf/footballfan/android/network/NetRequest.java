package com.zqf.footballfan.android.network;

import java.util.List;

import org.apache.http.NameValuePair;

/**
 * Created by liyan on 15/12/8.
 */
public interface NetRequest {

    String doHttpGet(String url, List<NameValuePair> headers, boolean ignoreSslVerify);

    String doHttpPost(String url, List<NameValuePair> params);

}
