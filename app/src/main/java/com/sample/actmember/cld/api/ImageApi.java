package com.sample.actmember.cld.api;


import com.sample.actmember.cld.model.Image;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ImageApi {
    @GET("/{imageName}")
    Call<Image> getImage(@Path("imageName") String imageName);
}
