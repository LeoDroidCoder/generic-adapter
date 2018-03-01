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

import android.content.Context;
import android.view.ViewGroup;

import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter;
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener;
import com.leodroidcoder.genericadaptersample.R;
import com.leodroidcoder.genericadaptersample.model.User;
import com.leodroidcoder.genericadaptersample.sample.common.UserViewHolder;

/**
 * Basic adapter implementation.
 * For a usage with one ite view type.
 * If you have multiple view types please review {@link com.leodroidcoder.genericadaptersample.sample.multipleviewtypes.MultipleViewTypesAdapter}
 *
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 1.0.0
 */

public class SimpleAdapter extends GenericRecyclerViewAdapter<User, OnRecyclerItemClickListener, UserViewHolder> {

    public SimpleAdapter(Context context, OnRecyclerItemClickListener listener) {
        super(context, listener);
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserViewHolder(inflate(R.layout.item_user, parent), getListener());
    }
}
