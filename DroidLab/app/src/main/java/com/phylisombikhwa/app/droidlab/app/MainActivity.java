package com.leinasharon.app.droidlab.app;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MainActivity extends AppCompatActivity {
    //declaring google map
    private GoogleMap googleMap;
    private MarkerOptions markerOptions;
    double latitude;
    double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialising google Maps
        googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.mapFragment)).getMap();

        markerOptions = new MarkerOptions().position(new LatLng(latitude, longitude)).title("Nairobi");
        //set marker icon
        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.powered_by_google_light));

        //animate

        CameraPosition cameraPosition = new CameraPosition.Builder().target(
                new LatLng(17.385044, 78.486671)).zoom(12).build();

        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));


        //enabling application location
        googleMap.setMyLocationEnabled(true);

        // Enabling zooming gestures but by default is true
        googleMap.getUiSettings().setZoomGesturesEnabled(false);

        //Enabling compass
        googleMap.getUiSettings().setCompassEnabled(true);

        //add the marker to the map
        googleMap.addMarker(markerOptions);


        //Button onclick to do some action for different type of maps
         //setting types of maps

//       Button mapButton = (Button) findViewById(R.id.mapFragment);
//        mapButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View m) {
//                switch (m.getId()){
//                    case R.id.normal:
//                        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
//                        break;
//                    case R.id.satellite:
//                        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
//                        break;
//                    case R.id.terrain:
//                        googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
//                        break;
//                    case R.id.hybrid:
//                        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
//                        break;
//                }
//                // Loading Google Map View
//                //startService(new Intent(MainActivity.this, NormalMapView.class));
//            }
//
//
//        });
    }

    public void onclick(View v){
        switch (v.getId()){
            case R.id.MapNormal:
                Toast.makeText(MainActivity.this,"Map Normal",Toast.LENGTH_SHORT).show();
                break;
            case R.id.MapSatellite:
                googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;

        }
    }
    //setting types of maps
   /* protected final int[]
            MAP_TYPES = { GoogleMap.MAP_TYPE_TERRAIN,
            GoogleMap.MAP_TYPE_NORMAL,
            GoogleMap.MAP_TYPE_HYBRID,
            GoogleMap.MAP_TYPE_TERRAIN,
            GoogleMap.MAP_TYPE_NONE };
    private int curMapTypeIndex = 0;*/
}


