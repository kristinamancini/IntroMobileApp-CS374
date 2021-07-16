package com.example.asynctaskproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageDownloader extends AsyncTask<String, Integer, Bitmap> {

    private Bitmap bm;
    private ImageView newImage;
    private TextView loadingText;

    public ImageDownloader(Bitmap bitMap, ImageView image, TextView tv) {

        bm = bitMap;
        newImage = image;
        loadingText = tv;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Log.i("hello1", "hello1");
        publishProgress(1);
        try {
            URL url = new URL(params[0]);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            if (con.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new Exception("Failed to connect");
            }

            InputStream is = con.getInputStream();
            publishProgress(0);
            // get image behind UI thread
            bm = BitmapFactory.decodeStream((InputStream) new URL(params[0]).getContent());
            is.close();

        } catch (Exception e) {
            Log.e("Image", "Failed to load image", e);
            Log.e("error", e.getMessage());
        }
        return bm;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        Log.i("hello4", "hello4");
        if (newImage != null && bitmap != null) {
            Log.i("hello6", "hello6");
            newImage.setImageBitmap(bitmap);
        }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {

        if (values[0] == 1) {
            loadingText.setText("Loading...");
        } else {
            loadingText.setText("");
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


}
