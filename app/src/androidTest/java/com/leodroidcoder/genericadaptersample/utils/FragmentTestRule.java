package com.leodroidcoder.genericadaptersample.utils;

import android.support.test.rule.ActivityTestRule;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.leodroidcoder.genericadaptersample.R;
import com.leodroidcoder.genericadaptersample.test.MainTestingActivity;

import org.junit.Assert;

public class FragmentTestRule<F extends Fragment> extends ActivityTestRule<MainTestingActivity> {

    private final Class<F> fragmentClass;
    private F fragment;

    public FragmentTestRule(final Class<F> fragmentClass) {
        super(MainTestingActivity.class, true, false);
        this.fragmentClass = fragmentClass;
    }

    @Override
    protected void afterActivityLaunched() {
        super.afterActivityLaunched();

        getActivity().runOnUiThread(() -> {
            try {
                //Instantiate and insert the fragment into the container layout
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                fragment = fragmentClass.newInstance();
                transaction.replace(R.id.fl_container, fragment);
                transaction.commit();
            } catch (InstantiationException | IllegalAccessException e) {
                Assert.fail(String.format("%s: Could not insert %s into TestActivity: %s",
                        getClass().getSimpleName(),
                        fragmentClass.getSimpleName(),
                        e.getMessage()));
            }
        });
    }

    public F getFragment() {
        return fragment;
    }
}