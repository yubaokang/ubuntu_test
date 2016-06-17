package com.example.yubaokang.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.chanven.lib.cptr.PtrClassicFrameLayout;
import com.example.yubaokang.myapplication.adapter.CommAdapter;
import com.example.yubaokang.myapplication.adapter.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private PtrClassicFrameLayout test_list_view_frame;
    private ListView test_list_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test_list_view_frame = (PtrClassicFrameLayout) findViewById(R.id.test_list_view_frame);
        test_list_view = (ListView) findViewById(R.id.test_list_view);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add("哈哈哈" + i);
        }
        test_list_view.setAdapter(new CommAdapter<String>(this, list, R.layout.item) {
            @Override
            public void convert(ViewHolder holder, String s) {
                holder.setText(R.id.textView, s);
            }
        });
    }
}
