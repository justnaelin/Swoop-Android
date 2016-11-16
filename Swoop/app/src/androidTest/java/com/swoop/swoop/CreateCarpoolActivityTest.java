package com.swoop.swoop;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.DatePicker;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.espresso.contrib.PickerActions;
import android.widget.TimePicker;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Main Activity Test
 *
 * @author Yarely Chino
 * @version 1.0
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class CreateCarpoolActivityTest {


    @Rule public ActivityTestRule<CreateCarpoolActivity> activityTestRule =
            new ActivityTestRule<>(CreateCarpoolActivity.class);

    @Test public void shouldShowSwoopFragmentName() {
        //Test if the view is displaying the correct output
        onView(withText("Location:")).check(matches(isDisplayed()));
        onView(withText("Destination:")).check(matches(isDisplayed()));
        onView(withText("Max people:")).check(matches(isDisplayed()));
        onView(withText("Rate:")).check(matches(isDisplayed()));
        onView(withText("User:")).check(matches(isDisplayed()));


    }

    @Test public void inputInformationToCreateCarpool() {
        //Test User valid input
        onView(withId(R.id.input_max_people))
                .perform(typeText("6"), closeSoftKeyboard());
        onView(withId(R.id.input_rate))
                .perform(typeText("34.2"), closeSoftKeyboard());

        //verify user input has been entered
        onView(withText("6")).check(matches(isDisplayed()));
        onView(withText("34.2")).check(matches(isDisplayed()));


        int year = 2017;
        int month = 11;
        int day = 15;
        int hour = 10;
        int minutes = 59;

        //launches datePicker tests
        onView(withId(R.id.button_date)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(year, month, day));
        onView(withId(android.R.id.button1)).perform(click());

        //launches timePicker tests
        onView(withId(R.id.button_time)).perform(click());
        onView(withClassName(Matchers.equalTo(TimePicker.class.getName()))).perform(PickerActions.setTime(hour, minutes));
        onView(withId(android.R.id.button1)).perform(click());

        //verifies the user input
        onView(withText(day+"-"+month+"-"+year)).check(matches(isDisplayed()));
        onView(withText(hour+":"+minutes)).check(matches(isDisplayed()));

        //If valid toast then createCarpool was created
        onView(withId(R.id.submit_button)).perform(click());
        //onView(withText(CarpoolService.VALID)).inRoot(withDecorView(not(is(activityTestRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));


    }

}

