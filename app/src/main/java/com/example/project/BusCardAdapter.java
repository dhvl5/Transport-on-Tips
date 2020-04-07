package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BusCardAdapter extends RecyclerView.Adapter<BusCardAdapter.MyViewHolder>
{
    private ArrayList<BusCard> busCardList;
    private ArrayList<BusCard> busCardFilteredList;

    BusCardAdapter(Context context, ArrayList<BusCard> busCardList)
    {
        this.busCardList = busCardList;
        this.busCardFilteredList = busCardList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.bus_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        BusCard busCard = busCardFilteredList.get(position);
        holder.routeText.setText(busCard.getRoute());
        holder.fareText.setText(busCard.getFare());
        holder.timeText.setText(busCard.getTime());
    }

    @Override
    public int getItemCount()
    {
        return busCardFilteredList.size();
    }

    void FilterList(String first, String second, String firstEquals, String secondEquals, String route)
    {
        if(first.equals(firstEquals) && second.equals(secondEquals))
        {
            ArrayList<BusCard> filteredList = new ArrayList<>();
            filteredList.clear();
            for(BusCard temp : busCardList)
            {
                if(temp.getRoute().contains(route))
                {
                    filteredList.add(temp);
                }
            }
            busCardFilteredList = filteredList;
            this.notifyDataSetChanged();
        }
    }

    static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView routeText;
        TextView fareText;
        TextView timeText;

        MyViewHolder(final View view)
        {
            super(view);
            routeText = view.findViewById(R.id.route);
            fareText = view.findViewById(R.id.fare);
            timeText = view.findViewById(R.id.time);
        }
    }
}