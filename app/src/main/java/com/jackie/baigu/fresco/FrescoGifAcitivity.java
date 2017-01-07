package com.jackie.baigu.fresco;

import android.app.Activity;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jackie.baigu.R;

public class FrescoGifAcitivity extends Activity {

    private TextView tvTitle;
    private SimpleDraweeView sdvFrescoGif;
    private Button bt_fresco_askImg;
    private Button bt_fresco_stopAnim;
    private Button bt_fresco_startAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();

        // 请求gif图片
        bt_fresco_askImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://ww2.sinaimg.cn/large/67e51264gw1emosl2otb1g208c08c4io.gif");

                DraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setUri(uri)
                        .setAutoPlayAnimations(false)
                        .setOldController(sdvFrescoGif.getController())
                        .build();

                sdvFrescoGif.setController(controller);
            }
        });
        //  动画停止
        bt_fresco_stopAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animatable animatable = sdvFrescoGif.getController().getAnimatable();
                if (animatable != null && animatable.isRunning()) {
                    animatable.stop();
                }
            }
        });
        // 动画开始
        bt_fresco_startAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animatable animatable = sdvFrescoGif.getController().getAnimatable();
                if (animatable != null && !animatable.isRunning()) {
                    animatable.start();
                }
            }
        });
    }

    private void initView() {
        setContentView(R.layout.activity_fresco_gif_acitivity);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        sdvFrescoGif = (SimpleDraweeView) findViewById(R.id.sdv_fresco_gif);
        bt_fresco_askImg = (Button) findViewById(R.id.bt_fresco_askImg);
        bt_fresco_stopAnim = (Button) findViewById(R.id.bt_fresco_stopAnim);
        bt_fresco_startAnim = (Button) findViewById(R.id.bt_fresco_startAnim);
    }

    private void initData() {
        tvTitle.setText("Gif动画图片");
    }
}
