package com.jackie.baigu.glide;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.jackie.baigu.R;

public class GlideTranformationsActivity extends Activity {

    private TextView tvTitle;
    private RecyclerView rvGlideTransformations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initView() {
        setContentView(R.layout.activity_glide_tranformations);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        rvGlideTransformations = (RecyclerView) findViewById(R.id.rv_glide_transformations);
    }

    private void initData() {
        tvTitle.setText("Glide图形变换");
        // 初始化Recyclerview
        GlideTranformationsAdapter glideTranformationsAdapter = new GlideTranformationsAdapter(this);
        rvGlideTransformations.setAdapter(glideTranformationsAdapter);
        rvGlideTransformations.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}
