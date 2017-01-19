package com.jackie.baigu.tablayout.soundcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jackie.baigu.R;

/**
 * Created by Administrator on 2017/1/11.
 */
public class TabLayoutSoundCodeMainActivity extends Activity implements View.OnClickListener{

    private TextView tv_title;
    private Button btn_lead_into;
    private Button btn_remark;
    private Button btn_main_tablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initListener();
    }

    private void initData() {
        tv_title.setText("源码");
    }

    private void initListener() {
        btn_lead_into.setOnClickListener(this);
        btn_remark.setOnClickListener(this);
        btn_main_tablayout.setOnClickListener(this);
    }

    private void initView() {
        setContentView(R.layout.sound_code_tablayout);
        tv_title = (TextView)findViewById(R.id.tv_title);
        btn_lead_into = (Button)findViewById(R.id.btn_lead_into);
        btn_remark = (Button)findViewById(R.id.btn_remark);
        btn_main_tablayout = (Button)findViewById(R.id.btn_main_tablayout);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_lead_into:
                Toast.makeText(TabLayoutSoundCodeMainActivity.this, "只要在build.gradle中加入：compile 'com.android.support:design:23.4.0'", Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_remark:
                Toast.makeText(TabLayoutSoundCodeMainActivity.this, "《在清单文件中》：<activity\n" +
                        "            android:name=\".tablayout.activity.TabLayoutMainActivity\"\n" +
                        "            android:theme=\"@style/Theme.AppCompat.Light.NoActionBar\" />", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_main_tablayout:
                startActivity(new Intent(TabLayoutSoundCodeMainActivity.this,MainSoundCodeActivity.class));
                break;
            default:
                break;
        }
    }
}
