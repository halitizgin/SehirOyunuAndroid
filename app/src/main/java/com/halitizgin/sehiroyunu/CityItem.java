package com.halitizgin.sehiroyunu;

public class CityItem
{
    private Integer index;
    private String city;
    private String error;

    public CityItem()
    {
        this.index = -1;
        this.city = null;
        this.error = null;
    }

    public CityItem(Integer index, String city, String error)
    {
        this.index = index;
        this.city = city;
        this.error = error;
    }

    public Integer getIndex()
    {
        return this.index;
    }

    public String getCity()
    {
        return this.city;
    }

    public String getError() { return this.error; }

    public void setIndex(Integer index)
    {
        this.index = index;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setError(String error) { this.error = error; }
}
