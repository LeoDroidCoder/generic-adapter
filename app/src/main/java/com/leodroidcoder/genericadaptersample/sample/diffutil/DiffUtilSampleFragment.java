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
package com.leodroidcoder.genericadaptersample.sample.diffutil;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter;
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener;
import com.leodroidcoder.genericadaptersample.R;
import com.leodroidcoder.genericadaptersample.model.User;
import com.leodroidcoder.genericadaptersample.sample.common.BaseSampleFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Shows usage of a {@link GenericRecyclerViewAdapter} with the DiffUtil
 * {@link android.support.v7.util.DiffUtil.Callback}.
 * The magic happens when your adapter data is somehow hanged (an item is changed, removed, or added),
 * DiffUtil will it's job not to redraw all the items, but only the changed ones.
 * In this sample the {@link User#name} is changed and {@link User#age} is incremented by 1 (on items click).
 * Note, that for getting the full output you also have to implement the Payloads, what will let your adapter not to redraw an item completely, but it could update only one view .
 * For basic {@link GenericRecyclerViewAdapter} please refer to the sample: {@link com.leodroidcoder.genericadaptersample.sample.simple.SimpleFragment}
 *
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 1.0.0
 */

public class DiffUtilSampleFragment extends BaseSampleFragment implements OnRecyclerItemClickListener {

    private static final String TAG = "DiffUtilSampleFragment";

    private DiffUtilAdapter adapter;
    private RecyclerView recycler;

    public static Fragment newInstance() {
        return new DiffUtilSampleFragment();
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
        adapter = new DiffUtilAdapter(getActivity(), this);
        recycler.setAdapter(adapter);
    }

    /**
     * This is a callback of the recycler listener.
     * {@link OnRecyclerItemClickListener}.
     * Is being triggered when an item has been clicked.
     *
     * @param position clicked position
     */
    @Override
    public void onItemClick(int position) {
        // get the User entity, associated with the clicked item.
        simulateDataSetUpdate(position);
    }

    /**
     * Simulates data set changing, for instance if you receive fresh data From the net.
     * In this sample the {@link User#name} is changed and {@link User#age} is incremented by 1.
     * Updates adapter with the new data.
     *
     * @param position index of a User, which has to be changed.
     */
    private void simulateDataSetUpdate(int position) {
        User oldUser = adapter.getItem(position);
        List<User> newUsers = new ArrayList<>(adapter.getItems());
        newUsers.set(position, new User(oldUser.getId(), "Updated user " + oldUser.getId(), oldUser.getAge() + 1));
        adapter.updateItems(newUsers);
    }
}
