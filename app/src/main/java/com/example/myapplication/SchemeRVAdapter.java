package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SchemeRVAdapter extends RecyclerView.Adapter<SchemeRVAdapter.ViewHolder> {
    // variable for our array list and context
    private ArrayList<SchemeDetails> schemeModalArrayList;
    private Context context;

    // constructor
    public SchemeRVAdapter(ArrayList<SchemeDetails> courseModalArrayList, Context context) {
        this.schemeModalArrayList = courseModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.scheme_rv_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        SchemeDetails modal = schemeModalArrayList.get(position);
        holder.SchemeName.setText(modal.getSchemename());
        holder.SchemeNidhi.setText(modal.getSchemenidhi());
        holder.SchemeDuration.setText(modal.getDuration());

    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return schemeModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView SchemeName, SchemeNidhi, SchemeDuration;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            SchemeName = itemView.findViewById(R.id.idTVSchemeName);
            SchemeNidhi = itemView.findViewById(R.id.idTVSchemeNidhi);
            SchemeDuration = itemView.findViewById(R.id.idTVSchemeDuration);


        }
    }
}
