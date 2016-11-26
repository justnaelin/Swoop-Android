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
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.swoop.swoop.MainActivity;

/**
 * Created by anaperez on 11/4/16.
 * Summary: Authentication for swoop users to login with Facebook.
 */
public class FacebookLogin extends Activity implements View.OnClickListener{
    private CallbackManager callbackManager;
    private TextView mTextDetails;
    private AccessTokenTracker accessTokenTracker;
    private ProfileTracker profileTracker;
    private LoginButton loginButton;
    private AccessToken accessToken;
    private Button skipLogin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        setContentView(com.swoop.swoop.R.layout.facebook_login_activity);
        loginButton = (LoginButton) findViewById(com.swoop.swoop.R.id.login_button);
        callbackManager = CallbackManager.Factory.create();
        skipLogin = (Button) findViewById(com.swoop.swoop.R.id.skipLogin);
        skipLogin.setOnClickListener(this);
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Log.d("LOGIN_SUCCESS", "Success");
                        loginButton.setVisibility(View.INVISIBLE); //<- IMPORTANT
                        Intent intent = new Intent(getBaseContext(), MainActivity.class);
                        startActivity(intent);
                        finish();//<- IMPORTANT
                        // App code
                    }
                    @Override
                    public void onCancel() {
                        // App
                        Log.d("CANCEL", "cancel");
                    }
                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                        Log.d("message: ", "error loggin in");
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
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case com.swoop.swoop.R.id.skipLogin:
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
