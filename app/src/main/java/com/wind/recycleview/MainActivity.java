package com.wind.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    List<String> list=new ArrayList<>();
    private LinearLayoutManager layoutManager;
    private Button add;
    private Button delete;
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= (RecyclerView) findViewById(R.id.rv_city);
        add= (Button) findViewById(R.id.bt_add);
        delete= (Button) findViewById(R.id.bt_delete);
        add.setOnClickListener(this);
        delete.setOnClickListener(this);
        recyclerView.addItemDecoration(new MyDividerItemDecoration(MainActivity.this));
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        adapter=new MyAdapter(getData());

        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this,list.get(position),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bt_add:
                adapter.addItem();
                layoutManager.scrollToPosition(0);
                break;
            case R.id.bt_delete:
                adapter.deleteItem();
                layoutManager.scrollToPosition(0);
                break;
            default:
                break;
        }
    }

    public List<String> getData() {
        list.add("北京");
        for (int i=0;i<6;i++)
        {
            list.add("深圳");
        }
        return list;
    }
}
