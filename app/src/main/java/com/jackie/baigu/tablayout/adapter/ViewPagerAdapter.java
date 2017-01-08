package com.jackie.baigu.tablayout.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jackie.baigu.tablayout.fragment.MyFragment;

import java.util.ArrayList;

/**
 * 作用：xxxx
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final ArrayList<MyFragment> fragments;

    public ViewPagerAdapter(FragmentManager fm, ArrayList<MyFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    /**
     * 根据位置返回对应的Fragment
     *
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    /**
     * 得到页面的标题
     *
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getTitle();
    }
}
