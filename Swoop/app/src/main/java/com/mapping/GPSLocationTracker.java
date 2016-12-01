package com.mapping;
import android.app.Service;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.os.IBinder;
import android.content.Intent;
import android.app.AlertDialog;
import android.support.v7.view.ContextThemeWrapper;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import com.swoop.swoop.MainActivity;
import android.Manifest;

import static android.support.v4.app.ActivityCompat.requestPermissions;

/**
 * @author karinapizano
 * @version 1.0
 */

public class GPSLocationTracker extends Service implements LocationListener {

    /**
     * context of calling class
     */
    private Context mContext;
    private static final int MY_PERMISSION_ACCESS_COARSE_LOCATION = 11;

    // GPS, Network Status
    private boolean isGpsEnabled = false;
    private boolean isNetworkEnabled = false;

    // User GPS Location Status
    private boolean canGetLocation = false;

    // Location & Latitude & Longitude
    private Location mLocation;
    private double mLatitude;
    private double mLongitude;

    // Minmum distance and time (1 minute) to get a location update.
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATE = 10;
    private static final long MIN_TIME_FOR_UPDATE = 60000;

    // Location Manager
    private LocationManager mLocationManager;


    /**
     * @param mContext constructor of the class
     */
    public GPSLocationTracker(Context mContext) {

        this.mContext = mContext;
        getLocation();
    }


    /**
     * @return location
     */
    public Location getLocation() {

        String TAG = "GPS Location Tracker";
        try {
            //TAG

            mLocationManager = (LocationManager) mContext.getSystemService(LOCATION_SERVICE);
            /*getting status of the gps*/
            isGpsEnabled = mLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            /*getting status of network provider*/
            isNetworkEnabled = mLocationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            /**
             * Cannot get users location.
             * TODO: More Assertions and what to do if we cannot.
             */
            if (!isGpsEnabled && !isNetworkEnabled) {

                Log.i(TAG, " GPS and Network is not enabled.");
            } else {

                if (!isGpsEnabled) {
                    Log.i(TAG, "GPS is not enabled");
                }
                if (!isNetworkEnabled) {
                    Log.i(TAG, "Network is not enabled");
                }
                this.canGetLocation = true;

                /**
                 * If network, we get the location using it.
                 */
                if (isNetworkEnabled) {
                    mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                            MIN_TIME_FOR_UPDATE, MIN_DISTANCE_CHANGE_FOR_UPDATE, this);
                    Log.d("Network", "Network");

                    if (mLocationManager != null) {
                        mLocation = mLocationManager
                                .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        if (mLocation != null) {
                            mLatitude = mLocation.getLatitude();
                            mLongitude = mLocation.getLongitude();
                        }
                    }
                }
                if (isGpsEnabled) {

                    /**
                     * Ask user for permission to Enable their GPS.
                     */
                    if (mLocation == null) {
                        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(mContext,Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                            requestPermissions((MainActivity)mContext, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSION_ACCESS_COARSE_LOCATION);
                        }
                        mLocationManager.requestLocationUpdates(
                                LocationManager.GPS_PROVIDER,
                                MIN_TIME_FOR_UPDATE,
                                MIN_DISTANCE_CHANGE_FOR_UPDATE, this);
                        Log.d("GPS Enabled", "GPS Enabled");
                        if (mLocationManager != null) {
                            mLocation = mLocationManager
                                    .getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            if (mLocation != null) {
                                mLatitude = mLocation.getLatitude();
                                mLongitude = mLocation.getLongitude();
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mLocation;
    }

    /**
     *
     *
     */
    @Override
    public void onLocationChanged(Location location) {
    }

    @Override
    public void onProviderDisabled(String provider) {
    }

    @Override
    public void onProviderEnabled(String provider) {
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    /**
     * Function to get latitude
     * */
    public double getLatitude(){
        if(mLocation != null){
            mLatitude = mLocation.getLatitude();
        }

        // return latitude
        return mLatitude;
    }

    /**
     * Function to get longitude
     * */
    public double getLongitude(){
        if(mLocation != null){
            mLongitude = mLocation.getLongitude();
        }

        // return longitude
        return mLongitude;
    }

    /**
     * Function to check if best network provider
     * @return boolean
     * */
    public boolean canGetLocation() {
        return this.canGetLocation;
    }

    /**
     * Function to show settings alert dialog
     * */
    public void showSettingsAlert(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);

        // Setting Dialog Title
        alertDialog.setTitle("GPS is settings");

        // Setting Dialog Message
        alertDialog.setMessage("GPS is not enabled. Do you want to go to settings menu?");

        // Setting Icon to Dialog
        //alertDialog.setIcon(R.drawable.delete);

        // On pressing Settings button
        alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                mContext.startActivity(intent);
            }
        });

        // on pressing cancel button
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        // Showing Alert Message
        alertDialog.show();
    }

}