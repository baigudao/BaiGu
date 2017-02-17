package com.jackie.baigu.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

/**
 * 作用：Android基础Fragment
 */
public class BaseAndroidFragment extends BaseFragment {


    private static final String TAG = BaseAndroidFragment.class.getSimpleName();//"BaseAndroidFragment"
    private TextView textView;

    @Override
    protected View initView() {
        Log.e(TAG, "Android基础Fragment页面被初始化了...");
        textView = new TextView(mContext);
        textView.setTextSize(20);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        return textView;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG, "Android基础Fragment数据被初始化了...");
        textView.setText("Android基础页面");
    }
}