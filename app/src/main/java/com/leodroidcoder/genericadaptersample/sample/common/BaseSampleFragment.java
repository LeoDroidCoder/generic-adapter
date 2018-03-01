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

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.leodroidcoder.genericadaptersample.R;
import com.leodroidcoder.genericadaptersample.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Base sample fragment which implements some mock users data generating and some other basics
 *
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 1.0.0
 */

public abstract class BaseSampleFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_base_sample, container, false);
    }

    /**
     * Shows a Toast message.
     *
     * @param message message to show
     */
    protected void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Creates some mock users.
     */
    protected List<User> generateMockUsers() {
        int totalUsers = 25;
        List<User> users = new ArrayList<>(totalUsers);
        for (int i = 1; i <= totalUsers; i++) {
            users.add(new User(i, "User " + i, getRandomAge()));
        }
        return users;
    }

    /**
     * Generates random age between 0 and 110 (excluded)
     *
     * @return random age value
     */
    private int getRandomAge() {
        return (int) (Math.random() * 110);
    }
}
