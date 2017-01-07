package com.jackie.baigu.fresco;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jackie.baigu.R;

public class FrescoCircleAndCornerActivity extends Activity implements View.OnClickListener {

    private TextView tvTitle;
    private SimpleDraweeView sdvFrescoCircleandcorner;
    private Button bt_fresco_circle;
    private Button bt_fresco_corner;
    private Uri uri;
    private GenericDraweeHierarchy hierarchy;
    private GenericDraweeHierarchyBuilder builder;
    private RoundingParams parames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initListener();
    }

    private void initListener() {
        bt_fresco_circle.setOnClickListener(this);
        bt_fresco_corner.setOnClickListener(this);
    }

    private void initView() {
        setContentView(R.layout.activity_fresco_circle_and_corner);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        sdvFrescoCircleandcorner = (SimpleDraweeView) findViewById(R.id.sdv_fresco_circleandcorner);
        bt_fresco_circle = (Button) findViewById(R.id.bt_fresco_circle);
        bt_fresco_corner = (Button) findViewById(R.id.bt_fresco_corner);
    }

    private void initData() {
        tvTitle.setText("圆形和圆角图片");
        uri = Uri.parse("http://b.hiphotos.baidu.com/image/pic/item/f9198618367adab46341cd4a89d4b31c8701e422.jpg");
        builder = new GenericDraweeHierarchyBuilder(getResources());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // 设置圆形图片
            case R.id.bt_fresco_circle:
                // 设置圆形图片
                parames = RoundingParams.asCircle();
                hierarchy = builder.setRoundingParams(parames).build();
                sdvFrescoCircleandcorner.setHierarchy(hierarchy);
                sdvFrescoCircleandcorner.setImageURI(uri);
                break;
            // 设置圆角图片
            case R.id.bt_fresco_corner:
                parames = RoundingParams.fromCornersRadius(50f);
                parames.setOverlayColor(getResources().getColor(android.R.color.holo_red_light));//覆盖层
                parames.setBorder(getResources().getColor(android.R.color.holo_blue_light), 5);//边框
                hierarchy = builder.setRoundingParams(parames).build();
                sdvFrescoCircleandcorner.setHierarchy(hierarchy);
                // 加载图片
                sdvFrescoCircleandcorner.setImageURI(uri);
                break;
            default:
                break;
        }
    }
}
