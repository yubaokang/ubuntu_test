package com.example.yubaokang.myapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.yubaokang.myapplication.utils.ListUtil;

import java.util.List;


/**
 * Created by hank on 2015/10/8/16:16:07
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    //结合TabLayout使用，设置标题
    private List<String> titles;

    public MyFragmentPagerAdapter(FragmentManager mFragmentManager, List<Fragment> fragments) {
        super(mFragmentManager);
        this.fragments = fragments;
    }

    public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments, List<String> titles) {
        super(fm);
        this.fragments = fragments;
        this.titles = titles;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //结合TabLayout使用，设置标题
        return ListUtil.isEmpty(titles) ? "" : titles.get(position);
    }
}