package com.jackie.baigu.banner.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jackie.baigu.AtguiguApplication;
import com.jackie.baigu.R;
import com.jackie.baigu.banner.loader.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

public class CustomBannerActivity extends AppCompatActivity {

    Banner banner1, banner2, banner3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_banner);
        banner1 = (Banner) findViewById(R.id.banner1);
        banner2 = (Banner) findViewById(R.id.banner2);
        banner3 = (Banner) findViewById(R.id.banner3);

        banner1.setImages(AtguiguApplication.images)
                .setImageLoader(new GlideImageLoader())
                .start();

        banner2.setImages(AtguiguApplication.images)
                .setImageLoader(new GlideImageLoader())
                .start();

        banner3.setImages(AtguiguApplication.images)
                .setBannerTitles(AtguiguApplication.titles)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
                .setImageLoader(new GlideImageLoader())
                .start();
    }
}
