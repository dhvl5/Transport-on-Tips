package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Successfullticket extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successfullticket);
    }
    public void success(View v)
    {
        Intent intent = new Intent(getApplicationContext(), PlanJourney.class);
        startActivity(intent);
    }
}
