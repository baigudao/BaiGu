package com.jackie.baigu.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jackie.baigu.R;
import com.jackie.baigu.fragmentadapter.SoundCodeFragmentAdapter;
import com.jackie.baigu.tablayout.soundcode.TabLayoutSoundCodeMainActivity;

/**
 * 作用：源码Fragment
 */
public class SoundCodeFragment extends BaseFragment {

    private ListView mListView;
    private String[] datas;
    private SoundCodeFragmentAdapter adapter;
    private static final String TAG = SoundCodeFragment.class.getSimpleName();//"CommonFrameFragment"

    @Override
    protected View initView() {
        Log.e(TAG, "源码Fragment页面被初始化了...");
        View view = View.inflate(mContext, R.layout.fragment_sound_code, null);
        mListView = (ListView) view.findViewById(R.id.listview);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = datas[position];
                if (data.toLowerCase().equals("tablayout&viewpager")) {
                    startActivity(new Intent(mContext, TabLayoutSoundCodeMainActivity.class));
                }
                // 点击位置的显示
//                Toast.makeText(mContext, "data==" + data, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG, "源码Fragment数据被初始化了...");
        //准备数据
        datas = new String[]{"网络请求:", "OKHttp", "Volley",
                "数据解析:", "NativeJsonPrase", "Gson", "FastJson",
                "图片加载:", "Glide", "Picasso", "ImageLoader", "Fresco",
                "视图显示:", "Banner", "RecyclerView", "PullToRefresh", "UniversalVideoView", "JieCaoVideoPlayer", "TabLayout&ViewPager", "OpenDanmaku", "CountdownView",
                "依赖注入:", "ButterKnife",
                "事件总线:", "EventBus",
                "数据库:", "GreenDao",
                "综合框架:", "xUtils3", "Afinal",
                "....."};
        //设置适配器
        adapter = new SoundCodeFragmentAdapter(mContext, datas);
        mListView.setAdapter(adapter);
    }
}
