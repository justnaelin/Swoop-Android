package com.swoop.swoop.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
import com.service.UserService;
import com.swoop.swoop.CreateUser;
import com.swoop.swoop.MainActivity;

/**
 * Created by anaperez on 11/4/16.
 * Summary: Authentication for swoop users to login with Facebook.
 */
public class FacebookLogin extends Activity{
    private CallbackManager callbackManager;
    private TextView mTextDetails;
    private AccessTokenTracker accessTokenTracker;
    private ProfileTracker profileTracker;
    private LoginButton loginButton;
    private AccessToken accessToken;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        setContentView(com.swoop.swoop.R.layout.facebook_login_activity);
        loginButton = (LoginButton) findViewById(com.swoop.swoop.R.id.login_button);
        callbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Log.d("LOGIN_SUCCESS", "Success");
                        AccessToken accessToken = loginResult.getAccessToken();
                        if(accessToken.getUserId() != null){
                            if(accessToken != null) {
                                loginButton.setVisibility(View.INVISIBLE); //<- IMPORTANT
                                if(UserService.isUserById(accessToken.getUserId())){
                                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                                    startActivity(intent);
                                }
                                else{
                                    Log.d("NO USER ID", "no id for user");
                                    Intent intent = new Intent(getBaseContext(), CreateUser.class);
                                    Bundle newBundle = new Bundle();
                                    newBundle.putString("USER_ID",accessToken.getUserId());
                                    intent.putExtras(newBundle);
                                    getBaseContext().startActivity(intent);
                                }
                                finish();//<- IMPORTANT
                            }
                        }
                        else{
                            Intent intent = new Intent(getBaseContext(), CreateUser.class);
                            Bundle newBundle = new Bundle();
                            newBundle.putString("USER_ID",accessToken.getUserId());
                            intent.putExtras(newBundle);
                            startActivity(intent);
                        }
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
}
