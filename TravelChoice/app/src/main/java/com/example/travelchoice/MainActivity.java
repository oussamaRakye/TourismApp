package com.example.travelchoice;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    TextView textView, beachTV, mountainTV;
    CheckBox beachCB, mountainCB, islandCB;
    boolean a1, a2, a3, a4;
    Button nextB, backB;
    SeekBar clubbingSB, bigSB, countrySideSB, monumentsSB;
    int index = 0;
    LinearLayout beachL, mountainL, islandL, clubbingL, bigL, countrySideL, monumentsL;
    ArrayList<LinearLayout> listQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text);

        nextB = (Button) findViewById(R.id.nextB);
        backB = (Button) findViewById(R.id.backB);


        beachTV = (TextView) findViewById(R.id.beachTV);
        mountainTV = (TextView) findViewById(R.id.mountainTV);

        beachCB = (CheckBox) findViewById(R.id.beachCB);
        mountainCB = (CheckBox) findViewById(R.id.mountainCB);
        islandCB = (CheckBox) findViewById(R.id.islandCB);
        clubbingSB = (SeekBar) findViewById(R.id.clubbingSB);
        bigSB = (SeekBar) findViewById(R.id.bigSB);
        countrySideSB = (SeekBar) findViewById(R.id.countrySideSB);
        monumentsSB = (SeekBar) findViewById(R.id.monumentsSB);

        beachL = (LinearLayout) findViewById(R.id.beachL);
        mountainL = (LinearLayout) findViewById(R.id.mountainL);
        islandL = (LinearLayout) findViewById(R.id.islandL);
        clubbingL = (LinearLayout) findViewById(R.id.clubbingL);
        bigL = (LinearLayout) findViewById(R.id.bigL);
        countrySideL = (LinearLayout) findViewById(R.id.countrySideL);
        monumentsL = (LinearLayout) findViewById(R.id.monumentsL);

        textView.setVisibility(View.GONE);

        mountainL.setVisibility(View.GONE);
        islandL.setVisibility(View.GONE);
        clubbingL.setVisibility(View.GONE);
        bigL.setVisibility(View.GONE);
        countrySideL.setVisibility(View.GONE);
        monumentsL.setVisibility(View.GONE);

        listQuestions = new ArrayList();
        listQuestions.add(beachL);
        listQuestions.add(mountainL);
        listQuestions.add(islandL);
        listQuestions.add(clubbingL);
        listQuestions.add(bigL);
        listQuestions.add(countrySideL);
        listQuestions.add(monumentsL);


        Create_cities create_cities = new Create_cities(this);



        nextB.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                buttonN();
            }
        });

        backB.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                buttonB();
            }
        });

    }


    private void animationF(LinearLayout firstL, LinearLayout secondL){
        firstL.animate()
                .alpha(-1f)
                .translationY(200f)
                .setDuration(800)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        firstL.setVisibility(View.GONE);
                        firstL.animate()
                                .alpha(1f)
                                .translationYBy(-200f)
                                .setDuration(1)
                                .setListener(null);
                    }
                });

        secondL.setAlpha(0f);
        secondL.setVisibility(View.VISIBLE);

        secondL.animate()
                .translationYBy(-200f)
                .setDuration(1)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        secondL.animate()
                                .alpha(1f)
                                .translationYBy(200f)
                                .setDuration(800)
                                .setListener(null);
                    }
                });

    }

    private void animationB(LinearLayout firstL, LinearLayout secondL){
        firstL.animate()
                .alpha(-1f)
                .translationY(-200f)
                .setDuration(800)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        firstL.setVisibility(View.GONE);
                        firstL.animate()
                                .alpha(1f)
                                .translationYBy(200f)
                                .setDuration(1)
                                .setListener(null);
                    }
                });

        secondL.setAlpha(0f);
        secondL.setVisibility(View.VISIBLE);

        secondL.animate()
                .translationYBy(200f)
                .setDuration(1)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        secondL.animate()
                                .alpha(1f)
                                .translationYBy(-200f)
                                .setDuration(800)
                                .setListener(null);
                    }
                });

    }

    private void buttonN(){
        if(index + 1 < listQuestions.size()){
            animationF(listQuestions.get(index), listQuestions.get(index + 1));

            index++;
        }
        else {
            a1 = beachCB.isChecked();
            a2 = mountainCB.isChecked();
            a3 = islandCB.isChecked();

            City.list_cities.forEach(s -> s.setPuntuaction(0));

            /**
            ArrayList<City> al1 = City.list_cities.stream()
                    .filter(s -> s.beach == a1)
                    .filter(s -> a2 == s.mountain)
                    .filter(s -> a3 == s.island)
                    .collect(Collectors.toCollection(ArrayList::new));
**/

            ArrayList<City> filteredCities = City.list_cities.stream()
                    .filter(s -> (!a1)||s.isBeach())
                    .filter(s -> (!a2)||s.isMountain())
                    .filter(s -> (!a3)||s.isIsland())
                    .collect(Collectors.toCollection(ArrayList::new));

            filteredCities.forEach(s -> s.setPuntuaction(Math.abs(s.getClubbing() - clubbingSB.getProgress())
                    + Math.abs(s.getBig() - bigSB.getProgress())
                    + Math.abs(s.getCountry_side() - countrySideSB.getProgress())
                    + Math.abs(s.getMonuments() - monumentsSB.getProgress())));
            Collections.sort(filteredCities, new CityComparator());

            if (filteredCities.size() > 0) {
                textView.setText(filteredCities.get(0).name());
            } else {
                textView.setText("rffff");
            }

            Bundle b = new Bundle();
            b.putSerializable("extra", filteredCities);

            Intent intent = new Intent(this, CardViewActivity.class);
            intent.putExtras(b);
            startActivity(intent);
        }
    }

    private void buttonB(){
        if(index  > 0){
            animationB(listQuestions.get(index), listQuestions.get(index - 1));

            index--;
        }
    }

}


