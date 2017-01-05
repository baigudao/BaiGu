package com.jackie.baigu.imageloader.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.jackie.baigu.R;
import com.jackie.baigu.imageloader.adapter.ImageloaderViewpagerAdapter;

public class ImageloaderViewpagerActivity extends Activity {

    private TextView tvTitle;
    private ViewPager vpImageloaderViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_imageloader_viewpager);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        vpImageloaderViewpager = (ViewPager) findViewById(R.id.vp_imageloader_viewpager);
        initData();
    }

    private void initData() {
        // 标题
        tvTitle.setText("Imageloader应用在viewpager中");

        // 初始化viewpager
        ImageloaderViewpagerAdapter imageloaderViewpagerAdapter = new ImageloaderViewpagerAdapter(this);

        vpImageloaderViewpager.setAdapter(imageloaderViewpagerAdapter);

        // 显示第一个条目
        vpImageloaderViewpager.setCurrentItem(1);
    }
}
