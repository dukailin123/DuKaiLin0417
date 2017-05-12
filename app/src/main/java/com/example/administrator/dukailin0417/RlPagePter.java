package com.example.administrator.dukailin0417;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/17 0017.
 */
public class RlPagePter extends RecyclerView.Adapter<RlPagePter.MyViewHolder>{
      private Context context;
      private List<Bean> list=new ArrayList<>();
    public RlPagePter(Context context){
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item2, null);
        MyViewHolder holder = new MyViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvhe.setText(list.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<Bean> list) {
        this.list = list;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView tvhe;

        public MyViewHolder(View itemView) {
           super(itemView);
           tvhe=  (TextView) itemView.findViewById(R.id.tvhe);
       }
   }

}

