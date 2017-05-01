package com.example.tuyen.TempleFoodSelector;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Map;
import java.util.TreeMap;

public class HispanicMaps extends FragmentActivity implements OnMapReadyCallback {
    public static final String EXTRA_SELECTED_RESTAURANT = "EXTRA_SELECTED_RESTAURANT";
    private Map<String, LatLng> mPlaces = new TreeMap<>();


    private GoogleMap mMap;
    private String mSelectedRestaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

// Places to show in the map... Could also be in a database instead.
        mPlaces.put("El Guaco Loco", new LatLng(39.98312, -75.15465));
        mPlaces.put("Mexican Grill Stand", new LatLng(39.97952, -75.1555));

        // Get the data passed to this Activity
        Intent from = getIntent();
        if (from != null)
            mSelectedRestaurant = from.getStringExtra(EXTRA_SELECTED_RESTAURANT); //is the text to search for
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Show the place passed to this activity
        if (mSelectedRestaurant != null) {

            LatLng center = new LatLng(39.98141, -75.1556);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(center, (float) 18.5));

            LatLng location = mPlaces.get(mSelectedRestaurant);
            mMap.addMarker(new MarkerOptions().position(location).title(mSelectedRestaurant));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(location));

        }

    }
}