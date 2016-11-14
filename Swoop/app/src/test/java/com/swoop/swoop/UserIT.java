package com.swoop.swoop;

import android.test.mock.MockContext;

import com.service.UserService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anaperez on 11/13/16.
 */

public class UserIT {

    @Before
    public void setUp() {

    }

    @After
    public void teardown() {

    }

    @Test
    public void testRetrieveUserById() {
        // Create a User with some basic attributes
        List<String> requestedCarpoolIds = new ArrayList<>();
        requestedCarpoolIds.add("1");
        requestedCarpoolIds.add("2");

        List<String> reviewIds = new ArrayList<>();
        reviewIds.add("12");
        MockContext context = new MockContext();
        UserService.verifyCreateUser("12345", "Naelin", "Aquino", "justnaelin@yahoo.com", "123 Street", "555-555-5555",
                 "02/10/95", 99.9,"13", requestedCarpoolIds, reviewIds, context);

      //  assertEquals("12345", UserService.);

       // String retrievedUserJSON = UserService.retrieveUserById(newUser.getUserId());

      //  User user = UserUtility.convertJSONtoUser(retrievedUserJSON);

     //   assertEquals(newUser.getUserId(), user.getUserId());

     //   UserService.deleteUserById(newUser.getUserId());
    }
}
