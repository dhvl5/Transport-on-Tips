package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.ArrayList;

public class activity_journeywologin extends AppCompatActivity
{
    Spinner sourceSpinner, destinationSpinner;

    RecyclerView recyclerView;
    BusCardAdapter busCardAdapter;
    ArrayList<BusCard> busCardList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journeywologin);

        sourceSpinner = findViewById(R.id.srcSkip);
        destinationSpinner = findViewById(R.id.desSkip);
        recyclerView = findViewById(R.id.rvSkip);

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
