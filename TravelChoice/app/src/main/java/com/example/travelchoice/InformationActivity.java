package com.example.travelchoice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        Intent intent = getIntent();
        String cityName = intent.getStringExtra("city");

        City city = CardViewActivity.getCity(cityName);

        TextView nameTV = (TextView) findViewById(R.id.nameTV);
        nameTV.setText(city.getName());

        ImageView imageView = (ImageView) findViewById(R.id.imageT);
        int resID = getResources().getIdentifier(city.getName().toLowerCase(), "drawable", "com.example.travelchoice");
        imageView.setImageResource(resID);

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
    }

}

