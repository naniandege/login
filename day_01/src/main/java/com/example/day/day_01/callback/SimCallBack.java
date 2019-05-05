package com.example.day.day_01.callback;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public class SimCallBack extends ItemTouchHelper.Callback {
    private TochCallBack tochCallBack;
    public SimCallBack(TochCallBack callBack){
        this.tochCallBack = callBack;
    }
    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        //允许上下拖拽
        int drag = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        //允许左右滑动
        int swipe = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        //设置
        return makeMovementFlags(drag,swipe);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
        //通知适配器两个子条目位置发生改变
        tochCallBack.onItemMove(viewHolder.getAdapterPosition(),viewHolder1.getAdapterPosition());
        return true;
    }

    //当用户左右滑动item时达到删除条件就会调用
    //一般为一半 条目继续滑动删除 否则弹回
    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        tochCallBack.onItemDelete(viewHolder.getAdapterPosition());
    }


    //支持长按拖到  默认是true
    @Override
    public boolean isLongPressDragEnabled() {
        return super.isLongPressDragEnabled();
    }

    //是否支持滑动
    @Override
    public boolean isItemViewSwipeEnabled() {
        return super.isItemViewSwipeEnabled();
    }
}
