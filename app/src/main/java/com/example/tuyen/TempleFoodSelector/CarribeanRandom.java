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

public class CarribeanRandom extends AppCompatActivity {
    final String[] places = {
            "Natasha's Caribbean Cafe",
            "Jamaican D's",
            "Caribbean Feast",

    };
    Button maps;
    Button randomize;
    TextView place;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halalrandom);
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

                Intent showMap = new Intent(CarribeanRandom.this, CaribbeanMaps.class);
                showMap.putExtra(CaribbeanMaps.EXTRA_SELECTED_RESTAURANT,
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


