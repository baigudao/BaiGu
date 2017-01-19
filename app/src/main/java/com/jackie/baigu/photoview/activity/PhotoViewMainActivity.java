package com.jackie.baigu.photoview.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jackie.baigu.R;

import uk.co.senab.photoview.PhotoView;

/**
 * Created by jackie on 2017/1/20 3:43.
 * QQ : 971060378
 * Used as : xxx
 */
public class PhotoViewMainActivity extends Activity implements View.OnClickListener{

    private TextView tv_title;
    private Button btn_simple;
    private Button btn_picasso_photo_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        setListener();
    }

    private void setListener() {
        btn_simple.setOnClickListener(this);
        btn_picasso_photo_view.setOnClickListener(this);
    }

    private void initData() {
        tv_title.setText("PhotoView操作");
    }

    private void initView() {
        setContentView(R.layout.activity_photo_view_main);
        tv_title = (TextView)findViewById(R.id.tv_title);
        btn_simple = (Button)findViewById(R.id.btn_simple);
        btn_picasso_photo_view = (Button)findViewById(R.id.btn_picasso_photo_view);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_simple:
                startActivity(new Intent(PhotoViewMainActivity.this,SimpleSampleActivity.class));
                break;
            case R.id.btn_picasso_photo_view:
                startActivity(new Intent(PhotoViewMainActivity.this,PicassoSampleActivity.class));
                break;
            default:
                break;
        }
    }
}
