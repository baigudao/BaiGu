package com.jackie.baigu.imageloader.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.jackie.baigu.R;
import com.jackie.baigu.imageloader.adapter.ImageloaderListviewAdapter;


public class ImageloaderListviewActivity extends Activity {

    private TextView tvTitle;
    private ListView lvImageloader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_imageloader_listview);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        lvImageloader = (ListView) findViewById(R.id.lv_imageloader);
        initData();
    }

    private void initData() {
        // 初始化标题
        tvTitle.setText("Imageloader应用在Listview中");

        ImageloaderListviewAdapter imageloaderListviewAdapter = new ImageloaderListviewAdapter(this);

        lvImageloader.setAdapter(imageloaderListviewAdapter);
    }
}
