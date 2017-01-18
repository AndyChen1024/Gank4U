package com.ctaken.gank4u.ui.classify;

import android.content.Context;

import com.ctaken.gank4u.net.NetResponse;

import java.util.List;

/**
 * Created by chentaikang on 2017/1/18 21:40.
 * <p>
 * MVP presenter 接口实现
 */

public class ClassifyPresenterImpl implements ClassifyContent.IClassifyPresenter {


    private Context context;
    private ClassifyContent.IClassifyView view;
    private ClassifyContent.IClassifyModel model;


    private String type;
    private int page;

    public ClassifyPresenterImpl(Context context, ClassifyContent.IClassifyView view, String type, ClassifyContent.IClassifyModel model) {
        this.context = context;
        this.view = view;
        this.type = type;
        this.model = model;
    }

    //下拉刷新
    @Override
    public void refresh() {
        page = 1;
        model.loadData(context, type, page, new NetResponse() {
            @Override
            public void onResponse(Object data) {
                List<ClassifyBean> list = (List<ClassifyBean>) data;
                view.onRefresh(list);
                view.loadFinish();
            }

            @Override
            public void onError(String msg) {
                view.loadError(msg);
            }
        });
    }

    //上拉加载
    @Override
    public void add() {
        page++;
        model.loadData(context, type, page, new NetResponse() {
            @Override
            public void onResponse(Object data) {
                List<ClassifyBean> list = (List<ClassifyBean>) data;
                view.onAdd(list);
                view.loadFinish();
            }

            @Override
            public void onError(String msg) {

            }
        });
    }
}
