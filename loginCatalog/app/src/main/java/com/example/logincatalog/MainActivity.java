package com.example.logincatalog;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void clickFunction(View view) {



        EditText myPlainText=(EditText) findViewById(R.id.myPlainText);

        Toast.makeText(MainActivity.this, "Hello "  +   myPlainText.getText().toString(),Toast.LENGTH_LONG).show();

        EditText myPasswordtext=(EditText) findViewById(R.id.myPasswordtext);

        Log.i("Username",myPlainText.getText().toString());
        Log.i("Password",myPasswordtext.getText().toString());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
