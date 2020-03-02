package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void login(View v){
        Intent i=new Intent(Main2Activity.this,Main3Activity.class);
        startActivity(i);
    }
    public void register(View v){
        Intent i1=new Intent(Main2Activity.this,Main4Activity.class);
        startActivity(i1);
    }
}
