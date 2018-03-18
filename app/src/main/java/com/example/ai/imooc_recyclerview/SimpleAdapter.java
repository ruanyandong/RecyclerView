package com.example.ai.imooc_recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by AI on 2018/3/17.
 */

public class SimpleAdapter extends RecyclerView.Adapter<MyViewHolder>{

    private LayoutInflater mInflater;

    private Context mContext;

    protected List<String> mDatas;


    public interface OnItemClickListener{

        void onItemClick(View view,int position);
        void onItemLongClick(View view,int position);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public SimpleAdapter(Context context, List<String > list) {

        this.mContext=context;
        this.mDatas=list;

        mInflater=LayoutInflater.from(context);
    }


    /**
     * 创建ViewHolder
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=mInflater.inflate(R.layout.item_simple,parent,false);

        MyViewHolder myViewHolder=new MyViewHolder(view);


        return myViewHolder;
    }

    /**
     * 绑定ViewHolder
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.tv.setText(mDatas.get(position));

        setUpItemEvent(holder);
    }


    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    protected void setUpItemEvent(final MyViewHolder holder){
        /**
         * 设置点击监听
         */
        /**
         * 也就是当外部调用了 setmOnItemClickListener方法，
         * 给mOnItemClickListener设置了一个实例对象
         */
        if(mOnItemClickListener!=null) {


            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /**
                     * 得到在item在布局上的位置
                     */
                    int layoutPosition = holder.getLayoutPosition();

                    mOnItemClickListener.onItemClick(holder.itemView, layoutPosition);
                }
            });

            /**
             * 当返回true时，表示已经完整地处理了这个事件，并不希望其他的回调方法再次进行处理；
             * 当返回false时，表示并没有完全处理完该事件，更希望其他方法继续对其进行处理
             * 返回true，执行完 onLongClick 方法就停止了
             * 返回false，执行完 onLongClick 方法 还会执行onClick方法
             */
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    /**
                     * 得到在item在布局上的位置
                     */
                    int layoutPosition = holder.getLayoutPosition();

                    mOnItemClickListener.onItemLongClick(holder.itemView, layoutPosition);
                    return true;
                }
            });
        }
    }


    public void addData(int postion){

        mDatas.add(postion,"Insert one");

        /**
         * 不是 notifyDataSetChanged(); 注意区分
         */

        notifyItemInserted(postion);

        /**
         * 如果写成：
         mDatas.add("Insert one");
         notifyDataSetChanged();
         则会在list的最后把Insert one插进去
         */
    }


    public void deleteData(int position){
        mDatas.remove(position);

        notifyItemRemoved(position);

    }


}

class MyViewHolder extends RecyclerView.ViewHolder{

    TextView tv;
    public MyViewHolder(View itemView) {
        super(itemView);

        tv=itemView.findViewById(R.id.id_textView);
    }

}

