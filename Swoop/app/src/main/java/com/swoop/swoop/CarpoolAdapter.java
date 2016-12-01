package com.swoop.swoop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mapping.Carpool;
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


        // Get title element
        TextView titleTextView =
                (TextView) view.findViewById(com.swoop.swoop.R.id.carpool_list_title);

        // Get subtitle element
        TextView subtitleTextView =
                (TextView) view.findViewById(com.swoop.swoop.R.id.carpool_list_subtitle);

        // Get detail element
        TextView detailTextView =
                (TextView) view.findViewById(com.swoop.swoop.R.id.carpool_list_detail);

        // Get thumbnail element
        ImageView thumbnailImageView =
                (ImageView) view.findViewById(com.swoop.swoop.R.id.user_photo);

        Carpool carpool = (Carpool) getItem(position);

        titleTextView.setText(carpool.getStartLocation());
        subtitleTextView.setText(carpool.getEndLocation());
        detailTextView.setText(carpool.getTimeStamp());

        // Load photo from url on another thread
        Picasso.with(mContext).load("https://cdn1.iconfinder.com/data/icons/user-pictures/100/unknown-256.png").placeholder(R.mipmap.ic_launcher).into(thumbnailImageView);


        return view;
    }


    public void upDateEntries(List<Carpool> entries) {
        mCarpools = entries;
        notifyDataSetChanged();
    }
}

