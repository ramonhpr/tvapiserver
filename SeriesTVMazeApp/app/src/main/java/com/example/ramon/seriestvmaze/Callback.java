package com.example.ramon.seriestvmaze;

import android.graphics.Bitmap;

/**
 * Created by ramon on 05/09/17.
 */

interface Callback<T> {
    void onResponse(T results);
}
