package com.jkg.nasapics.view.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jkg.nasapics.databinding.HomeGridViewActivityBinding;
import com.jkg.nasapics.models.ImageDetailsModel;
import com.jkg.nasapics.view.adapters.HomeGridRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeGridView extends AppCompatActivity {
    HomeGridViewActivityBinding binding;
    List<ImageDetailsModel> detailsModelList = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = HomeGridViewActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        HomeGridRecyclerAdapter recyclerAdapter = new HomeGridRecyclerAdapter(this,detailsModelList);
        binding.gridImageRv.setAdapter(recyclerAdapter);

    }
}
