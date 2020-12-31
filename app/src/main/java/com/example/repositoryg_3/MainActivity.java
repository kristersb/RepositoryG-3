package com.example.repositoryg_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES;
import static androidx.appcompat.app.AppCompatDelegate.setDefaultNightMode;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Button button2;
    private Button button;
    EditText editSave;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            Spinner spinner = (Spinner) findViewById(R.id.themeselect);

            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.themes, android.R.layout.simple_spinner_item);

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

         spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        editSave  = (EditText) findViewById(R.id.editSave);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activityv2();
            }
        });

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               SaveThings();
            }
        });

    }
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {

if(id == 1){
    setDefaultNightMode(MODE_NIGHT_YES);

}else{
    setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
}



    }

    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void Activityv2(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
    public void SaveThings(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXT, editSave.getText().toString());
        editor.apply();
        
    }
}