package com.bawei.lss_rk1205;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.lss_rk1205.bean.Data;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by love_mysunshine on 2017/12/5.
 */

public class Myadapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder>{
    Context context;
    private List<Data.NewslistBean> listrv=new ArrayList<>();

    public Myadapter(Context context, List<Data.NewslistBean> listrv) {
        this.context = context;
        this.listrv = listrv;
    }

    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.item,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(XRecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder)holder).sdv.setImageURI(listrv.get(position).getPicUrl());
        ((MyViewHolder)holder).tv.setText(listrv.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return listrv!=null?listrv.size():0;
    }
    class MyViewHolder extends XRecyclerView.ViewHolder{
        SimpleDraweeView sdv;
        TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            sdv=itemView.findViewById(R.id.tu);
            tv=itemView.findViewById(R.id.tv);
        }
    }
}
