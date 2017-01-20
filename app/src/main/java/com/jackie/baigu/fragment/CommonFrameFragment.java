package com.jackie.baigu.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jackie.baigu.R;
import com.jackie.baigu.afinal.AfinalActivity;
import com.jackie.baigu.pulltorefresh.PullToRefreshMainActivity;
import com.jackie.baigu.banner.activity.BannerMainActivity;
import com.jackie.baigu.butterknife.ButterknifeActivity;
import com.jackie.baigu.countdownview.CountdownViewMainActivity;
import com.jackie.baigu.eventbus.EventBusActivity;
import com.jackie.baigu.fastjson.activity.FastJsonActivity;
import com.jackie.baigu.fragmentadapter.CommonFrameFragmentAdapter;
import com.jackie.baigu.fresco.FrescoActivity;
import com.jackie.baigu.glide.activity.GlideActivity;
import com.jackie.baigu.gson.activity.GsonActivity;
import com.jackie.baigu.imageloader.activity.ImageLoaderActivity;
import com.jackie.baigu.jiecaovideoplayer.activity.JieCaoVideoPlayerMainActivity;
import com.jackie.baigu.json.activity.NativeJsonPraseActivity;
import com.jackie.baigu.okhttp.activity.OKHttpActivity;
import com.jackie.baigu.opendanmaku.OpenDanmakuMainActivity;
import com.jackie.baigu.photoview.activity.PhotoViewMainActivity;
import com.jackie.baigu.picasso.activity.PicassoActivity;
import com.jackie.baigu.recyclerview.RecyclerViewActivity;
import com.jackie.baigu.tablayout.activity.TabLayoutMainActivity;
import com.jackie.baigu.universalvideoview.UniversalVideoViewActivity;
import com.jackie.baigu.volley.VolleyActivity;
import com.jackie.baigu.xutils3.XUtils3Activity;

/**
 * 作用：常用框架Fragment
 */
public class CommonFrameFragment extends BaseFragment {

    private ListView mListView;
    private String[] datas;
    private CommonFrameFragmentAdapter adapter;
    private static final String TAG = CommonFrameFragment.class.getSimpleName();//"CommonFrameFragment"

    @Override
    protected View initView() {
        Log.e(TAG, "常用框架Fragment页面被初始化了...");
        View view = View.inflate(mContext, R.layout.fragment_common_frame, null);
        mListView = (ListView) view.findViewById(R.id.listview);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = datas[position];
                if (data.toLowerCase().equals("okhttp")) {
                    startActivity(new Intent(mContext, OKHttpActivity.class));
                } else if (data.toLowerCase().equals("picasso")) {
                    startActivity(new Intent(mContext, PicassoActivity.class));
                } else if (data.toLowerCase().equals("nativejsonprase")) {
                    startActivity(new Intent(mContext, NativeJsonPraseActivity.class));
                } else if (data.toLowerCase().equals("gson")) {
                    startActivity(new Intent(mContext, GsonActivity.class));
                } else if (data.toLowerCase().equals("fastjson")) {
                    startActivity(new Intent(mContext, FastJsonActivity.class));
                } else if (data.toLowerCase().equals("xutils3")) {
                    startActivity(new Intent(mContext, XUtils3Activity.class));
                } else if (data.toLowerCase().equals("recyclerview")) {
                    startActivity(new Intent(mContext, RecyclerViewActivity.class));
                } else if (data.toLowerCase().equals("glide")) {
                    startActivity(new Intent(mContext, GlideActivity.class));
                } else if (data.toLowerCase().equals("imageloader")) {
                    startActivity(new Intent(mContext, ImageLoaderActivity.class));
                } else if (data.toLowerCase().equals("universalvideoview")) {
                    startActivity(new Intent(mContext, UniversalVideoViewActivity.class));
                } else if (data.toLowerCase().equals("pulltorefresh")) {
                    startActivity(new Intent(mContext, PullToRefreshMainActivity.class));
                } else if (data.toLowerCase().equals("fresco")) {
                    startActivity(new Intent(mContext, FrescoActivity.class));
                } else if (data.toLowerCase().equals("eventbus")) {
                    startActivity(new Intent(mContext, EventBusActivity.class));
                } else if (data.toLowerCase().equals("butterknife")) {
                    startActivity(new Intent(mContext, ButterknifeActivity.class));
                } else if (data.toLowerCase().equals("opendanmaku")) {
                    startActivity(new Intent(mContext, OpenDanmakuMainActivity.class));
                } else if (data.toLowerCase().equals("countdownview")) {
                    startActivity(new Intent(mContext, CountdownViewMainActivity.class));
                } else if (data.toLowerCase().equals("volley")) {
                    startActivity(new Intent(mContext, VolleyActivity.class));
                } else if (data.toLowerCase().equals("afinal")) {
                    startActivity(new Intent(mContext, AfinalActivity.class));
                } else if (data.toLowerCase().equals("banner")) {
                    startActivity(new Intent(mContext, BannerMainActivity.class));
                } else if (data.toLowerCase().equals("jiecaovideoplayer")) {
                    startActivity(new Intent(mContext, JieCaoVideoPlayerMainActivity.class));
                } else if (data.toLowerCase().equals("tablayout&viewpager")) {
                    startActivity(new Intent(mContext, TabLayoutMainActivity.class));
                }else if (data.toLowerCase().equals("photoview")){
                    startActivity(new Intent(mContext,PhotoViewMainActivity.class));
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
        Log.e(TAG, "常用框架Fragment数据被初始化了...");
        //准备数据
        datas = new String[]{"网络请求:", "OKHttp", "Volley",
                "数据解析:", "NativeJsonPrase", "Gson", "FastJson",
                "图片加载:", "Glide", "Picasso", "ImageLoader", "Fresco",
                "视图显示:", "Banner","PhotoView", "RecyclerView", "PullToRefresh", "UniversalVideoView", "JieCaoVideoPlayer", "TabLayout&ViewPager", "OpenDanmaku", "CountdownView","JPush","ShareSDK","BaiduMapSDK",
                "依赖注入:", "ButterKnife",
                "事件总线:", "EventBus",
                "数据库:", "ORMLite","GreenDao",
                "综合框架:", "xUtils3", "Afinal",
                "....."};
        //设置适配器
        adapter = new CommonFrameFragmentAdapter(mContext, datas);
        mListView.setAdapter(adapter);
    }
}