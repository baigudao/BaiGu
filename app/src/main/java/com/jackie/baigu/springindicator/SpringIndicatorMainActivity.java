package com.jackie.baigu.springindicator;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jackie.baigu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackie on 2017/1/22 0:49.
 * QQ : 971060378
 * Used as : xxx
 */
public class SpringIndicatorMainActivity extends Activity {

    private ViewPager viewPager;
    private int[] imageIds = {R.drawable.waimai1, R.drawable.waimai2, R.drawable.waimai3, R.drawable.waimai4
            , R.drawable.waimai5};
    private List<BasePager> basePagers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initView() {
        setContentView(R.layout.activity_springindicator_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
    }

    private void initData() {
        //准备数据
        basePagers = new ArrayList<>();
        for (int i = 0; i < imageIds.length; i++) {
            BasePager basePager = new BasePager(SpringIndicatorMainActivity.this,imageIds[i]);
            basePagers.add(basePager);
        }
        viewPager.setAdapter(new MySpringIndicatorAdapter());
    }

    private class MySpringIndicatorAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return basePagers == null ? 0 : basePagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //通过位置得到某个位置的视图实例
            BasePager basePager = basePagers.get(position);
            //得到相应位置的视图
            View rootView = basePager.getRootView();
            basePager.initData();
            //通过视图找到ImageView的id
//            ImageView imageView = (ImageView) rootView.findViewById(R.id.iv);
//            imageView.setBackgroundResource(imageIds[position]);
            //将相应位置的视图添加到容器中
            container.addView(rootView);
            return rootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
