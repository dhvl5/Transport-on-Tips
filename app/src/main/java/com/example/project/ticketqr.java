package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ticketqr extends AppCompatActivity
{
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticketqr);

        imageView = findViewById(R.id.qrImage);

        Bundle extras = getIntent().getExtras();
        assert extras != null;
        byte[] bytes = extras.getByteArray("image");

        assert bytes != null;
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        imageView.setImageBitmap(bitmap);
    }

    public void addpic(View view)
    {
        Intent intent = new Intent(getApplicationContext(), Successfullticket.class);
        startActivity(intent);
    }

}