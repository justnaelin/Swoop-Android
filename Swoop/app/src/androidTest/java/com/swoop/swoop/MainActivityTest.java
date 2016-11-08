package com.swoop.swoop;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

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
    public void shouldShowSwoopFragmentName() {

    }
}
