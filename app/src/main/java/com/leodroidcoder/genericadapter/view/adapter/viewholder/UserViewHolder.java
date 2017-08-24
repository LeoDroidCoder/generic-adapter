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
package com.leodroidcoder.genericadapter.view.adapter.viewholder;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.leodroidcoder.genericadapter.R;
import com.leodroidcoder.genericadapter.view.adapter.listener.BaseRecyclerListener;
import com.leodroidcoder.genericadapter.view.adapter.listener.OnRecyclerObjectClickListener;
import com.leodroidcoder.genericadapter.view.entity.User;

/**
 * User ViewHolder to be used with the generic adapter.
 * {@link com.leodroidcoder.genericadapter.view.adapter.GenericRecyclerAdapter}
 *
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 0.1.0
 */
public class UserViewHolder extends BaseViewHolder<User, OnRecyclerObjectClickListener<User>> {

    private TextView name;
    private ImageView avatar;

    public UserViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.tv_name);
        avatar = itemView.findViewById(R.id.iv_avatar);
    }

    /**
     * Bind data to the item and set listener if needed.
     *
     * @param item     object, associated with the item.
     * @param listener listener a listener {@link BaseRecyclerListener} which has to b set at the item (if not `null`).
     */
    @Override
    public void onBind(User item, @Nullable OnRecyclerObjectClickListener<User> listener) {
        // set all data
        name.setText(item.getLogin());
        Glide.with(itemView.getContext())
                .load(item.getImageUrl())
                .centerCrop()
                .crossFade()
                .into(avatar);
        // set listener if needed
        // you can set it at any of the views instead of whole itemView if you wish
        if (listener != null) {
            itemView.setOnClickListener(v -> listener.onItemClicked(item));
        }
    }
}
