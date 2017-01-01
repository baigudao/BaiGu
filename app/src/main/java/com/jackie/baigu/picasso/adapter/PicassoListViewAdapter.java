package com.jackie.baigu.picasso.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jackie.baigu.R;
import com.jackie.baigu.picasso.utils.Constants;
import com.squareup.picasso.Picasso;

/**
 * Created by Administrator on 2016/12/31.
 */
public class PicassoListViewAdapter extends BaseAdapter {

    private Context context;

    public PicassoListViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return Constants.IMAGES.length;
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
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_picasso_listview, null);
            viewHolder = new ViewHolder();
            viewHolder.iv_picasso_item = (ImageView) convertView.findViewById(R.id.iv_picasso_item);
            viewHolder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //名称
        viewHolder.tv_name.setText("item"+ (position+1));
        //加载图片
        Picasso.with(context)
                .load(Constants.IMAGES[position])
                .placeholder(R.drawable.atguigu_logo)
                .error(R.drawable.atguigu_logo)
                .into(viewHolder.iv_picasso_item);

        return convertView;
    }

    static class ViewHolder {
        ImageView iv_picasso_item;
        TextView tv_name;
    }
}

