package com.jackie.baigu.fragmentadapter;

/**
 * Created by jackie on 2017/2/17 22:46.
 * QQ : 971060378
 * Used as : xxx
 */


import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * 作用：常用框架的FragmentAdapter
 */
public class CommonFrameFragmentAdapter extends BaseAdapter {

    private final Context mContext;
    private final String[] mDatas;

    public CommonFrameFragmentAdapter(Context context, String[] datas) {
        this.mContext = context;
        this.mDatas = datas;
    }

    @Override
    public int getCount() {
        return mDatas.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = new TextView(mContext);
        textView.setPadding(15, 15, 0, 15);
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(18);
        textView.setText(mDatas[position]);
        return textView;
    }
}