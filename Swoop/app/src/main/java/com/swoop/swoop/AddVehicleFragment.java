package com.swoop.swoop;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by ychino on 12/1/16.
 */

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class AddVehicleFragment extends Fragment implements View.OnClickListener{

    private Button mHamburgerButton;
    private TextView mFullNameTextView;
    private ImageView mProfilePhotoImageView;
    private ImageView mRatingImageView;
    private TextView mRatingTextView;

    public AddVehicleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.add_vehicle_fragment, container, false);

        mHamburgerButton = (Button) view.findViewById(R.id.hamburger_button2);
        mHamburgerButton.setOnClickListener(this);


        return view;
    }

    /**
     * Implementation for View.onClickListener
     *
     * @param //View v
     */
    @Override
    public void onClick(View v) {

        // Check what was clicked
        switch (v.getId()) {
            case R.id.hamburger_button2:
                // Open navigation drawer
                ((MainActivity)getActivity()).openDrawer();
        }
    }



}
