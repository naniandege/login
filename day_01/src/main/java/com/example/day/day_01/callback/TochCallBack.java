package com.example.day.day_01.callback;

public interface TochCallBack {
    //条目交换位置
    void onItemMove(int promPosition,int toPosition);

    //删除数据
    void onItemDelete(int position);
}
