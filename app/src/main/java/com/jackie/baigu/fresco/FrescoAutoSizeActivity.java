package com.jackie.baigu.fresco;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.jackie.baigu.R;

public class FrescoAutoSizeActivity extends Activity {

    private TextView tvTitle;
    private LinearLayout llFresco;
    private Button bt_fresco_loadsmall;
    private SimpleDraweeView simpleDraweeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fresco_auto_size);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        llFresco = (LinearLayout) findViewById(R.id.ll_fresco);
        bt_fresco_loadsmall = (Button) findViewById(R.id.bt_fresco_loadsmall);
        initData();

        bt_fresco_loadsmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 图片的地址
                Uri uri = Uri.parse("http://img4q.duitang.com/uploads/item/201304/27/20130427043538_wAfHC.jpeg");
                // 图片的请求
                ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                        .build();
                // 加载图片的控制
                PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                        .setOldController(simpleDraweeView.getController())
                        .setImageRequest(request)
                        .build();
                // 加载图片
                simpleDraweeView.setController(controller);
                // 添加View到线性布局中
                llFresco.addView(simpleDraweeView);
            }
        });
    }

    private void initData() {
        tvTitle.setText("动态展示图片");
        simpleDraweeView = new SimpleDraweeView(this);
        // 设置宽高比
        simpleDraweeView.setAspectRatio(3.0f);
    }
}
