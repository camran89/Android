package com.example.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void fade(View view){

        ImageView bart=(ImageView) findViewById(R.id.bart);;
       bart.animate().scaleYBy(0.5f).scaleYBy(0.5f).alpha(1f).setDuration(2000);



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView bart=(ImageView) findViewById(R.id.bart);
        bart.animate().scaleX(0.5f).scaleY(0.5f);

//        ImageView bart=(ImageView) findViewById(R.id.bart);
//        bart.setTranslationX(-2000f);
    }
}
