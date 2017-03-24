package com.example.ywb.scrrowviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

/*
* 上滑时顶部控件被挤出隐藏，中间的控件悬浮在顶部，底部的RecyclerView可以点击item
* */
public class MainActivity extends AppCompatActivity implements MyScrollView.OnScrollListener {
    private EditText search_edit;
    private MyScrollView myScrollView;
    private int searchLayoutTop;
    private RecyclerView rvd;
    List<String> list = new ArrayList<>();

    LinearLayout search01, search02;
    RelativeLayout rlayout;
    private int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化控件
        init();
        initData();
        rvd = (RecyclerView) findViewById(R.id.rvd);
        MyAdapter myAdapter = new MyAdapter(MainActivity.this, list);
        rvd.setAdapter(myAdapter);
        //正常的写法，RecycleView可以滚动
        //rvd.setLayoutManager(new LinearLayoutManager(this));

        //自定义CustomLinearLayoutManager
        CustomLinearLayoutManager manager = new CustomLinearLayoutManager(MainActivity.this);
        //设置RecycleView不可滚动
        manager.setScrollEnabled(false);
        rvd.setLayoutManager(manager);
    }

    private void init() {
        search_edit = (EditText) findViewById(R.id.search_edit);
        myScrollView = (MyScrollView) findViewById(R.id.myScrollView);
        rvd = (RecyclerView) findViewById(R.id.rvd);
        search01 = (LinearLayout) findViewById(R.id.search01);
        search02 = (LinearLayout) findViewById(R.id.search02);
        rlayout = (RelativeLayout) findViewById(R.id.rlayout);
        myScrollView.setOnScrollListener(this);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            searchLayoutTop = rlayout.getBottom();//获取searchLayout的顶部位置
        }
    }

    //监听滚动Y值变化，通过addView和removeView来实现悬停效果
    @Override
    public void onScroll(int scrollY) {
        if (scrollY >= searchLayoutTop) {
            if (search_edit.getParent() != search01) {
                search02.removeView(search_edit);
                search01.addView(search_edit);
            }
        } else {
            if (search_edit.getParent() != search02) {
                search01.removeView(search_edit);
                search02.addView(search_edit);
            }
        }
    }

    public void initData() {
        list.add("RecyclerView 向下滑");
        list.add("RecyclerView 向下滑");
        list.add("RecyclerView 向下滑");
        list.add("RecyclerView 向下滑");
        list.add("RecyclerView 向下滑");
        list.add("RecyclerView 向下滑");
        list.add("RecyclerView 向下滑");
        list.add("RecyclerView 向下滑");
        list.add("RecyclerView 向下滑");
        list.add("RecyclerView 向下滑");
        list.add("RecyclerView 向下滑");
        list.add("RecyclerView 向下滑");
        list.add("RecyclerView 向下滑");
        list.add("RecyclerView 向下滑");
        list.add("RecyclerView 向下滑");
        list.add("RecyclerView 向下滑");
        list.add("RecyclerView 向下滑");
        list.add("RecyclerView 向下滑");
        list.add("RecyclerView 向下滑");

    }


}
