package com.wangly.recycleviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.wangly.recycleviewtest.adapter.StaggeredAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycleView;
    private List<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initView() {
        recycleView = (RecyclerView) findViewById(R.id.recycleView);
        StaggeredAdapter adapter = new StaggeredAdapter(this, mDatas);
        recycleView.setAdapter(adapter);

        //设置布局管理
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recycleView.setLayoutManager(staggeredGridLayoutManager);

        //设置item之间的间隔  只做参考网上连接！
//        SpacesItemDecoration decoration = new SpacesItemDecoration(16);
//        recycleView.addItemDecoration(decoration);
    }

    private void initData() {
        mDatas = new ArrayList<>();
        for (int i = 'A'; i < 'Z'; i++) {
            mDatas.add("" + (char) i);
        }
    }

}
