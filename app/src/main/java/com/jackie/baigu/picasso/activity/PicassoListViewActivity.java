package com.jackie.baigu.picasso.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.jackie.baigu.R;
import com.jackie.baigu.picasso.adapter.PicassoListViewAdapter;

/**
 * Created by Administrator on 2016/12/31.
 */
public class PicassoListViewActivity extends Activity {

    private ListView listView;
    private TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        tv_title.setText("Picasso在ListView中使用");
        PicassoListViewAdapter picassoListViewAdapter = new PicassoListViewAdapter(PicassoListViewActivity.this);
        listView.setAdapter(picassoListViewAdapter);
    }

    private void initView() {
        setContentView(R.layout.activity_picasso_listview);
        listView = (ListView) findViewById(R.id.lv);
        tv_title = (TextView) findViewById(R.id.tv_title);
    }


}
