package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    public void Convert (View view){

        EditText mytext=(EditText) findViewById(R.id.myeditText);
        Double myNepaliCurrency=Double.parseDouble(mytext.getText().toString());
        Double indianCurrency=(myNepaliCurrency*1.6);
        Toast.makeText(MainActivity.this,indianCurrency  + "INR",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
