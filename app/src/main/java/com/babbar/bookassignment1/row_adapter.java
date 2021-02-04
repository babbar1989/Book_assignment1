package com.babbar.bookassignment1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class row_adapter extends RecyclerView.Adapter<row_adapter.myviewholder> {
    public  static int columntop=1;
   MainActivity.pair p;

    public  row_adapter(MainActivity.pair p)
    {
        this.p=p;
    }

    private RecyclerView.RecycledViewPool
            viewPool
            = new RecyclerView
            .RecycledViewPool();

    public class myviewholder extends RecyclerView.ViewHolder{

        TextView tvlist;
         RecyclerView ChildRecyclerView;
        public  myviewholder(View view)
        {
            super(view);
            //tvlist=view.findViewById(R.id.textView);

            ChildRecyclerView
                    = view
                    .findViewById(
                            R.id.recyclerView);
        }

    }

    @NonNull
    @Override
    public row_adapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemview= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_item,parent,false);
        return new myviewholder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull row_adapter.myviewholder holder, int position) {


       // String  name=user.get(position);
        //holder.tvlist.setText(name);
        column_adapter column_adapter=new column_adapter(new ArrayList<>(p.user));
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(holder.ChildRecyclerView.getContext());
        holder.ChildRecyclerView.setLayoutManager(layoutManager);
        holder.ChildRecyclerView.setAdapter(column_adapter);
    }

    @Override
    public int getItemCount() {
        return p.colsize;
    }
}
