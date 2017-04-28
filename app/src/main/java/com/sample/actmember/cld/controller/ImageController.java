package com.sample.actmember.cld.controller;

import android.util.Log;

import com.sample.actmember.cld.api.ImageApi;
import com.sample.actmember.cld.model.Image;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImageController {
    ImageApi imageApi;

    public ImageController(ImageApi imageApi) {
        this.imageApi = imageApi;
    }

    public void getImage(String imageName, final ControllerCallback controllerCallback) {
        Call<Image> imageCall = imageApi.getImage(imageName);
        imageCall.enqueue(new Callback<Image>() {
            @Override
            public void onResponse(Call<Image> call, Response<Image> response) {
                controllerCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Image> call, Throwable t) {

            }
        });
    }
}
