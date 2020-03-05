package com.example.downloadwebimage;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Bitmap myImage;

    public void DownloadImage(View view){

       imageView.setImageBitmap(myImage);

    }

    public class DownloadContent extends AsyncTask<String,Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... urls) {
            URL url;
            try {

                url=new URL(urls[0]);
                HttpURLConnection urlConnection=(HttpURLConnection) url.openConnection();
                urlConnection.connect();
                InputStream is=urlConnection.getInputStream();
                Bitmap img= BitmapFactory.decodeStream(is);
                return img;

            }catch (Exception e){
                e.printStackTrace();
            }

          return null;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      imageView=(ImageView) findViewById(R.id.imageView);

        DownloadContent mycontent=new DownloadContent();
        try {

             myImage= mycontent.execute("https://cdn.pixabay.com/photo/2015/12/01/20/28/road-1072823_960_720.jpg").get();

        } catch (ExecutionException e) {

            e.printStackTrace();

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

    }
}
