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
package com.leodroidcoder.genericadaptersample.sample.common;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.leodroidcoder.genericadaptersample.sample.diffutil.DiffUtilSampleFragment;
import com.leodroidcoder.genericadaptersample.sample.home.HomeFragment;
import com.leodroidcoder.genericadaptersample.sample.multiplebuttons.MultipleButtonsFragment;
import com.leodroidcoder.genericadaptersample.sample.multipleviewtypes.MultipleViewTypesFragment;
import com.leodroidcoder.genericadaptersample.sample.simple.SimpleFragment;

/**
 * Simple navigator used for replacing Fragments.
 *
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 1.0.0
 */

public class SimpleNavigator {

    private static volatile SimpleNavigator instance;

    private SimpleNavigator() {
    }

    public static SimpleNavigator getInstance() {
        if (instance == null) {
            synchronized (SimpleNavigator.class) {
                if (instance == null) {
                    instance = new SimpleNavigator();
                }
            }
        }
        return instance;
    }

    /**
     * Replaces a fragment in the container by a screen key.
     *
     * @param screenKey   screen key {@link Screens}
     * @param fm          Fragment Fanager
     * @param containerId Identifier of the container whose fragment(s) are
     *                    to be replaced.
     */

    public void replaceFragment(Screens screenKey, FragmentManager fm, @IdRes int containerId, boolean addToBakStack) {
        FragmentTransaction transaction = fm.beginTransaction()
                .replace(containerId, create(screenKey));
        if (addToBakStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }

    /**
     * Simple factory method.
     * Creates Fragment by a screen key.
     *
     * @param key screen key {@link Screens}
     * @return Fragment matching the screen key
     */
    private Fragment create(Screens key) {
        final Fragment fragment;
        switch (key) {
            case HOME:
                fragment = HomeFragment.newInstance();
                break;
            case SIMPLE:
                fragment = SimpleFragment.newInstance();
                break;
            case MULTIPLE_VIEW_TYPES:
                fragment = MultipleViewTypesFragment.newInstance();
                break;
            case MULTIPLE_BUTTONS:
                fragment = MultipleButtonsFragment.newInstance();
                break;
            case DIFFUTIL:
                fragment = DiffUtilSampleFragment.newInstance();
                break;
            default:
                throw new IllegalArgumentException("Unknown screen key " + key.name());
        }
        return fragment;
    }

    public enum Screens {
        HOME, SIMPLE, MULTIPLE_VIEW_TYPES, MULTIPLE_BUTTONS, DIFFUTIL
    }
}
