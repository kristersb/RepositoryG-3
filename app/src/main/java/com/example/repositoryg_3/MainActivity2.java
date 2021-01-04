package com.example.repositoryg_3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.repositoryg_3.MainActivity.SHARED_PREFS;
import static com.example.repositoryg_3.MainActivity.TEXT;

public class MainActivity2 extends AppCompatActivity {
private Button button4;
private Button button3;
private TextView textView;
private String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = (TextView) findViewById(R.id.textview);
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activityv2();


            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowThings();
                updateViews();

            }
        });

    }

    public void Activityv2(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void ShowThings(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT, "");
        if(text.length()<1){
            Toast.makeText(this, "Nothing found", Toast.LENGTH_LONG).show();
        }


    }
    public void updateViews() {
        textView.setText(text);
    }

}