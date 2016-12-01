package com.swoop.swoop;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rest.InputUtility;
import com.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class CreateUserActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mCreateUser;
    private EditText mInputName, mInputLastName, mInputEmail, mInputAddress, mInputphoneNumber, mInputDOB;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        setTitle(getString(R.string.title_activity_create_user));
        mProgressDialog = new ProgressDialog(this);
        mCreateUser = (Button) findViewById(R.id.submit_button_to_create_user);
        mCreateUser.setOnClickListener(this);
    }

    public boolean checkEmptyFields() {
        mInputAddress = (EditText) findViewById(R.id.input_homeAddress);
        mInputDOB = (EditText) findViewById(R.id.input_DOB);
        mInputEmail = (EditText) findViewById(R.id.input_userEmail);
        mInputName = (EditText) findViewById(R.id.input_userName);
        mInputLastName = (EditText) findViewById(R.id.input_userLastName);
        mInputphoneNumber = (EditText) findViewById(R.id.input_cellPhone);
        if (InputUtility.isNotNull(mInputAddress.getText().toString()) &&
                InputUtility.isNotNull(mInputDOB.getText().toString()) &&
                InputUtility.isNotNull(mInputEmail.getText().toString()) &&
                InputUtility.isNotNull(mInputName.getText().toString()) &&
                InputUtility.isNotNull(mInputLastName.getText().toString()) &&
                InputUtility.isNotNull(mInputphoneNumber.getText().toString())) {
            return true;
        } else {
            createToast("Please enter all fields");
            return false;
        }
    }

    public void createToast(String s) {
        Toast toast = Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onClick(View v) {
        //check what was clicked
        switch (v.getId()) {
            case R.id.submit_button_to_create_user: {
                Log.d("CLICKED CREATE USER", "creating user");
                if (checkEmptyFields()) {
                    Bundle bundle = getIntent().getExtras();
                    String userId = bundle.getString("USER_ID");
                    String name = mInputName.getText().toString();
                    String lastName = mInputLastName.getText().toString();
                    String email = mInputEmail.getText().toString();
                    String phoneNumber = mInputphoneNumber.getText().toString();
                    String address = mInputAddress.getText().toString();
                    String birthday = mInputDOB.getText().toString();
                    double averageRating = 0;
                    String vehicleId = "";
                    List<String> requestedCarpoolIds = new ArrayList<String>();
                    requestedCarpoolIds.add(0, "null");
                    List<String> reviewIds = new ArrayList<String>();
                    reviewIds.add(0, "null");
                    //CREATE USER , vehicleId, requestedCarpoolIds, reviewIds
                    String response = UserService.verifyCreateUser(userId, name, lastName,
                            email, phoneNumber, address, birthday, averageRating, vehicleId, requestedCarpoolIds, reviewIds, getBaseContext());
                }
            }
        }

    }

}
