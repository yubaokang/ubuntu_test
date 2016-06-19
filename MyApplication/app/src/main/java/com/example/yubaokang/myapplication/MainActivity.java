package com.example.yubaokang.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chanven.lib.cptr.PtrClassicFrameLayout;
import com.chanven.lib.cptr.PtrDefaultHandler;
import com.chanven.lib.cptr.PtrFrameLayout;
import com.chanven.lib.cptr.loadmore.OnLoadMoreListener;
import com.chanven.lib.cptr.recyclerview.RecyclerAdapterWithHF;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    PtrClassicFrameLayout test_list_view_frame;
    Handler handler = new Handler();
    RecyclerView.Adapter mainAdapter;
    RecyclerView recyclerView;
    RecyclerAdapterWithHF mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test_list_view_frame = (PtrClassicFrameLayout) findViewById(R.id.test_list_view_frame);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        LinearLayoutManager lin = new LinearLayoutManager(this);
//        lin.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(lin);
        initData();
    }

    private void initData() {
        final List<String> lists = new ArrayList<>();
        mainAdapter = new MainAdapter(this, R.layout.item, lists);
        mAdapter = new RecyclerAdapterWithHF(mainAdapter);
        recyclerView.setAdapter(mainAdapter);
//        test_list_view_frame.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                test_list_view_frame.autoRefresh(true);
//            }
//        }, 150);
        test_list_view_frame.setPtrHandler(new PtrDefaultHandler() {

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 30; i++) {
                            lists.add("刷新加载" + i);
                        }
                        mainAdapter.notifyDataSetChanged();
                        test_list_view_frame.refreshComplete();
                        test_list_view_frame.setLoadMoreEnable(true);
                    }
                }, 1000);
            }
        });

        test_list_view_frame.setOnLoadMoreListener(new OnLoadMoreListener() {

            @Override
            public void loadMore() {
                handler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        for (int i = 0; i < 20; i++) {
                            lists.add("新加的");
                        }
                        mainAdapter.notifyDataSetChanged();
                        test_list_view_frame.loadMoreComplete(true);
                    }
                }, 1000);
            }
        });
    }
}
