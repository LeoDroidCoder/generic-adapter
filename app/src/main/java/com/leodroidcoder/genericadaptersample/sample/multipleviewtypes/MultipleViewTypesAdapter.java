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

import android.content.Context;
import android.view.ViewGroup;

import com.leodroidcoder.genericadapter.BaseViewHolder;
import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter;
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener;
import com.leodroidcoder.genericadaptersample.R;
import com.leodroidcoder.genericadaptersample.model.User;
import com.leodroidcoder.genericadaptersample.sample.common.UserViewHolder;

/**
 * Generic adapter {@link GenericRecyclerViewAdapter} implementation with multiple view types.
 * Note that the abstract {@link BaseViewHolder} used here instead of a concrete implementation, in order to let {@link #onCreateViewHolder(ViewGroup, int)} return different ViewHolders (each for a concrete viewType)
 *
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 1.0.0
 */

public class MultipleViewTypesAdapter extends GenericRecyclerViewAdapter<User, OnRecyclerItemClickListener, BaseViewHolder<User, OnRecyclerItemClickListener>> {

    private static final int VIEW_TYPE_NORMAL = R.layout.item_user;
    private static final int VIEW_TYPE_COLORED = R.layout.item_user_accent;


    public MultipleViewTypesAdapter(Context context, OnRecyclerItemClickListener listener) {
        super(context, listener);
    }

    /**
     * Create here appropriate ViewHolder for each view type
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View. It corresponds to layout resource id {@link android.support.annotation.LayoutRes} for convenience
     * @return ViewHolder which corresponds to needed view type
     */
    @Override
    public BaseViewHolder<User, OnRecyclerItemClickListener> onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new UserViewHolder(inflate(viewType, parent), getListener());
            case VIEW_TYPE_COLORED:
                return new UserAccentViewHolder(inflate(viewType, parent), getListener());
            default:
                throw new IllegalArgumentException("Unexpected view type " + viewType);
        }
    }

    /**
     * Implement here returning various view types upon your requirements
     *
     * @param position item position
     * @return appropriate view type
     */
    @Override
    public int getItemViewType(int position) {
        return (position % 2 == 0) ? VIEW_TYPE_NORMAL : VIEW_TYPE_COLORED;
    }
}
