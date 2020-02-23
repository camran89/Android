package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber;

   public void makeToast(String string){

       Toast.makeText(MainActivity.this,string,Toast.LENGTH_SHORT).show();

   }

    public void guessFunc(View view){



        EditText mytext = findViewById(R.id.myeditText);
        int userGuess=Integer.parseInt(mytext.getText().toString());

        if(userGuess==randomNumber){

                makeToast("Thats correct");

            Random r = new Random();
            randomNumber = r.nextInt(20) +1;
        }
        else if(userGuess>randomNumber){
            makeToast("lower than " + userGuess);
        }
        else{
            makeToast("Greater than" + userGuess);
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random r = new Random();
         randomNumber = (r.nextInt(20)+1);

    }
}
