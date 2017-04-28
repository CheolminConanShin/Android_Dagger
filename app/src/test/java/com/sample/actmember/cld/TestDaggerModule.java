package com.sample.actmember.cld;

import android.content.Context;

import com.sample.actmember.cld.api.ImageApi;
import com.sample.actmember.cld.controller.ImageController;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static org.mockito.Mockito.mock;

@Module
public class TestDaggerModule {
    private Context context;

    public TestDaggerModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public ImageController provideImageController(ImageApi imageApi) {
        return mock(ImageController.class);
    }

    @Provides
    @Singleton
    public ImageApi provideImageApi() {
        return mock(ImageApi.class);
    }
}
