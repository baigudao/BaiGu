package com.jackie.baigu.fresco;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jackie.baigu.R;


public class FrescoActivity extends Activity implements View.OnClickListener {

    private TextView tvTitle;
    private Button bt_fresco_spimg;
    private Button bt_fresco_crop;
    private Button bt_fresco_circleAndCorner;
    private Button bt_fresco_jpeg;
    private Button bt_fresco_gif;
    private Button bt_fresco_multi;
    private Button bt_fresco_resize;
    private Button bt_fresco_listener;
    private Button bt_fresco_modifyImg;
    private Button bt_fresco_autoSizeImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initListener();
    }

    private void initView() {
        setContentView(R.layout.activity_fresco);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        bt_fresco_spimg = (Button) findViewById(R.id.bt_fresco_spimg);
        bt_fresco_crop = (Button) findViewById(R.id.bt_fresco_crop);
        bt_fresco_circleAndCorner = (Button) findViewById(R.id.bt_fresco_circleAndCorner);
        bt_fresco_jpeg = (Button) findViewById(R.id.bt_fresco_jpeg);
        bt_fresco_gif = (Button) findViewById(R.id.bt_fresco_gif);
        bt_fresco_gif = (Button) findViewById(R.id.bt_fresco_gif);
        bt_fresco_multi = (Button) findViewById(R.id.bt_fresco_multi);
        bt_fresco_resize = (Button) findViewById(R.id.bt_fresco_resize);
        bt_fresco_listener = (Button) findViewById(R.id.bt_fresco_listener);
        bt_fresco_modifyImg = (Button) findViewById(R.id.bt_fresco_modifyImg);
        bt_fresco_autoSizeImg = (Button) findViewById(R.id.bt_fresco_autoSizeImg);
    }

    private void initListener() {
        bt_fresco_spimg.setOnClickListener(this);
        bt_fresco_crop.setOnClickListener(this);
        bt_fresco_circleAndCorner.setOnClickListener(this);
        bt_fresco_jpeg.setOnClickListener(this);
        bt_fresco_gif.setOnClickListener(this);
        bt_fresco_multi.setOnClickListener(this);
        bt_fresco_resize.setOnClickListener(this);
        bt_fresco_listener.setOnClickListener(this);
        bt_fresco_modifyImg.setOnClickListener(this);
        bt_fresco_autoSizeImg.setOnClickListener(this);
    }

    private void initData() {
        tvTitle.setText("Fresco");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_fresco_spimg:
                // 带进度条的图片
                startActivity(new Intent(FrescoActivity.this, FrescoSpimgActivity.class));
                break;
            case R.id.bt_fresco_crop:
                // 图片的不同裁剪
                startActivity(new Intent(FrescoActivity.this, FrescoCropActivity.class));
                break;
            case R.id.bt_fresco_circleAndCorner:
                // 圆形和圆角图片
                startActivity(new Intent(FrescoActivity.this, FrescoCircleAndCornerActivity.class));
                break;
            case R.id.bt_fresco_jpeg:
                // 渐进式展示图片
                startActivity(new Intent(FrescoActivity.this, FrescoJpegActivity.class));
                break;
            case R.id.bt_fresco_gif:
                // GIF动画图片
                startActivity(new Intent(FrescoActivity.this, FrescoGifAcitivity.class));
                break;
            case R.id.bt_fresco_multi:
                // 多图请求及图片复用
                startActivity(new Intent(FrescoActivity.this, FrescoMultiActivity.class));
                break;
            case R.id.bt_fresco_resize:
                // 图片修改和旋转
                startActivity(new Intent(FrescoActivity.this, FrescoResizeActivity.class));
                break;
            case R.id.bt_fresco_listener:
                // 图片加载监听
                startActivity(new Intent(FrescoActivity.this, FrescoListenerActivity.class));
                break;
            case R.id.bt_fresco_modifyImg:
                // 修改图片
                startActivity(new Intent(FrescoActivity.this, FrescoModifyActivity.class));
                break;
            case R.id.bt_fresco_autoSizeImg:
                // 动态展示图片
                startActivity(new Intent(FrescoActivity.this, FrescoAutoSizeActivity.class));
                break;
            default:
                break;
        }
    }
}
