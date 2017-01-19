package com.jackie.baigu.photoview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.jackie.baigu.R;

import uk.co.senab.photoview.PhotoViewAttacher;

public class SimpleSampleActivity extends Activity {

    private ImageView iv_photo;
    private PhotoViewAttacher photoViewAttacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_sample);
        iv_photo = (ImageView) findViewById(R.id.iv_photo);
        iv_photo.setImageResource(R.drawable.origin);

        //给PhotoView设置点击事件
        photoViewAttacher = new PhotoViewAttacher(iv_photo);
        photoViewAttacher.setOnPhotoTapListener(new PhotoTapListener());
    }

    class PhotoTapListener implements PhotoViewAttacher.OnPhotoTapListener {
        //在图片上的点击监听
        @Override
        public void onPhotoTap(View view, float x, float y) {
            Toast.makeText(SimpleSampleActivity.this, "你点击了图片", Toast.LENGTH_SHORT).show();
        }

        //在图片外的点击监听
        @Override
        public void onOutsidePhotoTap() {
            Toast.makeText(SimpleSampleActivity.this, "你点击了图片的外面", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //最后需要清除
        photoViewAttacher.cleanup();
    }
}
