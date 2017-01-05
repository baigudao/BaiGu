package com.jackie.baigu.imageloader.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import com.jackie.baigu.R;
import com.jackie.baigu.imageloader.adapter.ImageloaderGridviewAdapter;


public class ImageloaderGridviewActivity extends Activity {

    private TextView tvTitle;
    private GridView gvImageloaderGridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_imageloader_gridview);
        tvTitle = (TextView)findViewById(R.id.tv_title);
        gvImageloaderGridview = (GridView)findViewById(R.id.gv_imageloader_gridview);
        initData();
    }

    private void initData() {
        // 标题
        tvTitle.setText("Imageloader应用在Gridview中");

        // 初始化Gridview
        ImageloaderGridviewAdapter imageloaderGridviewAdapter = new ImageloaderGridviewAdapter(this);

        gvImageloaderGridview.setAdapter(imageloaderGridviewAdapter);
    }
}
