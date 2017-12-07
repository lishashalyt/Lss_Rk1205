package com.bawei.lss_rk1205.presenter;

import com.bawei.lss_rk1205.bean.Data;
import com.bawei.lss_rk1205.model.GoodsModel;
import com.bawei.lss_rk1205.view.IMainActivity;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

import rx.Observer;

/**
 * Created by love_mysunshine on 2017/12/5.
 */

public class GoodsPresenter implements IGoodsPresenter{
GoodsModel goodsModel;
IMainActivity iMainActivity;
List<Data.NewslistBean> listrv=new ArrayList<>();
    SoftReference<IMainActivity> softView;
    public GoodsPresenter(IMainActivity view) {
        attach(view);
        goodsModel=new GoodsModel();
    }
    public void getDtData(){
        int num= softView.get().getNum();
        goodsModel.getData(num,new Observer<Data>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Data data) {
                listrv.addAll(data.getNewslist());
                softView.get().showData(listrv);

            }


        });
    }
    @Override
    public void attach(IMainActivity view) {
        softView=new SoftReference<IMainActivity>(view);
    }

    @Override
    public void detach() {
        softView.clear();
    }
}
