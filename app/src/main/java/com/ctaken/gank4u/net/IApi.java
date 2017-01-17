package com.ctaken.gank4u.net;

import com.ctaken.gank4u.ui.classify.ClassifyBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by chentaikang on 2017/1/16 12:39.
 */

public interface IApi {
    @GET("data/{type}/{size}/{page}")
    Call<BaseResult<List<ClassifyBean>>> listAll(
            @Path("type") String type,
            @Path("size") int size,
            @Path("page") int page
    );

    @GET("data/{type}/{size}/{page}")
    Observable<BaseResult<List<ClassifyBean>>> listAllRx(
            @Path("type") String type,
            @Path("size") int size,
            @Path("page") int page
    );

    @FormUrlEncoded
    @POST("add2gank")
    Call<BaseResult> push2Gank(@Field("url") String url,
                               @Field("desc")String desc,
                               @Field("type") String type,
                               @Field("debug") boolean isDebug
                               );
}
