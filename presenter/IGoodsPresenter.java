package com.bawei.lss_rk1205.presenter;

import com.bawei.lss_rk1205.view.IMainActivity;

/**
 * Created by love_mysunshine on 2017/12/5.
 */

public interface IGoodsPresenter<T extends IMainActivity> {
    public void attach(T view);
    public void detach();
}
