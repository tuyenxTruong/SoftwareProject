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

public class AmericanMaps extends FragmentActivity implements OnMapReadyCallback {
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
        mPlaces.put("Tommy's", new LatLng(39.98304, -75.15545));
        mPlaces.put("Burger Tank", new LatLng(39.98292, -75.15452));
        mPlaces.put("The Creperie Truck", new LatLng(39.98291, -75.1544));
        mPlaces.put("Ray's Truck", new LatLng(39.9829, -75.15428));
        mPlaces.put("Honey", new LatLng(39.98253, -75.15324));
        mPlaces.put("Richie's LunchBox", new LatLng(39.98279, -75.15345));
        mPlaces.put("Foot Long", new LatLng(39.98227, -75.15329));
        mPlaces.put("Brother's Pizza", new LatLng(39.98201, -75.15335));
        mPlaces.put("TJ's Corner", new LatLng(39.98016, -75.15729));
        mPlaces.put("Chicken Heaven", new LatLng(39.98001, -75.15606));
        mPlaces.put("E&E Gourmet Express", new LatLng(39.97999, -75.15594));
        mPlaces.put("Eppy's Truck", new LatLng(39.9799, -75.1552));
        mPlaces.put("Ernie's", new LatLng(39.97996, -75.1557));
        mPlaces.put("Sexy Green Truck", new LatLng(39.97986, -75.1549));
        mPlaces.put("Eddie's", new LatLng(39.97984, -75.15474));
        mPlaces.put("Mountain Pizza", new LatLng(39.97933, -75.15086));

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