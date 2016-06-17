package com.example.yubaokang.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public abstract class CommAdapter<T> extends BaseAdapter {
    protected List<T> mDatas;
    protected LayoutInflater inflater;
    protected Context context;
    private int layoutId;

    public CommAdapter(Context context, List<T> mDatas, int layoutId) {
        this.context = context;
        this.mDatas = mDatas;
        this.layoutId = layoutId;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if (mDatas == null || mDatas.size() == 0) {
            return 0;
        }
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.get(context, convertView, position, layoutId, parent);
        convert(holder, getItem(position));
        return holder.getConvertView();
    }

    public abstract void convert(ViewHolder holder, T t);

    public String getString(int resId) {
        return context.getString(resId);
    }
}
