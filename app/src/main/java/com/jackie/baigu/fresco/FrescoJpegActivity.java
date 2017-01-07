package com.jackie.baigu.fresco;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.jackie.baigu.R;

public class FrescoJpegActivity extends Activity {

    private TextView tvTitle;
    private SimpleDraweeView sdvFrescoJpeg;
    private Button sdv_fresco_askImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco_jpeg);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        sdvFrescoJpeg = (SimpleDraweeView) findViewById(R.id.sdv_fresco_jpeg);
        sdv_fresco_askImg = (Button) findViewById(R.id.sdv_fresco_askImg);

        initData();

        sdv_fresco_askImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 加载质量配置
                ProgressiveJpegConfig jpegConfig = new ProgressiveJpegConfig() {
                    @Override
                    public int getNextScanNumberToDecode(int scanNumber) {
                        return scanNumber + 2;
                    }

                    @Override
                    public QualityInfo getQualityInfo(int scanNumber) {
                        boolean isGoodEnough = (scanNumber >= 5);

                        return ImmutableQualityInfo.of(scanNumber, isGoodEnough, false);
                    }
                };
                ImagePipelineConfig.newBuilder(FrescoJpegActivity.this).setProgressiveJpegConfig(jpegConfig).build();
                // 获取图片URL
                Uri uri = Uri.parse("http://h.hiphotos.baidu.com/image/pic/item/3801213fb80e7bec83f190e12d2eb9389b506b83.jpg");
                // 获取图片请求
                ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri).setProgressiveRenderingEnabled(true).build();

                DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request)
                        .setTapToRetryEnabled(true)
                        .setOldController(sdvFrescoJpeg.getController())//使用oldController可以节省不必要的内存分配
                        .build();
                // 1设置加载的控制
                sdvFrescoJpeg.setController(draweeController);
            }
        });
    }

    private void initData() {
        tvTitle.setText("渐进式展示图片");
    }
}
