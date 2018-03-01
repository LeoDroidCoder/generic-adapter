package com.leodroidcoder.genericadaptersample.fragment;

import android.support.test.espresso.contrib.RecyclerViewActions;

import com.leodroidcoder.genericadaptersample.R;
import com.leodroidcoder.genericadaptersample.sample.simple.SimpleFragment;
import com.leodroidcoder.genericadaptersample.utils.FragmentTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.Is.is;

/**
 * Created by leonid on 2/24/18.
 */

public class SimpleSampleFragmentTests {

    @Rule
    public FragmentTestRule<SimpleFragment> fragmentTestRule = new FragmentTestRule<>(SimpleFragment.class);

    @Before
    public void init() {
        // Launch the activity to make the fragment visible
        fragmentTestRule.launchActivity(null);
    }

    @Test
    public void fragment_shouldBeInstantiated() {
        onView(withId(R.id.recycler)).check(matches(isDisplayed()));
    }

    @Test
    public void recyclerItemClick_shouldShowToast() {
        // perform click on an item
        onView(withId(R.id.recycler))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        // toast has to be shown
        onView(withText(allOf(startsWith("User "), endsWith(" has been clicked"))))
                .inRoot(withDecorView(not(is(fragmentTestRule.getActivity().getWindow()
                        .getDecorView())))).check(matches(isDisplayed()));
    }
}
