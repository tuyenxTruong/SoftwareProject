package com.example.tuyen.TempleFoodSelector;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Randomizer extends AppCompatActivity {
    final String[] places = {
            "VeganTree", "Tommy's", "Tabeteki", "Korea House", "Halal Kebab King", "El Guaco Loco",
            "Burger Tank","The Creperie Truck","Ray's Truck","Top Bap","Samosa Deb",
            "Honey","Richie's LunchBox","Natasha's Caribbean Cafe","Foot Long","Brother's Pizza",
            "Philly Fellas Gyro Halal","TJ's Corner","Simply Yummy","Jamaican D's","Cha Cha","","Chop Chop",
            "Kobawoo Express","Chicken Heaven","E&E Gourmet Express","Eppy's Truck","Ernie's","Sexy Green Truck",
            "Eddie's","Sunny Halal Food","Caribbean Feast","Ebi's Lunch Truck (Halal)","Famous NY Gyro (Halal)",
            "Halal Gyro Express","Mexican Grill Stand","Mountain Pizza",
    };
    Button maps;
    Button randomize;
    TextView place;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randomize2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final int[] randomPosition = new int[1]; // Add this

        place = (TextView) findViewById(R.id.place);

        final Random random = new Random();
        randomPosition[0] = random.nextInt(places.length);
        place.setText(places[randomPosition[0]]);

        maps = (Button) findViewById(R.id.maps);
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String randomRestaurant = places[randomPosition[0]];

                Intent showMap = new Intent(Randomizer.this, RestaurantMaps.class);
                showMap.putExtra(RestaurantMaps.EXTRA_SELECTED_RESTAURANT,
                        randomRestaurant);
                startActivity(showMap);
            }
        });

        randomize = (Button) findViewById(R.id.randomize);
        randomize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomPosition[0] = random.nextInt(places.length);
                place.setText(places[randomPosition[0]]);
            }
        });



    }
}


