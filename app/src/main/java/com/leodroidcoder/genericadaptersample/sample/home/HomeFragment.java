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
package com.leodroidcoder.genericadaptersample.sample.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.leodroidcoder.genericadaptersample.R;

/**
 * Servers a purpose of navigating between sample fragments
 *
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 1.0.0
 */

public class HomeFragment extends Fragment {

    private HomeFragmentListener activityCallback;

    public static Fragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //initialize views
        initViews(view);
    }

    private void initViews(@NonNull View view) {
        final Button btnSimpleSample = view.findViewById(R.id.btn_simple);
        btnSimpleSample.setOnClickListener(v -> activityCallback.onSimpleClick());
        final Button btnMultipleTypes = view.findViewById(R.id.btn_multiple_viewtypes);
        btnMultipleTypes.setOnClickListener(v -> activityCallback.onMultipleViewTypesClick());
        final Button btnMultipleButtons = view.findViewById(R.id.btn_multiple_buttons);
        btnMultipleButtons.setOnClickListener(v -> activityCallback.onMultipleButtonsClick());
        final Button btnDiffUtil = view.findViewById(R.id.btn_diffutil);
        btnDiffUtil.setOnClickListener(v -> activityCallback.onDiffUtilClick());
    }

    /**
     * Used  to communicate with the host activity
     *
     * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
     * @since 1.0.0
     */
    public interface HomeFragmentListener {

        void onSimpleClick();

        void onMultipleViewTypesClick();

        void onMultipleButtonsClick();

        void onDiffUtilClick();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            activityCallback = (HomeFragmentListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context + " must implement " + HomeFragmentListener.class.getName());
        }
    }
}
