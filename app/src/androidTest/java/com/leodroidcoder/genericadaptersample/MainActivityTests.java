package com.leodroidcoder.genericadaptersample;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by leonid on 2/23/18.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTests {

    @Rule
    public final ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class, false, false);


    @Before
    public void init() {
        activityRule.launchActivity(null);
    }

    @Test
    public void testHomeFragmentTitle() {
        // app name title should be by default
        onView(withText(R.string.app_name)).check(matches(isDisplayed()));

        // navigate to sample fragment. Title should be different
        onView(withId(R.id.btn_simple)).perform(click());
        onView(withText(R.string.app_name)).check(doesNotExist());

        // press back button. App name title should be shown again
        pressBack();
        onView(withText(R.string.app_name)).check(matches(isDisplayed()));
    }

    @Test
    public void testSimpleSampleFragmentTitle() {
        //launch simple sample fragment
        onView(withId(R.id.btn_simple)).perform(click());

        //check title
        onView(withText(R.string.title_simple_adapter)).check(matches(isDisplayed()));
    }

    @Test
    public void testMultipleViewTypesFragmentTitle() {
        //launch multople view types sample fragment
        onView(withId(R.id.btn_multiple_viewtypes)).perform(click());

        //check title
        onView(withText(R.string.title_multiple_viewtypes)).check(matches(isDisplayed()));

        // press back, title should be changed
        pressBack();
        onView(withText(R.string.title_multiple_viewtypes)).check(doesNotExist());
    }

    @Test
    public void testMultipleButtonsFragmentTitle() {
        //launch multiple buttons sample fragment
        onView(withId(R.id.btn_multiple_buttons)).perform(click());

        //check title
        onView(withText(R.string.title_multiple_buttons)).check(matches(isDisplayed()));

        // press back, title should be changed
        pressBack();
        onView(withText(R.string.title_multiple_buttons)).check(doesNotExist());
    }

    @Test
    public void testDiffUtilFragmentTitle() {
        //launch multiple buttons sample fragment
        onView(withId(R.id.btn_diffutil)).perform(click());

        //check title
        onView(withText(R.string.title_difutil)).check(matches(isDisplayed()));

        // press back, title should be changed
        pressBack();
        onView(withText(R.string.title_difutil)).check(doesNotExist());
    }
}
