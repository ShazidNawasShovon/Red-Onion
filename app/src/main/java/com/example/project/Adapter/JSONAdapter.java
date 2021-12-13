package com.example.project.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.Domain.JSONDomain;
import com.example.project.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class JSONAdapter extends RecyclerView.Adapter<JSONAdapter.ViewHolder> {

    LayoutInflater inflater;

    List<JSONDomain> jsonDomains;
    public JSONAdapter(Context ctx, List<JSONDomain> jsonDomains){
        this.inflater=LayoutInflater.from(ctx);
        this.jsonDomains=jsonDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.custom_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        bind the data
        holder.clientTitle.setText(jsonDomains.get(position).getTitle());
        holder.clientDetails.setText(jsonDomains.get(position).getDetails());
        Picasso.get().load(jsonDomains.get(position).getCoverImage()).into(holder.clientCoverImage);

    }

    @Override
    public int getItemCount() {
        return jsonDomains.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView clientTitle,clientDetails;
        ImageView clientCoverImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
             clientTitle=itemView.findViewById(R.id.clientTitle);
             clientDetails=itemView.findViewById(R.id.details);
             clientCoverImage=itemView.findViewById(R.id.coverImage);
        }
    }
}
