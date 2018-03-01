package com.leodroidcoder.genericadaptersample.fragment;

import com.leodroidcoder.genericadaptersample.R;
import com.leodroidcoder.genericadaptersample.sample.diffutil.DiffUtilSampleFragment;
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

public class DiffutilSampleFragmentTests {

    @Rule
    public FragmentTestRule<DiffUtilSampleFragment> fragmentTestRule = new FragmentTestRule<>(DiffUtilSampleFragment.class);

    @Before
    public void init() {
        // Launch the activity to make the fragment visible
        fragmentTestRule.launchActivity(null);
    }

    @Test
    public void fragment_shouldBeInstantiated() {
        onView(withId(R.id.recycler)).check(matches(isDisplayed()));
    }
}
