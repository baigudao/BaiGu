package com.jackie.baigu.springindicator;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jackie.baigu.R;

/**
 * Created by jackie on 2017/1/22 0:49.
 * QQ : 971060378
 * Used as : xxx
 */
public class SpringIndicatorMainActivity extends Activity {

    private ViewPager viewPager;
    private int[] imageIds = {R.drawable.amier, R.drawable.trim, R.drawable.bruce01, R.drawable.bruce02
            , R.drawable.jackiechan};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_springindicator_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        initData();
    }

    private void initData() {
        //准备数据
        viewPager.setAdapter(new MySpringIndicatorAdapter());
    }

    private class MySpringIndicatorAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return imageIds.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //通过位置得到某个位置的图片资源id
            int imageId = imageIds[position];
            View view = View.inflate(SpringIndicatorMainActivity.this,R.layout.item_spring_indicator,null);
            ImageView imageView = (ImageView) view.findViewById(R.id.iv);
            imageView.setBackgroundResource(imageId);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
