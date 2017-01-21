package com.jackie.baigu.bezier;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.jackie.baigu.R;

/**
 * Created by jackie on 2017/1/22 0:08.
 * QQ : 971060378
 * Used as : xxx
 */
public class BezierMainActivity extends Activity{

    private TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bezier_main);
        tv_title = (TextView)findViewById(R.id.tv_title);
        tv_title.setText("Bezier");
    }
}
