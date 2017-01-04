package com.jackie.baigu.xutils3.annotation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;

import com.jackie.baigu.R;
import com.jackie.baigu.xutils3.annotation.DemoFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by Administrator on 2017/1/4.
 */
@ContentView(R.layout.activity_xutils3_fragment)
public class XUtils3Fragment extends FragmentActivity {

    @ViewInject(R.id.tv_title)
    private TextView tv_title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        tv_title.setText("在Fragment中使用注解");

        //1，得到FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
        //2，开启事务
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //3，替换
        fragmentTransaction.replace(R.id.fl_content, new DemoFragment());
        //4，提交
        fragmentTransaction.commit();
    }
}
