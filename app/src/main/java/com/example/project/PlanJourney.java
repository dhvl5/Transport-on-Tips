package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class PlanJourney extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    MaterialToolbar materialToolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

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
        Intent intent = new Intent(getApplicationContext(), ticketqr.class);
        startActivity(intent);
    }
}
