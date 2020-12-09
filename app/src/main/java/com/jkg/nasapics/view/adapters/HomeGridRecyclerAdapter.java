package com.jkg.nasapics.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jkg.nasapics.R;
import com.jkg.nasapics.databinding.GridViewRecyclerItemBinding;
import com.jkg.nasapics.interfaces.HomeGridItemClickListener;
import com.jkg.nasapics.models.ImageDetailsModel;

import java.util.List;

public class HomeGridRecyclerAdapter extends RecyclerView.Adapter<HomeGridRecyclerAdapter.GridViewHolder> {

    private Context context;
    private List<ImageDetailsModel> detailsModelList;
    HomeGridItemClickListener itemClickListener;

    public HomeGridRecyclerAdapter(Context context, List<ImageDetailsModel> detailsModelList) {
        this.context = context;
        this.detailsModelList = detailsModelList;
        this.itemClickListener = (HomeGridItemClickListener)context;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        GridViewRecyclerItemBinding view = GridViewRecyclerItemBinding.inflate(LayoutInflater.from(context),parent,false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        holder.bind(detailsModelList.get(position).getUrl(),position);
    }

    @Override
    public int getItemCount() {
        return detailsModelList.size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder{
        GridViewRecyclerItemBinding binding;
        public GridViewHolder(@NonNull GridViewRecyclerItemBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        void bind(String image,int position){
            Glide.with(context).load(image).placeholder(R.drawable.static_placeholder_image).into(binding.recyclerGridItemImage);
            binding.recyclerGridItemImage.setOnClickListener(v -> itemClickListener.itemClickedAtPosition(position,binding.recyclerGridItemImage));
        }
    }
}
