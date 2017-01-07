package com.jackie.baigu.fresco;

import android.app.Activity;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jackie.baigu.R;

public class FrescoCropActivity extends Activity implements View.OnClickListener {

    private TextView tvTitle;
    private SimpleDraweeView sdvFrescoCrop;
    private TextView tvFrescoExplain;
    private GenericDraweeHierarchy hierarchy;
    private GenericDraweeHierarchyBuilder builder;

    private Button bt_fresco_center;
    private Button bt_fresco_centercrop;
    private Button bt_fresco_focuscrop;
    private Button bt_fresco_centerinside;
    private Button bt_fresco_fitcenter;
    private Button bt_fresco_fitstart;
    private Button bt_fresco_fitend;
    private Button bt_fresco_fitxy;
    private Button bt_fresco_none;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        setListener();
    }

    private void initView() {
        setContentView(R.layout.activity_fresco_crop);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        sdvFrescoCrop = (SimpleDraweeView) findViewById(R.id.sdv_fresco_crop);
        tvFrescoExplain = (TextView) findViewById(R.id.tv_fresco_explain);
        bt_fresco_center = (Button) findViewById(R.id.bt_fresco_center);
        bt_fresco_centercrop = (Button) findViewById(R.id.bt_fresco_centercrop);
        bt_fresco_focuscrop = (Button) findViewById(R.id.bt_fresco_focuscrop);
        bt_fresco_centerinside = (Button) findViewById(R.id.bt_fresco_centerinside);
        bt_fresco_fitcenter = (Button) findViewById(R.id.bt_fresco_fitcenter);
        bt_fresco_fitstart = (Button) findViewById(R.id.bt_fresco_fitstart);
        bt_fresco_fitend = (Button) findViewById(R.id.bt_fresco_fitend);
        bt_fresco_fitxy = (Button) findViewById(R.id.bt_fresco_fitxy);
        bt_fresco_none = (Button) findViewById(R.id.bt_fresco_none);
    }

    private void setListener() {
        bt_fresco_center.setOnClickListener(this);
        bt_fresco_centercrop.setOnClickListener(this);
        bt_fresco_focuscrop.setOnClickListener(this);
        bt_fresco_centerinside.setOnClickListener(this);
        bt_fresco_fitcenter.setOnClickListener(this);
        bt_fresco_fitstart.setOnClickListener(this);
        bt_fresco_fitend.setOnClickListener(this);
        bt_fresco_fitxy.setOnClickListener(this);
        bt_fresco_none.setOnClickListener(this);
    }

    private void initData() {
        tvTitle.setText("图片的不同裁剪");
        builder = new GenericDraweeHierarchyBuilder(getResources());
    }

    private void imageDisplay(GenericDraweeHierarchy hierarchy) {
        sdvFrescoCrop.setHierarchy(hierarchy);
        // 加载图片
        Uri uri = Uri.parse("http://d.hiphotos.baidu.com/image/pic/item/50da81cb39dbb6fdb171262b0b24ab18972b3791.jpg");
        sdvFrescoCrop.setImageURI(uri);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // 居中，无缩放
            case R.id.bt_fresco_center:
                // 设置描述
                tvFrescoExplain.setText("居中，无缩放");
                // 样式设置
                hierarchy = builder.setActualImageScaleType(ScalingUtils.ScaleType.CENTER).build();
                // 图片显示
                imageDisplay(hierarchy);
                break;
            // 保持宽高比缩小或放大，使得两边都大于或等于显示边界。居中显示
            case R.id.bt_fresco_centercrop:
                // 设置描述
                tvFrescoExplain.setText("保持宽高比缩小或放大，使得两边都大于或等于显示边界。居中显示");
                // 样式设置
                hierarchy = builder.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP).build();
                // 图片显示
                imageDisplay(hierarchy);
                break;
            // 同centerCrop, 但居中点不是中点，而是指定的某个点,这里我设置为图片的左上角那点
            case R.id.bt_fresco_focuscrop:
                // 设置描述
                tvFrescoExplain.setText("同centerCrop, 但居中点不是中点，而是指定的某个点,这里我设置为图片的左上角那点");
                // 样式设置
                PointF point = new PointF(0, 0);
                hierarchy = builder.setActualImageScaleType(ScalingUtils.ScaleType.FOCUS_CROP)
                        .setActualImageFocusPoint(point).build();
                // 图片显示
                imageDisplay(hierarchy);
                break;
            // 使两边都在显示边界内，居中显示。如果图尺寸大于显示边界，则保持长宽比缩小图片
            case R.id.bt_fresco_centerinside:
                // 设置描述
                tvFrescoExplain.setText("使两边都在显示边界内，居中显示。如果图尺寸大于显示边界，则保持长宽比缩小图片");
                // 样式设置
                hierarchy = builder.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE).build();
                // 图片显示
                imageDisplay(hierarchy);
                break;
            // 保持宽高比，缩小或者放大，使得图片完全显示在显示边界内。居中显示
            case R.id.bt_fresco_fitcenter:
                // 设置描述
                tvFrescoExplain.setText("保持宽高比，缩小或者放大，使得图片完全显示在显示边界内。居中显示");
                // 样式设置
                hierarchy = builder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).build();
                // 图片显示
                imageDisplay(hierarchy);
                break;
            // 保持宽高比，缩小或者放大，使得图片完全显示在显示边界内，不居中，和显示边界左上对齐
            case R.id.bt_fresco_fitstart:
                // 设置描述
                tvFrescoExplain.setText("保持宽高比，缩小或者放大，使得图片完全显示在显示边界内，不居中，和显示边界左上对齐");
                // 样式设置
                hierarchy = builder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_START).build();
                // 图片显示
                imageDisplay(hierarchy);
                break;
            // 保持宽高比，缩小或者放大，使得图片完全显示在显示边界内，不居中，和显示边界右下对齐
            case R.id.bt_fresco_fitend:
                // 设置描述
                tvFrescoExplain.setText("保持宽高比，缩小或者放大，使得图片完全显示在显示边界内，不居中，和显示边界右下对齐");
                // 样式设置
                hierarchy = builder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_END).build();
                // 图片显示
                imageDisplay(hierarchy);
                break;
            // 不保持宽高比，填充满显示边界
            case R.id.bt_fresco_fitxy:
                // 设置描述
                tvFrescoExplain.setText("不保持宽高比，填充满显示边界");
                // 样式设置
                hierarchy = builder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY).build();
                // 图片显示
                imageDisplay(hierarchy);
                break;
            // 如要使用title mode显示, 需要设置为none
            case R.id.bt_fresco_none:
                // 设置描述
                tvFrescoExplain.setText("如要使用title mode显示, 需要设置为none");
                // 样式设置
                hierarchy = builder.setActualImageScaleType(null).build();
                // 图片显示
                imageDisplay(hierarchy);
                break;
            default:
                break;
        }
    }
}
