package com.halitizgin.sehiroyunu;

import java.util.ArrayList;

public class History
{
    private ArrayList<String> citiesHistory;
    private ArrayList<Integer> pointsHistory;

    public History()
    {
        this.citiesHistory = new ArrayList<String>();
        this.pointsHistory = new ArrayList<Integer>();
    }

    public void addCityToHistory(String city)
    {
        citiesHistory.add(city);
    }

    public void addPointToHistory(Integer point)
    {
        pointsHistory.add(point);
    }

    public String getCityFromHistory(Integer position)
    {
        return this.citiesHistory.get(position);
    }

    public Integer getPointFromHistory(Integer position)
    {
        return this.pointsHistory.get(position);
    }

    public ArrayList<String> getCitiesHistory()
    {
        return this.citiesHistory;
    }

    public ArrayList<Integer> getPointsHistory()
    {
        return this.pointsHistory;
    }
}
