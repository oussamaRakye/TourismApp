package com.example.travelchoice;

import java.util.Comparator;

public class CityComparator implements Comparator<City> {
    public int compare(City c1, City c2) {
        return c1.getPuntuaction() - c2.getPuntuaction();
    }
}
