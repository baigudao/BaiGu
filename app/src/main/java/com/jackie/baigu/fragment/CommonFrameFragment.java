package com.jackie.baigu.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.jackie.baigu.R;
import com.jackie.baigu.fastjson.activity.FastJsonActivity;
import com.jackie.baigu.gson.activity.GsonActivity;
import com.jackie.baigu.json.activity.NativeJsonPraseActivity;
import com.jackie.baigu.okhttp.activity.OKHttpActivity;
import com.jackie.baigu.okhttp.adapter.CommonFrameFragmentAdapter;
import com.jackie.baigu.picasso.activity.PicassoActivity;

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
        Log.e(TAG,"常用框架Fragment页面被初始化了...");
        View view = View.inflate(mContext, R.layout.fragment_common_frame,null);
        mListView = (ListView) view.findViewById(R.id.listview);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data =  datas[position];
                if (data.toLowerCase().equals("okhttp")){
                    startActivity(new Intent(mContext,OKHttpActivity.class));
                }else if (data.toLowerCase().equals("picasso")){
                    startActivity(new Intent(mContext,PicassoActivity.class));
                }else if (data.toLowerCase().equals("nativejsonprase")){
                    startActivity(new Intent(mContext,NativeJsonPraseActivity.class));
                }else if (data.toLowerCase().equals("gson")){
                    startActivity(new Intent(mContext,GsonActivity.class));
                }else if (data.toLowerCase().equals("fastjson")){
                    startActivity(new Intent(mContext,FastJsonActivity.class));
                }
                Toast.makeText(mContext, "data=="+data, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG, "常用框架Fragment数据被初始化了...");
        //准备数据
        datas = new String[]{"OKHttp", "NativeJsonPrase","Gson","FastJson","xUtils3","Retrofit2","Fresco","Glide","greenDao","RxJava","volley","Picasso","evenBus","jcvideoplayer","pulltorefresh","Expandablelistview","UniversalVideoView","....."};
        //设置适配器
        adapter = new CommonFrameFragmentAdapter(mContext,datas);
        mListView.setAdapter(adapter);
    }
}