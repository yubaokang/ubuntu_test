package com.example.yubaokang.myapplication;

import android.content.Context;

import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.recyclerview.CommonAdapter;

import java.util.List;

/**
 * Created by yubaokang on 16-6-18.
 */
public class MainAdapter extends CommonAdapter<String> {

    public MainAdapter(Context context, int layoutId, List<String> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void convert(ViewHolder holder, String s) {
        holder.setText(R.id.textView, s);
    }
}
