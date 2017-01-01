package com.jackie.baigu.picasso.utils;

import android.content.Context;

/**
 * Created by Administrator on 2016/12/31.
 */
public class Utils {
    public static int dip2px(Context context, float dp) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}
