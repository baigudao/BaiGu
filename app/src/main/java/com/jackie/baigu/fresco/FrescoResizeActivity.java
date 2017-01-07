package com.jackie.baigu.fresco;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.jackie.baigu.R;

public class FrescoResizeActivity extends Activity {

    private TextView tvTitle;
    private SimpleDraweeView sdvFrescoResize;
    private Button bt_fresco_resize;
    private Button bt_fresco_rotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fresco_resize);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        sdvFrescoResize = (SimpleDraweeView) findViewById(R.id.sdv_fresco_resize);
        bt_fresco_resize = (Button) findViewById(R.id.bt_fresco_resize);
        bt_fresco_rotate = (Button) findViewById(R.id.bt_fresco_rotate);
        initData();

        // 修内存中改图片大小
        bt_fresco_resize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 图片地址
                Uri uri = Uri.parse("http://4493bz.1985t.com/uploads/allimg/160923/3-160923104149.jpg");
                // 图片的请求
                ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                        .setResizeOptions(new ResizeOptions(50, 50))
                        .build();
                // 控制图片的加载
                PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                        .setOldController(sdvFrescoResize.getController())
                        .setImageRequest(request)
                        .build();
                // 加载图片
                sdvFrescoResize.setController(controller);
            }
        });
        // 旋转图片
        bt_fresco_rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://pic3.nipic.com/20090630/4527_091422023_2.jpg");
                ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                        .setAutoRotateEnabled(true)
                        .build();
                // 控制图片的加载
                DraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setOldController(sdvFrescoResize.getController())
                        .setImageRequest(request)
                        .build();
                // 加载图片
                sdvFrescoResize.setController(controller);
            }
        });
    }

    private void initData() {
        tvTitle.setText("图片缩放和旋转");
    }
}
