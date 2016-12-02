package com.swoop.swoop;

import android.content.Context;
import android.location.Address;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mapping.Carpool;
import com.rest.InputUtility;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by naelin on 11/27/16.
 */

public class CarpoolAdapter extends BaseAdapter {
    private Context mContext;
    private List<Carpool> mCarpools = new ArrayList<Carpool>();

    public CarpoolAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return mCarpools.size();
    }

    @Override
    public Object getItem(int position) {
        return mCarpools.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item_carpool, null);
        } else {
            view = convertView;
        }



        // Get carpool date element
        TextView mDate = (TextView) view.findViewById(R.id.carpool_date);

        // Get carpool end location element
        TextView  mEndLocation = (TextView) view.findViewById(R.id.carpool_end_location);

        // Get start location element
        TextView  mStartLocation = (TextView) view.findViewById(R.id.carpool_start_location);

        // Get thumbnail element
        ImageView thumbnailImageView = (ImageView) view.findViewById(com.swoop.swoop.R.id.user_photo);

        Carpool carpool = (Carpool) getItem(position);
        List<Address> startLocation = InputUtility.reverseGeo(carpool.getStartLocation(), mContext);
        List<Address> endLocation  = InputUtility.reverseGeo(carpool.getEndLocation(), mContext);

        if(startLocation != null && endLocation != null){
            mStartLocation.setText(startLocation.get(0).getThoroughfare() +", "+  startLocation.get(0).getLocality() +", "+  startLocation.get(0).getAdminArea());
            mEndLocation.setText(endLocation.get(0).getThoroughfare() +", "+  endLocation.get(0).getLocality() +", "+  endLocation.get(0).getAdminArea());
        }

        mDate.setText(carpool.getTimeStamp());

        // Load photo from url on another thread
        Picasso.with(mContext).load("https://cdn1.iconfinder.com/data/icons/user-pictures/100/unknown-256.png").placeholder(R.mipmap.ic_launcher).into(thumbnailImageView);


        return view;
    }


    public void upDateEntries(List<Carpool> entries) {
        mCarpools = entries;
        notifyDataSetChanged();
    }

}

