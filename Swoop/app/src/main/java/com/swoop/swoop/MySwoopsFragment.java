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

/**
 * MySwoopsFragment
 *
 * @author Yarely Chino
 * @author NaelinAquino
 * @version 1.0
 */

public class MySwoopsFragment extends Fragment implements View.OnClickListener{

    private ListView mListView;

    public MySwoopsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.my_swoops_fragment, container, false);

        mListView = (ListView) view.findViewById(R.id.my_swoops_list_view);

        final ArrayList<Carpool> carpoolList = getCarpoolsFromFile("carpools.json", view.getContext());

        CarpoolAdapter adapter = new CarpoolAdapter(view.getContext(), carpoolList);
        mListView.setAdapter(adapter);

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

    public static ArrayList<Carpool> getCarpoolsFromFile(String filename, Context context) {
        final ArrayList<Carpool> carpoolList = new ArrayList<>();

        try {
            // Load data
            String jsonString = loadJsonFromAsset("carpools.json", context);
            JSONArray carpools = new JSONArray(jsonString);

            // Get Carpool objects from data
            for(int i = 0; i < carpools.length(); i++){
                Carpool carpool = new Carpool();

                carpool.setStartLocation(carpools.getJSONObject(i).getString("startLocation"));
                carpool.setEndLocation(carpools.getJSONObject(i).getString("endLocation"));
                carpool.setTimeStamp(carpools.getJSONObject(i).getString("requestDate"));


                carpoolList.add(carpool);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return carpoolList;
    }

    private static String loadJsonFromAsset(String filename, Context context) {
        String json = null;

        try {
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }
        catch (java.io.IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;
    }



}