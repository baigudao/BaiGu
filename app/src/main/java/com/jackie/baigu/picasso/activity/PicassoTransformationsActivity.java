package com.jackie.baigu.picasso.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.jackie.baigu.R;
import com.jackie.baigu.picasso.adapter.PicassoTransformationsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/31.
 */
public class PicassoTransformationsActivity extends Activity {

    private TextView tv_title;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        tv_title.setText("Picasso的转换操作");
        List<String> datas = new ArrayList<>();
        for (int i = 1; i < 36; i++) {
            datas.add(i + "");
        }
        PicassoTransformationsAdapter picassoTransformationsAdapter = new PicassoTransformationsAdapter(PicassoTransformationsActivity.this, datas);
        listView.setAdapter(picassoTransformationsAdapter);
    }

    private void initView() {
        setContentView(R.layout.activity_picasso_transfomations);
        tv_title = (TextView) findViewById(R.id.tv_title);
        listView = (ListView) findViewById(R.id.lv);
    }
}
