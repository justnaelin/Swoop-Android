package com.swoop.swoop;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mapping.Carpool;
import com.mapping.CarpoolStatus;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * MySwoopsFragment
 *
 * @author Yarely Chino
 * @author NaelinAquino
 * @version 1.0
 */

public class MySwoopsFragment extends Fragment implements View.OnClickListener {

    private ListView mCarpoolListView;


    public MySwoopsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.my_swoops_fragment, container, false);

        // Inflate the list layout defined in XML
        mCarpoolListView = (ListView) view.findViewById(R.id.my_swoops_list_view);

        // Create and set RequestedSwoopsAdapter for the ListView.
        CarpoolAdapter adapter = new CarpoolAdapter(this.getActivity());
        mCarpoolListView.setAdapter(adapter);

        CarpoolAdapterSingleton.destroySingleton();

        // Instantiate and execute data retrieval using singleton
        CarpoolAdapterSingleton requestedCarpoolData = CarpoolAdapterSingleton.getInstance(adapter);
        requestedCarpoolData.executeCreatedCarpoolByUser();


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