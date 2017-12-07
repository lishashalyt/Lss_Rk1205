package com.bawei.lss_rk1205;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;

import com.bawei.lss_rk1205.bean.Data;
import com.bawei.lss_rk1205.presenter.GoodsPresenter;
import com.bawei.lss_rk1205.view.IMainActivity;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainActivity {

    GoodsPresenter goodsPresenter;
    List<Data.NewslistBean> listrv;
    Myadapter myadapter;
    private XRecyclerView mRv;
   int Num=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        listrv = new ArrayList<>();
        /*实例化P,传来attach*/
        goodsPresenter = new GoodsPresenter(this);
        showData(listrv);
        goodsPresenter.getDtData();
        /*刷新 加载*/
        mRv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                Num++;
                goodsPresenter.getDtData();
                mRv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                Num++;
                goodsPresenter.getDtData();
                mRv.loadMoreComplete();
            }
        });
    }

    @Override
    public void showData(List<Data.NewslistBean> listrv) {
        GridLayoutManager manager = new GridLayoutManager(this, 1);
        mRv.setLayoutManager(manager);
        myadapter = new Myadapter(this, listrv);
        mRv.setAdapter(myadapter);

        ArrayList<String> pic = new ArrayList<>();
        for (int i = 0; i < listrv.size(); i++) {
            pic.add(listrv.get(i).getPicUrl());
        }

    }

    @Override
    public int getNum() {
        return Num;
    }

    private void initView() {

        mRv = (XRecyclerView) findViewById(R.id.rv);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        goodsPresenter.detach();
    }
}
