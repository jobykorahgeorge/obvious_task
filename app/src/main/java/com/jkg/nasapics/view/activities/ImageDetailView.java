package com.jkg.nasapics.view.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jkg.nasapics.databinding.ImageDetailActivityBinding;
import com.jkg.nasapics.models.ImageDetailsModel;
import com.jkg.nasapics.view.adapters.ImageDetailViewPagerAdapter;

import java.util.List;

public class ImageDetailView extends AppCompatActivity {

    ImageDetailActivityBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ImageDetailActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        List<ImageDetailsModel> detailsModelList = (List<ImageDetailsModel>) getIntent().getSerializableExtra("data");
        int position = getIntent().getIntExtra("position",0);
        ImageDetailViewPagerAdapter detailViewPagerAdapter = new ImageDetailViewPagerAdapter(detailsModelList,this);
        binding.imageDetailViewPager.setAdapter(detailViewPagerAdapter);
        binding.imageDetailViewPager.setCurrentItem(position,false);
        binding.imageDetailViewPager.setOffscreenPageLimit(detailsModelList.size());
    }

}
