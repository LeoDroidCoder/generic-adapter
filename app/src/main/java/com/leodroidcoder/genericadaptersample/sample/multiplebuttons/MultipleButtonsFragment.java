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
package com.leodroidcoder.genericadaptersample.sample.multiplebuttons;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter;
import com.leodroidcoder.genericadaptersample.R;
import com.leodroidcoder.genericadaptersample.model.User;
import com.leodroidcoder.genericadaptersample.sample.common.BaseSampleFragment;
import com.leodroidcoder.genericadaptersample.sample.simple.SimpleAdapter;

/**
 * Shows basic usage of a {@link GenericRecyclerViewAdapter}
 * with a custom item click listener.
 * Typical usage is when you need several click listeners for an item.
 * <p>
 * Here are the steps which you have to follow:
 * 1. Create a concrete adapter by extending {@link GenericRecyclerViewAdapter}.
 * In this sample {@link SimpleAdapter} is used.
 * 2. Initialize adapter as usual {@link RecyclerView.Adapter} and pass Listener to the constructor (or null if item click listener is not needed)
 * In this sample {@link MultipleUserClickListener} is used.
 * Here you will retrieve the clicked position.
 * 3. Set adapter to a RecyclerView.
 * 4. Populate it with data.
 *
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 1.0.0
 */

public class MultipleButtonsFragment extends BaseSampleFragment implements MultipleUserClickListener {

    private MultipleButtonsAdapter adapter;
    private RecyclerView recycler;

    public static Fragment newInstance() {
        return new MultipleButtonsFragment();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //initialize views
        initViews(view);
        // for simplicity just populate adapter with some data.
        // TODO in real life app it should be done by a Presenter or a ViewModel.
        adapter.setItems(generateMockUsers());
    }

    private void initViews(@NonNull View view) {
        recycler = view.findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler.setHasFixedSize(true);
        recycler.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL));
        adapter = new MultipleButtonsAdapter(getActivity(), this);
        recycler.setAdapter(adapter);
    }

    /**
     * This is a callback of the recycler listener.
     * {@link MultipleUserClickListener}.
     * Is being triggered when an "Age" button is clicked.
     *
     * @param position clicked position
     */
    @Override
    public void onGetAgeClick(int position) {
        // get the User entity, associated with the clicked item.
        final User clickedUser = adapter.getItem(position);
        // now you are free to do whatever you want with it.
        // We just show a Toast message
        showToast(clickedUser.getName() + ", age: " + clickedUser.getAge());
    }

    /**
     * This is a callback of the recycler listener.
     * {@link MultipleUserClickListener}.
     * Is being triggered when an "Greet" button is clicked.
     *
     * @param position clicked position
     */
    @Override
    public void onGreetClick(int position) {
        // get the User entity, associated with the clicked item.
        final User clickedUser = adapter.getItem(position);
        // now you are free to do whatever you want with it.
        // We just show a Toast message
        showToast("Hello " + clickedUser.getName() + "!");
    }
}
