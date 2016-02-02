package com.zqf.footballfan.android.network;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.util.List;

import org.apache.http.NameValuePair;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * Created by liyan on 15/12/8.
 */
public class OkhttpNetRequest implements NetRequest{
    OkHttpClient client;

    public OkhttpNetRequest() {
        client = new OkHttpClient();
    }

    @Override
    public String doHttpGet(String url, List<NameValuePair> headers, boolean ignoreSslVerify) {
        String data = null;
        try {
            Request.Builder builder = new Request.Builder();
            if (headers != null) {
                for (NameValuePair header : headers) {
                    builder.addHeader(header.getName(), header.getValue());
                }
            }
            OkHttpClient okHttpClient;
            if (!ignoreSslVerify) {
                okHttpClient = client;
            } else {
                okHttpClient = getUnsafeOkHttpClient(client);
            }
            Request request = new Request.Builder().url(url).build();
            Response response = okHttpClient.newCall(request).execute();
            data = response.body().string();
            response.body().close();
        } catch (IOException e) {

        }
        return data;
    }


    @Override
    public String doHttpPost(String url, List<NameValuePair> params) {
        String data = null;
        try {
            FormEncodingBuilder builder = new FormEncodingBuilder();
            for (NameValuePair pair : params) {
                builder.add(pair.getName(), pair.getValue());
            }
            RequestBody body = builder.build();
            Request request = new Request.Builder().url(url).post(body).build();
            com.squareup.okhttp.Response response = client.newCall(request).execute();
            data = response.body().string();
            response.body().close();
        } catch (IOException e) {

        }
        return data;
    }

    /**
     * 忽略证书认证
     * @param client
     * @return
     */
    private OkHttpClient getUnsafeOkHttpClient(OkHttpClient client) {
        if (client == null) {
            return null;
        }
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient okHttpClient = client.clone();
            okHttpClient.setSslSocketFactory(sslSocketFactory);
            okHttpClient.setHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

            return okHttpClient;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
