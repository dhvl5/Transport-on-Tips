package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import java.io.ByteArrayOutputStream;

public class PlanJourney extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    MaterialToolbar materialToolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    Spinner sourceSpinner, destinationSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        sourceSpinner = findViewById(R.id.Src);
        destinationSpinner = findViewById(R.id.des);

        materialToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(materialToolbar);

        drawerLayout = findViewById(R.id.custom_drawer_layout);
        navigationView = findViewById(R.id.custom_navigation_view);

        ActionBarDrawerToggle drawerToggle;
        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,materialToolbar,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.addDrawerListener(drawerToggle);

        navigationView.setNavigationItemSelectedListener(this);

        drawerToggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.nav_item_1:
                Intent i1 = new Intent(PlanJourney.this, Generate_Pass.class);
                startActivity(i1);
                break;
            case R.id.nav_item_2:
                Intent i2 = new Intent(PlanJourney.this, mycard.class);
                startActivity(i2);
                break;
            case R.id.nav_item_3:
                Intent i3 = new Intent(PlanJourney.this, accountsett.class);
                startActivity(i3);
                break;
            case R.id.nav_item_4:
                Intent i4 = new Intent(PlanJourney.this, feedback.class);
                startActivity(i4);
                break;
            case R.id.nav_item_5:
                Intent i5 = new Intent(PlanJourney.this, aboutus.class);
                startActivity(i5);
                break;
            case R.id.nav_item_6:
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("UserLogin",
                        Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("login");
                editor.apply();
                editor.commit();
                Intent i6 = new Intent(PlanJourney.this, Login.class);
                startActivity(i6);
                finish();
                break;
        }
        return false;
    }

    public void success(View view)
    {
        String src = sourceSpinner.getSelectedItem().toString();
        String des = destinationSpinner.getSelectedItem().toString();
        byte[] bytes;
        Intent intent = new Intent(getApplicationContext(), ticketqr.class);

        if(src.equals("Maninagar") && des.equals("Shivranjani"))
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maninagar_shivranjani);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytes = stream.toByteArray();
            intent.putExtra("image", bytes);
            startActivity(intent);
        }
        else if(src.equals("Maninagar") && des.equals("Nehrunagar"))
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maninagar_nehrunagar);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytes = stream.toByteArray();
            intent.putExtra("image", bytes);
            startActivity(intent);
        }
        else if(src.equals("Maninagar") && des.equals("L.D College"))
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maninagar_ld);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytes = stream.toByteArray();
            intent.putExtra("image", bytes);
            startActivity(intent);
        }
        else if(src.equals("Maninagar") && des.equals("Andhjan Mandal"))
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maninagar_andhjan);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytes = stream.toByteArray();
            intent.putExtra("image", bytes);
            startActivity(intent);
        }
        else if(src.equals("Maninagar") && des.equals("Iskcon"))
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maninagar_iscon);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytes = stream.toByteArray();
            intent.putExtra("image", bytes);
            startActivity(intent);
        }
        else if(src.equals("Shivranjani") && des.equals("Maninagar"))
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.shivranjani_maninagar);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytes = stream.toByteArray();
            intent.putExtra("image", bytes);
            startActivity(intent);
        }
        else if(src.equals("Shivranjani") && des.equals("Nehrunagar"))
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.shivranjani_nehrunagar);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytes = stream.toByteArray();
            intent.putExtra("image", bytes);
            startActivity(intent);
        }
        else if(src.equals("Shivranjani") && des.equals("L.D College"))
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.shivranjani_ld);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytes = stream.toByteArray();
            intent.putExtra("image", bytes);
            startActivity(intent);
        }
        else if(src.equals("Shivranjani") && des.equals("Andhjan Mandal"))
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.shivranjani_andhjan);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytes = stream.toByteArray();
            intent.putExtra("image", bytes);
            startActivity(intent);
        }
        else if(src.equals("Shivranjani") && des.equals("Iskcon"))
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.shivranjani_iscon);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytes = stream.toByteArray();
            intent.putExtra("image", bytes);
            startActivity(intent);
        }
        else if(src.equals("Nehrunagar") && des.equals("Maninagar"))
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.nehrunagar_maninagar);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytes = stream.toByteArray();
            intent.putExtra("image", bytes);
            startActivity(intent);
        }
        else if(src.equals("Nehrunagar") && des.equals("Shivranjani"))
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.nehrunagar_shivranjani);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytes = stream.toByteArray();
            intent.putExtra("image", bytes);
            startActivity(intent);
        }
        else if(src.equals("Nehrunagar") && des.equals("L.D College"))
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.nehrunagar_ld);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytes = stream.toByteArray();
            intent.putExtra("image", bytes);
            startActivity(intent);
        }
        else if(src.equals("Nehrunagar") && des.equals("Andhjan Mandal"))
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.nehrunagar_andhjan);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytes = stream.toByteArray();
            intent.putExtra("image", bytes);
            startActivity(intent);
        }
        else if(src.equals("Nehrunagar") && des.equals("Iskcon"))
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.nehrunagar_iscon);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytes = stream.toByteArray();
            intent.putExtra("image", bytes);
            startActivity(intent);
        }
        else if(src.equals("L.D College") && des.equals("Maninagar"))
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ld_maninagar);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytes = stream.toByteArray();
            intent.putExtra("image", bytes);
            startActivity(intent);
        }
        else if(src.equals("L.D College") && des.equals("Shivranjani"))
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ld_shivranjani);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytes = stream.toByteArray();
            intent.putExtra("image", bytes);
            startActivity(intent);
        }
        else if(src.equals("L.D College") && des.equals("Nehrunagar"))
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ld_nehrunagar);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytes = stream.toByteArray();
            intent.putExtra("image", bytes);
            startActivity(intent);
        }
        else if(src.equals("L.D College") && des.equals("Andhjan Mandal"))
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ld_andhjan);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytes = stream.toByteArray();
            intent.putExtra("image", bytes);
            startActivity(intent);
        }
        else if(src.equals("L.D College") && des.equals("Iskcon"))
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ld_iscon);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytes = stream.toByteArray();
            intent.putExtra("image", bytes);
            startActivity(intent);
        }
        else if(src.equals("Andhjan Mandal") && des.equals("Maninagar"))
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.andhjan_maninagar);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytes = stream.toByteArray();
            intent.putExtra("image", bytes);
            startActivity(intent);
        }
        else if(src.equals("Andhjan Mandal") && des.equals("Shivranjani"))
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.andhjan_shivranjani);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytes = stream.toByteArray();
            intent.putExtra("image", bytes);
            startActivity(intent);
        }
        else if(src.equals("Andhjan Mandal") && des.equals("Nehrunagar"))
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.andhjan_nehrunagar);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytes = stream.toByteArray();
            intent.putExtra("image", bytes);
            startActivity(intent);
        }
        else if(src.equals("Andhjan Mandal") && des.equals("L.D College"))
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.andhjan_ld);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytes = stream.toByteArray();
            intent.putExtra("image", bytes);
            startActivity(intent);
        }
        else if(src.equals("Andhjan Mandal") && des.equals("Iskcon"))
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.andhjan_iscon);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytes = stream.toByteArray();
            intent.putExtra("image", bytes);
            startActivity(intent);
        }
        else if(src.equals("Iskcon") && des.equals("Maninagar"))
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.iscon_maninagar);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytes = stream.toByteArray();
            intent.putExtra("image", bytes);
            startActivity(intent);
        }
        else if(src.equals("Iskcon") && des.equals("Shivranjani"))
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.iscon_shivranjani);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytes = stream.toByteArray();
            intent.putExtra("image", bytes);
            startActivity(intent);
        }
        else if(src.equals("Iskcon") && des.equals("Nehrunagar"))
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.iscon_nehrunagar);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytes = stream.toByteArray();
            intent.putExtra("image", bytes);
            startActivity(intent);
        }
        else if(src.equals("Iskcon") && des.equals("L.D College"))
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.iscon_ld);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytes = stream.toByteArray();
            intent.putExtra("image", bytes);
            startActivity(intent);
        }
        else if(src.equals("Iskcon") && des.equals("Andhjan Mandal"))
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.iscon_andhjan);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytes = stream.toByteArray();
            intent.putExtra("image", bytes);
            startActivity(intent);
        }
        else
        {
            ShowToast("Couldn't find a route between those two places!!!");
        }
    }

    private void ShowToast(String msg)
    {
        Toast toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
        View view = toast.getView();
        view.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
        TextView text = view.findViewById(android.R.id.message);
        text.setTextColor(Color.WHITE);
        toast.show();
    }
}