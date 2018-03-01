/*
 * Copyright (C) 2017 Leonid Ustenko Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.leodroidcoder.genericadaptersample;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.leodroidcoder.genericadaptersample.sample.common.SimpleNavigator;
import com.leodroidcoder.genericadaptersample.sample.diffutil.DiffUtilSampleFragment;
import com.leodroidcoder.genericadaptersample.sample.home.HomeFragment;
import com.leodroidcoder.genericadaptersample.sample.multiplebuttons.MultipleButtonsFragment;
import com.leodroidcoder.genericadaptersample.sample.multipleviewtypes.MultipleViewTypesFragment;
import com.leodroidcoder.genericadaptersample.sample.simple.SimpleFragment;

public class MainActivity extends AppCompatActivity implements HomeFragment.HomeFragmentListener {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        setupBackStackListener();
    }

    private void setupViews() {
        toolbar = findViewById(R.id.toolbar);
        navigateTo(SimpleNavigator.Screens.HOME, false);
    }

    @Override
    public void onSimpleClick() {
        navigateTo(SimpleNavigator.Screens.SIMPLE, true);
    }

    @Override
    public void onMultipleViewTypesClick() {
        navigateTo(SimpleNavigator.Screens.MULTIPLE_VIEW_TYPES, true);
    }

    @Override
    public void onMultipleButtonsClick() {
        navigateTo(SimpleNavigator.Screens.MULTIPLE_BUTTONS, true);
    }

    @Override
    public void onDiffUtilClick() {
        navigateTo(SimpleNavigator.Screens.DIFFUTIL, true);
    }

    /**
     * Helper method to replace fragment by key.
     *
     * @param key scfreen key {@link com.leodroidcoder.genericadaptersample.sample.common.SimpleNavigator.Screens}
     */
    private void navigateTo(SimpleNavigator.Screens key, boolean addToBakStack) {
        SimpleNavigator.getInstance().replaceFragment(key, getSupportFragmentManager(), R.id.fl_container, addToBakStack);
    }

    /**
     * Changes toolbar title on backStack change
     */
    private void setupBackStackListener() {
        getSupportFragmentManager().addOnBackStackChangedListener(() -> {
            Fragment frag = getSupportFragmentManager().findFragmentById(R.id.fl_container);
            setToolbarTitle(getString(getTitleResForFragment(frag)));
        });
    }

    /**
     * Returns toolbar title for a fragment.
     * @param frag a Fragment
     * @return String resource containing title
     */
    private @StringRes int getTitleResForFragment(Fragment frag) {
        int titleResId;
        if (frag instanceof SimpleFragment) {
            titleResId = R.string.title_simple_adapter;
        } else if (frag instanceof MultipleViewTypesFragment) {
            titleResId = R.string.title_multiple_viewtypes;
        } else if (frag instanceof MultipleButtonsFragment) {
            titleResId = R.string.title_multiple_buttons;
        } else if (frag instanceof DiffUtilSampleFragment) {
            titleResId = R.string.title_difutil;
        } else {
            titleResId = R.string.app_name;
        }
        return titleResId;
    }

    /**
     * Sets toolbar title
     *
     * @param title
     */
    private void setToolbarTitle(String title) {
        toolbar.setTitle(title);
    }
}
