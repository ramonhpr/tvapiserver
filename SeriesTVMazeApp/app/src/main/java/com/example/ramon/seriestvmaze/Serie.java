package com.example.ramon.seriestvmaze;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Created by ramon on 05/09/17.
 */

public class Serie {
    public String name;
    public String year;
    public String urlImage;
    public String summary;


    private ImageLoadTask ilt;
    private Bitmap image;

    public Serie(String name, String year, String urlImage, String summary) {
        this.name = name;
        this.year = year;
        this.urlImage = urlImage;
        this.summary = summary;
    }

}
