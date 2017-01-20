package com.jackie.baigu.glide.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.jackie.baigu.R;
import com.jackie.baigu.glide.adapter.GlideRecyclerviewAdapter;

public class GlideRecyclerviewActivity extends Activity {

    private TextView tvTitle;
    private RecyclerView rvGlide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initView() {
        setContentView(R.layout.activity_glide_recyclerview);
        tvTitle = (TextView)findViewById(R.id.tv_title);
        rvGlide = (RecyclerView)findViewById(R.id.rv_glide);
    }

    private void initData() {
        tvTitle.setText("Glide在RecyclerView中加载图片");

        // 初始化Recyclerview
        GlideRecyclerviewAdapter glideRecyclerviewAdapter = new GlideRecyclerviewAdapter(this);
        rvGlide.setAdapter(glideRecyclerviewAdapter);
        //设置布局管理
        //ListView的效果
        rvGlide.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }
}
