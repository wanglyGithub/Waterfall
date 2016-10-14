package com.wangly.recycleviewtest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.wangly.recycleviewtest.Constants;
import com.wangly.recycleviewtest.R;

import java.util.List;

/**
 * Created by wangly on 2016/10/13.
 */

public class StaggeredAdapter extends RecyclerView.Adapter<StaggeredAdapter.MyViewHodler> {
    private Context mContext;
    private List<String> mDatas;
    private LayoutInflater inflater;

    private final DisplayImageOptions options;

    public StaggeredAdapter(Context context, List<String> data) {
        this.mContext = context;
        this.mDatas = data;

        options = new DisplayImageOptions.Builder()
                .showStubImage(R.drawable.empty_photo)          // 设置图片下载期间显示的图片
                .showImageForEmptyUri(R.drawable.empty_photo)  // 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.drawable.empty_photo)       // 设置图片加载或解码过程中发生错误显示的图片
                .cacheInMemory(true)                        // 设置下载的图片是否缓存在内存中
                .cacheOnDisc(true)                          // 设置下载的图片是否缓存在SD卡中
                //            .displayer(new RoundedBitmapDisplayer(20))  // 设置成圆角图片
                .build();


    }

    @Override
    public StaggeredAdapter.MyViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.from(mContext).inflate(R.layout.list_item, null);
        MyViewHodler viewHodler = new MyViewHodler(view);
        return viewHodler;
    }

    @Override
    public void onBindViewHolder(StaggeredAdapter.MyViewHodler holder, int position) {
        holder.tv_info.setText(mDatas.get(position));
        ImageLoader.getInstance().displayImage(Constants.images[position], holder.iv_pic, options); //

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class MyViewHodler extends RecyclerView.ViewHolder {
        TextView tv_info;
        ImageView iv_pic;

        public MyViewHodler(View itemView) {
            super(itemView);
            tv_info = (TextView) itemView.findViewById(R.id.tv_item);
            iv_pic = (ImageView) itemView.findViewById(R.id.iv_item_imag);

        }
    }
}


