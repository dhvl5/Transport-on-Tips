package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class regotp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regotp);
    }
    public void Submit(View view)
    {
        Intent intent = new Intent(getApplicationContext(), Successfull.class);
        startActivity(intent);
    }
}
