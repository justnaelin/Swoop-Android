package com.swoop.swoop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.mapping.Carpool;

import java.util.ArrayList;

/**
 * RequestedSwoopsAdapter
 *
 * @author Yarely Chino
 * @version 1.0
 */


public class RequestedSwoopsAdapter extends BaseAdapter {

    private ArrayList<Carpool> requestedSwoopList;
    private Context mContext;
    private LayoutInflater layoutInflater;

    public RequestedSwoopsAdapter(){

    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.requested_swoops_listview, null);
        } else {
            view = convertView;
        }
        return null;
    }
}
