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

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.leodroidcoder.genericadapter.BaseViewHolder;
import com.leodroidcoder.genericadaptersample.R;
import com.leodroidcoder.genericadaptersample.model.User;

/**
 * A view holder implementation sample with multiple buttons.
 * The implementation is as simple as:
 * 1. Create a listener which extends {@link com.leodroidcoder.genericadapter.BaseRecyclerListener} and define there as meny methods as you need.
 * 2. Set listeners for each button you need.
 * Note that here we used {@link MultipleUserClickListener} in the ViewHolder.
 * We will also have to:
 * - implement it in a Fragment/Activity
 * - use same listener in the adapter implementation (pass to the constructor)
 *
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 1.0.0
 */

public class MultipleButtonsViewHolder extends BaseViewHolder<User, MultipleUserClickListener> {

    private TextView nameTv;

    /**
     * Do here any expensive operations such as initialize views (findViewById) or setting click listeners.
     *
     * @param itemView current item view
     * @param listener click listener {@link com.leodroidcoder.genericadapter.BaseRecyclerListener}
     */
    public MultipleButtonsViewHolder(View itemView, MultipleUserClickListener listener) {
        super(itemView, listener);
        initViews();
    }

    /**
     * Initialize views and set the listeners
     */
    private void initViews() {
        nameTv = itemView.findViewById(R.id.tv_name);
        if (getListener() != null) {
            final Button ageBtn = itemView.findViewById(R.id.btn_age);
            ageBtn.setOnClickListener(v -> getListener().onGetAgeClick(getAdapterPosition()));
            final Button greetBtn = itemView.findViewById(R.id.btn_greet);
            greetBtn.setOnClickListener(v -> getListener().onGreetClick(getAdapterPosition()));
        }
    }

    /**
     * Bind data to the item.
     * Make sure not to perform any expensive operations here.
     *
     * @param item     object, associated with the item.
     */
    @Override
    public void onBind(User item) {
        // bind data to the views
        nameTv.setText(item.getName());
    }
}
