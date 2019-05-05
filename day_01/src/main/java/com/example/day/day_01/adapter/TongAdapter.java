package com.example.day.day_01.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.day.day_01.R;
import com.example.day.day_01.bean.Bean;
import com.example.day.day_01.callback.TochCallBack;

import java.util.ArrayList;
import java.util.Collections;

public class TongAdapter extends RecyclerView.Adapter<TongAdapter.ViewHolder> implements TochCallBack{
    private ArrayList<Bean> list;
    private Context context;

    public TongAdapter(ArrayList<Bean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public TongAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.tong_item,null));
    }

    @Override
    public void onBindViewHolder(@NonNull TongAdapter.ViewHolder viewHolder, int i) {
        Bean bean = list.get(i);
        viewHolder.name.setText(bean.getName());
        viewHolder.data.setText(bean.getDate());
        viewHolder.show.setText(bean.getShow());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onItemMove(int promPosition, int toPosition) {
        //减缓集合中两个数据的位置
        Collections.swap(list,promPosition,toPosition);

        //刷新界面 局部刷新 索引会混乱
        notifyItemMoved(promPosition,toPosition);
    }

    @Override
    public void onItemDelete(int position) {
        list.remove(position);
        //局部刷新  索引会混乱 + 越界
        notifyItemRemoved(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView data;
        private TextView show;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            data = itemView.findViewById(R.id.data);
            show = itemView.findViewById(R.id.show);
        }
    }


}
