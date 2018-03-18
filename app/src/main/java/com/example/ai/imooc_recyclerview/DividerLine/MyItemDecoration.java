package com.example.ai.imooc_recyclerview.DividerLine;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by AI on 2018/3/18.
 */

/**
 * 添加底部分割线的一种方法
 */
public class MyItemDecoration extends RecyclerView.ItemDecoration{

    /**
     *
     * @param outRect 边界
     * @param view Item子view
     * @param parent recyclerView
     * @param state 内部数据管理
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        /**
         * 设置item底部边距一厘米
         */
        outRect.set(0,0,0,1);
    }
}
