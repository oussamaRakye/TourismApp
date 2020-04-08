package com.example.travelchoice;

import java.io.Serializable;
import java.util.ArrayList;

public class City implements Serializable {
    private boolean beach, mountain, island;
    private String name;
    private int big, country_side, clubbing, puntuaction, monuments;

    public boolean isBeach() {
        return beach;
    }

    public void setBeach(boolean beach) {
        this.beach = beach;
    }

    public boolean isMountain() {
        return mountain;
    }

    public void setMountain(boolean mountain) {
        this.mountain = mountain;
    }

    public boolean isIsland() {
        return island;
    }

    public void setIsland(boolean island) {
        this.island = island;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBig() {
        return big;
    }

    public void setBig(int big) {
        this.big = big;
    }

    public int getCountry_side() {
        return country_side;
    }

    public void setCountry_side(int country_side) {
        this.country_side = country_side;
    }

    public int getClubbing() {
        return clubbing;
    }

    public void setClubbing(int clubbing) {
        this.clubbing = clubbing;
    }

    public int getPuntuaction() {
        return puntuaction;
    }

    public void setPuntuaction(int puntuaction) {
        this.puntuaction = puntuaction;
    }

    public int getMonuments() {
        return monuments;
    }

    public void setMonuments(int monuments) {
        this.monuments = monuments;
    }

    public static ArrayList<City> getList_cities() {
        return list_cities;
    }

    public static void setList_cities(ArrayList<City> list_cities) {
        City.list_cities = list_cities;
    }

    static ArrayList<City> list_cities = new ArrayList<>();

    public City(String name, boolean beach, boolean mountain, boolean island, int big, int country_side, int clubbing, int monuments){
        this.name = name;
        this.beach = beach;
        this.mountain = mountain;
        this.island = island;
        this.big = big;
        this.country_side = country_side;
        this.clubbing = clubbing;
        this.monuments = monuments;
        list_cities.add(this);
    }

    public String name(){
        return name;
    }

}
