package com.swoop.swoop;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.rest.InputUtility;
import com.mapping.CarpoolStatus;
import com.service.CarpoolService;
import android.util.Log;

import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.common.api.Status;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * CreateCarpoolActivity
 *
 * @author Yarely Chino
 * @author karinapizano
 * @version 1.0
 */


public class CreateCarpoolActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mInputRate, mInputMaxPeople;
    private Button mSubmitButton, mButtonDatePicker, mButtonTimePicker;
    private ProgressDialog mProgressDialog;
    private TextView mTxtDate, mTxtTime;
    private RadioGroup mRadioGroup;

    //Google Places
    private PlaceAutocompleteFragment locationFragment;
    private PlaceAutocompleteFragment destinationFragment;
    private String mLocation;
    private String mDestination;
    private static final String TAG = "CreateCarpoolActivity";
    private String userLocations;

    // Start with the RadioButtonDriver clicked
    private boolean isDriver = true;


    /**
     * Initializing CreateCarPoolActivity
     *
     * @paramBundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_carpool);

        setTitle(getString(R.string.create_carpool_name));
        mProgressDialog = new ProgressDialog(this);

        // Set progress Dialog to False
        mProgressDialog.setMessage("Please wait...");
        mProgressDialog.setCancelable(false);
        initializeAll();



    }
    /**
     * Initializes all user interactive tools. (Buttons, Pickers, Locations .. )
     */

    private void initializeAll(){

        mSubmitButton = (Button) findViewById(R.id.submit_button);
        mButtonDatePicker = (Button) findViewById(R.id.button_date);
        mButtonTimePicker = (Button) findViewById(R.id.button_time);
        mTxtDate = (TextView) findViewById(R.id.in_date);
        mTxtTime = (TextView) findViewById(R.id.in_time);

        mRadioGroup = (RadioGroup) findViewById(R.id.radio_group);

        mRadioGroup.check(R.id.radio_driver);

        mSubmitButton.setOnClickListener(this);
        mRadioGroup.setOnClickListener(this);
        mButtonDatePicker.setOnClickListener(this);
        mButtonTimePicker.setOnClickListener(this);

        //Get users locations.
        locationFragment = (PlaceAutocompleteFragment)getFragmentManager()
                .findFragmentById(R.id.location_input);

        destinationFragment = (PlaceAutocompleteFragment) getFragmentManager()
                .findFragmentById(R.id.destination_input);
        mLocation = getUsersLocations(locationFragment);
        mDestination = getUsersLocations(destinationFragment);
    }
    /**
     * Gets users location using the places API.
     */

    private String getUsersLocations(PlaceAutocompleteFragment fragment){

        fragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                userLocations = place.getLatLng().toString().replace("(", "")
                        .replace(")", "").substring(9);
                Log.i(TAG, "Place:" + userLocations);
            }

            @Override
            public void onError(Status status) {
                Log.i(TAG, "Error occurred:" + status);
            }
        });

        return userLocations;
    }

    /**
     * Checks for input carpool validation
     *
     * @return true if all information is not empty, false if any fields are emtpy
     */
    public boolean checkEmptyFields() {

        mInputRate = (EditText) findViewById(R.id.input_rate);
        mInputMaxPeople = (EditText) findViewById(R.id.input_max_people);

        if (InputUtility.isNotNull(mTxtDate.getText().toString()) &&
                InputUtility.isNotNull(mTxtTime.getText().toString()) &&
                mLocation != null &&
                mDestination != null &&
                InputUtility.isNotNull(mInputRate.getText().toString()) &&
                InputUtility.isNotNull(mInputMaxPeople.getText().toString()) &&
                InputUtility.isNotNegative(mInputRate.getText().toString()) &&
                InputUtility.isNotNegative(mInputMaxPeople.getText().toString())) {
            return true;
        } else {

            createToast("Please enter all fields");
            return false;
        }
    }

    void createToast(String s) {
        Toast toast = Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT);
        toast.show();
    }



    /**
     * Implementation for View.onClickListener
     *
     * @param
     */
    @Override
    public void onClick(View v) {

        // Check what was clicked
        switch (v.getId()) {
            case R.id.button_date:
                getDate();
                break;
            case R.id.button_time:
                getTime();
                break;
            case R.id.submit_button:
                serviceVerify();
                break;
            case R.id.radio_passanger:
                isDriver = false;
                break;
            case R.id.radio_driver:
                isDriver = true;
                break;
        }

    }


    private void getDate(){
        // Get Current Date
        final Calendar date = Calendar.getInstance();

        // Create a Date Picker Dialog with onDateSet method
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        mTxtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH));

        // Launch Date Picker Dialog
        datePickerDialog.show();
    }

    private void getTime(){
        // Get Current Time
        final Calendar time = Calendar.getInstance();

        // Create a Time Picker Dialog with onDateSet method
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
                        mTxtTime.setText(hourOfDay + ":" + minute);
                    }
                }, time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE), false);

        // Launch Time Picker Dialog
        timePickerDialog.show();

    }

    private void serviceVerify(){

        if (checkEmptyFields()) {

            String response = CarpoolService.verifyCreate(
                    mLocation,
                    mDestination,
                    mTxtDate.getText().toString() + " , " + mTxtTime.getText().toString(),
                    mInputRate.getText().toString(),
                    mInputMaxPeople.getText().toString(),
                    CarpoolStatus.PENDING,
                    isDriver);
            createToast(response);
        }

    }


}
