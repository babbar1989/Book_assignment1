package com.babbar.bookassignment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static int colsize=2,rowsize=1;

    Button btnrow,btncol;
    private List<String> user;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=new ArrayList<>();
        recyclerView=findViewById(R.id.rv_row);

        for(int i=0;i<10;i++)
        {
            user.add("abhishek"+(rowsize++));
        }

        btncol=findViewById(R.id.btncol);
        btnrow=findViewById(R.id.btnrow);


        set_row_adapter(user);

        btnrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                user.add("new tupple"+rowsize++);
                column_adapter.coltop=0;
                set_row_adapter(user);
            }
        });
        btncol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colsize+=1;
                column_adapter.coltop=0;
                List<String> temp=new ArrayList<>();
                set_row_adapter(user);
            }
        });



    }

    public void set_row_adapter(List<String> user)
    {

        pair p=new pair(colsize,user);
        row_adapter row_adapter=new row_adapter(p);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(row_adapter);
        row_adapter.notifyDataSetChanged();

    }

    public  class  pair{
        int colsize;
        List<String> user;
        pair(int c,List<String> user)
        {
            this.colsize=c;
            this.user=user;
        }
    }
}