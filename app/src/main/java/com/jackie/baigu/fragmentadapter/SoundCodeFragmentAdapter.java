package com.jackie.baigu.fragmentadapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * 作用：常用框架的Frament
 */
public class SoundCodeFragmentAdapter extends BaseAdapter {

    private final Context mContext;
    private final String[] mDatas;

    public SoundCodeFragmentAdapter(Context context, String[] datas){
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
        textView.setPadding(10,10,0,10);
        textView.setTextColor(Color.BLUE);
        textView.setTextSize(18);
        textView.setText(mDatas[position]);
        return textView;
    }
}