package com.ctaken.gank4u.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by chentaikang on 2017/1/16 20:56.
 */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    /**
     * 填充数据 将Bean中的数据设置到View上
     * @param data
     */
    public abstract void fillData(T data);
}
