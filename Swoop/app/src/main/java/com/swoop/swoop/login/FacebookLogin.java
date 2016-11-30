package com.swoop.swoop.login;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.service.UserService;
import com.swoop.swoop.CreateUserActivity;
import com.swoop.swoop.MainActivity;
import com.swoop.swoop.R;

/**
 * Created by anaperez on 11/4/16.
 * Summary: Authentication for swoop users to login with Facebook.
 */
public class FacebookLogin extends Activity implements View.OnClickListener {
    private CallbackManager callbackManager;
    private TextView mTextDetails;
    private AccessTokenTracker accessTokenTracker;
    private ProfileTracker profileTracker;
    private LoginButton loginButton;
    private AccessToken accessToken;
    private Button skipLogin;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        setContentView(R.layout.facebook_login_activity);
        loginButton = (LoginButton) findViewById(R.id.login_button);
        callbackManager = CallbackManager.Factory.create();
        skipLogin = (Button) findViewById(R.id.skipLogin);
        skipLogin.setOnClickListener(this);
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    private ProfileTracker mProfileTracker;

                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Log.d("LOGIN_SUCCESS", "Success");
                        loginButton.setVisibility(View.INVISIBLE);
                        AccessToken accessToken = loginResult.getAccessToken();
                        //for right now this will send any user to the mainActivity without the creation of a new user.
                        //still working on handling that part
                        Log.d("GRANTED PERMISSIONS: ", loginResult.getRecentlyGrantedPermissions().toString());
                        Object[] object = loginResult.getRecentlyGrantedPermissions().toArray();
                        Log.d("OBJECT CONTENTS", object.toString());
                    /*    if(Profile.getCurrentProfile() == null) {
                            mProfileTracker = new ProfileTracker() {
                                @Override
                                protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                                    Log.d("PROFILE CHANGED: ", currentProfile.toString());
                                    Log.d("NAME: ", currentProfile.getFirstName());
                                    mProfileTracker.stopTracking();
                                }

                            };

                        }
                        else {
                            Profile profile = Profile.getCurrentProfile();
                            Log.v("facebook - profile", profile.getFirstName());
                        } */
                      /*  Profile profile = Profile.getCurrentProfile();
                        Log.d("PROFILE: ", profile.toString());
                        Log.d("NAME: ", profile.getFirstName());
                        Log.d("LastName: ", profile.getLastName());
                        Log.d("id: ", profile.getId());
                        Log.d("ID:", accessToken.getUserId()); */
                        if (UserService.isUser(accessToken.getUserId())) {
                            Intent intent = new Intent(getBaseContext(), MainActivity.class);
                            startActivity(intent);
                            finish();//<- IMPORTANT
                        } else {
                            Intent intent = new Intent(getBaseContext(), CreateUserActivity.class);
                            startActivity(intent);
                            finish();//<- IMPORTANT
                        }
                    }

                    @Override
                    public void onCancel() {
                        // App
                        Log.d("CANCEL", "cancelled logging in into app");
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        Log.d("ERROR onERROR:", exception.getStackTrace().toString());
                    }
                });

        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(
                    AccessToken oldAccessToken,
                    AccessToken currentAccessToken) {
                // Set the access token using
                // currentAccessToken when it's loaded or set.
            }
        };
        // If the access token is available already assign it.
        accessToken = AccessToken.getCurrentAccessToken();
        // If already logged in show the home view
        if (accessToken != null) {//<- IMPORTANT
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
            finish();//<- IMPORTANT
        }
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.skipLogin:
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public static void logout() {
        LoginManager.getInstance().logOut();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("FacebookLogin Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
