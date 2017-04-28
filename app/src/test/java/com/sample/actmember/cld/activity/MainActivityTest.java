package com.sample.actmember.cld.activity;

import android.widget.Button;

import com.sample.actmember.cld.BuildConfig;
import com.sample.actmember.cld.R;
import com.sample.actmember.cld.TestCLDApplication;
import com.sample.actmember.cld.TestCLDComponent;
import com.sample.actmember.cld.controller.ControllerCallback;
import com.sample.actmember.cld.controller.ImageController;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import javax.inject.Inject;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {

    @Inject
    ImageController imageController;

    private MainActivity subject;
    private Button firstButton;
    private Button secondButton;

    @Before
    public void setUp() throws Exception {
        subject = Robolectric.setupActivity(MainActivity.class);

        ((TestCLDComponent) ((TestCLDApplication) RuntimeEnvironment.application).getComponent()).inject(this);

        firstButton =(Button) subject.findViewById(R.id.image_a);
        secondButton = (Button) subject.findViewById(R.id.image_b);
    }

    @Test
    public void OnClickImageAButton_ShouldInvokeControllerGetImageMethod() throws Exception {
        firstButton.performClick();
        verify(imageController).getImage(anyString(), any(ControllerCallback.class));
    }
}