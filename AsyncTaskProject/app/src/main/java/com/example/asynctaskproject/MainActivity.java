package com.example.asynctaskproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button remoteImageButton;
    private ImageView remoteImagePlaceholder;
    private Bitmap bitmapImage;
    private TextView textview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //when you click button, fetch image
    public void showImage(View view) {
        remoteImageButton = (Button) findViewById(R.id.image_view_button);
        remoteImagePlaceholder = (ImageView) findViewById(R.id.birthplace_image);
        textview = (TextView) findViewById(R.id.loading_text);

        remoteImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ImageDownloader(bitmapImage, remoteImagePlaceholder, textview)
                        .execute("https://user-images.githubusercontent.com/85172362/122703165-f66b2180-d21e-11eb-8d1f-f8505647f9ae.jpg");
            }
        });
    }


}