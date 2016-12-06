package com.swoop.swoop;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.mapping.Carpool;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.rest.InputUtility;

import org.w3c.dom.Text;

public class CarpoolDetailPageActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private TextView mTextViewLocation;
    private TextView mTextViewDestination;
    private TextView mTextViewPrice;
    private TextView mTextViewName;
    private TextView mTextViewSeats;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carpool_detail_page);
        Carpool c = (Carpool)getIntent().getSerializableExtra("carpool");
        mTextViewDestination = (TextView)findViewById(R.id.destination_detail);
        mTextViewLocation = (TextView)findViewById(R.id.location_detail);
        mTextViewName = (TextView)findViewById(R.id.name_detail);
        mTextViewPrice = (TextView)findViewById(R.id.price_detail);
        mTextViewSeats = (TextView)findViewById(R.id.seats_detail);

        Log.i("SEATS", String.valueOf((int)c.getNumberOfPassengers()));

        //String start= InputUtility.reverseGeo(c.getStartLocation(), getApplicationContext());
        mTextViewLocation.setText(c.getStartLocation());
        mTextViewDestination.setText(c.getEndLocation());
        mTextViewName.setText("User name");
        mTextViewPrice.setText(String.valueOf((int) c.getRate()));
        mTextViewSeats.setText(String.valueOf((int)c.getNumberOfPassengers()));




        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(36.6544, 121.8018);
        mMap.addMarker(new MarkerOptions().position(sydney).title("CSUMB"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng((sydney) , 14.4));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new
                LatLng(36.65444970000001,-121.80175999999999), 16.0f));
    }
}
