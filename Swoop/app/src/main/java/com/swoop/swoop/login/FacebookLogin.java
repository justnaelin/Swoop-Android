package com.swoop.swoop.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.swoop.swoop.R;
import com.swoop.swoop.UserSingleton;

import org.json.JSONObject;

/**
 * Created by anaperez on 11/4/16.
 * Summary: Authentication for swoop users to login with Facebook.
 */
public class FacebookLogin extends Activity {
    private CallbackManager callbackManager;
    private AccessTokenTracker mAccessTokenTracker;
    private LoginButton loginButton;
    private static AccessToken accessToken;
    private Button skipLogin;
    private Bundle parameters;
    private JSONObject retrievedUserData = new JSONObject();

    /**
     *
     */
    public static void logout() {
        LoginManager.getInstance().logOut();
    }

    public static boolean isLoggedIn() {
        if (accessToken != null)
            return true;
        return false;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("FacebookLogin", "Start");
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        setContentView(R.layout.facebook_login_activity);

        loginButton = (LoginButton) findViewById(R.id.login_button);

        callbackManager = CallbackManager.Factory.create();


            LoginManager.getInstance().registerCallback(callbackManager,
                    new FacebookCallback<LoginResult>() {
                        //Success login in into app
                        @Override
                        public void onSuccess(LoginResult loginResult) {
                            loginButton.setVisibility(View.INVISIBLE);

                            accessToken = loginResult.getAccessToken();

                            UserSingleton.destroySingleton();

                            fetchFacebookProfileInformation();

                            Log.d("LOGIN_SUCCESS", "Success");
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


            mAccessTokenTracker = new AccessTokenTracker() {

                @Override
                protected void onCurrentAccessTokenChanged(
                        AccessToken oldAccessToken,
                        AccessToken currentAccessToken) {
                    Log.d("AccessTokenTracker", "here");

                    // Set the access token using
                    // currentAccessToken when it's loaded or set.
                    accessToken = currentAccessToken;
                }

            };



        // If the access token is available already assign it.
        accessToken = AccessToken.getCurrentAccessToken();
        // If already logged in show the home view
        if (accessToken != null) {//<- IMPORTANT

            Log.d("accessToken != null", "here");
            UserSingleton.destroySingleton();

            fetchFacebookProfileInformation();

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }


    /**
     *
     */
    private void fetchFacebookProfileInformation() {
        GraphRequest request = GraphRequest.newMeRequest(
                AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        // this is where you should have the profile
                        //  Log.d("fetched info", response.toString());
                        if (response != null) {
                            retrievedUserData = response.getJSONObject();
                            Log.d("RESPONSE TO JSON:", response.toString());

                            // Instntiate and execute data retrieval using singleton
                            UserSingleton retrievedUserBySingleton = UserSingleton.getInstance(getBaseContext(), retrievedUserData);

                            retrievedUserBySingleton.executeVerifyUser();

                            finish();

                        }

                    }
                });
        //fields needed from facebook
        parameters = new Bundle();
        parameters.putString("fields", "id,first_name,last_name,birthday,link,email,picture.type(large)");
        request.setParameters(parameters);
        request.executeAsync();
    }

}
