package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Generate_Pass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate__pass);
    }
    public void almost(View view)
    {
        Intent intent = new Intent(getApplicationContext(),mycard.class);
        startActivity(intent);
    }

}
