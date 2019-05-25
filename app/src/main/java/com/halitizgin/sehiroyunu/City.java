package com.halitizgin.sehiroyunu;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class City
{
    private ArrayList<String> cities = new ArrayList<String>();
    private ArrayList<String> temp = new ArrayList<String>(Arrays.asList("Adana", "Adıyaman", "Afyonkarahisar", "Ağrı", "Aksaray", "Amasya", "Ankara", "Antalya", "Artvin", "Ardahan", "Aydın", "Balıkesir", "Bartın", "Batman", "Bayburt", "Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa", "Çanakkale", "Çankırı", "Çorum", "Denizli", "Diyarbakır", "Düzce", "Edirne", "Elazığ", "Erzincan", "Erzurum", "Eskişehir", "Gaziantep", "Giresun", "Gümüşhane", "Hakkâri", "Hatay", "Iğdır", "Isparta", "İstanbul", "İzmir", "Kahramanmaraş", "Karabük", "Karaman", "Kars", "Kastamonu", "Kayseri", "Kırıkkale", "Kırklareli", "Kırşehir", "Kilis", "Kocaeli", "Konya", "Kütahya", "Malatya", "Manisa", "Mardin", "Mersin", "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu", "Osmaniye", "Rize", "Sakarya", "Samsun", "Siirt", "Sinop", "Sivas", "Şanlıurfa", "Şırnak", "Tekirdağ", "Tokat", "Trabzon", "Tunceli", "Uşak", "Van", "Yalova", "Yozgat", "Zonguldak"));

    public City()
    {
        this.syncTemp();
    }

    public Integer count()
    {
        return this.cities.size();
    }

    public CityItem getAndRemove(String city)
    {
        CityItem cityItem = new CityItem();
        city = city.trim();
        city = city.toLowerCase();
        city = city.substring(0, 1).toUpperCase() + city.substring(1);
        int index = this.cities.indexOf(city);
        if (index == -1)
        {
            Integer index2 = temp.indexOf(city);
            if (index2 == -1)
                cityItem.setError("Böyle bir şehir bulunmamaktadır!");
            else
                cityItem.setError("Bu şehir daha önce kullanılmıştır!");
        }
        else
        {
            cityItem.setIndex(index);
            cityItem.setCity(city);
            this.cities.remove(index);
        }
        return cityItem;
    }

    public void syncTemp()
    {
        this.cities.clear();
        this.cities.addAll(temp);
    }
}
