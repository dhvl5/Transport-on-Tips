package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class successfulfeed extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successfulfeed);
    }

    public void success(View v)
    {
        Intent intent = new Intent(getApplicationContext(), PlanJourney.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed()
    {
        startActivity(new Intent(getApplicationContext(), PlanJourney.class));
    }
}
