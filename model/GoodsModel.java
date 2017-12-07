package com.bawei.lss_rk1205.model;

import com.bawei.lss_rk1205.LoggingInterceptor;
import com.bawei.lss_rk1205.Url;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by love_mysunshine on 2017/12/5.
 */

public class GoodsModel implements IGoodsModel{
    @Override
    public void getData(int num,Observer observer) {
        OkHttpClient client = new OkHttpClient.Builder()
                .addNetworkInterceptor(new LoggingInterceptor())
                .build();
        Retrofit retrofit=new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.tianapi.com/")
                .client(client)
                .build();
        Url userUrl=retrofit.create(Url.class);
        userUrl.getCall(num).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(observer);
    }
}
