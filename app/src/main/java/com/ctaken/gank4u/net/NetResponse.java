package com.ctaken.gank4u.net;

/**
 * Created by chentaikang on 2017/1/18 22:23.
 */

public interface NetResponse {

    void onResponse(Object data);
    void onError(String msg);
}
