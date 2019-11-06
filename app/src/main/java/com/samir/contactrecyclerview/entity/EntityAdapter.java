package com.samir.contactrecyclerview.entity;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.samir.contactrecyclerview.R;

import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;



public class EntityAdapter extends RecyclerView.Adapter<EntityAdapter.DetailsViewHolder> {
    Context context;
    List<Entity> entityList;

    public EntityAdapter(Context context, List<Entity> entityList) {
        this.context = context;
        this.entityList = entityList;
    }

    @NonNull
    @Override
    public DetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_details, parent, false);
        return new DetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsViewHolder holder, int position) {
        final Entity entity = entityList.get(position);
        holder.imgCircle.setImageResource(entity.getImageId());
        holder.txvName.setText(entity.getName());
        holder.txvAge.setText(entity.getAge());
        holder.txvGender.setText(entity.getGender());
        holder.imgDelete.setImageResource(entity.getDeleteId());
    }

    @Override
    public int getItemCount() {
        return entityList.size();
    }

    public class DetailsViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imgCircle;
        TextView txvName, txvAge, txvGender;
        ImageView imgDelete;

        public DetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCircle = itemView.findViewById(R.id.imgCircle);
            txvName = itemView.findViewById(R.id.txtName);
            txvAge = itemView.findViewById(R.id.txtAge);
            txvGender = itemView.findViewById(R.id.txtGender);
            imgDelete = itemView.findViewById(R.id.imgDelete);
        }
    }
}
