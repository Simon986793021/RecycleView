package com.wind.recycleview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zhangcong on 2017/7/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements View.OnClickListener {
    private String [] data;
    public MyAdapter(String[] data)
    {
        this.data=data;
    }
    private OnItemClickListener onItemClickListener=null;
    public  interface OnItemClickListener{
        void onItemClick(View view,int position);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_item,parent,false);
         MyViewHolder viewHolder=new MyViewHolder(view);
        view.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // 绑定数据
        holder.textView.setText(data [position]);
        holder.itemView.setTag(position);
    }



    @Override
    public int getItemCount() {
        Log.i(">>>>>>",data.length+"");
        return data == null ? 0 : data.length;

    }


    @Override
    public void onClick(View v) {
        if (onItemClickListener!=null)
        {
            //通过gettag获取点击位置
            onItemClickListener.onItemClick(v, (int) v.getTag());
        }
    }
    public void setOnItemClickListener(OnItemClickListener listener)
    {
        this.onItemClickListener=  listener;
    }
      public static  class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView textView;
        public MyViewHolder(View view)
        {
            super(view);
            textView= (TextView) view.findViewById(R.id.tv_city);
        }
    }
}
