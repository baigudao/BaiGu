package com.jackie.baigu.butterknife;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.jackie.baigu.R;

import butterknife.OnClick;

// butterknife
public class ButterknifeActivity extends Activity {

    @butterknife.Bind(R.id.tv_title)
    TextView tvTitle;
    @butterknife.Bind(R.id.tv_butterknife)
    TextView tvButterknife;
    @butterknife.Bind(R.id.cb_butterknife)
    CheckBox cbButterknife;
    @butterknife.Bind(R.id.bt_butterknife)
    Button btButterknife;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_butterknife);
        butterknife.ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        // 初始化标题
        tvTitle.setText("Butterknife");
        tvButterknife.setText("我好喜欢butterknife");
    }

    @OnClick(R.id.cb_butterknife)
    void cbButterknife(View view){
        Toast.makeText(ButterknifeActivity.this, "点击了checkbox", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.bt_butterknife)
    void btButterknife(View view){
        Toast.makeText(ButterknifeActivity.this, "点击了button", Toast.LENGTH_SHORT).show();
    }
}
