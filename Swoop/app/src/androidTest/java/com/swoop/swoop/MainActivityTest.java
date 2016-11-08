package com.swoop.swoop;

import android.support.test.rule.ActivityTestRule;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Carpool Resource (Model)
 *
 * @author Yarely Chino
 * @version 1.0
 */

public class MainActivityTest {


    @Rule public ActivityTestRule<CreateCarpoolActivity> activityTestRule =
            new ActivityTestRule<>(CreateCarpoolActivity.class);

    @Test public void shouldShowSwopFragmentName() {
        // then
        onView(withText("Location:")).check(matches(isDisplayed()));
        onView(withText("Destination:")).check(matches(isDisplayed()));
        onView(withText("Max people:")).check(matches(isDisplayed()));
        onView(withText("Rate:")).check(matches(isDisplayed()));
        onView(withText("User:")).check(matches(isDisplayed()));
    }

}

