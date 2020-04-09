package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class PlanJourney extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    MaterialToolbar materialToolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    Spinner sourceSpinner, destinationSpinner;

    RecyclerView recyclerView;
    BusCardAdapter busCardAdapter;
    ArrayList<BusCard> busCardList;

    TextView headerName, headerEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        sourceSpinner = findViewById(R.id.Src);
        destinationSpinner = findViewById(R.id.des);
        recyclerView = findViewById(R.id.rv);
        materialToolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.custom_drawer_layout);
        navigationView = findViewById(R.id.custom_navigation_view);

        View headerView = navigationView.getHeaderView(0);
        headerName = headerView.findViewById(R.id.headerName);
        headerEmail = headerView.findViewById(R.id.headerEmail);

        SharedPreferences preferences;
        preferences = getApplicationContext().getSharedPreferences("UserLogin", Context.MODE_PRIVATE);
        headerName.setText(preferences.getString("name", ""));
        headerEmail.setText(preferences.getString("login", ""));

        setSupportActionBar(materialToolbar);

        busCardList = new ArrayList<>();
        busCardAdapter = new BusCardAdapter(this, busCardList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(busCardAdapter);

        busCardList.add(new BusCard("Maninagar - Shivranjani", "Fare : Rs. 15", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Maninagar - Nehrunagar", "Fare : Rs. 15", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Maninagar - L.D. College", "Fare : Rs. 15", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Maninagar - Andhjan Mandal", "Fare : Rs. 20", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Maninagar - Iskcon", "Fare : Rs. 20", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Shivranjani - Maninagar", "Fare : Rs. 20", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Shivranjani - Nehrunagar", "Fare : Rs. 4", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Shivranjani - L.D. College", "Fare : Rs. 9", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Shivranjani - Andhjan Mandal", "Fare : Rs. 4", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Shivranjani - Iskcon", "Fare : Rs. 9", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Nehrunagar - Maninagar", "Fare : Rs. 9", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Nehrunagar - Shivranjani", "Fare : Rs. 4", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Nehrunagar - L.D. College", "Fare : Rs. 7", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Nehrunagar - Andhjan Mandal", "Fare : Rs. 7", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Nehrunagar - Iskcon", "Fare : Rs. 10", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("L.D. College - Maninagar", "Fare : Rs. 15", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("L.D. College - Shivranjani", "Fare : Rs. 9", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("L.D. College - Nehrunagar", "Fare : Rs. 7", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("L.D. College - Andhjan Mandal", "Fare : Rs. 10", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("L.D. College - Iskcon", "Fare : Rs. 13", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Andhjan Mandal - Maninagar", "Fare : Rs. 20", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Andhjan Mandal - Shivranjani", "Fare : Rs. 4", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Andhjan Mandal - Nehrunagar", "Fare : Rs. 7", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Andhjan Mandal - L.D. College", "Fare : Rs. 10", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Andhjan Mandal - Iskcon", "Fare : Rs. 10", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Iskcon - Maninagar", "Fare : Rs. 22", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Iskcon - Nehrunagar", "Fare : Rs. 10", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Iskcon - Shivranjani", "Fare : Rs. 9", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Iskcon - L.D. College", "Fare : Rs. 10", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Iskcon - Andhjan Mandal", "Fare : Rs. 9", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Maninagar - Shivranjani", "Fare : Rs. 15", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Maninagar - Nehrunagar", "Fare : Rs. 15", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Maninagar - L.D. College", "Fare : Rs. 15", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Maninagar - Andhjan Mandal", "Fare : Rs. 20", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Maninagar - Iskcon", "Fare : Rs. 20", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Shivranjani - Maninagar", "Fare : Rs. 15", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Shivranjani - Nehrunagar", "Fare : Rs. 4", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Shivranjani - L.D. College", "Fare : Rs. 9", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Shivranjani - Andhjan Mandal", "Fare : Rs. 4", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Shivranjani - Iskcon", "Fare : Rs. 9", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Nehrunagar - Maninagar", "Fare : Rs. 9", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Nehrunagar - Shivranjani", "Fare : Rs. 4", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Nehrunagar - L.D. College", "Fare : Rs. 7", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Nehrunagar - Andhjan Mandal", "Fare : Rs. 7", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Nehrunagar - Iskcon", "Fare : Rs. 10", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("L.D. College - Maninagar", "Fare : Rs. 15", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("L.D. College - Shivranjani", "Fare : Rs. 9", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("L.D. College - Nehrunagar", "Fare : Rs. 7", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("L.D. College - Andhjan Mandal", "Fare : Rs. 10", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("L.D. College - Iskcon", "Fare : Rs. 13", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Andhjan Mandal - Maninagar", "Fare : Rs. 20", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Andhjan Mandal - Shivranjani", "Fare : Rs. 4", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Andhjan Mandal - Nehrunagar", "Fare : Rs. 7", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Andhjan Mandal - L.D. College", "Fare : Rs. 10", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Andhjan Mandal - Iskcon", "Fare : Rs. 10", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Iskcon - Maninagar", "Fare : Rs. 22", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Iskcon - Shivranjani", "Fare : Rs. 9", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Iskcon - Nehrunagar", "Fare : Rs. 10", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Iskcon - Andhjan Mandal", "Fare : Rs. 9", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Iskcon - L.D. College", "Fare : Rs. 10", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Maninagar - L.D. College", "Fare : Rs. 15", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Maninagar - Iskcon", "Fare : Rs. 20", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Shivranjani - Nehrunagar", "Fare : Rs. 4", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Shivranjani - Andhjan Mandal", "Fare : Rs. 4", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Shivranjani - Maninagar", "Fare : Rs. 15", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Maninagar - Shivranjani", "Fare : Rs. 15", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Nehrunagar - Shivranjani", "Fare : Rs. 4", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Nehrunagar - Maninagar", "Fare : Rs. 9", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Nehrunagar - L.D. College", "Fare : Rs. 7", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("L.D. College - Iskcon", "Fare : Rs. 13", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("L.D. College - Maninagar", "Fare : Rs. 15", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("L.D. College - Shivranjani", "Fare : Rs. 9", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Andhjan Mandal - Nehrunagar", "Fare : Rs. 7", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Andhjan Mandal - Iskcon", "Fare : Rs. 10", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Andhjan Mandal - Shivranjani", "Fare : Rs. 10", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Iskcon - Maninagar", "Fare : Rs. 22", "3:57 pm - 4:39 pm"));
        busCardList.add(new BusCard("Iskcon - Shivranjani", "Fare : Rs. 9", "3:57 pm - 4:39 pm"));
        busCardAdapter.notifyDataSetChanged();

        sourceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                FilterList();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        destinationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                FilterList();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("MenuItemVisibility", Context.MODE_PRIVATE);
        if(sharedPreferences.contains("visible"))
        {
            navigationView.getMenu().findItem(R.id.nav_item_1).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_item_2).setVisible(true);
        }
        else
            navigationView.getMenu().findItem(R.id.nav_item_2).setVisible(false);

        ActionBarDrawerToggle drawerToggle;
        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,materialToolbar,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.addDrawerListener(drawerToggle);

        navigationView.setNavigationItemSelectedListener(this);

        drawerToggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.nav_item_7:
                drawerLayout.closeDrawer(navigationView);
                break;
            case R.id.nav_item_1:
                drawerLayout.closeDrawer(navigationView);
                Intent i1 = new Intent(PlanJourney.this, Generate_Pass.class);
                startActivity(i1);
                break;
            case R.id.nav_item_2:
                drawerLayout.closeDrawer(navigationView);
                Intent i2 = new Intent(PlanJourney.this, mycard.class);
                startActivity(i2);
                break;
            case R.id.nav_item_3:
                drawerLayout.closeDrawer(navigationView);
                Intent i3 = new Intent(PlanJourney.this, accountsett.class);
                startActivity(i3);
                break;
            case R.id.nav_item_4:
                drawerLayout.closeDrawer(navigationView);
                Intent i4 = new Intent(PlanJourney.this, feedback.class);
                startActivity(i4);
                break;
            case R.id.nav_item_5:
                drawerLayout.closeDrawer(navigationView);
                Intent i5 = new Intent(PlanJourney.this, aboutus.class);
                startActivity(i5);
                break;
            case R.id.nav_item_6:
                drawerLayout.closeDrawer(navigationView);

                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("UserLogin", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("login");
                editor.remove("name");
                editor.remove("mobile");
                editor.apply();
                editor.commit();

                SharedPreferences preferences = getApplicationContext().getSharedPreferences("MenuItemVisibility", Context.MODE_PRIVATE);
                SharedPreferences.Editor edt = preferences.edit();
                edt.remove("visible");
                edt.apply();
                edt.commit();

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

        if(src.equals("Maninagar") && des.equals("Shivranjani"))
        {
            SetQR(R.drawable.maninagar_shivranjani);
        }
        else if(src.equals("Maninagar") && des.equals("Nehrunagar"))
        {
            SetQR(R.drawable.maninagar_nehrunagar);
        }
        else if(src.equals("Maninagar") && des.equals("L.D College"))
        {
            SetQR(R.drawable.maninagar_ld);
        }
        else if(src.equals("Maninagar") && des.equals("Andhjan Mandal"))
        {
            SetQR(R.drawable.maninagar_andhjan);
        }
        else if(src.equals("Maninagar") && des.equals("Iskcon"))
        {
            SetQR(R.drawable.maninagar_iscon);
        }
        else if(src.equals("Shivranjani") && des.equals("Maninagar"))
        {
            SetQR(R.drawable.shivranjani_maninagar);
        }
        else if(src.equals("Shivranjani") && des.equals("Nehrunagar"))
        {
            SetQR(R.drawable.shivranjani_nehrunagar);
        }
        else if(src.equals("Shivranjani") && des.equals("L.D College"))
        {
            SetQR(R.drawable.shivranjani_ld);
        }
        else if(src.equals("Shivranjani") && des.equals("Andhjan Mandal"))
        {
            SetQR(R.drawable.shivranjani_andhjan);
        }
        else if(src.equals("Shivranjani") && des.equals("Iskcon"))
        {
            SetQR(R.drawable.shivranjani_iscon);
        }
        else if(src.equals("Nehrunagar") && des.equals("Maninagar"))
        {
            SetQR(R.drawable.nehrunagar_maninagar);
        }
        else if(src.equals("Nehrunagar") && des.equals("Shivranjani"))
        {
            SetQR(R.drawable.nehrunagar_shivranjani);
        }
        else if(src.equals("Nehrunagar") && des.equals("L.D College"))
        {
            SetQR(R.drawable.nehrunagar_ld);
        }
        else if(src.equals("Nehrunagar") && des.equals("Andhjan Mandal"))
        {
            SetQR(R.drawable.nehrunagar_andhjan);
        }
        else if(src.equals("Nehrunagar") && des.equals("Iskcon"))
        {
            SetQR(R.drawable.nehrunagar_iscon);
        }
        else if(src.equals("L.D College") && des.equals("Maninagar"))
        {
            SetQR(R.drawable.ld_maninagar);
        }
        else if(src.equals("L.D College") && des.equals("Shivranjani"))
        {
            SetQR(R.drawable.ld_shivranjani);
        }
        else if(src.equals("L.D College") && des.equals("Nehrunagar"))
        {
            SetQR(R.drawable.ld_nehrunagar);
        }
        else if(src.equals("L.D College") && des.equals("Andhjan Mandal"))
        {
            SetQR(R.drawable.ld_andhjan);
        }
        else if(src.equals("L.D College") && des.equals("Iskcon"))
        {
            SetQR(R.drawable.ld_iscon);
        }
        else if(src.equals("Andhjan Mandal") && des.equals("Maninagar"))
        {
            SetQR(R.drawable.andhjan_maninagar);
        }
        else if(src.equals("Andhjan Mandal") && des.equals("Shivranjani"))
        {
            SetQR(R.drawable.andhjan_shivranjani);
        }
        else if(src.equals("Andhjan Mandal") && des.equals("Nehrunagar"))
        {
            SetQR(R.drawable.andhjan_nehrunagar);
        }
        else if(src.equals("Andhjan Mandal") && des.equals("L.D College"))
        {
            SetQR(R.drawable.andhjan_ld);
        }
        else if(src.equals("Andhjan Mandal") && des.equals("Iskcon"))
        {
            SetQR(R.drawable.andhjan_iscon);
        }
        else if(src.equals("Iskcon") && des.equals("Maninagar"))
        {
            SetQR(R.drawable.iscon_maninagar);
        }
        else if(src.equals("Iskcon") && des.equals("Shivranjani"))
        {
            SetQR(R.drawable.iscon_shivranjani);
        }
        else if(src.equals("Iskcon") && des.equals("Nehrunagar"))
        {
            SetQR(R.drawable.iscon_nehrunagar);
        }
        else if(src.equals("Iskcon") && des.equals("L.D College"))
        {
            SetQR(R.drawable.iscon_ld);
        }
        else if(src.equals("Iskcon") && des.equals("Andhjan Mandal"))
        {
            SetQR(R.drawable.iscon_andhjan);
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

    private void SetQR(int id)
    {
        byte[] bytes;
        Intent intent = new Intent(getApplicationContext(), ticketqr.class);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), id);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        bytes = stream.toByteArray();
        intent.putExtra("image", bytes);
        startActivity(intent);
    }

    private void FilterList()
    {
        busCardAdapter.FilterList(sourceSpinner.getSelectedItem().toString(), destinationSpinner.getSelectedItem().toString(),
                "Maninagar", "Shivranjani", "Maninagar - Shivranjani");

        busCardAdapter.FilterList(sourceSpinner.getSelectedItem().toString(), destinationSpinner.getSelectedItem().toString(),
                "Maninagar", "Nehrunagar", "Maninagar - Nehrunagar");

        busCardAdapter.FilterList(sourceSpinner.getSelectedItem().toString(), destinationSpinner.getSelectedItem().toString(),
                "Maninagar", "L.D College", "Maninagar - L.D. College");

        busCardAdapter.FilterList(sourceSpinner.getSelectedItem().toString(), destinationSpinner.getSelectedItem().toString(),
                "Maninagar", "Andhjan Mandal", "Maninagar - Andhjan Mandal");

        busCardAdapter.FilterList(sourceSpinner.getSelectedItem().toString(), destinationSpinner.getSelectedItem().toString(),
                "Maninagar", "Iskcon", "Maninagar - Iskcon");

        busCardAdapter.FilterList(sourceSpinner.getSelectedItem().toString(), destinationSpinner.getSelectedItem().toString(),
                "Shivranjani", "Maninagar", "Shivranjani - Maninagar");

        busCardAdapter.FilterList(sourceSpinner.getSelectedItem().toString(), destinationSpinner.getSelectedItem().toString(),
                "Shivranjani", "Nehrunagar", "Shivranjani - Nehrunagar");

        busCardAdapter.FilterList(sourceSpinner.getSelectedItem().toString(), destinationSpinner.getSelectedItem().toString(),
                "Shivranjani", "L.D College", "Shivranjani - L.D. College");

        busCardAdapter.FilterList(sourceSpinner.getSelectedItem().toString(), destinationSpinner.getSelectedItem().toString(),
                "Shivranjani", "Andhjan Mandal", "Shivranjani - Andhjan Mandal");

        busCardAdapter.FilterList(sourceSpinner.getSelectedItem().toString(), destinationSpinner.getSelectedItem().toString(),
                "Shivranjani", "Iskcon", "Shivranjani - Iskcon");

        busCardAdapter.FilterList(sourceSpinner.getSelectedItem().toString(), destinationSpinner.getSelectedItem().toString(),
                "Nehrunagar", "Maninagar", "Nehrunagar - Maninagar");

        busCardAdapter.FilterList(sourceSpinner.getSelectedItem().toString(), destinationSpinner.getSelectedItem().toString(),
                "Nehrunagar", "Shivranjani", "Nehrunagar - Shivranjani");

        busCardAdapter.FilterList(sourceSpinner.getSelectedItem().toString(), destinationSpinner.getSelectedItem().toString(),
                "Nehrunagar", "L.D College", "Nehrunagar - L.D. College");

        busCardAdapter.FilterList(sourceSpinner.getSelectedItem().toString(), destinationSpinner.getSelectedItem().toString(),
                "Nehrunagar", "Andhjan Mandal", "Nehrunagar - Andhjan Mandal");

        busCardAdapter.FilterList(sourceSpinner.getSelectedItem().toString(), destinationSpinner.getSelectedItem().toString(),
                "Nehrunagar", "Iskcon", "Nehrunagar - Iskcon");

        busCardAdapter.FilterList(sourceSpinner.getSelectedItem().toString(), destinationSpinner.getSelectedItem().toString(),
                "L.D College", "Maninagar", "L.D. College - Maninagar");

        busCardAdapter.FilterList(sourceSpinner.getSelectedItem().toString(), destinationSpinner.getSelectedItem().toString(),
                "L.D College", "Shivranjani", "L.D. College - Shivranjani");

        busCardAdapter.FilterList(sourceSpinner.getSelectedItem().toString(), destinationSpinner.getSelectedItem().toString(),
                "L.D College", "Nehrunagar", "L.D. College - Nehrunagar");

        busCardAdapter.FilterList(sourceSpinner.getSelectedItem().toString(), destinationSpinner.getSelectedItem().toString(),
                "L.D College", "Andhjan Mandal", "L.D. College - Andhjan Mandal");

        busCardAdapter.FilterList(sourceSpinner.getSelectedItem().toString(), destinationSpinner.getSelectedItem().toString(),
                "L.D College", "Iskcon", "L.D. College - Iskcon");

        busCardAdapter.FilterList(sourceSpinner.getSelectedItem().toString(), destinationSpinner.getSelectedItem().toString(),
                "Andhjan Mandal", "Maninagar", "Andhjan Mandal - Maninagar");

        busCardAdapter.FilterList(sourceSpinner.getSelectedItem().toString(), destinationSpinner.getSelectedItem().toString(),
                "Andhjan Mandal", "Shivranjani", "Andhjan Mandal - Shivranjani");

        busCardAdapter.FilterList(sourceSpinner.getSelectedItem().toString(), destinationSpinner.getSelectedItem().toString(),
                "Andhjan Mandal", "Nehrunagar", "Andhjan Mandal - Nehrunagar");

        busCardAdapter.FilterList(sourceSpinner.getSelectedItem().toString(), destinationSpinner.getSelectedItem().toString(),
                "Andhjan Mandal", "L.D College", "Andhjan Mandal - L.D. College");

        busCardAdapter.FilterList(sourceSpinner.getSelectedItem().toString(), destinationSpinner.getSelectedItem().toString(),
                "Andhjan Mandal", "Iskcon", "Andhjan Mandal - Iskcon");

        busCardAdapter.FilterList(sourceSpinner.getSelectedItem().toString(), destinationSpinner.getSelectedItem().toString(),
                "Iskcon", "Maninagar", "Iskcon - Maninagar");

        busCardAdapter.FilterList(sourceSpinner.getSelectedItem().toString(), destinationSpinner.getSelectedItem().toString(),
                "Iskcon", "Shivranjani", "Iskcon - Shivranjani");

        busCardAdapter.FilterList(sourceSpinner.getSelectedItem().toString(), destinationSpinner.getSelectedItem().toString(),
                "Iskcon", "Nehrunagar", "Iskcon - Nehrunagar");

        busCardAdapter.FilterList(sourceSpinner.getSelectedItem().toString(), destinationSpinner.getSelectedItem().toString(),
                "Iskcon", "L.D College", "Iskcon - L.D. College");

        busCardAdapter.FilterList(sourceSpinner.getSelectedItem().toString(), destinationSpinner.getSelectedItem().toString(),
                "Iskcon", "Andhjan Mandal", "Iskcon - Andhjan Mandal");
    }
}