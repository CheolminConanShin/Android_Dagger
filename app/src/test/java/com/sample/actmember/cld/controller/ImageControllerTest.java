package com.sample.actmember.cld.controller;


import com.sample.actmember.cld.api.ImageApi;
import com.sample.actmember.cld.model.Image;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import retrofit2.Call;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ImageControllerTest {
    @Mock
    ImageApi imageApi;
    @Mock
    private Call<Image> imageCall;

    private ImageController imageController;

    @Before
    public void setUp() throws Exception {
        imageController = new ImageController(imageApi);
        when(imageApi.getImage(anyString())).thenReturn(imageCall);
    }

    @Test
    public void getImageA_shouldCallImageApi() throws Exception {
        imageController.getImage("conan", mock(ControllerCallback.class));
        verify(imageApi).getImage("conan");
    }
}