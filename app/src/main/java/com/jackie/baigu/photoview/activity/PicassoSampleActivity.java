package com.jackie.baigu.photoview.activity;

import android.app.Activity;
import android.os.Bundle;

import com.jackie.baigu.R;
import com.squareup.picasso.Picasso;

import uk.co.senab.photoview.PhotoView;

public class PicassoSampleActivity extends Activity {

    private PhotoView photoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso_sample);
        photoView = (PhotoView) findViewById(R.id.iv_photo);

        Picasso.with(this)
                .load("http://pbs.twimg.com/media/Bist9mvIYAAeAyQ.jpg")
                .into(photoView);
    }
}
