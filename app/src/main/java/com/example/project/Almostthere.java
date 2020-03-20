package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Almostthere extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.almostthere);
    }
    public void addpic(View view)
    {
        Intent intent = new Intent(getApplicationContext(), Addpic.class);
        startActivity(intent);
    }

}
