package com.swoop.swoop;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mapping.Carpool;

import java.util.ArrayList;

/**
 * RequestedSwoopsFragment
 *
 * @author Yarely Chino
 * @version 1.0
 */

public class RequestedSwoopsFragment extends Fragment implements View.OnClickListener{

    private ArrayList<Carpool> requestedCarpools = new ArrayList<Carpool>();

    public RequestedSwoopsFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.requested_swoops_fragment, container, false);

        // Inflate the layout for this fragment
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

        }
    }

}