package com.jackie.baigu.springindicator;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.jackie.baigu.R;

/**
 * Created by jackie on 2017/1/23 18:33.
 * QQ : 971060378
 * Used as : 页面的基类
 */
public class BasePager {
    /**
     * 上下文
     */
    private Context context;
    /**
     * 页面的视图
     */
    private View rootView;
    /**
     * 资源Id
     */
    private int imageId;

    private ImageView imageView;

    public BasePager(Context context, int imageId) {
        this.context = context;
        this.imageId = imageId;
        rootView = initView();
    }

    private View initView() {
        View view = View.inflate(context, R.layout.activity_item_pager, null);
        imageView = (ImageView) view.findViewById(R.id.iv);
        return view;
    }

    public void initData() {
        imageView.setBackgroundResource(imageId);
    }

    public View getRootView() {
        return rootView;
    }
}
