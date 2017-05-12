package com.example.administrator.dukailin0417;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rl;
    private Button quan;
    private Button fan;
   private List<Bean> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rl = (RecyclerView) findViewById(R.id.rl);
        quan = (Button) findViewById(R.id.quan);
        fan = (Button) findViewById(R.id.fan);
        ListView lv= (ListView) findViewById(R.id.lv);
        for (int i=0;i<20;i++){
            Bean bean=new Bean("条目"+i,false);
            list.add(bean);
        }
        LinearLayoutManager mLinear=new LinearLayoutManager(this);
        rl.setLayoutManager(mLinear);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        rl.setHasFixedSize(true);
        mLinear.setOrientation(LinearLayoutManager.HORIZONTAL);
          RlPagePter Rpage=new RlPagePter(this);
        Rpage.setList(list);
        rl.setAdapter(Rpage);
        final LvpagePter Lpage=new LvpagePter(this);
        Lpage.setList(list);
        lv.setAdapter(Lpage);

        quan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<list.size();i++){
                    list.get(i).setIschend(true);
                }
                Lpage.notifyDataSetChanged();

            }
        });
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i=0;i<list.size();i++){
                    list.get(i).setIschend(false);
                }
                Lpage.notifyDataSetChanged();
            }
        });

        Lpage.setOnItemClickListener(new LvpagePter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, ""+position, Toast.LENGTH_SHORT).show();
            }
        });
       Lpage.setOnItemLongClickListener(new LvpagePter.OnItemLongClickListener() {
            @Override
            public void onItemLongClick(View view, final int position) {
                //Toast.makeText(MainActivity.this, "这是长安时间", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder customizeDialog =
                        new AlertDialog.Builder(MainActivity.this);
                final View dialogView = LayoutInflater.from(MainActivity.this)
                        .inflate(R.layout.item3,null);
                customizeDialog.setTitle("我是一个自定义Dialog");
                customizeDialog.setView(dialogView);
                customizeDialog.setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 获取EditView中的输入内容
                                TextView edit_text =
                                        (TextView) dialogView.findViewById(R.id.tvi);
                                edit_text.setText(""+position);

                            }
                        });
                customizeDialog.show();



            }
        });
      /*  lv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {


                return true;
            }
        });*/







    }



}
