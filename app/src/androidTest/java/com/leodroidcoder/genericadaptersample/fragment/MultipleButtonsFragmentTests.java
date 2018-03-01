package com.leodroidcoder.genericadaptersample.fragment;

import com.leodroidcoder.genericadaptersample.R;
import com.leodroidcoder.genericadaptersample.sample.multiplebuttons.MultipleButtonsFragment;
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
import static com.leodroidcoder.genericadaptersample.utils.RecyclerViewMatcher.withRecyclerView;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.Is.is;

/**
 * Created by leonid on 2/24/18.
 */

public class MultipleButtonsFragmentTests {

    @Rule
    public FragmentTestRule<MultipleButtonsFragment> fragmentTestRule = new FragmentTestRule<>(MultipleButtonsFragment.class);

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
    public void recyclerItemAgeClick_shouldShowToast() {
        // click at "Age" button of an RecyclerView item
        onView(withRecyclerView(R.id.recycler).atPositionOnView(3, R.id.btn_age)).perform(click());

        // toast has to be shown
        onView(withText(startsWith("User ")))
                .inRoot(withDecorView(not(is(fragmentTestRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
    }

    @Test
    public void recyclerItemGreetClick_shouldShowToast() {
        // click at "Greet" button of an RecyclerView item
        onView(withRecyclerView(R.id.recycler).atPositionOnView(3, R.id.btn_greet)).perform(click());

        // toast has to be shown
        onView(withText(startsWith("Hello User ")))
                .inRoot(withDecorView(not(is(fragmentTestRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
    }
}
