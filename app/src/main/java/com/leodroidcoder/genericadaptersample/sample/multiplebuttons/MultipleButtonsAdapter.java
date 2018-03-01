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

import android.content.Context;
import android.view.ViewGroup;

import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter;
import com.leodroidcoder.genericadaptersample.R;
import com.leodroidcoder.genericadaptersample.model.User;

/**
 * Generic adapter {@link GenericRecyclerViewAdapter} implementation with multiple button at an item
 *
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 1.0.0
 */

public class MultipleButtonsAdapter extends GenericRecyclerViewAdapter<User, MultipleUserClickListener, MultipleButtonsViewHolder> {

    public MultipleButtonsAdapter(Context context, MultipleUserClickListener listener) {
        super(context, listener);
    }

    @Override
    public MultipleButtonsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MultipleButtonsViewHolder(inflate(R.layout.item_user_multible_buttons, parent), getListener());
    }
}
