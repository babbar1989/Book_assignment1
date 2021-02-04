package com.babbar.bookassignment1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class column_adapter extends RecyclerView.Adapter<column_adapter.myviewholder> {

    ArrayList<String> col;
    static  int coltop=0;

    public column_adapter(ArrayList<String> user) {
        this.col = user;
        coltop++;
    }

    public class myviewholder extends RecyclerView.ViewHolder {

        private TextView tvcol;

        public myviewholder(View view) {
            super(view);
            //tvlist=view.findViewById(R.id.textView);
            tvcol=view.findViewById(R.id.tvcol);
        }

    }

    @NonNull
    @Override
    public column_adapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_col_item, parent, false);
        return new myviewholder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull column_adapter.myviewholder holder, int position) {

        String name = col.get(position);
        if(position==0)
        {
            holder.tvcol.setText("Column"+coltop);
        }
        else
        holder.tvcol.setText(name);
    }

    @Override
    public int getItemCount() {
        return col.size();
    }
}