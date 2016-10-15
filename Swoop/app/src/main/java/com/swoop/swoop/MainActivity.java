package com.swoop.swoop;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton createSwoopImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createSwoopImageButton = (ImageButton) findViewById(R.id.createSwoopButton);
        createSwoopImageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //create a intent
                Intent intent = new Intent(v.getContext(), CreateCarpoolActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onClick(View v) {

    }

}
