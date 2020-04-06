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

    BusCardAdapter(Context context, ArrayList<BusCard> busCardList)
    {
        this.busCardList = busCardList;
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
        BusCard busCard = busCardList.get(position);
        holder.routeText.setText(busCard.getRoute());
        holder.fareText.setText(busCard.getFare());
        holder.timeText.setText(busCard.getTime());
    }

    @Override
    public int getItemCount()
    {
        return busCardList.size();
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