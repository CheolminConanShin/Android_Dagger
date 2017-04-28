package com.sample.actmember.cld.contract;

import com.sample.actmember.cld.api.ImageApi;
import com.sample.actmember.cld.model.Image;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.notNull;
import static org.mockito.Mockito.mock;

public class ImageApiContractTest {

    ImageApi imageApi;

    @Before
    public void setUp() throws Exception {
        imageApi = getRetrofit().create(ImageApi.class);
    }

    @Test
    public void name() throws Exception {
        Call<Image> imageCall = imageApi.getImage("beautyandthebeast");
        Response<Image> response = imageCall.execute();
        assertThat(response.code(), is(200));
        assertNotNull(response.body().getName());
    }

    private Retrofit getRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://70.50.170.93:9000")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

}
