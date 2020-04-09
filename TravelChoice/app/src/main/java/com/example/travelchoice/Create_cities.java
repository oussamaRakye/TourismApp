package com.example.travelchoice;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;


public class Create_cities {
    private Context context;
    public Create_cities(Context current){
        this.context = current;

        try{
            CSVReader reader = new CSVReader(new InputStreamReader(context.getResources().openRawResource(R.raw.travel)));//Specify asset file name
            String [] line;
            reader.readNext();
            while ((line = reader.readNext()) != null) {

                // nextLine[] is an array of values from the line
                String name = line[0];
                boolean beach = line[1].equals("t") ? true : false;
                boolean mountain = line[2].equals("t") ? true : false;
                boolean island = line[3].equals("t") ? true : false;
                int big = Integer.parseInt(line[4]);
                int country_side = Integer.parseInt(line[5]);
                int clubbimg = Integer.parseInt(line[6]);
                int monuments = Integer.parseInt(line[7]);


                City city = new City(name, beach, mountain, island, big, country_side, clubbimg, monuments);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
