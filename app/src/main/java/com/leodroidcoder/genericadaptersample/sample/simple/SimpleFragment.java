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
package com.leodroidcoder.genericadaptersample.sample.simple;

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

/**
 * Shows basic usage of a {@link GenericRecyclerViewAdapter}.
 * Here are the steps which you have to follow:
 * 1. Create a concrete adapter by extending {@link GenericRecyclerViewAdapter}.
 * In this sample {@link SimpleAdapter} is used.
 * 2. Initialize adapter as usual {@link RecyclerView.Adapter} with passing listener to the constructoe {@link com.leodroidcoder.genericadapter.OnRecyclerItemClickListener}
 * Here you will retrieve the object bound to the clicked item.
 * 3. Set adapter to a RecyclerView.
 * 4. Populate it with data.
 *
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 1.0.0
 */

public class SimpleFragment extends BaseSampleFragment implements OnRecyclerItemClickListener {

    private SimpleAdapter adapter;
    private RecyclerView recycler;

    public static Fragment newInstance() {
        return new SimpleFragment();
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
        adapter = new SimpleAdapter(getActivity(), this);
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
        final User clickedUser = adapter.getItem(position);
        // now you are free to do whatever you want with it.
        // We just show a Toast message
        showToast(clickedUser.getName() + " has been clicked");
    }
}
