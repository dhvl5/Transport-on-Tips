package com.example.project;

public class BusCard
{
    private String route, fare, time;

    BusCard(String route, String fare, String time)
    {
        this.route = route;
        this.fare = fare;
        this.time = time;
    }

    String getRoute()
    {
        return route;
    }

    public void setRoute(String route)
    {
        this.route = route;
    }

    String getFare()
    {
        return fare;
    }

    public void setFare(String fare)
    {
        this.fare = fare;
    }

    String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }
}
