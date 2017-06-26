package com.guozhe.android.httpbbs;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guozhe on 2017. 6. 26..
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.Holder>{
    List<Bbs> list;

    public CustomAdapter(){
        list = new ArrayList<>();
    }

    public void setList(List<Bbs> list){
        Log.e("Adapter","여긴가");
        this.list = list;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Bbs bbs = list.get(position);
        holder.title.setText(bbs.title);
        holder.author.setText(bbs.author);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        TextView title;
        TextView author;
        public Holder(View itemView) {
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.title);
            author = (TextView)itemView.findViewById(R.id.author);
        }
    }
}