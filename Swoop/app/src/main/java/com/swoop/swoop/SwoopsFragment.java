package com.swoop.swoop;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;
import android.util.Log;
import android.widget.AdapterView;
import android.content.Intent;
import com.mapping.Carpool;

/**
 * SwoopsFragment
 *
 * @author Yarely Chino
 * @author karinapizano
 * @version 1.0
 */

public class SwoopsFragment extends Fragment implements View.OnClickListener {

    private ListView mCarpoolListView;
    public SwoopsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.swoops_fragment, container, false);
        mCarpoolListView = (ListView)view.findViewById(R.id.all_swoops_list);

        final CarpoolAdapter adapter = new CarpoolAdapter(this.getActivity());
        mCarpoolListView.setAdapter(adapter);

        CarpoolAdapterSingleton.destroySingleton();

        // Instantiate and execute data retrieval using singleton
        CarpoolAdapterSingleton requestedCarpoolData = CarpoolAdapterSingleton.getInstance(adapter);
        requestedCarpoolData.executeAllCarpools();

        mCarpoolListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
           Carpool carpoolToBeSent;

            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                carpoolToBeSent = (Carpool)adapter.getItem(position);
                Log.i("CARPOOL","end Location: " +  carpoolToBeSent.getEndLocation().toString()
                        + "\nStart Loc: " + carpoolToBeSent.getStartLocation() + "/nPassengers: "
                + carpoolToBeSent.getNumberOfPassengers() + "\nPrice: " + carpoolToBeSent.getRate());


                Intent intent = new Intent(getActivity(), CarpoolDetailPageActivity.class);
                intent.putExtra("carpool", carpoolToBeSent);
                startActivity(intent);
            }
        });

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