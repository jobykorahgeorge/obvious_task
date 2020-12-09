package com.jkg.nasapics.view.activities;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;

import com.jkg.nasapics.databinding.HomeGridViewActivityBinding;
import com.jkg.nasapics.interfaces.HomeGridItemClickListener;
import com.jkg.nasapics.models.ImageDetailsModel;
import com.jkg.nasapics.view.adapters.HomeGridRecyclerAdapter;
import com.jkg.nasapics.viewmodel.ImageDetailsViewModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HomeGridView extends AppCompatActivity implements HomeGridItemClickListener {
    HomeGridViewActivityBinding binding;
    List<ImageDetailsModel> detailsModelList = new ArrayList<>();
    ImageDetailsViewModel detailsViewModel;
    HomeGridRecyclerAdapter recyclerAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = HomeGridViewActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        detailsViewModel = ViewModelProviders.of(this).get(ImageDetailsViewModel.class);
        detailsViewModel.retrieveData();

        recyclerAdapter = new HomeGridRecyclerAdapter(this,detailsModelList);
        binding.gridImageRv.setLayoutManager(new GridLayoutManager(this,3));
        binding.gridImageRv.setAdapter(recyclerAdapter);
        viewModelObserver();
    }

    private void viewModelObserver(){
        detailsViewModel.detailsLiveData.observe(this, imageDetailsModels -> {
            if(detailsModelList !=null) {
                detailsModelList.clear();
            }
            detailsModelList.addAll(imageDetailsModels);
            recyclerAdapter.notifyDataSetChanged();
            binding.errorMessage.setVisibility(View.GONE);
        });
        detailsViewModel.parseError.observe(this, isError -> {
            if(isError!=null){
                binding.errorMessage.setVisibility(isError? View.VISIBLE: View.GONE);
            }
        });
    }

    @Override
    public void itemClickedAtPosition(int position, View imageView) {
        Intent detailViewIntent = new Intent(HomeGridView.this,ImageDetailView.class);
        detailViewIntent.putExtra("data",(Serializable)detailsModelList);
        detailViewIntent.putExtra("position",position);
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this,imageView,"image");
        startActivity(detailViewIntent,options.toBundle());
    }
}
