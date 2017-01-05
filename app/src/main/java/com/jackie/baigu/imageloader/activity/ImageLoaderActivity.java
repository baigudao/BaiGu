package com.jackie.baigu.imageloader.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jackie.baigu.R;

/**
 * Created by Administrator on 2017/1/6.
 */
public class ImageLoaderActivity extends Activity implements View.OnClickListener {

    private TextView tvTitle;
    private Button btImageloaderListview;
    private Button btImageloaderGridview;
    private Button btImageloaderViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loader);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        btImageloaderListview = (Button) findViewById(R.id.bt_imageloader_listview);
        btImageloaderGridview = (Button) findViewById(R.id.bt_imageloader_gridview);
        btImageloaderViewpager = (Button) findViewById(R.id.bt_imageloader_viewpager);
        initData();
        setListener();
    }

    private void setListener() {
        btImageloaderListview.setOnClickListener(this);
        btImageloaderGridview.setOnClickListener(this);
        btImageloaderViewpager.setOnClickListener(this);
    }

    private void initData() {
        // 标题
        tvTitle.setText("Imageloader");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_imageloader_listview:
// 跳转到listview案例页面
                startActivity(new Intent(ImageLoaderActivity.this, ImageloaderListviewActivity.class));
                break;
            case R.id.bt_imageloader_gridview:
// 跳转到gridview案例页面
                startActivity(new Intent(ImageLoaderActivity.this, ImageloaderGridviewActivity.class));
                break;
            case R.id.bt_imageloader_viewpager:
// 跳转到viewpager案例页面
                startActivity(new Intent(ImageLoaderActivity.this, ImageloaderViewpagerActivity.class));
                break;
            default:
                break;
        }
    }
}
