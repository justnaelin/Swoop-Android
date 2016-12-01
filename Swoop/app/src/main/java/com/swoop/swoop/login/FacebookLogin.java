package com.swoop.swoop.login;

import android.app.Activity;
import android.content.Intent;
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
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.service.UserService;
import com.swoop.swoop.MainActivity;
import com.swoop.swoop.R;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by anaperez on 11/4/16.
 * Summary: Authentication for swoop users to login with Facebook.
 */
public class FacebookLogin extends Activity implements View.OnClickListener {
    private CallbackManager callbackManager;
    private TextView mTextDetails;
    private AccessTokenTracker mAccessTokenTracker;
    private ProfileTracker profileTracker;
    private LoginButton loginButton;
    private AccessToken accessToken;
    private Button skipLogin;

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
                    //Success login in into app
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Log.d("LOGIN_SUCCESS", "Success");
                        loginButton.setVisibility(View.INVISIBLE);
                        AccessToken accessToken = loginResult.getAccessToken();
                        fetchFacebookProfileInformation();
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

    /*
     call this method from anywhere within the app to logout of the app.
     Remember to create a new intent to FacebookLogin class.
     */
    public static void logout() {
        LoginManager.getInstance().logOut();
    }

    /*
    this is used to fetch user's information from facebook.
     */
    private void fetchFacebookProfileInformation() {
        GraphRequest request = GraphRequest.newMeRequest(
                AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        // this is where you should have the profile
                        Log.d("fetched info", object.toString());
                        if(response != null) {
                           // JSONObject data = response.getJSONObject();
                            String url = null;
                            try {
                                url = response.getJSONObject().getJSONObject("picture")
                                        .getJSONObject("data").getString("url");
                                Log.d("profile pic: URLS: " , url);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            nextActivity(object);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
        Bundle parameters = new Bundle();
        //fields needed from facebook
        parameters.putString("fields", "id,name,link,email,picture.type(large),phonenumber");
        request.setParameters(parameters);
        request.executeAsync();

    }

    private void nextActivity(JSONObject profile) throws JSONException, InterruptedException {
        if (UserService.isUser(profile)) {
            Log.d("TRYING TO MAKE THE CALL", profile.toString());
        }
        Log.d("SOMETHING BAD HAPPENED", profile.toString());
    }

}
