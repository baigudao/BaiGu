package com.jackie.baigu.xutils3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jackie.baigu.R;
import com.jackie.baigu.xutils3.annotation.XUtils3Fragment;
import com.jackie.baigu.xutils3.net.XUtils3NetActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_xutils3)
public class XUtils3Activity extends Activity {

    @ViewInject(R.id.tv_title)
    private TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(XUtils3Activity.this);
        initData();
    }

    private void initData() {
        tv_title.setText("xUtils3");
    }

    @Event(value = {R.id.btn_image, R.id.btn_annotation, R.id.btn_image_list, R.id.btn_net})
    private void getEvent(View view) {
        switch (view.getId()) {
            case R.id.btn_image:
                Toast.makeText(XUtils3Activity.this, "哈哈", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_image_list:

                break;
            case R.id.btn_annotation:
                startActivity(new Intent(XUtils3Activity.this, XUtils3Fragment.class));
                break;
            case R.id.btn_net:
                startActivity(new Intent(XUtils3Activity.this, XUtils3NetActivity.class));
                break;
        }
    }
}
