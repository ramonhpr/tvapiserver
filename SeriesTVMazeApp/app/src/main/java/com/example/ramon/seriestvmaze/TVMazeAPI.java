package com.example.ramon.seriestvmaze;

import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * Created by ramon on 05/09/17.
 */

public class TVMazeAPI {
    private static String queryEndPoint = "http://api.tvmaze.com/shows";

    public void getSeries(final Callback callback) {
        clientHttp.getJSON(queryEndPoint,null, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);

                List<Serie> list = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject elem = response.getJSONObject(i);
                        String name = elem.getString("name");
                        String year = elem.getString("airdate");
                        String urlImage = elem.getJSONObject("image").getString("medium");
                        String summary = elem.getString("summary");
                        Serie s = new Serie(name,year,urlImage,summary);
                        list.add(s);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                callback.onResponse(list);


            }
        });

    }

}
