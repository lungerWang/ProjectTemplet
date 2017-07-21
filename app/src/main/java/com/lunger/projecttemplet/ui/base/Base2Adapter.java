package com.lunger.projecttemplet.ui.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Lunger on 2017/3/31.
 * ListView 适配器的封装
 */

public abstract class Base2Adapter<T> extends android.widget.BaseAdapter {
    protected LayoutInflater mInflater;
    protected Context mContext;
    protected List<T> mList;
    protected final int mItemLayoutId;

    public Base2Adapter(Context context, List<T> data, int itemLayoutId) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(this.mContext);
        this.mList = data;
        this.mItemLayoutId = itemLayoutId;
    }

    public int getCount() {
        return this.mList.size();
    }

    public T getItem(int position) {
        return this.mList.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = this.getViewHolder(position, convertView, parent);
        this.convert(viewHolder, this.getItem(position), position);
        return viewHolder.getConvertView();
    }

    public abstract void convert(ViewHolder holder, T item, int position);

    private ViewHolder getViewHolder(int position, View convertView, ViewGroup parent) {
        return ViewHolder.get(this.mContext, convertView, parent, this.mItemLayoutId, position, new ViewHolder.OnCreateConvertViewListener() {
            @Override
            public void onCreateConvertView(View convertView) {
                Base2Adapter.this.onCreateConvertView(convertView);
            }
        });
    }

    /**
     * ConvetView创建的时候的回调，有需要就复写
     * @param convertView
     */
    public void onCreateConvertView(View convertView){

    }
}
