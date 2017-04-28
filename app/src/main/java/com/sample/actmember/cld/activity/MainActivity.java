package com.sample.actmember.cld.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sample.actmember.cld.CLDApplication;
import com.sample.actmember.cld.R;
import com.sample.actmember.cld.controller.ControllerCallback;
import com.sample.actmember.cld.controller.ImageController;
import com.sample.actmember.cld.model.Image;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String RESOURCE_DIRECTORY = "android.resource://com.sample.actmember.cld/drawable/";
    private ImageView imageView;

    @Inject
    ImageController imageController;
    private TextView textView;

    public MainActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((CLDApplication) getApplication()).getComponent().inject(this);
        imageView = (ImageView) findViewById(R.id.image_view);
        textView = (TextView) findViewById(R.id.image_name);

        Button firstButton = (Button) findViewById(R.id.image_a);
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImage("beautyandthebeast");
            }
        });

        Button secondButton = (Button) findViewById(R.id.image_b);
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImage("aladin");
            }
        });

    }

    private void setImage(String imageName) {
        imageController.getImage(imageName, new ControllerCallback<Image>() {
            @Override
            public void onSuccess(Image response) {
                Uri imageUri = Uri.parse(RESOURCE_DIRECTORY + response.getPath());
                imageView.setImageURI(imageUri);
                textView.setText(response.getName());
            }

            @Override
            public void onFailure(Image errorMessage) {

            }
        });
    }
}
