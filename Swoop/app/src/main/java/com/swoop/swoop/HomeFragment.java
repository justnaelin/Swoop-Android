package com.swoop.swoop;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * HomeFragment
 *
 * @author Yarely Chino
 * @version 1.0
 */

public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button mCreateSwoopButton, mSwoopButton, mMySwoopButton, mRequestedSwoops, mHamburgerButton;
    private Fragment fragment;
    private DrawerLayout mDrawerLayout;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_fragment, container, false);
        initiateDrawerItems(view);

        /**
         *  Make sure we get the users current location
         *  TODO: Use the users location to map all swoops 50miles away.
         */

        /**
         *  TODO: Later add filters (Start location, End Location)
         */


        fragment = new SwoopsFragment();
        getFragmentManager().beginTransaction()
                .replace(R.id.home_fragment_container, fragment)
                .commit();


        // Inflate the layout for this fragment
        return view;
    }

    private void initiateDrawerItems(View view) {
        mCreateSwoopButton = (Button) view.findViewById(R.id.create_swoop_button);
        mSwoopButton = (Button) view.findViewById(R.id.swoop_button);
        mMySwoopButton = (Button) view.findViewById(R.id.my_swoops_button);
        mRequestedSwoops = (Button) view.findViewById(R.id.requested_swoops_button);
        mHamburgerButton = (Button) view.findViewById(R.id.hamburger_button);

        mCreateSwoopButton.setOnClickListener(this);
        mSwoopButton.setOnClickListener(this);
        mMySwoopButton.setOnClickListener(this);
        mRequestedSwoops.setOnClickListener(this);
        mHamburgerButton.setOnClickListener(this);
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
            case R.id.create_swoop_button:
                Intent intent = new Intent(v.getContext(), CreateCarpoolActivity.class);
                startActivity(intent);
                break;
            case R.id.swoop_button:
                Intent intent_map = new Intent(v.getContext(), CarpoolDetailPageActivity.class);
                startActivity(intent_map);
                break;
            case R.id.my_swoops_button:
                fragment = new MySwoopsFragment();
                getFragmentManager().beginTransaction()
                        .replace(R.id.home_fragment_container, fragment)
                        .commit();
                break;
            case R.id.requested_swoops_button:
                fragment = new RequestedSwoopsFragment();
                getFragmentManager().beginTransaction()
                        .replace(R.id.home_fragment_container, fragment)
                        .commit();
                break;
            case R.id.hamburger_button:
                // Open navigation drawer
                ((MainActivity) getActivity()).openDrawer();

            default:
                break;

        }

    }


}