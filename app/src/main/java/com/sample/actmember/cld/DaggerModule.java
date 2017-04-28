package com.sample.actmember.cld;

import android.content.Context;

import com.sample.actmember.cld.api.ImageApi;
import com.sample.actmember.cld.controller.ImageController;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Module
public class DaggerModule {

    private Context context;

    public DaggerModule(Context context) {
        this.context = context;
    }

    @Provides
    public ImageController provideImageController(ImageApi imageApi) {
        return new ImageController(imageApi);
    }

    @Provides
    public ImageApi provideImageApi(Retrofit retrofit) {
        return retrofit.create(ImageApi.class);
    }

    @Provides
    public Retrofit provideRetrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:" + 3334)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
