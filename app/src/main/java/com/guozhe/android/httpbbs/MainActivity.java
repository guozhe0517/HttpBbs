package com.guozhe.android.httpbbs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity implements DataLoader.CallBack{
    RecyclerView listView;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (RecyclerView)findViewById(R.id.listView);

        DataLoader loader = new DataLoader();
        loader.getData("http://192.168.10.247:8080/json/list", this);
        adapter = new CustomAdapter();
        listView.setAdapter(adapter);
        listView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void setData(List<Bbs> list) {
        Log.e("Main","여긴가");
        adapter.setList(list);
        adapter.notifyDataSetChanged();
    }
}