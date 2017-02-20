package com.jackie.baigu.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jackie.baigu.R;
import com.jackie.baigu.androidstudio.AndroidStudioConfigureActivity;
import com.jackie.baigu.fragmentadapter.BaseAndroidFragmentAdapter;

/**
 * 作用：Android基础Fragment
 */
public class BaseAndroidFragment extends BaseFragment {

    private static final String TAG = BaseAndroidFragment.class.getSimpleName();//"BaseAndroidFragment"
    private ListView listview;
    private String[] datas;
    private BaseAndroidFragmentAdapter adapter;

    @Override
    protected View initView() {
        Log.e(TAG, "Android基础Fragment页面被初始化了...");
        //加载布局视图
        View view = View.inflate(mContext, R.layout.fragment_base_android, null);
        listview = (ListView)view.findViewById(R.id.listview);
        //给listview的item设置点击事件
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = datas[position];
                if (data.equals("Android Studio的配置")){
                    startActivity(new Intent(mContext,AndroidStudioConfigureActivity.class));
                }
            }
        });
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG, "Android基础Fragment数据被初始化了...");
        //准备数据
        datas = new String[]{"Android Studio的配置","Activity", "Service", "....."};
        //设置适配器
        adapter = new BaseAndroidFragmentAdapter(mContext, datas);
        listview.setAdapter(adapter);
    }
}