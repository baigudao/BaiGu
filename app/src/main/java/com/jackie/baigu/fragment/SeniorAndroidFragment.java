package com.jackie.baigu.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jackie.baigu.R;
import com.jackie.baigu.fragmentadapter.SeniorAndroidFragmentAdapter;
import com.jackie.baigu.glide.soundcode.GlideSoundCodeMainActivity;
import com.jackie.baigu.tablayout.soundcode.TabLayoutSoundCodeMainActivity;

/**
 * 作用：高级Android的Fragment：包括自定义控件；JNI；android与H5互调等
 */
public class SeniorAndroidFragment extends BaseFragment {

    private ListView mListView;
    private String[] datas;
    private SeniorAndroidFragmentAdapter adapter;
    private static final String TAG = SeniorAndroidFragment.class.getSimpleName();//"SeniorAndroidFragment"

    @Override
    protected View initView() {
        Log.e(TAG, "高级Android的Fragment页面被初始化了...");
        View view = View.inflate(mContext, R.layout.fragment_senior_android, null);
        mListView = (ListView) view.findViewById(R.id.listview);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = datas[position];
                if (data.toLowerCase().equals("tablayout&viewpager")) {
                    startActivity(new Intent(mContext, TabLayoutSoundCodeMainActivity.class));
                } else if (data.toLowerCase().equals("glide")) {
                    startActivity(new Intent(mContext, GlideSoundCodeMainActivity.class));
                }
            }
        });
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG, "高级Android的Fragment数据被初始化了...");
        //准备数据
        datas = new String[]{"图片加载:", "Glide", "Picasso", "ImageLoader", "Fresco",
                "网络请求:", "OKHttp", "Volley",
                "数据解析:", "NativeJsonPrase", "Gson", "FastJson",
                "视图显示:", "Banner", "PhotoView", "RecyclerView", "PullToRefresh", "UniversalVideoView", "JieCaoVideoPlayer", "TabLayout&ViewPager", "OpenDanmaku", "CountdownView", "JPush", "ShareSDK", "BaiduMapSDK",
                "依赖注入:", "ButterKnife",
                "事件总线:", "EventBus",
                "数据库:", "ORMLite", "GreenDao",
                "综合框架:", "xUtils3", "Afinal",
                "....."};
        //设置适配器
        adapter = new SeniorAndroidFragmentAdapter(mContext, datas);
        mListView.setAdapter(adapter);
    }
}
