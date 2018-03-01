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

import android.view.View;
import android.widget.TextView;

import com.leodroidcoder.genericadapter.BaseViewHolder;
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener;
import com.leodroidcoder.genericadaptersample.R;
import com.leodroidcoder.genericadaptersample.model.User;

/**
 * A view holder implementation.
 *
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 1.0.0
 */

public class UserAccentViewHolder extends BaseViewHolder<User, OnRecyclerItemClickListener> {

    private TextView nameTv;
    private TextView ageTv;

    /**
     * Do here any expensive operations such as initialize views (findViewById) or setting click listeners.
     *
     * @param itemView current item view
     * @param listener click listener {@link com.leodroidcoder.genericadapter.OnRecyclerItemClickListener}
     */
    public UserAccentViewHolder(View itemView, OnRecyclerItemClickListener listener) {
        super(itemView, listener);
        initViews();
    }

    /**
     * Initialize views and set the listeners
     */
    private void initViews() {
        nameTv = itemView.findViewById(R.id.tv_name);
        ageTv = itemView.findViewById(R.id.tv_age);
        if (getListener() != null) {
            itemView.setOnClickListener(v -> getListener().onItemClick(getAdapterPosition()));
        }
    }

    @Override
    public void onBind(User item) {
        // bind data to the views
        nameTv.setText(item.getName());
        ageTv.setText(String.valueOf(item.getAge()));
    }
}
