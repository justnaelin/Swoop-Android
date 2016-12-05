package com.swoop.swoop;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * ProfileFragment
 *
 * @author Naelin Aquino
 * @version 1.0
 */

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ProfileFragment extends Fragment implements View.OnClickListener{

    private Button mHamburgerButton;
    private TextView mFullNameTextView;
    private ImageView mProfilePhotoImageView;
    private ImageView mRatingImageView;
    private TextView mRatingTextView;
    private TextView mPhoneNumberTextView;
    private TextView mEmailTextView;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.profile_fragment, container, false);

        mHamburgerButton = (Button) view.findViewById(R.id.hamburger_button2);
        mHamburgerButton.setOnClickListener(this);

        mFullNameTextView = (TextView) view.findViewById(R.id.name_text_view);
        mProfilePhotoImageView = (ImageView) view.findViewById(R.id.profile_image);
        mRatingImageView = (ImageView) view.findViewById(R.id.ratings_image_view);
        mRatingTextView = (TextView) view.findViewById(R.id.rating_text_view);
        mPhoneNumberTextView = (TextView) view.findViewById(R.id.phone_number_text_view);
        mEmailTextView = (TextView) view.findViewById(R.id.email_text_view);
        populateViews(view);

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

    public void populateViews(View view) {


        if(UserSingleton.getInstance() != null) {
            mFullNameTextView.setText(UserSingleton.firstName + " " + UserSingleton.lastName);
            mRatingTextView.setText(String.valueOf(UserSingleton.averageRating));
            mPhoneNumberTextView.setText(UserSingleton.phoneNumber);
            Log.d("ProfileFragment", UserSingleton.phoneNumber.toString());
            mEmailTextView.setText(UserSingleton.emailAddress);

            Log.d("ProfileFragment", UserSingleton.photoUrl.toString());
            Picasso.with(view.getContext()).load(UserSingleton.photoUrl).placeholder(R.mipmap.ic_launcher).into(mProfilePhotoImageView);
        }
    }

}