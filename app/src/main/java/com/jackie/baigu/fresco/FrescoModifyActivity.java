package com.jackie.baigu.fresco;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.jackie.baigu.R;

public class FrescoModifyActivity extends Activity {

    private TextView tvTitle;
    private SimpleDraweeView sdvFrescoModify;
    private Button bt_fresco_modify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco_modify);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        sdvFrescoModify = (SimpleDraweeView) findViewById(R.id.sdv_fresco_modify);
        bt_fresco_modify = (Button) findViewById(R.id.bt_fresco_modify);
        initData();

        bt_fresco_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 图片地址
                Uri uri = Uri.parse("http://imgsrc.baidu.com/forum/pic/item/d52a2834349b033b48568b6515ce36d3d439bdb6.jpg");
                // 修改图片
                Postprocessor postProcessor = new BasePostprocessor() {
                    @Override
                    public String getName() {
                        return "postProcessor";
                    }

                    @Override
                    public void process(Bitmap bitmap) {

                        for (int x = 0; x < bitmap.getWidth(); x += 2) {

                            for (int y = 0; y < bitmap.getHeight(); y += 2) {
                                bitmap.setPixel(x, y, Color.RED);
                            }
                        }
                    }
                };
                // 创建图片请求
                ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                        .setPostprocessor(postProcessor)
                        .build();
                // 控制加载
                PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                        .setOldController(sdvFrescoModify.getController())
                        .setImageRequest(request)
                        .build();
                // 加载图片
                sdvFrescoModify.setController(controller);
            }
        });
    }

    private void initData() {
        tvTitle.setText("修改图片");
    }
}
