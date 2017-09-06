package com.example.ramon.seriestvmaze;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ramon on 05/09/17.
 */

public class ImageLoadTask extends AsyncTask<Void,Void,Bitmap> {
    private String url;
    private ImageView imageView;
    private Callback callback;

    public ImageLoadTask(String url, ImageView imageView, final Callback callback) {
        this.url = url;
        this.imageView = imageView;
        this.callback = callback;
    }

    @Override
    protected Bitmap doInBackground(Void... params) {
        try {
            URL urlConnection = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlConnection
                    .openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        super.onPostExecute(result);
        imageView.setImageBitmap(result);
        callback.onResponse(result);
    }

}
