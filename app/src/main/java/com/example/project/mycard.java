package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class mycard extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycard);
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(mycard.this, PlanJourney.class);
        startActivity(intent);
    }
}
