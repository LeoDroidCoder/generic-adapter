package com.leodroidcoder.genericadaptersample.fragment;

import com.leodroidcoder.genericadaptersample.R;
import com.leodroidcoder.genericadaptersample.sample.home.HomeFragment;
import com.leodroidcoder.genericadaptersample.utils.FragmentTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by leonid on 2/24/18.
 */

public class HomeFragmentTests {

    @Rule
    public FragmentTestRule<HomeFragment> fragmentTestRule = new FragmentTestRule<>(HomeFragment.class);

    @Before
    public void init() {
        // Launch the activity to make the fragment visible
        fragmentTestRule.launchActivity(null);
    }

    @Test
    public void testHomeFragment() {
        onView(withId(R.id.btn_simple)).check(matches((isDisplayed())));
        onView(withId(R.id.btn_multiple_viewtypes)).check(matches((isDisplayed())));
        onView(withId(R.id.btn_multiple_buttons)).check(matches((isDisplayed())));
        onView(withId(R.id.btn_diffutil)).check(matches((isDisplayed())));
    }



}
