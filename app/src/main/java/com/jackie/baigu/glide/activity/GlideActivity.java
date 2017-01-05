package com.jackie.baigu.glide.activity;

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
public class GlideActivity extends Activity implements View.OnClickListener {

    private TextView tv_title;
    private Button btn_glide_base;
    private Button btn_glide_recyclerView;
    private Button btn_glide_transformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        setListener();
    }

    private void setListener() {
        btn_glide_base.setOnClickListener(this);
        btn_glide_recyclerView.setOnClickListener(this);
        btn_glide_transformation.setOnClickListener(this);
    }

    private void initData() {
        tv_title.setText("Glide操作");
    }

    private void initView() {
        setContentView(R.layout.activity_glide);
        tv_title = (TextView) findViewById(R.id.tv_title);
        btn_glide_base = (Button) findViewById(R.id.btn_glide_base);
        btn_glide_recyclerView = (Button) findViewById(R.id.btn_glide_recyclerView);
        btn_glide_transformation = (Button) findViewById(R.id.btn_glide_transformation);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_glide_base:
                startActivity(new Intent(GlideActivity.this, GlideBaseActivity.class));
                break;
            case R.id.btn_glide_recyclerView:
                startActivity(new Intent(GlideActivity.this, GlideRecyclerviewActivity.class));
                break;
            case R.id.btn_glide_transformation:
                startActivity(new Intent(GlideActivity.this, GlideTranformationsActivity.class));
                break;
            default:
                break;
        }
    }
}
