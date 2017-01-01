package com.jackie.baigu.picasso.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jackie.baigu.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Administrator on 2016/12/31.
 */
public class PicassoActivity extends Activity implements View.OnClickListener{

    private TextView tv_title;
    private Button btn_picasso_base;
    private Button btn_picasso_listview;
    private Button btn_picasso_tranformations;
    private ImageView iv_picasso_result1;
    private ImageView iv_picasso_result2;
    private ImageView iv_picasso_result3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initData();
        initListener();
    }

    private void initListener() {
        btn_picasso_base.setOnClickListener(this);
        btn_picasso_listview.setOnClickListener(this);
        btn_picasso_tranformations.setOnClickListener(this);
    }

    private void initData() {
        tv_title.setText("Picasso");
    }

    private void initView() {
        setContentView(R.layout.activity_picasso);
        tv_title = (TextView)findViewById(R.id.tv_title);
        btn_picasso_base = (Button)findViewById(R.id.btn_picasso_base);
        btn_picasso_listview = (Button)findViewById(R.id.btn_picasso_listview);
        btn_picasso_tranformations = (Button)findViewById(R.id.btn_picasso_tranformations);
        iv_picasso_result1 = (ImageView)findViewById(R.id.iv_picasso_result1);
        iv_picasso_result2 = (ImageView)findViewById(R.id.iv_picasso_result2);
        iv_picasso_result3 = (ImageView)findViewById(R.id.iv_picasso_result3);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_picasso_base:
                loadBase();
                break;
            case R.id.btn_picasso_listview:
                startActivity(new Intent(PicassoActivity.this,PicassoListViewActivity.class));
                break;
            case R.id.btn_picasso_tranformations:
                startActivity(new Intent(PicassoActivity.this,PicassoTransformationsActivity.class));
                break;
            default:
                break;
        }
    }

    /**
     * picasso的基本用法
     */
    private void loadBase() {

        //普通加载图片
        Picasso.with(PicassoActivity.this)
                .load("http://d.hiphotos.baidu.com/image/pic/item/5243fbf2b2119313b35897ca60380cd791238db4.jpg")
                .into(iv_picasso_result1);

        //裁剪的方式加载图片
        Picasso.with(PicassoActivity.this)
                .load("http://d.hiphotos.baidu.com/image/pic/item/5243fbf2b2119313b35897ca60380cd791238db4.jpg")
                .resize(100,100)
                .into(iv_picasso_result2);
        //180度转换
        Picasso.with(PicassoActivity.this)
                .load("http://d.hiphotos.baidu.com/image/pic/item/5243fbf2b2119313b35897ca60380cd791238db4.jpg")
                .rotate(180)
                .into(iv_picasso_result3);
    }
}
