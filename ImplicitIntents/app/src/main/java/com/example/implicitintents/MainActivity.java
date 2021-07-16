package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mWebsiteEditText;
    private EditText mLocationEditText;
    private EditText mShareTextEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebsiteEditText = findViewById(R.id.website_edittext);
        mLocationEditText = findViewById(R.id.location_edittext);
        mShareTextEditText = findViewById(R.id.share_edittext);
    }

    public void openWebsite(View view) {
        //get URL text
        String url = mWebsiteEditText.getText().toString();

        //parse the URI and make intent
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        //find activity to send intent to and start (or not)

        /*
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);

        else
            Log.d("ImplicitsIntents", "Can't handle this intent!");
        */

        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Log.d("ImplicitsIntents", "Can't handle this intent!");
        }

    }

    public void openLocation(View view) {
        //get location text string
        String loc = mLocationEditText.getText().toString();

        //parse the URI into geo search query and make intent
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        //find activity to send intent to and start (or not)

        /*
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);

        else
            Log.d("ImplicitsIntents", "Can't handle this intent!");

        */
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Log.d("ImplicitsIntents", "Can't handle this intent!");
        }

    }

    public void shareText(View view) {
        //get share text string
        String txt = mShareTextEditText.getText().toString();
        //define type of text to share
        String mimeType = "text/plain";

        ShareCompat.IntentBuilder.from(this).setType(mimeType).setChooserTitle(R.string.share_text_with).setText(txt).startChooser();



    }
}