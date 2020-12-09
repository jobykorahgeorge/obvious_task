package com.jkg.nasapics.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jkg.nasapics.R;
import com.jkg.nasapics.databinding.ImageDetailViewPagerItemBinding;
import com.jkg.nasapics.models.ImageDetailsModel;

import java.util.List;

public class ImageDetailViewPagerAdapter extends RecyclerView.Adapter<ImageDetailViewPagerAdapter.ImageDetailViewHolder> {

    private List<ImageDetailsModel> detailsModelList;
    private Context context;

    public ImageDetailViewPagerAdapter(List<ImageDetailsModel> detailsModelList, Context context) {
        this.detailsModelList = detailsModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ImageDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ImageDetailViewPagerItemBinding view = ImageDetailViewPagerItemBinding.inflate(LayoutInflater.from(context),parent,false);
        return new ImageDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageDetailViewHolder holder, int position) {
        holder.Bind(detailsModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return detailsModelList.size();
    }

    class ImageDetailViewHolder extends RecyclerView.ViewHolder{
        ImageDetailViewPagerItemBinding binding;
        public ImageDetailViewHolder(@NonNull ImageDetailViewPagerItemBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        void Bind(ImageDetailsModel detailsModel){
            binding.imageTitle.setText(detailsModel.getTitle());
            binding.imageDate.setText(detailsModel.getDate());
            binding.imageExplanation.setText(detailsModel.getExplanation());
            binding.picCredits.setText(detailsModel.getCopyright());
            Glide.with(context).load(detailsModel.getHdurl()).placeholder(R.drawable.placeholder_image_rotate).into(binding.detailEnlargedImage);
        }
    }
}
