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
package com.leodroidcoder.genericadaptersample.sample.multipleviewtypes;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter;
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener;
import com.leodroidcoder.genericadaptersample.R;
import com.leodroidcoder.genericadaptersample.model.User;
import com.leodroidcoder.genericadaptersample.sample.common.BaseSampleFragment;

/**
 * Shows basic usage of a {@link GenericRecyclerViewAdapter}
 * with multiple view types.
 * Actually the same implementation as {@link com.leodroidcoder.genericadaptersample.sample.simple.SimpleFragment}, except using another adapter
 * {@link MultipleViewTypesAdapter}
 * <p>
 * For detailed implementation description please refer to {@link com.leodroidcoder.genericadaptersample.sample.simple.SimpleFragment}.
 *
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 1.0.0
 */

public class MultipleViewTypesFragment extends BaseSampleFragment implements OnRecyclerItemClickListener {

    private MultipleViewTypesAdapter adapter;
    private RecyclerView recycler;

    public static Fragment newInstance() {
        return new MultipleViewTypesFragment();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //initialize views
        initViews(view);
        // for simplicity just populate adapter with some data.
        // TODO in real app the data should be provided by a Presenter or a ViewModel.
        adapter.setItems(generateMockUsers());
    }

    private void initViews(@NonNull View view) {
        recycler = view.findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler.setHasFixedSize(true);
        adapter = new MultipleViewTypesAdapter(getActivity(), this);
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
