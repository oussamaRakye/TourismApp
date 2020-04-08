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
/**
        String fileName = "\travel.csv";


        try (FileInputStream fis = new FileInputStream(fileName);
             InputStreamReader isr = new InputStreamReader(fis,
                     StandardCharsets.UTF_8);
             CSVReader reader = new CSVReader(isr)) {
            String[] line;
            //reader.readNext();
            Log.d("ddd", "jjj");
            while ((line = reader.readNext()) != null) {
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }

**/
/**
        try{
            URL url = getClass().getResource("travel.csv");
            CSVReader reader = new CSVReader(new FileReader(new File(url.toURI()).getAbsolutePath()));
            String [] line;
            //skip the first row (column headers)
            reader.readNext();
            while ((line = reader.readNext()) != null) {
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
        } catch(IOException e){
            System.out.println("Failure! Something went wrong when loading the property file");
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
**/

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

        //City barcelona = new City("Barcelona", true, true, false, 9, 5, 8, 8);
        //City madrid = new City("Madrid", false, false, false, 10, 5, 6, 8);
        //City mallorca = new City("Mallorca", true, false, true, 2, 7, 9, 2);

    }
}
