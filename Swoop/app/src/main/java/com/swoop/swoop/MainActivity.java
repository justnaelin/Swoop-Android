package com.swoop.swoop;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.*;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.*;
import com.amazonaws.services.dynamodbv2.model.*;
import com.mapping.Carpool;
import com.mapping.Review;
import com.mapping.User;
import com.mapping.Notification;


public class MainActivity extends AppCompatActivity {

    private Button databaseButon;
    private CognitoCachingCredentialsProvider credentialsProvider;
    private AmazonDynamoDBClient ddbClient;
    private DynamoDBMapper mapper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the Amazon AWS Cognito credentials provider
        credentialsProvider = new CognitoCachingCredentialsProvider(
                getApplicationContext(),
                "us-west-2:16a412e8-b5eb-49f0-9bfc-78c6c5ecad1c", // Identity Pool ID
                Regions.US_WEST_2 // Region
        );

        //Instantiate a DynamoDB client using the credentialsProvider
        ddbClient = new AmazonDynamoDBClient(credentialsProvider);

        ddbClient.setRegion(Region.getRegion(Regions.US_WEST_2));  // Add correct Region. In my case its EU_WEST_1

        //DynamoDB Object Mapper to map a client-side class to our database
        mapper = new DynamoDBMapper(ddbClient);

        databaseButon = (Button) findViewById(R.id.databaseButton);
        databaseButon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                databaseConnection(v);
            }
        });
    }

    public void databaseConnection(View v){

        Context context = v.getContext();
        Toast.makeText(context, "Button was clicked", Toast.LENGTH_SHORT).show();

        final Runnable runnable = new Runnable() {
            public void run() {
                //DynamoDB calls go here
                Log.d("MainActivity", "Inside new Runnable Thread");


                Carpool carRetrieved = mapper.load(Carpool.class, "123A");//retreived car with id 123A
                Log.d("MainActivity", "ID: " + carRetrieved.getId() + " " + carRetrieved.getRate());

               /* User user1 = new User();
                user1.setUserId("0119");
                user1.setAverageRating(22.5);
                user1.setBirthday("02/10/1994");
                user1.setName("Ana");
                user1.setLastName("Perez");
                user1.setPhoneNumber("8317376598");
                mapper.save(user1);
                */

               // Carpool carRetrieved = mapper.load(Carpool.class, "123A");//retrieved car with id 123A
               // User userRetrieved = mapper.load(User.class, "1234"); //retrieved user with id 1234
                //Notification notificationRetrieved = mapper.load(Notification.class, "1237");
               // Log.d("MainActivity", "ID: " + carRetrieved.getId() + " " + carRetrieved.getRate());
                //Log.d("MainActivity", "ID: " + notificationRetrieved.getNotificationId() + " " + notificationRetrieved.getCarpoolId());
               // Log.d("MainActivity", "ID: " + userRetrieved.getUserId() +  " " + userRetrieved.getBirthday());

                Review reviewRetrieved = mapper.load(Review.class, "123A");//retreived car with id 123A
                Log.d("MainActivity", "ID: " + reviewRetrieved.getRevieweeId() + " " + reviewRetrieved.getComments());


            }
        };
        Thread mythread = new Thread(runnable);
        mythread.start();

    }
}
