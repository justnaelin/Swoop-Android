package com.swoop.swoop;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerActions.closeDrawer;
import static android.support.test.espresso.contrib.DrawerActions.openDrawer;
import static android.support.test.espresso.contrib.DrawerMatchers.isOpen;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.anything;
/**
 * MainActivityTest
 *
 * @author Yarely Chino
 * @version 1.0
 */


public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testOpenAndCloseDrawer() {

        openDrawer(R.id.drawerLayout);
        closeDrawer(R.id.drawerLayout);

        openDrawer(R.id.drawerLayout);
        onView(withId(R.id.drawerLayout)).check(matches(isOpen()));

    }

    @Test
    public void testOpenDrawerAndItemTitle() {

        openDrawer(R.id.drawerLayout);
        onData(anything())
                .inAdapterView(withId(R.id.navList))
                .atPosition(0)
                .onChildView(withId(R.id.title))
                .check(matches(isDisplayed()));

        //check if the title content is being display properly
        onView(withId(R.string.drawer_title_0));
        onView(withId(R.string.drawer_title_1));
        onView(withId(R.string.drawer_title_2));
        onView(withId(R.string.drawer_title_3));

    }

    @Test
    public void testOpenDrawerAndItemDescription() {
        openDrawer(R.id.drawerLayout);

        onData(anything())
                .inAdapterView(withId(R.id.navList))
                .atPosition(0)
                .onChildView(withId(R.id.title))
                .check(matches(isDisplayed()));

        //check if the description content is being display properly
        onView(withId(R.string.drawer_description_0));
        onView(withId(R.string.drawer_description_1));
        onView(withId(R.string.drawer_description_2));
        onView(withId(R.string.drawer_description_3));


    }


}
