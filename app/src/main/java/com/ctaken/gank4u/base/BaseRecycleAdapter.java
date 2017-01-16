package com.ctaken.gank4u.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.util.ArrayList;

/**
 * Created by chentaikang on 2017/1/16 20:55.
 */
public abstract class BaseRecycleAdapter<T> extends RecyclerView.Adapter<BaseViewHolder>{

    protected ArrayList<T> data;
    protected LayoutInflater inflater;

    public BaseRecycleAdapter(Context context,ArrayList<T> data){
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<T> data){
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data == null?0:data.size();
    }
}
