package com.jkg.nasapics.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jkg.nasapics.App;
import com.jkg.nasapics.R;
import com.jkg.nasapics.models.ImageDetailsModel;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class ImageDetailsViewModel extends ViewModel {
    public MutableLiveData<List<ImageDetailsModel>> detailsLiveData = new MutableLiveData<>();
    public MutableLiveData<Boolean> parseError = new MutableLiveData<>();

    public void retrieveData(){
        parseDataFromFile();
    }

    private void parseDataFromFile(){
        String jsonData = inputStreamToString(App.getApplication().getResources().openRawResource(R.raw.data));
        Type dataListType = new TypeToken<List<ImageDetailsModel>>(){}.getType();
        List<ImageDetailsModel> imageDetailsModelList = new Gson().fromJson(jsonData,dataListType);
        Collections.reverse(imageDetailsModelList);
        detailsLiveData.setValue(imageDetailsModelList);
    }

    private String inputStreamToString(InputStream inputStream) {
        try {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, bytes.length);
            return new String(bytes);
        } catch (IOException e) {
            parseError.setValue(false);
            return null;
        }
    }
}