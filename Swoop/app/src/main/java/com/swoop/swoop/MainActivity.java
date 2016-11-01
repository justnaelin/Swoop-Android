package com.swoop.swoop;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mCreateSwoopButton, mSwoopButton, mNotificationButton, mNewSwoops;
    private ListView mDrawerList;
    private RelativeLayout mDrawerPanel;
    private DrawerLayout mDrawerLayout;
    private ArrayList<DrawerItem> mDrawerItems = new ArrayList<DrawerItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCreateSwoopButton = (Button) findViewById(R.id.create_swoop_button);
        mSwoopButton = (Button) findViewById(R.id.swoop_button);
        mNotificationButton = (Button) findViewById(R.id.notification_button);
        mNewSwoops = (Button) findViewById(R.id.new_swoops_button);

        mCreateSwoopButton.setOnClickListener(this);
        mSwoopButton.setOnClickListener(this);
        mNotificationButton.setOnClickListener(this);
        mNewSwoops.setOnClickListener(this);


        //All Drawer Navigation Items initialized
        mDrawerItems.add(new DrawerItem(getString(R.string.drawer_list_title_0), getString(R.string.drawer_list_title_0), R.mipmap.ic_launcher));
        mDrawerItems.add(new DrawerItem(getString(R.string.drawer_list_title_1), getString(R.string.drawer_list_title_1), R.mipmap.ic_launcher));
        mDrawerItems.add(new DrawerItem(getString(R.string.drawer_list_title_2), getString(R.string.drawer_list_title_2), R.mipmap.ic_launcher));
        mDrawerItems.add(new DrawerItem(getString(R.string.drawer_list_title_3), getString(R.string.drawer_list_title_3), R.mipmap.ic_launcher));
        mDrawerItems.add(new DrawerItem(getString(R.string.drawer_list_title_4), getString(R.string.drawer_list_title_4), R.mipmap.ic_launcher));


        // Initializing DrawerLayout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        // Populate the Navigation Drawer with options
        mDrawerPanel = (RelativeLayout) findViewById(R.id.drawerPane);
        mDrawerList = (ListView) findViewById(R.id.navList);

        //Adapter for the Drawer List
        DrawerListAdapter adapter = new DrawerListAdapter(this, mDrawerItems);
        mDrawerList.setAdapter(adapter);

        // Drawer Item click listener
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemSelectedFromDrawer(position);
            }
        });

    }

    void createToast(String s) {
        Toast toast = Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT);
        toast.show();
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
                createToast("Swoop button was clicked");
                break;
            case R.id.notification_button:
                createToast("Notification button was clicked");
                break;
            case R.id.new_swoops_button:
                //createToast("New Swoop button was clicked");
                //break;
                Intent map_intent = new Intent(v.getContext(), CarpoolDetailPageActivity.class);
                startActivity(map_intent);

        }

    }


    /**
     * Called when a item  is selected from the navigation drawer
     *
     * @param //int position at where the item was selected from drawer
     */
    private void itemSelectedFromDrawer(int position) {

        /*Fragment fragment = new PreferencesFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.mainContent, fragment)
                .commit();
*/
        mDrawerList.setItemChecked(position, true);
        setTitle(mDrawerItems.get(position).mTitle);

        // Close the drawer
        mDrawerLayout.closeDrawer(mDrawerPanel);
    }

    //Inner class model to populate the Drawer Items
    class DrawerItem {
        String mTitle;
        String mSubtitle;
        int mIcon;

        public DrawerItem(String title, String subtitle, int icon) {
            mTitle = title;
            mSubtitle = subtitle;
            mIcon = icon;
        }
    }

    //Inner class to generate the list adapter
    class DrawerListAdapter extends BaseAdapter {

        Context mContext;
        ArrayList<DrawerItem> mDrawerItems;


        public DrawerListAdapter(Context context, ArrayList<DrawerItem> drawerItems) {
            mContext = context;
            mDrawerItems = drawerItems;
        }

        @Override
        public int getCount() {
            return mDrawerItems.size();
        }

        @Override
        public Object getItem(int position) {
            return mDrawerItems.get(position);
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
                view = inflater.inflate(R.layout.main_drawer_item, null);
            } else {
                view = convertView;
            }

            TextView titleView = (TextView) view.findViewById(R.id.title);
            TextView subtitleView = (TextView) view.findViewById(R.id.subTitle);
            ImageView iconView = (ImageView) view.findViewById(R.id.icon);

            titleView.setText(mDrawerItems.get(position).mTitle);
            subtitleView.setText(mDrawerItems.get(position).mSubtitle);
            iconView.setImageResource(mDrawerItems.get(position).mIcon);

            return view;
        }
    }

}
