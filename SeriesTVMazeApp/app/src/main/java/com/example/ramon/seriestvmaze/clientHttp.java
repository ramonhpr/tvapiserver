package com.example.ramon.seriestvmaze;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by ramon on 05/09/17.
 */

public class clientHttp {
    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void getJSON(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.addHeader("Content-Type", "application/json");
        client.addHeader("Accept", "application/json");
        client.setTimeout(8000);
        client.setConnectTimeout(8000);
        client.setResponseTimeout(8000);
        client.get(url, params, responseHandler);
    }
}
