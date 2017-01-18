package com.ctaken.gank4u.ui.classify;

import android.content.Context;

import com.ctaken.gank4u.net.NetResponse;

import java.util.List;

/**
 * Created by chentaikang on 2017/1/18 22:05.
 *
 * MVP各种接口
 */

public class ClassifyContent {

    public interface IClassifyView{
        void onRefresh(List<ClassifyBean> data);//下拉刷新
        void onAdd(List<ClassifyBean> data);//上拉加载
        void loadFinish();
        void loadError(String msg);

    }

    public interface IClassifyPresenter{
        void refresh();
        void add();
    }

    public interface IClassifyModel{
        void loadData(Context context,String type,int page,NetResponse callback);
    }
}
