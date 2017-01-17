package com.ctaken.gank4u.net;

import android.content.Context;

import com.ctaken.gank4u.dialog.LoadingDialog;

import rx.Subscriber;


/**
 * Created by chentaikang on 2017/1/17 11:56.
 */

public abstract class MySubscribe<T> extends Subscriber<T> {

    public MySubscribe(Context context) {
        this.context = context;
    }
    private Context context;
    private LoadingDialog dialog;

    @Override
    public void onStart() {
        super.onStart();
        dialog = new LoadingDialog(context);
        dialog.show();
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        //统一处理异常
        if(e instanceof ExceptionHandle.ResponseThrowable){
            //回调给Activity
            onError((ExceptionHandle.ResponseThrowable)e);
        }else {
            onError(new ExceptionHandle.ResponseThrowable(e,ExceptionHandle.ERROR.UNKNOWN));
        }
    }

    @Override
    public void onNext(T t) {
        dialog.dismiss();
    }
    //出现错误直接调用 自定义的onError
    public abstract void onError(ExceptionHandle.ResponseThrowable e);
}
