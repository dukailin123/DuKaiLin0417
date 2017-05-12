package com.example.administrator.dukailin0417;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/17 0017.
 */
public class LvpagePter extends BaseAdapter{
    private Context context;
    private List<Bean> list=new ArrayList<>();
    private OnItemClickListener itemClickListener;
    private OnItemLongClickListener itemLogClickListener;
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    //定义条目的长按事件
    public interface OnItemLongClickListener {
        void onItemLongClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener){
        this.itemClickListener=itemClickListener;
    }
    public void setOnItemLongClickListener(OnItemLongClickListener itemLogClickListener){
        this.itemLogClickListener=itemLogClickListener;
    }


    public LvpagePter(Context context){
        this.context=context;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View inflate = View.inflate(context, R.layout.item, null);
        TextView tvname= (TextView) inflate.findViewById(R.id.tvname);
       CheckBox ckb= (CheckBox) inflate.findViewById(R.id.ckb);
        tvname.setText(list.get(position).getName());
        ckb.setChecked(list.get(position).getIschend());
        ckb.setFocusable(false);
        inflate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemClickListener!=null){
                    itemClickListener.onItemClick(v,position);
                }
            }
        });
        inflate.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(itemLogClickListener!=null){
                    itemLogClickListener.onItemLongClick(v,position);
                }
                return true;
            }
        });
       /* tvname.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                Toast.makeText(context, "这是长安时间", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder customizeDialog =
                        new AlertDialog.Builder(context);
                final View dialogView = LayoutInflater.from(context)
                        .inflate(R.layout.item,null);
                customizeDialog.setTitle("我是一个自定义Dialog");
                customizeDialog.setView(dialogView);
                customizeDialog.setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 获取EditView中的输入内容
                                TextView edit_text =
                                        (TextView) dialogView.findViewById(R.id.tvhe);
                                edit_text.setText(""+position);

                            }
                        });
                customizeDialog.show();

                return true;
            }
        });*/

        return inflate;
    }

    public void setList(List<Bean> list) {
        this.list = list;
    }
}
