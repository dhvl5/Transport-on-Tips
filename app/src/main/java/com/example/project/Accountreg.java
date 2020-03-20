package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Accountreg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountreg);
    }
    public void Start(View view)
    {
        Intent intent = new Intent(getApplicationContext(), PlanJourney.class);
        startActivity(intent);
    }
}
