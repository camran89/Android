package com.example.triangularorsquare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    class Number{

        int number;
        int triangularNumber=1;


        public boolean isSquare() {

            double sqrt=Math.sqrt(number);
            if(Math.floor(sqrt)==sqrt) {
                return true;
            }
            else {
                return false;
            }

        }



        public boolean isTriangular() {

            int x=1;
            while(triangularNumber<number) {
                x++;
                triangularNumber=triangularNumber+x;

            }
            if(triangularNumber==number) {
                return true;
            }else {
                return false;
            }

        }
    }




    public void funcDef(View view){
        EditText mytext=(EditText) findViewById(R.id.myEditText);
      int   parsedInt=Integer.parseInt(mytext.getText().toString());

        Number mynum=new Number();
        mynum.number=parsedInt;

        if(mynum.isTriangular()){

            Toast.makeText(MainActivity.this,parsedInt +" Is a triangular Number",Toast.LENGTH_SHORT).show();

        }else if(mynum.isSquare()){

            Toast.makeText(MainActivity.this,parsedInt +" Is a square Number",Toast.LENGTH_SHORT).show();

        }else if(mynum.isTriangular() && mynum.isSquare()){

            Toast.makeText(MainActivity.this,parsedInt +" It is both a square and  a triangular number",Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(MainActivity.this,parsedInt +" It is neither a square nor a traiangular number",Toast.LENGTH_SHORT).show();
        }


    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
