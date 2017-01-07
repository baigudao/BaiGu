package com.jackie.baigu.fresco;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jackie.baigu.R;

public class FrescoSpimgActivity extends Activity {

    private TextView tvTitle;
    private SimpleDraweeView sdvFrescoSpimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco_spimg);
        tvTitle = (TextView)findViewById(R.id.tv_title);
        sdvFrescoSpimg = (SimpleDraweeView)findViewById(R.id.sdv_fresco_spimg);

        initData();
    }

    private void initData() {
        tvTitle.setText("带进度条的图片");

        // 设置样式
        GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(getResources());
        GenericDraweeHierarchy hierarchy = builder.setProgressBarImage(new ProgressBarDrawable()).build();
        sdvFrescoSpimg.setHierarchy(hierarchy);

        // 加载图片的地址
        Uri uri = Uri.parse("http://s11.sinaimg.cn/mw690/003KqEYezy6VTgD9FtU4a&690");

        // 加载图片
        sdvFrescoSpimg.setImageURI(uri);
    }
}
