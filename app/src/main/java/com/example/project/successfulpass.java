package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class successfulpass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successfulpass);
    }
    public void success(View v)
    {
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
    }

}
