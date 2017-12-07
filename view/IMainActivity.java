package com.bawei.lss_rk1205.view;

import com.bawei.lss_rk1205.bean.Data;

import java.util.List;

/**
 * Created by love_mysunshine on 2017/12/5.
 */

public interface IMainActivity {
    public void showData(List<Data.NewslistBean> listrv);
    public int getNum();
}
