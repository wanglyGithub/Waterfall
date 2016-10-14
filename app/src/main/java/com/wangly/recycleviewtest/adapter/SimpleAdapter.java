package com.wangly.recycleviewtest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wangly.recycleviewtest.R;

import java.util.List;

/**
 * Created by wangly on 2016/10/13.
 */

public class SimpleAdapter extends RecyclerView.Adapter<MyViewHodler>{
    private Context mContext;
    private List<String> mDatas;
    private LayoutInflater inflater;


    public SimpleAdapter(Context context, List<String> data) {
        this.mContext = context;
        this.mDatas = data;
    }

    @Override
    public MyViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.from(mContext).inflate(R.layout.list_item,null);
        MyViewHodler viewHodler = new MyViewHodler(view);
        return viewHodler;
    }

    @Override
    public void onBindViewHolder(MyViewHodler holder, int position) {
        holder.tv_info.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}

class MyViewHodler extends RecyclerView.ViewHolder{
    TextView tv_info;
    public MyViewHodler(View itemView) {
        super(itemView);

        tv_info = (TextView) itemView.findViewById(R.id.tv_item);
    }
}
