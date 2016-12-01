package com.swoop.swoop;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * RequestedSwoopsFragment
 *
 * @author Yarely Chino
 * @version 1.0
 */

public class RequestedSwoopsFragment extends Fragment implements View.OnClickListener {

    private ListView mRequestedListView;

    public RequestedSwoopsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.requested_swoops_fragment, container, false);

        // Inflate the list layout defined in XML
        mRequestedListView = (ListView) view.findViewById(R.id.requested_swoops_list_view);

        // Create and set RequestedSwoopsAdapter for the ListView.
        CarpoolAdapter adapter = new CarpoolAdapter(this.getActivity());
        mRequestedListView.setAdapter(adapter);

        CarpoolAdapterSingleton.destroySingleton();

        // Instantiate and execute data retrieval using singleton
        CarpoolAdapterSingleton requestedCarpoolData = CarpoolAdapterSingleton.getInstance(adapter);
        requestedCarpoolData.executeRequestedCarpoolByUser();

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