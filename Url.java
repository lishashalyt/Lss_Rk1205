package com.bawei.lss_rk1205;

import com.bawei.lss_rk1205.bean.Data;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by love_mysunshine on 2017/12/5.
 */

public interface Url {
    @GET("nba/?key=71e58b5b2f930eaf1f937407acde08fe&num=10")
    Observable<Data> getCall(@Query("num") int num);
}
