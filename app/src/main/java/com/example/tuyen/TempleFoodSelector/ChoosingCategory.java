package com.example.tuyen.TempleFoodSelector;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ChoosingCategory extends AppCompatActivity {

    Button Halal;
    Button Asian;
    Button Hispanic;
    Button Caribbean;
    Button American;
    Button restaurant;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosing_category);

        restaurant = (Button) findViewById(R.id.restaurant);
        restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ChoosingCategory.this, RestaurantMaps.class);
                startActivity(intent);
            }
        });

        Halal = (Button) findViewById(R.id.Halal);
        Halal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ChoosingCategory.this, HalalRandom.class);
                startActivity(intent);
            }
        });

        Asian = (Button) findViewById(R.id.AsianButton);
        Asian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ChoosingCategory.this, AsianRandom.class);
                startActivity(intent);
            }
        });

        Hispanic = (Button) findViewById(R.id.HispanicButton);
        Hispanic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ChoosingCategory.this, HispanicRandom.class);
                startActivity(intent);
            }
        });

        Caribbean = (Button) findViewById(R.id.CaribbeanButton);
        Caribbean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ChoosingCategory.this, CarribeanRandom.class);
                startActivity(intent);
            }
        });

        American = (Button) findViewById(R.id.AmericanButton);
        American.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ChoosingCategory.this, AmericanRandom.class);
                startActivity(intent);
            }
        });



    }


}
