package com.ctaken.gank4u.base;

import android.os.Bundle;
import android.view.View;

/**
 * Created by chentaikang on 2017/1/16 15:25.
 */
//懒加载
public abstract class LazyFragment extends BaseFragment{

    protected boolean isCreated;//是否创建
    protected boolean isInited;//是否初始化过
    protected boolean needInit;//是否需要初始化


    /**
     * 在onCreateView()之前执行
     * 判断当前Fragment是否显示
     * @param isVisibleToUser true 显示 false 不显示
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if(isVisibleToUser && !isInited){
            if(isCreated){
                init();
            }else {
                needInit = true;
            }
        }
    }
    @Override
    protected void onInitView(View view, Bundle savedInstanceState) {
        if(needInit){
            init();
        }
        isCreated = true;
    }
    private void init() {
        onInitView(mRootView);
        isInited = true;
    }

    protected abstract void onInitView(View v);
}


