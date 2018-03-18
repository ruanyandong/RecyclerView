package com.example.ai.imooc_recyclerview;

import android.Manifest;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AI on 2018/3/18.
 */

public class StaggeredAdapter extends SimpleAdapter{

    private List<Integer> mHeights;

    public StaggeredAdapter(Context context, List<String > list) {

        super(context,list);

        mHeights=new ArrayList<Integer>();

        for(int i=0;i<mDatas.size();i++){
            mHeights.add((int)(Math.random()*300+100));
        }


    }

    /**
     * 绑定ViewHolder
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ViewGroup.LayoutParams layoutParams=holder.itemView.getLayoutParams();

        layoutParams.height=mHeights.get(position);
        holder.itemView.setLayoutParams(layoutParams);

        holder.tv.setText(mDatas.get(position));

        setUpItemEvent(holder);
    }

}



