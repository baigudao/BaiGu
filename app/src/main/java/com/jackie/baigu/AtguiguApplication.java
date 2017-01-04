package com.jackie.baigu;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Administrator on 2017/1/3.
 */
public class AtguiguApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化xUtils
        x.Ext.init(this);
        //是否输出debug日志，开启debug会影响性能
        x.Ext.setDebug(true);
    }
}
