package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void login(View v){
        EditText text=(EditText) findViewById(R.id.email);
        String str= text.getText().toString();
        EditText pass= (EditText) findViewById(R.id.password);
        String str1=pass.getText().toString();
        if(str.equals("abc@gmail.com") && str1.equals("abc123")){
        Intent i2=new Intent(Main2Activity.this,Main3Activity.class);
        startActivity(i2);
    }}
    public void register(View v){
        Intent i1=new Intent(Main2Activity.this,Main4Activity.class);
        startActivity(i1);
    }
}
