package com.example.travelchoice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class CardViewActivity extends AppCompatActivity implements Serializable {

    RecyclerView recyclerView;
    MyAdapter myAdapter;
    ArrayList<City> finalCities = new ArrayList<>();
    static HashMap<String, City> hashMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        Bundle b = getIntent().getExtras();
        finalCities = (ArrayList<City>) b.getSerializable("extra");

        for (City each : finalCities){
            hashMap.put(each.getName(), each);
        }

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new MyAdapter(this, getMyList());
        recyclerView.setAdapter(myAdapter);

    }

    private ArrayList<Model> getMyList() {

        ArrayList<Model> models = new ArrayList<>();

        Model m;

        for(City city : finalCities){
            m = new Model();
            m.setTitle(city.getName());
            m.setDescription("This is the description..");
            int resID = getResources().getIdentifier(city.getName().toLowerCase(), "drawable", "com.example.travelchoice");
            m.setImage(resID);
            models.add(m);
        }

        return models;
    }

    static City getCity(String city){
        return hashMap.get(city);
    }
}
