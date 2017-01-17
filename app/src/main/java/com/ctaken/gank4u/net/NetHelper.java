package com.ctaken.gank4u.net;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by chentaikang on 2017/1/17 19:56.
 */

public class NetHelper {
    public static Observable.Transformer schedulersTransformer() {
        return new Observable.Transformer() {
            @Override
            public Object call(Object observable) {
                return ((Observable) observable)
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <T> Observable.Transformer transformer() {
        return new Observable.Transformer() {
            @Override
            public Object call(Object observable) {
                return ((Observable) observable)
                        .map(new HandlerFuc<T>())//数据类型转换,取出真正的业务数据
                        .onErrorResumeNext(new HttpResopnseFunc<T>());//处理异常
            }
        };
    }

    private static class HttpResopnseFunc<T> implements Func1<Throwable,Observable<T>> {

        @Override
        public Observable<T> call(Throwable t) {
            //发送错误的Observable
            return Observable.error(ExceptionHandle.handleException(t));
        }
    }
    private static class HandlerFuc<T> implements Func1<BaseResult<T>, T> {
        @Override
        public T call(BaseResult<T> response) {
            //当前业务操作是否成功
            if (response.isError())
                throw new RuntimeException(response.getMsg());//抛出异常
                return response.getResults();

        }
    }

}
